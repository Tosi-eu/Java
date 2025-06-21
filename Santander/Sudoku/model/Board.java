package Santander.Sudoku.model;

import java.util.Collection;
import java.util.List;

import static Santander.Sudoku.model.GameStatus.*;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Board {

    private final List<List<Space>> spaces;

    public Board(final List<List<Space>> spaces) {
        this.spaces = spaces;
    }

    public List<List<Space>> getSpaces() {
        return spaces;
    }

    public GameStatus getStatus() {
        var allSpaces = spaces.stream().flatMap(Collection::stream);

        boolean hasUserInput = allSpaces.anyMatch(space -> !space.isFixed() && nonNull(space.getActual()));
        if (!hasUserInput) return NON_STARTED;

        boolean hasEmpty = spaces.stream()
                                 .flatMap(Collection::stream)
                                 .anyMatch(space -> isNull(space.getActual()));
        return hasEmpty ? INCOMPLETE : COMPLETE;
    }

    public boolean hasErrors() {
        if (getStatus() == NON_STARTED) return false;

        return spaces.stream()
                     .flatMap(Collection::stream)
                     .anyMatch(space -> nonNull(space.getActual()) && !space.getActual().equals(space.getExpected()));
    }

    public boolean changeValue(final int col, final int row, final int value) {
        var space = spaces.get(col).get(row);
        if (space.isFixed()) return false;

        space.setActual(value);
        return true;
    }

    public boolean clearValue(final int col, final int row) {
        var space = spaces.get(col).get(row);
        if (space.isFixed()) return false;

        space.clearSpace();
        return true;
    }

    public void reset() {
        spaces.forEach(row -> row.forEach(Space::clearSpace));
    }

    public boolean gameIsFinished() {
        return getStatus() == COMPLETE && !hasErrors();
    }
}
package Santander.Sudoku.service;

import Santander.Sudoku.model.Board;
import Santander.Sudoku.model.GameStatus;
import Santander.Sudoku.model.Space;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BoardService {

    private static final int BOARD_LIMIT = 9;
    private final Board board;

    public BoardService(final Map<String, String> gameConfig) {
        this.board = new Board(initBoard(gameConfig));
    }

    public List<List<Space>> getSpaces() {
        return board.getSpaces();
    }

    public void reset() {
        board.reset();
    }

    public boolean hasErrors() {
        return board.hasErrors();
    }

    public GameStatus getStatus() {
        return board.getStatus();
    }

    public boolean gameIsFinished() {
        return board.gameIsFinished();
    }

    private List<List<Space>> initBoard(final Map<String, String> gameConfig) {
        List<List<Space>> spaces = new ArrayList<>();

        for (int row = 0; row < BOARD_LIMIT; row++) {
            List<Space> line = new ArrayList<>();
            for (int col = 0; col < BOARD_LIMIT; col++) {
                String key = "%d,%d".formatted(row, col);
                String config = gameConfig.getOrDefault(key, "0,false");
                String[] parts = config.split(",");

                int value = Integer.parseInt(parts[0]);
                boolean fixed = Boolean.parseBoolean(parts[1]);

                line.add(new Space(value, fixed));
            }
            spaces.add(line);
        }

        return spaces;
    }
}
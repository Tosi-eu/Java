package Santander.Sudoku.ui.custom.screen;

import Santander.Sudoku.model.Space;
import Santander.Sudoku.service.BoardService;
import Santander.Sudoku.service.NotifierService;
import Santander.Sudoku.ui.custom.button.CheckGameStatusButton;
import Santander.Sudoku.ui.custom.button.FinishGameButton;
import Santander.Sudoku.ui.custom.button.ResetButton;
import Santander.Sudoku.ui.custom.frame.MainFrame;
import Santander.Sudoku.ui.custom.input.NumberText;
import Santander.Sudoku.ui.custom.panel.MainPanel;
import Santander.Sudoku.ui.custom.panel.SudokuSector;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static Santander.Sudoku.service.EventEnum.CLEAR_SPACE;
import static javax.swing.JOptionPane.*;

public class MainScreen {

    private static final Dimension SCREEN_DIMENSION = new Dimension(600, 600);
    private static final int YES_OPTION = 0;

    private final BoardService boardService;
    private final NotifierService notifierService;

    private JButton checkGameStatusButton;
    private JButton finishGameButton;
    private JButton resetButton;

    public MainScreen(final Map<String, String> gameConfig) {
        this.boardService = new BoardService(gameConfig);
        this.notifierService = new NotifierService();
    }

    public void buildMainScreen() {
        JPanel mainPanel = new MainPanel(SCREEN_DIMENSION);
        JFrame mainFrame = new MainFrame(SCREEN_DIMENSION, mainPanel);

        buildSudokuGrid(mainPanel);
        addControlButtons(mainPanel);

        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private void buildSudokuGrid(JPanel mainPanel) {
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                List<Space> sectorSpaces = extractSector(boardService.getSpaces(), row, row + 2, col, col + 2);
                JPanel sectorPanel = createSectorPanel(sectorSpaces);
                mainPanel.add(sectorPanel);
            }
        }
    }

    private void addControlButtons(JPanel mainPanel) {
        addResetButton(mainPanel);
        addCheckGameStatusButton(mainPanel);
        addFinishGameButton(mainPanel);
    }

    private List<Space> extractSector(List<List<Space>> grid, int startRow, int endRow, int startCol, int endCol) {
        List<Space> sector = new ArrayList<>();
        for (int r = startRow; r <= endRow; r++) {
            for (int c = startCol; c <= endCol; c++) {
                sector.add(grid.get(c).get(r));
            }
        }
        return sector;
    }

    private JPanel createSectorPanel(List<Space> spaces) {
        List<NumberText> fields = spaces.stream().map(NumberText::new).toList();
        fields.forEach(field -> notifierService.subscribe(CLEAR_SPACE, field));
        return new SudokuSector(fields);
    }

    private void addFinishGameButton(JPanel mainPanel) {
        finishGameButton = new FinishGameButton(e -> {
            if (boardService.gameIsFinished()) {
                showMessageDialog(null, "Parabéns! Você concluiu o jogo.");
                disableGameButtons();
            } else {
                showMessageDialog(null, "Seu jogo tem alguma inconsistência. Ajuste e tente novamente.");
            }
        });
        mainPanel.add(finishGameButton);
    }

    private void addCheckGameStatusButton(JPanel mainPanel) {
        checkGameStatusButton = new CheckGameStatusButton(e -> {
            var status = boardService.getStatus();
            var hasErrors = boardService.hasErrors();

            String message = switch (status) {
                case NON_STARTED -> "O jogo não foi iniciado";
                case INCOMPLETE -> "O jogo está incompleto";
                case COMPLETE -> "O jogo está completo";
            };
            message += hasErrors ? " e contém erros." : " e não contém erros.";
            showMessageDialog(null, message);
        });
        mainPanel.add(checkGameStatusButton);
    }

    private void addResetButton(JPanel mainPanel) {
        resetButton = new ResetButton(e -> {
            int result = showConfirmDialog(
                null,
                "Deseja realmente reiniciar o jogo?",
                "Limpar o jogo",
                YES_NO_OPTION,
                QUESTION_MESSAGE
            );

            if (result == YES_OPTION) {
                boardService.reset();
                notifierService.notify(CLEAR_SPACE);
            }
        });
        mainPanel.add(resetButton);
    }

    private void disableGameButtons() {
        resetButton.setEnabled(false);
        checkGameStatusButton.setEnabled(false);
        finishGameButton.setEnabled(false);
    }
}
package Santander.Sudoku;

import Santander.Sudoku.model.Board;
import Santander.Sudoku.model.Space;

import java.util.*;

import static Santander.Sudoku.util.BoardTemplate.TEMPLATE;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int BOARD_LIMIT = 9;

    private static Board board;

    public static void main(String[] args) {
        final Map<String, String> positions = generateRandomBoardConfig(25); 

        while (true) {
            System.out.println("""
                Selecione uma das opções a seguir:
                1 - Iniciar um novo Jogo
                2 - Colocar um novo número
                3 - Remover um número
                4 - Visualizar jogo atual
                5 - Verificar status do jogo
                6 - Limpar jogo
                7 - Finalizar jogo
                8 - Sair
                """);

            int option = scanner.nextInt();

            switch (option) {
                case 1 -> startGame(positions);
                case 2 -> inputNumber();
                case 3 -> removeNumber();
                case 4 -> showCurrentGame();
                case 5 -> showGameStatus();
                case 6 -> clearGame();
                case 7 -> finishGame();
                case 8 -> System.exit(0);
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static Map<String, String> generateRandomBoardConfig(int fixedCount) {
        Random random = new Random();
        Set<String> usedPositions = new HashSet<>();
        Map<String, String> config = new HashMap<>();
    
        while (config.size() < fixedCount) {
            int row = random.nextInt(9);
            int col = random.nextInt(9);
            String key = row + "," + col;
    
            if (usedPositions.contains(key)) continue;
    
            int value = 1 + random.nextInt(9); 
            config.put(key, value + ",true");
            usedPositions.add(key);
        }
    
        return config;
    }    

    private static void startGame(Map<String, String> positions) {
        if (nonNull(board)) {
            System.out.println("O jogo já foi iniciado.");
            return;
        }

        List<List<Space>> spaces = new ArrayList<>();
        for (int i = 0; i < BOARD_LIMIT; i++) {
            List<Space> row = new ArrayList<>();
            for (int j = 0; j < BOARD_LIMIT; j++) {
                String positionKey = "%s,%s".formatted(i, j);
                String config = positions.getOrDefault(positionKey, "0,false");
                String[] parts = config.split(",");
                int value = Integer.parseInt(parts[0]);
                boolean fixed = Boolean.parseBoolean(parts[1]);
                row.add(new Space(value, fixed));
            }
            spaces.add(row);
        }

        board = new Board(spaces);
        System.out.println("O jogo está pronto para começar.");
    }

    private static void inputNumber() {
        if (!isGameInitializedOrWarn()) return;

        System.out.println("Informe a coluna onde deseja inserir o número:");
        int col = runUntilGetValidNumber(0, 8);
        System.out.println("Informe a linha onde deseja inserir o número:");
        int row = runUntilGetValidNumber(0, 8);
        System.out.printf("Informe o número que vai entrar na posição [%s,%s]:%n", col, row);
        int value = runUntilGetValidNumber(1, 9);

        if (!board.changeValue(col, row, value)) {
            System.out.printf("A posição [%s,%s] tem um valor fixo.%n", col, row);
        }
    }

    private static void removeNumber() {
        if (!isGameInitializedOrWarn()) return;

        System.out.println("Informe a coluna da posição que deseja limpar:");
        int col = runUntilGetValidNumber(0, 8);
        System.out.println("Informe a linha da posição que deseja limpar:");
        int row = runUntilGetValidNumber(0, 8);

        if (!board.clearValue(col, row)) {
            System.out.printf("A posição [%s,%s] tem um valor fixo.%n", col, row);
        }
    }

    private static void showCurrentGame() {
        if (!isGameInitializedOrWarn()) return;

        Object[] args = new Object[81];
        int pos = 0;

        for (int i = 0; i < BOARD_LIMIT; i++) {
            for (List<Space> col : board.getSpaces()) {
                Integer val = col.get(i).getActual();
                args[pos++] = " " + (isNull(val) ? " " : val);
            }
        }

        System.out.println("Seu jogo se encontra da seguinte forma:");
        System.out.printf(TEMPLATE + "%n", args);
    }

    private static void showGameStatus() {
        if (!isGameInitializedOrWarn()) return;

        var status = board.getStatus();
        System.out.printf("Status atual do jogo: %s%n", status.getLabel());

        if (board.hasErrors()) {
            System.out.println("O jogo contém erros.");
        } else {
            System.out.println("O jogo não contém erros.");
        }
    }

    private static void clearGame() {
        if (!isGameInitializedOrWarn()) return;

        System.out.println("Tem certeza que deseja limpar o jogo e perder seu progresso? (sim/não)");
        String confirm = scanner.next();

        while (!confirm.equalsIgnoreCase("sim") && !confirm.equalsIgnoreCase("não")) {
            System.out.println("Informe 'sim' ou 'não':");
            confirm = scanner.next();
        }

        if (confirm.equalsIgnoreCase("sim")) {
            board.reset();
            System.out.println("Jogo reiniciado com sucesso.");
        }
    }

    private static void finishGame() {
        if (!isGameInitializedOrWarn()) return;

        if (board.gameIsFinished()) {
            System.out.println("Parabéns! Você concluiu o jogo.");
            showCurrentGame();
            board = null;
        } else if (board.hasErrors()) {
            System.out.println("Seu jogo contém erros. Verifique o tabuleiro e corrija-os.");
        } else {
            System.out.println("Ainda existem espaços vazios a serem preenchidos.");
        }
    }

    private static boolean isGameInitializedOrWarn() {
        if (isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado.");
            return false;
        }
        return true;
    }

    private static int runUntilGetValidNumber(int min, int max) {
        int current = scanner.nextInt();
        while (current < min || current > max) {
            System.out.printf("Informe um número entre %d e %d:%n", min, max);
            current = scanner.nextInt();
        }
        return current;
    }
}

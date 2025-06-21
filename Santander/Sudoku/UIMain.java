package Santander.Sudoku;

import Santander.Sudoku.ui.custom.screen.MainScreen;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class UIMain {

    public static void main(String[] args) {
        Map<String, String> gameConfig = generateRandomBoardConfig(25); 
        var mainScreen = new MainScreen(gameConfig);
        mainScreen.buildMainScreen();
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

            int value = 1 + random.nextInt(9); // valores entre 1 e 9
            config.put(key, value + ",true");
            usedPositions.add(key);
        }

        return config;
    }
}

package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class HardComputerAI extends ComputerAI {


    private List<String> possibleGuesses = new ArrayList<>();
    private Random random = new Random();
    private int[] lastResult = null;
    private String lastGuess = null;

    public HardComputerAI() {
        generatePossibleGuessesList();
    }

    private void generatePossibleGuessesList() {
        for (int i = 0; i < 10000; i++) {
            String possibleGuess = getPossibleGuess(String.valueOf(i));
            if (possibleGuess != null) {
                possibleGuesses.add(possibleGuess);
            }
        }
    }

    private String getPossibleGuess(String value) {
        if (value.length() < 4) {
            return null;
        }

        boolean[] b = new boolean[10];
        for (int i = 0; i < value.length(); i++) {
            int j = value.charAt(i) - 48;
             if (b[j]) {
                 return null;
             } else {
                 b[j] = true;
             }
        }
        return value;
    }


    @Override
    public String makeGuess() {
        if (lastResult != null) {
            Iterator<String> iterator = possibleGuesses.iterator();
            while (iterator.hasNext()) {
                String nextGuess = iterator.next();
                int[] nextResult = Game.evaluateGuess(lastGuess, nextGuess);
                if (nextResult[0] != lastResult[0] || nextResult[1] != lastResult[1]) {
                    iterator.remove();
                }
            }
        }

        lastGuess = possibleGuesses.get(random.nextInt(possibleGuesses.size()));
        return lastGuess;
    }

    @Override
    public void feedback(int[] result) {
        lastResult = result;
    }
}

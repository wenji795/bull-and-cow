package org.example;

import java.util.Random;
import java.util.Set;

public class ComputerAI extends Player {

    public ComputerAI() {
        super();
    }

    @Override
    public String getSecretCode() {
        return getRandomCode();
    }

    @Override
    public String makeGuess() {
        return getRandomCode();
    }

    //
    protected String getRandomCode() {
        Random random = new Random();
        //初始化数组
        int[] guesses = {-1, -1, -1, -1};
        //随机生成
        for (int i = 0; i < guesses.length; i++) {
            int g = guesses[i];
            if (g == -1) {
                do {
                    g = random.nextInt(10);
                } while (arrayContains(guesses, g));
                guesses[i] = g;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < guesses.length; i++) {
            sb.append(guesses[i]);
        }

        return sb.toString();
    }

    boolean arrayContains(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }
}

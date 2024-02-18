package org.example;

import java.util.*;

public class MediumComputerAI extends ComputerAI {

    private List<String> guessSet = new ArrayList<>(); // [1234]


    @Override
    public String makeGuess() {
        while (true) {
            String guess = getRandomCode(); // 1234
            if (!guessSet.contains(guess)) {
                guessSet.add(guess);
                return guess;
            }
        }
    }
}
/*

[1, 2, 3, 3, 2, 0]



[1, 0, 2, 3]


 */
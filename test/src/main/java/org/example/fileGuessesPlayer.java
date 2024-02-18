package org.example;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class fileGuessesPlayer extends HumanPlayer {
    private List<String> guessesFromFile;
    private int currentGuessIndex;

    public fileGuessesPlayer(String filename) {
        this.guessesFromFile = readGuessesFromFile(filename);
        this.currentGuessIndex = 0;
    }

    private List<String> readGuessesFromFile(String filename) {
        List<String> guesses = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                guesses.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return guesses;
    }

    @Override
    public String makeGuess() {
        if (currentGuessIndex < guessesFromFile.size()) {
            String guess = guessesFromFile.get(currentGuessIndex);
            System.out.println("Using guess from file: " + guess);
            currentGuessIndex++;

            // readGuessesFromFile(guess);

            return guess;
        } else {
            return super.makeGuess();
        }
    }
}

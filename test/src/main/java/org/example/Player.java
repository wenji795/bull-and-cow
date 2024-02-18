package org.example;

public abstract class Player {

    public abstract String getSecretCode();

    public abstract String makeGuess();

    public void feedback(int[] result) {}
}
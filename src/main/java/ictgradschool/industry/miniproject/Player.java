public abstract class Player {
    private String secretCode;

    public String getSecretCode() {
        return secretCode;
    }

    public abstract String makeGuess();
}
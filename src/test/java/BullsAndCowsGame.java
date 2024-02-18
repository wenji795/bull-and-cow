import java.util.Random;
import java.util.Scanner;

public class BullsAndCowsGame {
    private String computerSecretCode;
    private final int maxAttempts = 7;

    public BullsAndCowsGame() {
        this.computerSecretCode = generateComputerCode();
    }

    private String generateComputerCode() {
        Random random = new Random();
        char[] digits = new char[4];
        for (int i = 0; i < 4; i++) {
            digits[i] = (char) ('0' + random.nextInt(10));
            for (int j = 0; j < i; j++) {
                if (digits[j] == digits[i]) {
                    i--; // 重新生成这一位
                    break;
                }
            }
        }
        return new String(digits);
    }

    private int[] evaluateGuess(String secretCode, String guess) {
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < 4; i++) {
            if (guess.charAt(i) == secretCode.charAt(i)) {
                bulls++;
            } else if (secretCode.indexOf(guess.charAt(i)) != -1) {
                cows++;
            }
        }
        return new int[]{bulls, cows};
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Bulls and Cows Game!");
        System.out.println("Guess the 4-digit number. The digits are all different.");
        System.out.println("You have " + maxAttempts + " attempts.");

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.print("Attempt " + attempt + ": Enter your guess: ");
            String guess = scanner.nextLine();

            if (!isValidGuess(guess)) {
                System.out.println("Invalid guess. Please enter a 4-digit number with different digits.");
                continue;
            }

            int[] result = evaluateGuess(computerSecretCode, guess);
            System.out.println(result[0] + " bulls and " + result[1] + " cows");

            if (result[0] == 4) {
                System.out.println("Congratulations! You've guessed the secret code.");
                return;
            }
        }

        System.out.println("Sorry, you've run out of attempts. The secret code was " + computerSecretCode);
    }

    private boolean isValidGuess(String guess) {
        if (guess.length() != 4 || !guess.matches("\\d{4}")) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                if (guess.charAt(i) == guess.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BullsAndCowsGame game = new BullsAndCowsGame();
        game.start();
    }
}

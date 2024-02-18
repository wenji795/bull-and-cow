package org.example;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
//    //    private Player ComputerAI;
//    //     private String computerGuess;
//    //    private String computerSecretCode;
    private static final int maxAttempts = 7;

    private HumanPlayer humanPlayer;
    private ComputerAI computerAI;
    private String computerSecretCode;
    private String humanSecretCode;
    private List<String> result = new ArrayList<>();


//
    public Game() {
        this.humanPlayer = new HumanPlayer();
    }
//
//    private String generateComputerCode() {
//        Random random = new Random();
//        char[] digits = new char[4];
//        for (int i = 0; i < 4; i++) {
//            digits[i] = (char) ('0' + random.nextInt(10));
//            for (int j = 0; j < i; j++) {
//                if (digits[j] == digits[i]) {
//                    i--; // 重新生成这一位
//                    break;
//                }
//            }
//        }
//        return new String(digits);
//    }

//
//    private boolean isValidGuess(String guess) {
//        // TODO: 实现校验猜测是否有效的方法
//        if (guess.length() != 4 || !guess.matches("\\d{4}")) {
//            return false;
//        }
//        for (int i = 0; i < 4; i++) {
//            for (int j = i + 1; j < 4; j++) {
//                if (guess.charAt(i) == guess.charAt(j)) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }



    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Bulls and Cows Game!");
        System.out.println("---------------------------------");
        System.out.println("Guess the 4-digit number. The digits are all different.");

        //TODO 写入判断，让用户选择是否从文件读取输入结果
        System.out.println("Do you want to enter guesses manually or use a file?(manual/file)");
        String inputChoice = scanner.next().toLowerCase();
        String filename = "";
        switch (inputChoice) {
            case "file":
                System.out.println("Enter the filename: ");
                filename = scanner.next();
                humanPlayer = new fileGuessesPlayer(filename);
                break;
            case "manual":
                humanPlayer = new HumanPlayer();
                break;
            default:
                System.out.println("Invalid input. Please enter 'manual' or 'file'.");
                // Handle invalid input or loop back for correct input
                break;
        }


        System.out.println("You have " + maxAttempts + " attempts.");

        //选模式
        System.out.println("Select the AI difficulty level:");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");
        System.out.println("Enter a digit number to choice a mode");

        while (this.computerAI == null) {
            int choice = scanner.nextInt();
            if (choice == 1) {
                this.computerAI = new ComputerAI();
            } else if (choice == 2) {
                this.computerAI = new MediumComputerAI();
            } else if (choice == 3) {
                this.computerAI = new HardComputerAI();
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        //
        this.humanSecretCode = humanPlayer.getSecretCode();
        this.computerSecretCode = computerAI.getSecretCode();

        //玩家的秘密代码
        System.out.println("Enter your Secret Code: " + humanSecretCode);
        System.out.println("Computer secret code: " + computerSecretCode);

        //
        playGame();
    }

    private void playGame() {
        Scanner scanner = new Scanner(System.in);

        int guess;
        boolean gameOver = false;

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.println("**--------------Round " + attempt +"----------------**");

            // 定义了个变量，第一个从Humanplayer的makeGuess功能获取一个猜测
            String humanGuess = humanPlayer.makeGuess();
            //定义了个变量，第一个从ComputerAI的makeGuess功能获取一个猜测
            String computerGuess = computerAI.makeGuess();

            //玩家的猜测和电脑的秘密数字进行对比
            int[] playerResult = evaluateGuess(computerSecretCode, humanGuess);

            print("Your choice is " + humanGuess);
            print(playerResult[0] + " bulls and " + playerResult[1] + " cows");

            //猜测成功，玩家赢
            if (playerResult[0] == 4) {
                print("Congratulations! You've guessed the secret code.");
                gameOver = true;
                saveResults(computerSecretCode, attempt, false);
                return;
            }

            //电脑猜测的数字和玩家的秘密数字进行对比
            int[] computerResult = evaluateGuess(computerGuess, humanSecretCode);
            computerAI.feedback(computerResult); //
            print("Computer's choice is " + computerGuess);
            print(computerResult[0] + " bulls and " + computerResult[1] + " cows");

            //猜测成功..
            if (computerResult[0] == 4) {
                print("Congratulations! computer win!");
                gameOver = true;
                saveResults(computerSecretCode, attempt, false);
                return;
            } else {
                print("Wrong guess. Try again.");

            }
        }
        //猜测失败
        print("Sorry, you've run out of attempts. The secret code was " + computerSecretCode);
        saveResults(computerSecretCode, maxAttempts, false);
    }

    //print方法
    private void print(String value) {
        System.out.println(value);
        result.add(value);
    }

    private void saveResults(String computerSecretCode, int attempt, boolean playerWins) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Do you want to save the results to a file? (yes/no)");
            String saveChoice = scanner.nextLine().toLowerCase();

            if (saveChoice.equals("yes")) {
                System.out.println("Enter the filename: ");
                String filename = scanner.nextLine();

                Files.write(Path.of(filename), result, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                System.out.println("Results saved to " + filename);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //判断bull cow 逻辑
    public static int[] evaluateGuess(String secretCode, String guess) {
        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < 4; i++) {
            if (guess.charAt(i) == secretCode.charAt(i)) {
                bulls++;
            } else if (secretCode.indexOf(guess.charAt(i)) >= 0) {
                cows++;
            }
        }

        return new int[]{bulls, cows};
    }
}

package org.example;

import org.example.common.Keyboard;

public class HumanPlayer extends Player {
    @Override
    public String getSecretCode() {
        return readUserInput();
    }

    @Override
    public String makeGuess() {
        return readUserInput();
    }

    private String readUserInput() {
        while (true) {
            try {
                // 提示用户设置一个秘密数字
                System.out.println("Guess a secret number:");
                String input = Keyboard.readInput();

                // 检查输入是否有效
                if (isValidCode(input)) {
                    return input;
                } else {
                    System.out.println("Please enter a 4-digit number with all different digits.");
                }
            } catch (NumberFormatException e) {
                // 处理非数字输入
                System.out.println("Invalid input. Please enter a 4-digit number.");
            }
        }
    }

//    private String secretCode;
//    public HumanPlayer() {
//        // 初始化秘密代码为一个空字符串
//        this.secretCode = "";
//    }
////    public String humanGuess() {
////        Scanner scanner = new Scanner(System.in);
////        System.out.print("Enter your guess: ");
////        return scanner.nextLine();
////    }
//    public String setSecretCode(String secretCode) {
//        return secretCode;
//    }
//    public String secretCode(){
//
//
//    }
//    @Override
//    public String makeGuess() {
//        while (true) {
//            try {
//                // 提示用户输入一个猜测数字
//                System.out.println("Enter a 4-digit number:");
//                String input = Keyboard.readInput();
//
//                // 检查输入是否有效
//                if (isValidCode(input)) {
//                    return input;
//                } else {
//                    System.out.println("Please enter a 4-digit number with all different digits.");
//                }
//            } catch (NumberFormatException e) {
//                // 处理非数字输入
//                System.out.println("Invalid input. Please enter a 4-digit number.");
//            }
//        }
//    }
//

    // 检查代码是否有效：长度为4，所有数字都不同
    private boolean isValidCode(String code) {
        if (code.length() != 4 || !code.matches("\\d{4}")) {
            return false;
        }

        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                if (code.charAt(i) == code.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
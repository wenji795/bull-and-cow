public class HumanPlayer extends Player {

    @Override
    public String humanGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your guess: ");
        return scanner.nextLine();
    }
}
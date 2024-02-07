import java.util.Scanner;//Importing thee scanner for getting the input
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 5;
        int score = 0;

        System.out.println("Welcome to Guess the Number Game!");

        // Game loop
        while (true) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("I've selected a number between " + minRange + " and " + maxRange + ". Guess the number!");

            // Attempts loop
            for (int attempt = 1; attempt <= attemptsLimit; attempt++) {
                System.out.print("Attempt " + attempt + ": Enter your guess: ");
                int guess = scanner.nextInt();

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number!");
                    score += attemptsLimit - attempt + 1;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                if (attempt == attemptsLimit) {
                    System.out.println("Sorry, you've reached the maximum number of attempts.");
                    System.out.println("The correct number was: " + randomNumber);
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();

            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Your final score: " + score);
        System.out.println("Thanks for playing Guess the Number!");
        scanner.close();
    }
}

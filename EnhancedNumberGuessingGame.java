import java.util.Random;
import java.util.Scanner;

public class EnhancedNumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int maxTries = 7;
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Enhanced Number Guessing Game!");
        System.out.println("You have " + maxTries + " tries to guess the number between 1 and 100.");

        while (playAgain) {
            int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int numberOfTries = 0;

            while (numberOfTries < maxTries) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                numberOfTries++;

                if (guess < lowerBound || guess > upperBound) {
                    System.out.println("Please enter a number between 1 and 100.");
                } else if (guess < secretNumber) {
                    System.out.println("Try a higher number.");
                } else if (guess > secretNumber) {
                    System.out.println("Try a lower number.");
                } else {
                    System.out.println("Congratulations! You've guessed the number in " + numberOfTries + " tries.");
                    score++;
                    break;
                }

                if (numberOfTries == maxTries) {
                    System.out.println("Sorry, you've run out of tries. The correct number was " + secretNumber + ".");
                }
            }

            System.out.print("Play again? (yes/no): ");
            String playAgainChoice = scanner.next().toLowerCase();
            playAgain = playAgainChoice.equals("yes");

            if (playAgain) {
                System.out.println("Your score: " + score);
            }
        }

        System.out.println("Thanks for playing! Your final score: " + score);
        scanner.close();
    }
}

import java.util.Random;  
import java.util.Scanner;  

public class GuessingGame {  
    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);  
        Random random = new Random();  
        int playAgain;  

        do {  
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;  
            boolean guessedCorrectly = false;  
            int maxAttempts = 10; 

            System.out.println("Welcome to the Number Guessing Game!");  
            System.out.println("I have chosen a number between 1 and 100.");  
            System.out.println("You have " + maxAttempts + " attempts to guess it.");  

            while (attempts < maxAttempts && !guessedCorrectly) {  
                System.out.print("Enter your guess: ");  
                int userGuess = scanner.nextInt();  
                attempts++;  

                if (userGuess < 1 || userGuess > 100) {  
                    System.out.println("Please guess a number between 1 and 100.");  
                } else if (userGuess < numberToGuess) {  
                    System.out.println("Too low!");  
                } else if (userGuess > numberToGuess) {  
                    System.out.println("Too high!");  
                } else {  
                    guessedCorrectly = true;  
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");  
                }  

                if (attempts >= maxAttempts && !guessedCorrectly) {  
                    System.out.println("Sorry, you've used all your attempts! The number was: " + numberToGuess);  
                }  
            }  

             
            System.out.print("Do you want to play again? (1 for Yes, 0 for No): ");  
            playAgain = scanner.nextInt();  

        } while (playAgain == 1);  

        System.out.println("Thank you for playing the Number Guessing Game!");  
        scanner.close();  
    }  
}
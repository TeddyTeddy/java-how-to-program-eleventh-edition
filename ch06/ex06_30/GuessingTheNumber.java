import java.util.Scanner;
import java.security.SecureRandom;

public class GuessingTheNumber {
	
	private static final SecureRandom randomNumbers = new SecureRandom();
	private static final int ONE = 1;
	private static final int THOUSAND = 1000;
	
	public static void main(String[] args) {
		// initialize Scanner
		Scanner input = new Scanner(System.in);
		char continueTheGame = 'N'; // valid values 'Y' or 'y' or 'N' or 'n'
		int number = 0;
		int guess = 0;
		
		do {
			// select a random integer between 1 to 1000
			number = getRandomInteger(ONE, THOUSAND);
			System.out.printf("Number: %d%n", number);
			do {
				// Get a number between 1-1000 from user
				guess = inputInteger(input);
				// displayText
				displayText(number, guess);
			
				// if not a match between the entered number and guessed number
				// continue guessing
			} while (number != guess);	
		// prompt user if he wants to continue or not
		// input the answer ('Y' or 'y' or 'N' or 'n')
		continueTheGame = inputToContinueTheGameOrNot(input);
		
		// continue if the answer is 'Y' or 'y' else exit		
		} while( continueTheGame == 'Y' || continueTheGame == 'y' );

		// close scanner
		input.close();
	}
	
	private static char inputToContinueTheGameOrNot(Scanner input) {
		System.out.print("Enter 'y'/'Y' to continue or 'N'/'n' to exit: ");
		char answer = input.next().charAt(0);
		while(!((answer == 'y') || (answer == 'Y') || (answer == 'n') || (answer == 'N'))) {
			System.out.print("Incorrect input. Enter 'y'/'Y' to continue or 'N'/'n' to exit: ");
			answer = input.next().charAt(0);
		}
		return answer;	
	}
	
	private static void displayText(int number, int guess) {
		if(guess > number) {
			System.out.println("Too high. Try again");
		} else if( guess < number ) {
			System.out.println("Too low. Try again");
		} else {
			System.out.println("Congradulations. You guessed the number!");
		}
	}
	
	private static int getRandomInteger(int shiftingValue, int scalingFactor) {
		return shiftingValue + randomNumbers.nextInt(scalingFactor);
	}
	
	private static int inputInteger(Scanner input) {
		System.out.print("Enter an integer between 1 to 1000: ");
		int guess = input.nextInt();
		while(!((guess >= ONE) && (guess <= THOUSAND))) {
			System.out.print("Incorrect input. Enter an integer between 1 to 1000: ");
			guess = input.nextInt();
		}
		return guess;
	}
}
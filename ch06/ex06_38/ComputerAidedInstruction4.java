import java.util.Scanner;
import java.security.SecureRandom;

public class ComputerAidedInstruction4 {
	private static final SecureRandom randomNumbers = new SecureRandom();
	private static final int TEN = 10;
	private static final int ONE = 1;
	private static final int FOUR = 4;
	private static int scalingFactor; // need to initialize in main
	
	// test_power()
	private static final int TWO = 2;
	private static final int EIGHT = 8;
	private static final int SIXTEEN = 16;
	
	public static void main(String[] args) {
		
		// initialize
		Scanner input = new Scanner(System.in);
		int difficultyLevel = getDifficultyLevel(input);
		scalingFactor = power(10, difficultyLevel);
				
		int numberOfCorrectResponses = 0;
		for(int i = 1; i <= TEN; ++i) {
			if(executeQuestionRound(input)) {
				++numberOfCorrectResponses;
			}
		}
		if(numberOfCorrectResponses >= 8) {
			System.out.println("Congradulations! You are ready to go to the next level!");
		} else {
			System.out.println("Please ask your teacher for extra help.");
		}
		
		input.close();
		
	}
	
	private static int getDifficultyLevel(Scanner input) {
		System.out.print("Enter difficulty level from 1-4: ");
		int difficultyLevel = input.nextInt();
		while(!((difficultyLevel >= ONE) && (difficultyLevel <= FOUR)) ) {
			System.out.print("Incorrect value. Enter difficulty level from 1-4: ");
			difficultyLevel = input.nextInt();	
		}
		return difficultyLevel;
	}
	
	private static boolean executeQuestionRound(Scanner input) {
		
		// pick numberOne randomly from 0 to scalingFactor
		int numberOne = randomNumbers.nextInt(scalingFactor);
		// pick numberTwo randomly from 0 to scalingFactor
		int numberTwo = randomNumbers.nextInt(scalingFactor);
			
		// display the question
		displayQuestion(numberOne, numberTwo);
		// get the answer from user
		int answer = input.nextInt();
			
		boolean isGuessedCorrectly = (numberOne*numberTwo == answer);
		if(isGuessedCorrectly) {
			printRandomPositiveResponse();
		} else {
			printRandomNegativeResponse();	
		}
		
		return isGuessedCorrectly;

	}
	
	private static void displayQuestion(int a, int b) {
		System.out.printf("How much is %d times %d? ", a, b);
	}
	
	private static void printRandomPositiveResponse() {
		int randomNumber = ONE + randomNumbers.nextInt(FOUR);
		String message = "";
		switch( randomNumber ) {
			case 1:
				message = "Very good!";
				break;
			case 2:
				message = "Excellent!";
				break;
			case 3:
				message = "Nice work!";
				break;
			case 4:
				message = "Keep up the good work!";
				break;
		}
		System.out.printf("%s%n", message);
	}
	
	private static void printRandomNegativeResponse() {
		int randomNumber = ONE + randomNumbers.nextInt(FOUR);
		String message = "";
		switch( randomNumber ) {
			case 1:
				message = "No. But you can succeed in the next question!";
				break;
			case 2:
				message = "Wrong. But next question can be easier";
				break;
			case 3:
				message = "No, but don't give up!";
				break;
			case 4:
				message = "No. Keep trying.";
				break;
		}
		System.out.printf("%s%n", message);
	}
	
	private static void test_power() {
		for(int b = 0; b <= 10; ++b ) {
			System.out.printf("power(%d, %d) returns %d%n", TWO, b, power(TWO, b));
			System.out.printf("power(%d, %d) returns %d%n", EIGHT, b, power(EIGHT, b));
			System.out.printf("power(%d, %d) returns %d%n", SIXTEEN, b, power(SIXTEEN, b));
		}
	}
	
	private static int power(int base, int exponent) {
		int result = (exponent == 0) ? 1 : base;
		int counter = 1;
		while(counter < exponent) {
			result *= base;
			++counter;
		}
		return result;
	}

}
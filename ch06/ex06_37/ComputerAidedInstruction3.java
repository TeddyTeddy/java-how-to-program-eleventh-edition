import java.util.Scanner;
import java.security.SecureRandom;

public class ComputerAidedInstruction3 {
	private static final SecureRandom randomNumbers = new SecureRandom();
	private static final int TEN = 10;
	private static final int ONE = 1;
	private static final int FOUR = 4;
	
	public static void main(String[] args) {
		
		// initialize
		Scanner input = new Scanner(System.in);
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
	
	private static boolean executeQuestionRound(Scanner input) {
		// pick numberOne randomly from 0 to 9
		int numberOne = randomNumbers.nextInt(TEN);
		
		// pick numberTwo randomly from 0 to 9
		int numberTwo = randomNumbers.nextInt(TEN);
			
		// display the question
		displayQuestion(numberOne, numberTwo);
		// get the answer from user
		int answer = input.nextInt();
		
		boolean isCorrectAnswer = ((numberOne*numberTwo) == answer);
		if(isCorrectAnswer) {
			printRandomPositiveResponse();
		} else {
			printRandomNegativeResponse();	
		}
		
		return isCorrectAnswer;

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

}
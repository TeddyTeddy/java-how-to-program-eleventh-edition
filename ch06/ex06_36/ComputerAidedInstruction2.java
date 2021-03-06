import java.util.Scanner;
import java.security.SecureRandom;

public class ComputerAidedInstruction2 {
	private static final SecureRandom randomNumbers = new SecureRandom();
	private static final int TEN = 10;
	private static final int ONE = 1;
	private static final int FOUR = 4;
	
	public static void main(String[] args) {
		
		// initialize
		Scanner input = new Scanner(System.in);
		
		// pick numberOne randomly from 0 to 9
		int numberOne = randomNumbers.nextInt(TEN);
		
		// pick numberTwo randomly from 0 to 9
		int numberTwo = randomNumbers.nextInt(TEN);
		
		int answer;
		
		do {
			// display the question
			displayQuestion(numberOne, numberTwo);
			// get the answer from user
			answer = input.nextInt();
			
			// checkAnswer(numberOne, numberTwo, answer)
		} while(checkAnswer(numberOne, numberTwo, answer));
		
		input.close();
		
	}
	
	private static void displayQuestion(int a, int b) {
		System.out.printf("How much is %d times %d? ", a, b);
	}
	
	private static boolean checkAnswer(int a, int b, int answer) {
		if(a*b == answer) {
			printRandomPositiveResponse();
			return false; // stop the do/while loop
		}
		
		printRandomNegativeResponse();
		return true;
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
				message = "No. Please try again.";
				break;
			case 2:
				message = "Wrong. Try once more.";
				break;
			case 3:
				message = "Don't give up!";
				break;
			case 4:
				message = "No. Keep trying.";
				break;
		}
		System.out.printf("%s%n", message);
	}

}
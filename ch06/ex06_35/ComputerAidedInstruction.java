import java.util.Scanner;
import java.security.SecureRandom;

public class ComputerAidedInstruction {
	private static final SecureRandom randomNumbers = new SecureRandom();
	private static final int TEN = 10;
	
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
			System.out.println("Very Good!");
			return false; // stop the do/while loop
		}
		
		System.out.println("No. Please try again");
		return true;
	}
	
}
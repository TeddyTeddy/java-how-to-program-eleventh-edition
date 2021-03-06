import java.util.Scanner;
import java.security.SecureRandom;

public class ComputerAidedInstruction5 {
	private static final SecureRandom randomNumbers = new SecureRandom();
	private static final int TEN = 10;
	private static final int ONE = 1;
	private static final int FOUR = 4;
	private static final int FIVE = 5;
	private static int scalingFactor; // need to initialize in main
	private enum ProblemType { ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION, RANDOM };
	private static ProblemType problemType;
	private static ProblemType operation;
	
	// test_power()
	private static final int TWO = 2;
	private static final int EIGHT = 8;
	private static final int SIXTEEN = 16;
	
	public static void main(String[] args) {
		
		// initialize  
		Scanner input = new Scanner(System.in);
		int difficultyLevel = getDifficultyLevel(input);
		scalingFactor = power(10, difficultyLevel);
		
		// get the arithmetic problem type
		problemType = getProblemType(input);
				
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
	
	private static ProblemType getProblemType(Scanner input) {
		System.out.println("Enter 1 for addition");
		System.out.println("Enter 2 for subtraction");
		System.out.println("Enter 3 for multiplication");
		System.out.println("Enter 4 for division");
		System.out.println("Enter 5 for random mixture of above types");
		System.out.print("Enter arithmetic operation type (i.e. 1-5): ");
		int operationType = input.nextInt();
		while(!((operationType >= ONE) && (operationType <= FIVE)) ) {
			System.out.print("Incorrect value. Enter arithmetic operation type (i.e. 1-5): ");
			operationType = input.nextInt();	
		}
		ProblemType problemType = ProblemType.ADDITION;
		switch(operationType) {
			case 1:
				problemType = ProblemType.ADDITION;
				break;
			case 2:
				problemType = ProblemType.SUBTRACTION;
				break;
			case 3:
				problemType = ProblemType.MULTIPLICATION;
				break;
			case 4:
				problemType = ProblemType.DIVISION;
				break;
			case 5:
				problemType = ProblemType.RANDOM;
				break;			
		}
		
		return problemType;
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
	
		//* select a random "operation" if problemType is RANDOM, do nothing otherwise
		setRandomOperation();
		
		// display the question
		displayQuestion(numberOne, numberTwo);
		boolean isGuessedCorrectly = false;
		if(operation == ProblemType.DIVISION ) { // if problemType is a division, then the answer is expected to be a double
			double answer = input.nextDouble();
			isGuessedCorrectly = isCorrectAnswerForDivision(numberOne, numberTwo, answer);
			
		} else { // if problemType is not a division, then the answer is expected to be an integer
			// get the answer from user as integer
			int answer = input.nextInt();
			isGuessedCorrectly = isCorrectAnswer(numberOne, numberTwo, answer);
		}
		
		if(isGuessedCorrectly) {
			printRandomPositiveResponse();
		} else {
			printRandomNegativeResponse();	
		}
		
		return isGuessedCorrectly;

	}
	
	private static void setRandomOperation() {
		if( problemType == ProblemType.RANDOM ) {
			// pick randomOperation between 1-4 inclusive
			int randomOperation = 1 + randomNumbers.nextInt(4);
			switch( randomOperation ) {
				case 1:
					operation = ProblemType.ADDITION;
					break;
				case 2:
					operation = ProblemType.SUBTRACTION;
					break;
				case 3:
					operation = ProblemType.MULTIPLICATION;
					break;
				case 4:
					operation = ProblemType.DIVISION;
					break;					
			}
		}
	}
	
	// TODO: throw an exception if problemType has value different from DIVISION --> anything except division
	private static boolean isCorrectAnswerForDivision(int a, int b, double answer) {
		boolean result = false;
		final double ERROR_MARGIN = 0.001;
		
		switch( operation ) {
			case DIVISION :
				result = ( ((double) a / b) - answer ) <= ERROR_MARGIN;		
				break;
		}
		return result;
	}
	
	// TODO: throw an exception if problemType has value DIVISION
	private static boolean isCorrectAnswer(int a, int b, int answer) {
		boolean result = false;
		switch( operation ) {
		case ADDITION:
			result = ((a + b) == answer);		
			break;
		case SUBTRACTION:
			result = ((a - b) == answer);			
			break;
		case MULTIPLICATION:
			result = ((a * b) == answer);			
			break;
		}
		return result;
	}
	
	private static void displayQuestion(int a, int b) {
		switch( operation ) {
			case ADDITION:
				System.out.printf("How much is %d plus %d? ", a, b);		
				break;
			case SUBTRACTION:
				System.out.printf("How much is %d minus %d? ", a, b);		
				break;
			case MULTIPLICATION:
				System.out.printf("How much is %d times %d? ", a, b);		
				break;
			case DIVISION:
				System.out.printf("How much is %d divided by %d? ", a, b);		
				break;				
		}

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
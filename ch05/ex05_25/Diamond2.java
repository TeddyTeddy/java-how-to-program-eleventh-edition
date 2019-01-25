import java.util.Scanner;

public class Diamond2 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int numberOfRows = getNumberOfRows(input);
		input.close();
		
		for(int i = 1; i <= numberOfRows; ++i) {
			int numberOfAsterisks = getNumberOfAsterisks(i, numberOfRows);
			int numberOfSpaces = getNumberOfSpaces(i, numberOfRows);
			display(" ", numberOfSpaces);
			display("*", numberOfAsterisks);
			display(" ", numberOfSpaces);
			System.out.println();
		}
	}
	
	private static int getNumberOfRows(Scanner input) {
		System.out.print("Enter an odd # between 1 and 19: ");
		int number = input.nextInt();
		while( !( (number >=1) && (number <= 19) && (number % 2 == 1)) ) {
			System.out.print("Incorrect input. Enter an odd # between 1 and 19: ");
			number = input.nextInt();
		}
		return number;
	}
	
	private static int getConstant1(int numberOfRows) {
		return (numberOfRows + 1) / 2;
	}
	
	private static int getNumberOfAsterisks(int i, int numberOfRows) {
		int numberOfAsterisks = 1;
		int constant1 = getConstant1(numberOfRows);
		
		for(int j = 1; j < constant1; ++j) {
			if(j == i) {
				break;
			}
			numberOfAsterisks += 2;
		}
		
		for(int j = constant1+1; j <= numberOfRows; ++j ) {
			if(j > i) {
				break;
			}
			numberOfAsterisks -= 2;
		}
		return numberOfAsterisks;
	}
	
	private static int getNumberOfSpaces(int i, int numberOfRows) {
		int numberOfSpaces = (numberOfRows - 1) / 2;
		int constant1 = getConstant1(numberOfRows);
		for(int j = 1; j < constant1; ++j) {
			if( j == i ) {
				break;
			}
			--numberOfSpaces;
		}
		
		for(int j = constant1+1; j <= numberOfRows; ++j) {
			if( j > i) {
				break;
			}
			++numberOfSpaces;
		}
		return numberOfSpaces;
	}
	
	private static void display(String s, int times) {
		String temp = "";
		for(int j = 1; j <= times; ++j) {
			temp += s;
		}
		System.out.printf("%s", temp); // minimize the number of output statements
	}
}
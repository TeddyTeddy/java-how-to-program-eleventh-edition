import java.util.Scanner;

public class DuplicateElimination {
	public static void main(String[] args) {
		final int ARRAY_SIZE = 5;
		// init i to one
		int i = 1;
		// init uniqueNumbers array to int[5]
		int[] uniqueNumbers = new int[ARRAY_SIZE]; // elements init to zero
		
		// init Scanner
		Scanner input = new Scanner(System.in);
		while( i <= ARRAY_SIZE ) {
			// getNumber between 10 to 100 into number
			int number = getNumber(input);
			
			if(!isDuplicate(uniqueNumbers, number)) {
				append(uniqueNumbers, number);
			}
			++i;		
		}
		// display uniqueNumbers
		display(uniqueNumbers);
		
		input.close();
	}
	
	private static void display(int[] uniqueNumbers) {
		System.out.println("Unique Numbers entered are:");
		for(int i = 0; i < uniqueNumbers.length; ++i) {
			if(uniqueNumbers[i] == 0) {
				break; // end of unique numbers in uniqueNumbers array (i.e. empty slot)
			}
			System.out.printf("%d  ", uniqueNumbers[i]);
		}
	}
	
	private static void append(int[] uniqueNumbers, int number) {
		// calculate the index of number in uniqueNumbers array
		int i;
		for(i = 0; i < uniqueNumbers.length; ++i ) {
			if(uniqueNumbers[i] == 0) { // empty slot is found
				break;
			}
		}
		// append number into uniqueNumber array at the index of i
		uniqueNumbers[i] = number;
	}
	
	private static boolean isDuplicate(int[] uniqueNumbers, int number) {
		boolean result = false;
		for(int i = 0; i < uniqueNumbers.length; ++i) {
			if(uniqueNumbers[i] == 0) {
				break; // we reached the end of unique number set, we reached an empty slot
			}
			if(uniqueNumbers[i] == number) {
				result = true;
				break;
			}
		}
		return result;
	}
	
	private static int getNumber(Scanner input) {
		System.out.print("Enter a value between 10 & 100 inclusive: ");
		int value = input.nextInt();
		while(!((value >= 10) && (value <= 100))) {
			System.out.print("Incorrect input. Enter a value between 10 & 100 inclusive: ");
			value = input.nextInt();
		}
		return value;
	}
}
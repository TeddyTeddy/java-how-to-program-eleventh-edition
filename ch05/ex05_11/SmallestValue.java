import java.util.Scanner;

public class SmallestValue {
	public static void main(String[] args) {
		// initialize minimumValue to Integer.MAXVALUE
		int minimumValue = Integer.MAX_VALUE;
		Scanner input = new Scanner(System.in);
		
		// prompt user to enter # of integers
		System.out.print("Enter the number of integers: ");
		
		// set numberOfIntegers to inputed value
		int numberOfIntegers = input.nextInt();
		
		// while numberOfIntegers >= 1
		while( numberOfIntegers >= 1 ) {
			// prompt user to enter the value
			System.out.print("Enter an integer: ");
			// set value to inputed value
			int value = input.nextInt();
			// if value < minimumValue
			if( value < minimumValue ) {
				// set minimumValue to value
				minimumValue = value;
			}
			// decrement numberOfIntegers by 1
			--numberOfIntegers;
		}
		
		System.out.printf("The minimum value is: %d ", minimumValue);
		input.close();
	}
}
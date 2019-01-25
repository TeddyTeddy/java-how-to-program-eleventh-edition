import java.util.Scanner;

public class BinaryToDecimalConverter {
	public static void main(String[] args) {
		
		test_power();
		test_getithDigit();
		
		Scanner input = new Scanner(System.in);
		// prompt user to enter a binary number (or -1 to exit)
		System.out.print("Enter a binary number (or -1 to exit): ");
		// input value
		int binaryValue = input.nextInt(); // removes padded zeros from the front (i.e. 0111 -> 111)		
		// while value is not -1
		while(binaryValue != -1) {
			// call convertBinaryToDecimal and output the value
			System.out.printf("Binary %d's decimal equivalent is %d%n", binaryValue, convertBinaryToDecimal(binaryValue));
			System.out.println();
			// prompt user to enter a binary number (or -1 to exit)
			System.out.print("Enter a binary number (or -1 to exit): ");
			// input value
			binaryValue = input.nextInt(); // removes padded zeros from the front (i.e. 0111 -> 111)
		}
		input.close();
	}
	
	// TODO: only accept binaryValue greater than zero, containing only 1's and zeros
	private static int convertBinaryToDecimal(int binaryValue) {
		// initialize variables
			// set i to 1
			// set decimalValue to 0
			// set decimalWeight to 0
		int i = 1;
		int decimalValue = 0;
		
		// while exists ith digit in the binaryValue (i: 1, 2, 3, 4 ...)
		// get ith digit (i = 1)
		int ithDigit = getithDigit(i, binaryValue);
		while( ithDigit != -1) {
			// get ith digit's decimal weight
			int decimalWeight = power(2, (i-1));			
			// increment decimaValue with ith digit * ith digit decimal weight
			decimalValue += (ithDigit * decimalWeight);
			// increment i by 1
			// get ith digit
			ithDigit = getithDigit(++i, binaryValue);
		}
		return decimalValue;
	}
	
	// TODO: check : i cannot be negative or zero
	private static int getithDigit(int i, int binaryValue) {
		// check if ith digit exists
			// form expectAtLeast with ith digit (i.e. i = 3 then expectAtLeast is 100)
			// if binaryValue is greater than or equal to expectAtLeast, then ith digit exists
				// attempt to retrive the ith digit
					// set temp to binaryValue % (power(10, i))
					// set ithDigit = temp / (power(10, (i-1))
		// else
			// return -1
		int expectAtLeast = power(10, (i-1));
		if(binaryValue >= expectAtLeast) {
			// attempt to retrive the ith digit
			// set temp to binaryValue % (power(10, i))
			int temp = binaryValue % (power(10, i));
			// set ithDigit = temp / (power(10, (i-1))
			int ithDigit = temp / power(10, (i-1));
			return ithDigit;
			
		} else {
			return -1; // indicating that digit does not exist
		}
		
	}
		
	private static int power(int a, int b) {
		int counter = 1;
		int result = (b == 0) ? 1 : a;
		while(counter < b) {
			result *= a;
			++counter;
		}
		return result;
	}
	
	private static void test_getithDigit() {
		int binaryValue = 11011;
		
		int i = 1;
		System.out.printf("getithDigit(%d, %d) returns %d%n", i, binaryValue, getithDigit(i, binaryValue) );
		i = 2;
		System.out.printf("getithDigit(%d, %d) returns %d%n", i, binaryValue, getithDigit(i, binaryValue) );
		i = 3;
		System.out.printf("getithDigit(%d, %d) returns %d%n", i, binaryValue, getithDigit(i, binaryValue) );
		i = 4;
		System.out.printf("getithDigit(%d, %d) returns %d%n", i, binaryValue, getithDigit(i, binaryValue) );
		i = 5;
		System.out.printf("getithDigit(%d, %d) returns %d%n", i, binaryValue, getithDigit(i, binaryValue) );
		i = 6;
		System.out.printf("getithDigit(%d, %d) returns %d%n", i, binaryValue, getithDigit(i, binaryValue) );
		i = 7;
		System.out.printf("getithDigit(%d, %d) returns %d%n", i, binaryValue, getithDigit(i, binaryValue) );	
	}
	
	private static void test_power() {
		System.out.printf("power(10, 0) is %d%n", power(10, 0));
		System.out.printf("power(10, 1) is %d%n", power(10, 1));
		System.out.printf("power(10, 2) is %d%n", power(10, 2));
		System.out.printf("power(10, 3) is %d%n", power(10, 3));
		System.out.println();
		System.out.printf("power(2, 0) is %d%n", power(2, 0));
		System.out.printf("power(2, 1) is %d%n", power(2, 1));
		System.out.printf("power(2, 2) is %d%n", power(2, 2));
		System.out.printf("power(2, 3) is %d%n", power(2, 3));
		System.out.println();		
	}	
	
}
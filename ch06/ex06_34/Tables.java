public class Tables {
	
	private static final int TWO = 2;
	private static final int EIGHT = 8;
	private static final int SIXTEEN = 16;
	
	private static final int MAX_VALUE = 256;
	
	public static void main(String[] args) {
		// test_power();
		table_of_binary();
		table_of_octal();
		table_of_hexadecimal();
	}
	
	private static void table_of_binary() {
		System.out.print("Decimal\tBinary Representation\n");
		for(long decimal = 1; decimal <= MAX_VALUE; ++decimal) {
			String binary = getBinaryRepresentation( decimal );
			System.out.printf("%d\t%s%n", decimal, binary);
		}
		System.out.println();
	}
	
	private static void table_of_octal() {
		System.out.print("Decimal\tOctal Representation\n");
		for(long decimal = 1; decimal <= MAX_VALUE; ++decimal) {
			String octal = getOctalRepresentation( decimal );
			System.out.printf("%d\t%s%n", decimal, octal);
		}
		System.out.println();
	}
	
	private static void table_of_hexadecimal() {
		System.out.print("Decimal\tHexadecimal Representation\n");
		for(long decimal = 1; decimal <= MAX_VALUE; ++decimal) {
			String hexadecimal = getHexadecimalRepresentation( decimal );
			System.out.printf("%d\t%s%n", decimal, hexadecimal);
		}
		System.out.println();
	}
	
	// i.e. decimal = 25 --> binary: 11001
	// https://www.google.com/search?client=ubuntu&channel=fs&q=how+to+get+a+binary+equivalent+of+a+decimal+number&ie=utf-8&oe=utf-8#kpvalbx=1
	private static String getBinaryRepresentation(long decimal) {
		return getRepresentation(decimal, TWO);

	}
	
	// i.e. decimal = 25 --> octal:31
	private static String getOctalRepresentation(long decimal) {
		return getRepresentation(decimal, EIGHT);

	}
	
	// i.e. decimal = 25 --> binary: 11001 (base = 2)
	// https://www.google.com/search?client=ubuntu&channel=fs&q=how+to+get+a+binary+equivalent+of+a+decimal+number&ie=utf-8&oe=utf-8#kpvalbx=1
	private static String getRepresentation(long decimal, long base) {
		
		// find the leading digit (i.e. power of 2 being less than the parameter decimal, i.e. 16 )
		long leadingDigit = 1; // power(2, 0)
		long counter = 1;
		while(leadingDigit <= decimal) {
			leadingDigit = power(base, counter);
			++counter;
		}
		leadingDigit /= base; // i.e. 16
		// System.out.printf("%nDecimal: %d, Leading digit: %d%n", decimal, leadingDigit );
		
		String result = "";
		while(leadingDigit >= 1) {
			long digit = decimal / leadingDigit; // i.e. 1 = 25 / 16
			result += Long.toString( digit );
			decimal = decimal % leadingDigit; // i.e. 9 = 25 % 16
			leadingDigit /= base; // i.e. 8
		}
		
		return result;

	}	
	
	// i.e. decimal = 25 --> hexadecimal: 19
	private static String getHexadecimalRepresentation(long decimal) {
		
		// find the leading digit (i.e. power of 2 being less than the parameter decimal, i.e. 16 )
		long leadingDigit = 1; // power(16, 0)
		long counter = 1;
		while(leadingDigit <= decimal) {
			leadingDigit = power(SIXTEEN, counter);
			++counter;
		}
		leadingDigit /= SIXTEEN; // i.e. 16
		// System.out.printf("%nDecimal: %d, Leading digit: %d%n", decimal, leadingDigit );
		
		String result = "";
		while(leadingDigit >= 1) {
			long digit = decimal / leadingDigit; // i.e. 1
			result += getHexadecimalDigit( digit );
			decimal = decimal % leadingDigit; // i.e. 9
			leadingDigit /= SIXTEEN; // i.e. 8
		}
		
		return result;

	}
	
	private static String getHexadecimalDigit(long digit) {
		String result = "Error!!";
		if((digit >= 0) && (digit <= 9)) {
			result = Long.toString(digit);
		} else if(digit == 10) {
			result = "A";
		} else if(digit == 11) {
			result = "B";
		} else if(digit == 12) {
			result = "C";
		} else if(digit == 13) {
			result = "D";
		} else if(digit == 14) {
			result = "E";
		} else if(digit == 15) {
			result = "F";
		}
		
		return result;
	}
	
	private static void test_power() {
		for(int b = 0; b <= 10; ++b ) {
			System.out.printf("power(%d, %d) returns %d%n", TWO, b, power(TWO, b));
			System.out.printf("power(%d, %d) returns %d%n", EIGHT, b, power(EIGHT, b));
			System.out.printf("power(%d, %d) returns %d%n", SIXTEEN, b, power(SIXTEEN, b));
		}
	}
	
	private static long power(long base, long exponent) {
		long result = (exponent == 0) ? 1 : base;
		long counter = 1;
		while(counter < exponent) {
			result *= base;
			++counter;
		}
		return result;
	}
}
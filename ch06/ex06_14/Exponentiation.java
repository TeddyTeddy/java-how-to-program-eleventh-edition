public class Exponentiation {
	public static void main(String[] args) {
		test_integerPower();
	}
	
	private static void test_integerPower() {
		int base = 3;
		for(int exponent = 0; exponent <= 10; ++exponent) {
			System.out.printf("Base: %d, exponent: %d, result: %d%n", base, exponent, integerPower(base, exponent));
		}
	}
	
	private static int integerPower(int base, int exponent) {
		int result = (exponent == 0) ? 1 : base;
		int counter = 1;
		while(counter < exponent) {
			result *= base;
			++counter;
		}
		return result;
	}
}
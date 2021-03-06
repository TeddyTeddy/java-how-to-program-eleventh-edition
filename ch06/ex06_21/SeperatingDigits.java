public class SeperatingDigits {
	public static void main(String[] args) {
		for(int i = 1; i <= 99999; ++i) {
			displayDigits(i);
		}
	}
	
	private static int getIntegerPartOfQuotient(int divident, int divisor) {
		return divident / divisor;  // integer / integer returns an integer
	}
	
	private static int getRemainder(int divident, int divisor) {
		return divident % divisor;
	}
	
	// i.e. number is 4562
	private static void displayDigits(int number) {
		// get the highest 10's power that is less than the number (i.e. highest10sPower is 1000)
		int highest10sPower = 1;
		while(getIntegerPartOfQuotient(number, highest10sPower) != 0) {
			highest10sPower *= 10;
		}
		highest10sPower /= 10;
		
		for (int divisor = highest10sPower; divisor >= 1; divisor /= 10) {
			int digit = getIntegerPartOfQuotient(number, divisor);
			number = getRemainder( number, divisor);
			// output digit
			System.out.printf("%d ", digit);
		}
		// output a new line
		System.out.println();
	}
}
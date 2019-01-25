public class Factorial {
	// TODO: check if n is greater than or equal to 0
	public static int factorial(int n) {
		int result = 1;
		int counter = 1;
		while(counter < n) {
			result *= (++counter);
		}
		return result;
	}
}
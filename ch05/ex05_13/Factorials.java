public class Factorials {
	public static void main(String[] args) {
		System.out.print("n\tFactorial\n");
		for(int n = 1; n <= 20; ++n) {
			System.out.printf("%d!\t%d%n", n, factorial(n) );
		}
		
		int n = 100;
		System.out.printf("%d!\t%d%n", n, factorial(n) );
	}
	
	private static long factorial(long n) {
		long result = 1;
		long counter = 1;
		while (counter <= n) {
			result *= counter;
			++counter;
		}
		return result;
	}
}
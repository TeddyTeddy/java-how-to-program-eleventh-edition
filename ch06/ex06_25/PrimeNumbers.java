public class PrimeNumbers {
	public static void main(String[] args) {
		for(int n = 2; n <= 10000; ++n) {
			if( isPrime(n) ) {
				System.out.printf("%d is prime%n", n);
			}
		}
	}
	
	private static boolean isPrime(int n) {
		int upperLimit = (int) Math.sqrt(n);
		for(int i = 2; i <= upperLimit; ++i) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
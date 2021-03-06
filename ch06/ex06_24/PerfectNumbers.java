public class PerfectNumbers {
	public static void main(String[] args) {
		for(long number = 10000; number >= 1; --number) {
			if(isPerfect(number)) {
				System.out.printf("%d is perfect%n", number);
			}
		}
	}
	
	private static boolean isPerfect(long number) {
		long total = 0;
		for(long i = 1; i < number; ++i) {
			if(number % i == 0) { // i is a factor of number
				total += i; // add factor to total
			}
		}
		return total == number;
	}
}
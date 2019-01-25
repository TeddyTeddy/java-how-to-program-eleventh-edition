public class EvenOrOdd {
	public static void main(String[] args) {
		for(int n = 1; n <= 20; ++n) {
			if(isEven(n)) {
				System.out.printf("%d is even%n", n);
			} else {
				System.out.printf("%d is odd%n", n);
			}
		}
	}
	
	private static boolean isEven(int number) {
		return ((number % 2) == 0);
	}
}
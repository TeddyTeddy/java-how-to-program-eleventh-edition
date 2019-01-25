public class FactorialTest {
	public static void main(String[] args) {
		test_power();
		testFactorial();
		test_e();
		test_e_to_the_power();
	}
	
	private static void testFactorial() {
		int n;
		
		System.out.println("Factorials: ");
		n = 0;
		System.out.printf("%d! : %d%n", n, Factorial.factorial(n));
		n = 1;
		System.out.printf("%d! : %d%n", n, Factorial.factorial(n));
		n = 2;
		System.out.printf("%d! : %d%n", n, Factorial.factorial(n));
		n = 3;
		System.out.printf("%d! : %d%n", n, Factorial.factorial(n));
		n = 4;
		System.out.printf("%d! : %d%n", n, Factorial.factorial(n));
		n = 5;
		System.out.printf("%d! : %d%n", n, Factorial.factorial(n));
		n = 6;
		System.out.printf("%d! : %d%n", n, Factorial.factorial(n));
		n = 7;
		System.out.printf("%d! : %d%n", n, Factorial.factorial(n));
	}
	
	private static void test_e() {
		int numberOfTerms = 0;
		System.out.println();
		System.out.println("e calculation");
		System.out.printf("e formula with numberOfTerms %d: %f%n", numberOfTerms, e(numberOfTerms));
		numberOfTerms = 1;
		System.out.printf("e formula with numberOfTerms %d: %f%n", numberOfTerms, e(numberOfTerms));
		numberOfTerms = 2;
		System.out.printf("e formula with numberOfTerms %d: %f%n", numberOfTerms, e(numberOfTerms));
		numberOfTerms = 3;
		System.out.printf("e formula with numberOfTerms %d: %f%n", numberOfTerms, e(numberOfTerms));
		numberOfTerms = 4;
		System.out.printf("e formula with numberOfTerms %d: %f%n", numberOfTerms, e(numberOfTerms));
		numberOfTerms = 5;
		System.out.printf("e formula with numberOfTerms %d: %f%n", numberOfTerms, e(numberOfTerms));
		numberOfTerms = 6;
		System.out.printf("e formula with numberOfTerms %d: %f%n", numberOfTerms, e(numberOfTerms));
		numberOfTerms = 7;
		System.out.printf("e formula with numberOfTerms %d: %f%n", numberOfTerms, e(numberOfTerms));
		
	}
	
	private static double e(int numberOfTerms) {
		double result = 1.0;
		int counter = 1;
		while(counter <= numberOfTerms) {
			result += ((double) 1 / Factorial.factorial(counter++));
		}
		return result;
	}
	
	
	private static void test_e_to_the_power() {
		int numberOfTerms = 0;
		int x = 3;
		System.out.println();
		System.out.println("e to the power x calculation");
		System.out.printf("e to the power %d formula with numberOfTerms %d: %f%n", x, numberOfTerms, e_to_the_power(numberOfTerms, x));
		numberOfTerms = 1;
		System.out.printf("e to the power %d formula with numberOfTerms %d: %f%n", x, numberOfTerms, e_to_the_power(numberOfTerms, x));
		numberOfTerms = 2;
		System.out.printf("e to the power %d formula with numberOfTerms %d: %f%n", x, numberOfTerms, e_to_the_power(numberOfTerms, x));
		numberOfTerms = 3;
		System.out.printf("e to the power %d formula with numberOfTerms %d: %f%n", x, numberOfTerms, e_to_the_power(numberOfTerms, x));
		numberOfTerms = 4;
		System.out.printf("e to the power %d formula with numberOfTerms %d: %f%n", x, numberOfTerms, e_to_the_power(numberOfTerms, x));
		numberOfTerms = 5;
		System.out.printf("e to the power %d formula with numberOfTerms %d: %f%n", x, numberOfTerms, e_to_the_power(numberOfTerms, x));
		numberOfTerms = 6;
		System.out.printf("e to the power %d formula with numberOfTerms %d: %f%n", x, numberOfTerms, e_to_the_power(numberOfTerms, x));
		numberOfTerms = 7;
		System.out.printf("e to the power %d formula with numberOfTerms %d: %f%n", x, numberOfTerms, e_to_the_power(numberOfTerms, x));		
		numberOfTerms = 8;
		System.out.printf("e to the power %d formula with numberOfTerms %d: %f%n", x, numberOfTerms, e_to_the_power(numberOfTerms, x));		
		numberOfTerms = 9;
		System.out.printf("e to the power %d formula with numberOfTerms %d: %f%n", x, numberOfTerms, e_to_the_power(numberOfTerms, x));		
		numberOfTerms = 10;
		System.out.printf("e to the power %d formula with numberOfTerms %d: %f%n", x, numberOfTerms, e_to_the_power(numberOfTerms, x));		
		numberOfTerms = 11;
		System.out.printf("e to the power %d formula with numberOfTerms %d: %f%n", x, numberOfTerms, e_to_the_power(numberOfTerms, x));		

	}
	
	private static double e_to_the_power(int numberOfTerms, int x) {
		double result = 1.0;
		int counter = 1;
		while(counter <= numberOfTerms) {
			int temp = power(x, counter);
			result += ((double) (temp) / Factorial.factorial(counter++));
		}
		return result;
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
	
	private static int power(int a, int b) {
		int counter = 1;
		int result = (b == 0) ? 1 : a;
		while(counter < b) {
			result *= a;
			++counter;
		}
		return result;
	}
	
}
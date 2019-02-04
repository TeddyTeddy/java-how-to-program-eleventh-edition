public class VariableLengthArgumentList {
	public static void main(String[] args) {
		System.out.printf("product(10, 20) returns %d%n", product(10, 20));
		System.out.printf("product(10, 20, 3) returns %d%n", product(10, 20, 3));
		System.out.printf("product(10, 20, 3, 0) returns %d%n", product(10, 20, 3, 0));
	}
	
	private static long product(int...numbers) {
		long result = 1;
		for(int value : numbers) {
			result *= value;
		}
		return result;
	}
}
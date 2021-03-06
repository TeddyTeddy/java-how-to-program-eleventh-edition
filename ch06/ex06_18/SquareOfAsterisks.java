public class SquareOfAsterisks {
	public static void main(String[] args) {
		for(int size = 1; size <= 10; ++size) {
			squareOfAsterisks(size);
		}
	}
	
	private static void squareOfAsterisks(int size) {
		System.out.printf("%nSquare of size %d%n", size);
		for(int i = size; i >= 1; --i) {
			for(int j = size; j >= 1; --j) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
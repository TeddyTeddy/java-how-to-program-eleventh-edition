public class MultiplesOf2WithAnInfiniteLoop {
	public static void main(String[] args) {
		int startValue = 2;
		while(true) {
			System.out.printf("%d%n", startValue);
			startValue *= 2;
		}
	}
}
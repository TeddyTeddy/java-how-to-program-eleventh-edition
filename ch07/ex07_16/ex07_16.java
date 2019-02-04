public class ex07_16 {
	public static void main(String[] args) {
		double sum = 0.0;
		for(String arg : args) {
			sum += Double.parseDouble(arg);
		}
		System.out.printf("Sum of command line arguments is %.2f%n", sum);
	}
}
import java.util.Scanner;

public class RoundingNumbers {
	private static final double SENTINEL = -1.0;
	public static void main(String[] args) {
		double x;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter x (-1 to exit): ");
		x = input.nextDouble();
		while(x != SENTINEL) {
			double y = Math.floor(x + 0.5);
			System.out.printf("%f = Math.floor(%f + 0.5)%n", y, x);
			System.out.print("Enter x (-1 to exit): ");
			x = input.nextDouble();			
		}
		input.close();
	}
}
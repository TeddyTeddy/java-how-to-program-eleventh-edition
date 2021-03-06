import java.util.Scanner;

public class FindTheMinimum {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a (in double): ");
		double a = input.nextDouble();
		
		System.out.print("Enter b (in double): ");
		double b = input.nextDouble();
		
		System.out.print("Enter c (in double): ");
		double c = input.nextDouble();
		
		System.out.printf("Minimum: %f%n", minimum3(a, b, c));
		input.close();
	}
	
	private static double minimum3(double a, double b, double c) {
		return Math.min(a, Math.min(b, c));
	}
}
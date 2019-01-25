import java.util.Scanner;

public class Circle {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the circles radious: ");
		int r = input.nextInt();
		
		System.out.printf("Diameter = %d%n", (2*r));
		System.out.printf("Circumfrence = %f%n", (2*Math.PI*r));
		System.out.printf("Area: %f%n", (Math.PI*r*r));
	}
}
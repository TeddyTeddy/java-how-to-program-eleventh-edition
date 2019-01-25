import java.util.Scanner;

public class DistanceBetweenPoints {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter x1: ");
		double x1 = input.nextDouble();
		
		System.out.print("Enter y1: ");
		double y1 = input.nextDouble();
		
		System.out.print("Enter x2: ");
		double x2 = input.nextDouble();
		
		System.out.print("Enter y2: ");
		double y2 = input.nextDouble();
		
		System.out.printf("Distance: %f%n", distance(x1, y1, x2, y2));
		input.close();
	}
	
	private static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt( Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2) );
	}
}
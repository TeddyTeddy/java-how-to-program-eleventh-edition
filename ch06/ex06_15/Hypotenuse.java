public class Hypotenuse {
	public static void main(String[] args) {
		double side1, side2;
		
		side1 = 3.0;
		side2 = 4.0;
		System.out.printf("side1: %f, side2: %f, hypotenuse: %f%n", side1, side2, hypotenuse(side1, side2));
		
		side1 = 5.0;
		side2 = 12.0;
		System.out.printf("side1: %f, side2: %f, hypotenuse: %f%n", side1, side2, hypotenuse(side1, side2));
		
		side1 = 8.0;
		side2 = 15.0;
		System.out.printf("side1: %f, side2: %f, hypotenuse: %f%n", side1, side2, hypotenuse(side1, side2));
	}
	
	private static double hypotenuse(double side1, double side2) {
		return Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2) );
	}
}
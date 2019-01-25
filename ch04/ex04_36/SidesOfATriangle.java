import java.util.Scanner;

public class SidesOfATriangle {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// initialize sides of a triangle
		int a = getSide("1.st side of the triangle", input);
		int b = getSide("2.nd side of the triangle", input);
		int c = getSide("3.rd side of the triangle", input);
		// if isTriangle(a,b,c) returns true
		if(isTriangle(a,b,c)) {
			System.out.printf("%d %d and %d forms a triangle", a, b, c);
		} else {
			System.out.printf("%d %d and %d does not form a triangle", a, b, c);
		}
		input.close();
	}
	
	private static int getSide(String sideName, Scanner input) {
		int side = -1; // invalid
		while(side <= 0) {
			System.out.printf("Enter %s (must be greater than zero): ", sideName);
			side = input.nextInt();
		}
		return side;
	}
	
	private static boolean isTriangle(int a, int b, int c) {
		boolean result = false;
		if((a+b) >= c) {
			if((b+c) >= a) {
				if((c+a) >= b) {
					result = true;
				}
			}
		}
		return result;
	}
}
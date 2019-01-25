import java.util.Scanner;

public class Arithmetic {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the first integer: ");
		int x = input.nextInt();
		
		System.out.print("Enter the second integer: ");
		int y = input.nextInt();
		
		int sum = x + y;
		System.out.printf("%d + %d = %d%n", x, y, sum);
		
		int product = x * y;
		System.out.printf("%d * %d = %d%n", x, y, product);
		
		int diff = x - y;
		System.out.printf("%d - %d = %d%n", x , y, diff);
		
		int division = x / y;
		System.out.printf("%d / %d = %d%n", x, y, division);
		
	}
}
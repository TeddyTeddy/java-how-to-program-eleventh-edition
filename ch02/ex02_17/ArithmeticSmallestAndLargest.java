import java.util.Scanner;
import java.lang.Math;

public class ArithmeticSmallestAndLargest {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the first integer: ");
		int x = input.nextInt();
		
		System.out.print("Enter the second integer: ");
		int y = input.nextInt();
		
		System.out.print("Enter the third integer: ");
		int z = input.nextInt();
		
		int sum = x + y + z;
		System.out.printf("Sum: %d%n", sum);
		
		int average = sum / 3;
		System.out.printf("Average: %d%n", average);
		
		int product = x * y * z;
		System.out.printf("Product: %d%n", product);
		
		int smallest = Math.min(x,y);
		smallest = Math.min(smallest, z);
		System.out.printf("Smallest: %d%n", smallest);
		
		int largest = Math.max(x, y);
		largest = Math.max(largest, z);
		System.out.printf("Largest: %d%n", largest);
		
	}
}
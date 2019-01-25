import java.util.Scanner;
import java.lang.Math;

public class LargestAndSmallestIntegers {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter 1.st integer: ");
		int a = input.nextInt();
		
		System.out.print("Enter 2.nd integer: ");
		int b = input.nextInt();
		
		System.out.print("Enter 3.rd integer: ");
		int c = input.nextInt();
		
		System.out.print("Enter 4.th integer: ");
		int d = input.nextInt();
		
		System.out.print("Enter 5.th integer: ");
		int e = input.nextInt();
		
		int smallest = Math.min(a,b);
		smallest = Math.min(smallest, c);
		smallest = Math.min(smallest, d);
		smallest = Math.min(smallest, e);
		System.out.printf("Smallest: %d%n", smallest);
		
		int largest = Math.max(a,b);
		largest = Math.max(largest, c);
		largest = Math.max(largest, d);
		largest = Math.max(largest, e);
		System.out.printf("Largest: %d%n", largest);		
	
	}
}
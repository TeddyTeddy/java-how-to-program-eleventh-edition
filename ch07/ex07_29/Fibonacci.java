import java.util.Scanner;
import java.util.ArrayList;

public class Fibonacci {
	private static int INTEGER_OVERFLOW = -1;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a positive number: ");
		int n = input.nextInt();
		fibonacci_a(n);
		
		// determine the largest Fibonacci number that can be displayed on your system
		for(n = 1; n <=300; ++n) {
			int fn = fibonacci_b(n);  // fibonacci_b(47) returns 1836311903
			if(fn == INTEGER_OVERFLOW) {
				break; // fibonacci_b(48) returns INTEGER_OVERFLOW
			}
		}
		input.close();
	}
	
	private static void fibonacci_a(int n) {
		ArrayList<Integer> fibonacciSeries = new ArrayList<Integer>(); // initialize an array list of capacity 10
		fibonacciSeries.add(0);
		fibonacciSeries.add(1); 
		for(int i = 2; i < n; ++i) {
			// each succeeding term is the sum of the two preceding terms
			int newElement = fibonacciSeries.get(i-2) + fibonacciSeries.get(i-1);
			fibonacciSeries.add(newElement);
		}
		System.out.printf("fibonacci_a(%d) returns %d%n", n, fibonacciSeries.get(n-1));
	}
	
	// creates a Fibonacci series. During the Fibonacci series creation up to the n.th Fibonacci number
	// if there is an overflow, it is detected and INTEGER_OVERFLOW is returned to the caller
	// if there is no overflow, then the n.th Fibonacci number is returned to the user
	private static int fibonacci_b(int n) {
		ArrayList<Integer> fibonacciSeries = new ArrayList<Integer>(); // initialize an array list of capacity 10
		fibonacciSeries.add(0); // 1.st Fibonacci number
		fibonacciSeries.add(1); // 2.nd Fibonacci number

		for(int i = 2; i < n; ++i) {
			// each succeeding term is the sum of the two preceding terms
			// https://stackoverflow.com/questions/21233582/how-can-i-detect-integer-overflow-on-32-bits-int			
			long left = (long) fibonacciSeries.get(i-2);
			long right = (long) fibonacciSeries.get(i-1);
			if(right > 0 ? (left > Integer.MAX_VALUE - right) : ((left) < Integer.MIN_VALUE - right)) {
				fibonacciSeries.add(INTEGER_OVERFLOW); // fibonacciSeries[47] has INTEGER_OVERFLOW
				break;
			} else { // no integer overflow
				fibonacciSeries.add(fibonacciSeries.get(i-2) + fibonacciSeries.get(i-1));
			}
		}
		System.out.printf("fibonacci_b(%d) returns %d%n", n, fibonacciSeries.get(n-1));
		return fibonacciSeries.get(n-1);
	}
}
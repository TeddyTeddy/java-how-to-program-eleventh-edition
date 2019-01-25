import java.util.Scanner;

public class FindTheLargestNumber {
	public static void main(String[] args) {
		// initialize counter to 1
		int counter = 0;
		// init largest to Integer.MIN_VALUE
		int largest = Integer.MIN_VALUE;
		Scanner input = new Scanner(System.in);
		
		// while counter is less than or equal to ten
		while(counter <= 10) {
			// input an integer into number
			System.out.print("Enter an integer: ");
			int number = input.nextInt();
			// if number is greater than largest
			if(number > largest) {
				// set largest to number
				largest = number;
			}
			// increase counter by 1	
			counter += 1;
		}
		input.close();
		
		// output the largest number
		System.out.printf("%nThe largest number entered is: %d", largest);
	}
}
// https://codereview.stackexchange.com/questions/177026/find-the-two-largest-integers-in-a-list
import java.util.Scanner;

public class FindTheTwoLargestNumbers {
	public static void main(String[] args) {
		// initialize counter to 1
		int counter = 1;
		// init largest to Integer.MIN_VALUE
		int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;
		
		Scanner input = new Scanner(System.in);
		
		// while counter is less than or equal to ten
		while(counter <= 10) {
			// input an integer into number
			System.out.print("Enter an integer: ");
			int number = input.nextInt();
			// if number is greater than largest
			if(number > largest) {
				// set largest to secondLargest
				secondLargest = largest;
				// set largest to number
				largest = number;
			} else if(number > secondLargest) {
				secondLargest = number;
			}
			// increase counter by 1	
			counter += 1;
		}
		input.close();
		
		// output the largest number
		System.out.printf("%nThe largest number entered is: %d", largest);
		System.out.printf("%nThe second largest number entered is: %d", secondLargest);
	}
}
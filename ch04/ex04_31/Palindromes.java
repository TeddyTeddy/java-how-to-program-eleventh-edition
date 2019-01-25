import java.util.Scanner;

public class Palindromes {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// prompt user to enter a five digit integer
		System.out.print("Enter a five digit integer: ");
		// input value
		int value = input.nextInt();
		
		// while value is not in the range 10000 - 99999
		while(!((value >=10000) && (value <= 99999))) {
			// prompt user to enter a five digit integer
			System.out.print("Enter a five digit integer: ");
			// input value
			value = input.nextInt();
		}
		// check isPalindrome(value)
		if(isPalindrome(value)) {
			// print value is palindrome
			System.out.printf("%d is a palindrome", value);
		} else {
			// print value is not palindrome
			// print value is palindrome
			System.out.printf("%d is NOT a palindrome", value);			
		}
	}
	
	// @value: expects a 5 digit integer
	// TODO: throw an exception if value is not 5 digit
	private static boolean isPalindrome(int value) {
		// initialize variables
			// fifthDigit to 5th digit
			// fourthDigit to 4th digit
			// secondDigit to 2nd digit
			// firstDigit to 1st digit
		int fifthDigit = getfifthDigit(value);
		int fourthDigit = getfourthDigit(value);
		int secondDigit = getsecondDigit(value);
		int firstDigit = getfirstDigit(value);
		// return true if
			// 5th digit is equal to firstDigit
			// AND
			// 2nd digit is equal to fourthDigit
		// return false otherwise
		if((fifthDigit == firstDigit) && (fourthDigit == secondDigit)) {
			return true;
		} else {
			return false;
		}
	}
	private static int getfifthDigit(int value) {
		return (value / 10000);
	}
	private static int getfourthDigit(int value) {
		int temp = value % 10000;
		return (temp / 1000);
	}
	private static int getsecondDigit(int value) {
		int temp = value % 100;
		return (temp / 10);
	}
	private static int getfirstDigit(int value) {
		return value % 10;
	}	
}
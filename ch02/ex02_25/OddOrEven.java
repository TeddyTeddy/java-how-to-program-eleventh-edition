import java.util.Scanner;

public class OddOrEven {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter an integer: ");
		int x = input.nextInt();
		
		if((x % 2) == 0) {
			System.out.printf("%d is even", x);
		} else {
			System.out.printf("%d is odd", x);
		}
	}
}
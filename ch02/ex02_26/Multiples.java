import java.util.Scanner;

public class Multiples {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the first integer: ");
		int x = input.nextInt();
		
		System.out.print("Enter the second integer: ");
		int y = input.nextInt();
		
		// swap x & y if y is greater than x
		if(x < y) {
			int temp = x;
			x = y;
			y = temp;
		}
		
		// x must be greater than y here, as we use the % operator
		// otherwise we would get 0 as the remainder result always
		if((x % y) == 0) {
			System.out.printf("%d is multiple of %d", x, y);
		} else {
			System.out.printf("%d is NOT multiple of %d", x, y);
		}
	}
}
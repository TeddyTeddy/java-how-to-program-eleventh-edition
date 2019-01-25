import java.util.Scanner;

public class BarChart {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// initialize five variables between 1 to 30
		int num1 = getValue(input);
		int num2 = getValue(input);
		int num3 = getValue(input);
		int num4 = getValue(input);
		int num5 = getValue(input);
		
		display(num1);
		display(num2);
		display(num3);
		display(num4);
		display(num5);
		
		input.close();
	}
	
	private static void display(int num) {
		if(num <= 0) {
			return;
		}
		
		System.out.println();
		System.out.printf("%d: ", num);
		while(num >= 1) {
			System.out.print("*");
			--num;
		}
		System.out.println();
	}
	
	private static int getValue(Scanner input) {
		int result = -1;
		while( !((result >= 1 ) && (result <= 30)) ) {
			System.out.print("Enter a number between 1 and 30: ");
			result = input.nextInt();
		}
		return result;
	}
}
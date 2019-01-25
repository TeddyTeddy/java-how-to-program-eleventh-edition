import java.util.Scanner;

public class ComparingIntegers {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the first number: ");
		int x = input.nextInt();
		
		System.out.print("Enter the second number: ");
		int y = input.nextInt();
		
		if(x > y) {
			System.out.printf("%d is larger%n", x);
		} 
		
		if(y > x) {
			System.out.printf("%d is larger%n", y);
		}
		
		if(x == y){
			System.out.print("These numbers are equal\n");
		}
		
	}
}
import java.util.Scanner;

public class DigitsInAnInteger {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
	
		System.out.print("Enter an integer: ");
		long value = input.nextLong();
		
		// find the 10's largest power that is smaller than value
        long power = 1;
        while (power <= value) {
            power *= 10;
        }
        power /= 10;
        
        // print each digit
        while (power >= 1) {  // 1 / 10 is 0
            System.out.printf("%d ", value/power);
            value %= power;
            power /= 10;
        }
        
        System.out.printf("%n1 / 10 is %d", (1/10));
        input.close();
	}
}
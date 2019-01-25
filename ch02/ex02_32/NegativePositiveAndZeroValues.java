import java.util.Scanner;

public class NegativePositiveAndZeroValues {
	public static void main(String[] args) {
		
		int numberOfPositiveNumbers = 0;
		int numberOfNegativeNumbers = 0;
		int numberOfZeros = 0;
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter 1.st integer: ");
		int a = input.nextInt();
		
		if(a > 0) numberOfPositiveNumbers++;
		if(a < 0) numberOfNegativeNumbers++;
		if(a == 0) numberOfZeros++;
		
		System.out.print("Enter 2.nd integer: ");
		int b = input.nextInt();
		
		if(b > 0) numberOfPositiveNumbers++;
		if(b < 0) numberOfNegativeNumbers++;
		if(b == 0) numberOfZeros++;

		System.out.print("Enter 3.rd integer: ");
		int c = input.nextInt();
		
		if(c > 0) numberOfPositiveNumbers++;
		if(c < 0) numberOfNegativeNumbers++;
		if(c == 0) numberOfZeros++;

		System.out.print("Enter 4.th integer: ");
		int d = input.nextInt();
		
		if(d > 0) numberOfPositiveNumbers++;
		if(d < 0) numberOfNegativeNumbers++;
		if(d == 0) numberOfZeros++;

		System.out.print("Enter 5.th integer: ");
		int e = input.nextInt();
		
		if(e > 0) numberOfPositiveNumbers++;
		if(e < 0) numberOfNegativeNumbers++;
		if(e == 0) numberOfZeros++;

		System.out.printf("Number of negative numbers input: %d%n", numberOfNegativeNumbers);
		System.out.printf("Number of positive numbers input: %d%n", numberOfPositiveNumbers);
		System.out.printf("Number of zeros input: %d%n", numberOfZeros);
	
		input.close();
	}
}
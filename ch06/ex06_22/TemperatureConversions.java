import java.util.Scanner;

public class TemperatureConversions {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter celsius degree: ");
		double c = input.nextDouble();
		System.out.printf("%f celsius = %f fahrenheit%n", c, fahrenheit(c));
		
		System.out.print("Enter fahrenheit degree: ");
		double f = input.nextDouble();
		System.out.printf("%f fahrenheit = %f celsius%n", f, celsius(f));
		
		input.close();
	}
	
	private static double celsius(double fahrenheit) {
		return 5.0 / 9.0 * (fahrenheit - 32);
	}
	
	private static double fahrenheit(double celsius) {
		return 9.0 / 5.0 * celsius + 32;
	}
}
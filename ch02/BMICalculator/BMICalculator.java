import java.util.Scanner;

public class BMICalculator {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter weight in kilograms: ");
		float weight = input.nextInt();
		
		System.out.print("Enter height in meters: ");
		float height = input.nextFloat();
		
		float bmi = weight / (height * height);
		System.out.printf("BMI: %f%n", bmi);
		
		System.out.println("***************");
		System.out.println("Underweight = <18.5");
		System.out.println("Normal weight = 18.5–24.9");
		System.out.println("Overweight = 25–29.9");
		System.out.println("Obesity = BMI of 30 or greater");
		input.close();
	}
}
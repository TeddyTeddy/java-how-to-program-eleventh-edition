import java.util.Scanner;
import java.time.LocalDate;
import java.time.Month;


public class HealthProfileTest {
	public static void main(String[] args) {
		
		System.out.println("***************");
		System.out.println("Underweight = <18.5");
		System.out.println("Normal weight = 18.5–24.9");
		System.out.println("Overweight = 25–29.9");
		System.out.println("Obesity = BMI of 30 or greater");
		System.out.println("***************");
		
		LocalDate dateOfBirth = LocalDate.of(1978, Month.APRIL, 27);
		double height = 1.84;
		double weight = 72;
		HealthProfile hakanCuzdan = new HealthProfile("Hakan", "Cuzdan", "male", height, weight, dateOfBirth);
		printHealthProfile(hakanCuzdan);
		
		String firstName, lastName;
		int year, month, day;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter first name: "); // Helena
		firstName = input.nextLine();
		
		System.out.print("Enter last name: ");  // Holm
		lastName = input.nextLine();		
		
		System.out.print("Enter birth day (1-31): "); // 11
		day = input.nextInt();
		
		System.out.print("Enter birth month (1-12): "); // 10
		month = input.nextInt();
		
		System.out.print("Enter birth year: "); // 1984
		year = input.nextInt();

		System.out.print("Enter height in meters: ");
		height = input.nextDouble();
		
		System.out.print("Enter weight in kilograms: ");
		weight = input.nextDouble();
		
		dateOfBirth = LocalDate.of(year, month, day);
		HealthProfile helenaHolm = new HealthProfile(firstName, lastName, "female", height, weight, dateOfBirth);
		printHealthProfile(helenaHolm);
		
		input.close();
		
	}
	private static void printHealthProfile(HealthProfile hp) {
		System.out.println();
		System.out.println("INFO:");
		System.out.printf("%s %s%n", hp.getFirstName(), hp.getLastName());
		System.out.printf("Gender: %s%n", hp.getGender());
		System.out.printf("Date of birth: %s%n", hp.getDateOfBirth().toString());
		System.out.printf("Weight: %.2f%n", hp.getWeight());
		System.out.printf("Height: %.2f%n", hp.getHeight());
		System.out.printf("Age: %d%n", hp.getPersonsAge());
		System.out.printf("Max heart rate: %d%n", hp.getMaxHeartRate());
		System.out.printf("Target heart rate range: %d - %d%n", hp.getTargetHeartRangeMin(), hp.getTargetHeartRangeMax());
		System.out.printf("BMI: %.2f%n", hp.getBMI());
	}
}
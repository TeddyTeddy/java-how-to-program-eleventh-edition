import java.util.Scanner;
import java.time.LocalDate;
import java.time.Month;


public class HeartRatesTest {
	public static void main(String[] args) {
		
		LocalDate dateOfBirth = LocalDate.of(1978, Month.APRIL, 27);
		HeartRates hakanCuzdan = new HeartRates("Hakan", "Cuzdan", dateOfBirth);
		printHeartRates(hakanCuzdan);
		
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

		dateOfBirth = LocalDate.of(year, month, day);
		HeartRates helenaHolm = new HeartRates(firstName, lastName, dateOfBirth);
		printHeartRates(helenaHolm);
		
		input.close();
		
	}
	private static void printHeartRates(HeartRates hr) {
		System.out.println();
		System.out.println("INFO:");
		System.out.printf("%s %s%n", hr.getFirstName(), hr.getLastName());
		System.out.printf("Age: %d%n", hr.getPersonsAge());
		System.out.printf("Max heart rate: %d%n", hr.getMaxHeartRate());
		System.out.printf("Target heart rate range: %d - %d%n", hr.getTargetHeartRangeMin(), hr.getTargetHeartRangeMax());
	}
}
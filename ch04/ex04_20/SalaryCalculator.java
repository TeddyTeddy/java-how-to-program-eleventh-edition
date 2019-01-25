import java.util.Scanner;

// An app that determines the gross pay for each of the 3 employees
public class SalaryCalculator {
	public static void main(String[] args) {
		// initialize variables
		// numberOfHoursWorked to zero
		double numberOfHoursWorkedWeekly = 0.0;
		// hourlyRate to zero
		double hourlyRate = 0.0;
		
		Scanner input = new Scanner(System.in);
		
		// Prompt user to enter for employee1
		System.out.printf("%nFor emp[oyee1:%n");
		// Input # of hours worked last week
		System.out.print("Enter the number of hours worked: ");
		numberOfHoursWorkedWeekly = input.nextDouble();		
		// Input hourly rate for the employee
		System.out.print("Enter the hourly rate for the employee: ");
		hourlyRate = input.nextDouble();
		// Create employee1 object with the inputed values
		Employee employee1 = new Employee(numberOfHoursWorkedWeekly, hourlyRate);
		// Output the gross pay for the employee
		System.out.printf("Weekly gross pay for employee 1 is %.2f%n", employee1.calculateWeeklyGrossPay());
		
		// Prompt user to enter for employee2
		System.out.printf("%nFor emp[oyee2:%n");
		// Input # of hours worked last week
		System.out.print("Enter the number of hours worked: ");
		numberOfHoursWorkedWeekly = input.nextDouble();		
		// Input hourly rate for the employee
		System.out.print("Enter the hourly rate for the employee: ");
		hourlyRate = input.nextDouble();		
		// Create employee2 object with the inputed values
		Employee employee2 = new Employee(numberOfHoursWorkedWeekly, hourlyRate);		
		// Output the gross pay for the employee
		System.out.printf("Weekly gross pay for employee 2 is %.2f%n", employee2.calculateWeeklyGrossPay());
		
		// Prompt user to enter for employee2
		System.out.printf("%nFor emp[oyee3:%n");
		// Input # of hours worked last week
		System.out.print("Enter the number of hours worked: ");
		numberOfHoursWorkedWeekly = input.nextDouble();		
		// Input hourly rate for the employee
		System.out.print("Enter the hourly rate for the employee: ");
		hourlyRate = input.nextDouble();		
		// Create employee2 object with the inputed values
		Employee employee3 = new Employee(numberOfHoursWorkedWeekly, hourlyRate);		
		// Output the gross pay for the employee
		System.out.printf("Weekly gross pay for employee 3 is %.2f%n", employee3.calculateWeeklyGrossPay());
		
		input.close();
	}
}


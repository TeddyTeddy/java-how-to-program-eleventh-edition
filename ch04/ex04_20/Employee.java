// Employee class that calculates the gross pay for its instances
public class Employee {
	private double weeklyHoursWorked;
	private double hourlyRate;
	
	public Employee(double weeklyHoursWorked, double hourlyRate) {
		this.weeklyHoursWorked = weeklyHoursWorked;
		this.hourlyRate = hourlyRate;
	}
	
	public double calculateWeeklyGrossPay() {
		double weeklyGrossPay = 0.0;
		if(weeklyHoursWorked > 40) {
			weeklyGrossPay += (weeklyHoursWorked - 40) * 1.5 * hourlyRate;
			weeklyGrossPay += 40 * hourlyRate;
		} else {
			weeklyGrossPay += weeklyHoursWorked * hourlyRate;
		}
		return weeklyGrossPay;
	}
}
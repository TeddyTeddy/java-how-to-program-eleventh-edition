public class HourlyEmployeeTest {
	public static void main(String[] args) {
		testHourlyEmployeeConstructor();
		testHourlyEmployeeMethods();
	}
	
	private static void testHourlyEmployeeConstructor() {
		try {
			HourlyEmployee hourlyEmployee = new HourlyEmployee("Tom", "Jones", "1234-4567", -30, 100); // invalid hours
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			HourlyEmployee hourlyEmployee = new HourlyEmployee("Tom", "Jones", "1234-4567", 300, 100); // invalid hours
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			HourlyEmployee hourlyEmployee = new HourlyEmployee("Tom", "Jones", "1234-4567", 30, -100); // valid hours, invalid wage
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			HourlyEmployee hourlyEmployee = new HourlyEmployee("Tom", "Jones", "1234-4567", 30, 100); // valid hours, valid wage
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void testHourlyEmployeeMethods() {
		try {
			HourlyEmployee hourlyEmployee = new HourlyEmployee("Tom", "Jones", "1234-4567", 30, 100); // valid hours, valid wage
			System.out.println(hourlyEmployee);
			System.out.printf("Earnings: %.2f%n", hourlyEmployee.earnings());
			hourlyEmployee.setHours(55.0);
			System.out.printf("Earnings: %.2f%n", hourlyEmployee.earnings());
			hourlyEmployee.setWage(2000.00);
			System.out.printf("Earnings: %.2f%n", hourlyEmployee.earnings());
			
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}	
	}
}
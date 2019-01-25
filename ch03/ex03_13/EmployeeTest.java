public class EmployeeTest {
	public static void main(String[] args) {
		
		Employee employee1 = new Employee("Hakan", "Cuzdan", 5000.00);
		Employee employee2 = new Employee("Helena","Holm", 3500);
		
		printEmployee(employee1);
		printEmployee(employee2);
		
		employee1.setMonthlySalary(employee1.getMonthlySalary() * 1.1); // %10 raise in salary
		employee2.setMonthlySalary(employee2.getMonthlySalary() * 1.1); // %10 raise in salary
	
		printEmployee(employee1);
		printEmployee(employee2);		
	}
	
	private static void printEmployee(Employee employee) {
		System.out.println();
		System.out.printf("Name: %s%n", employee.getName());
		System.out.printf("Last Name: %s%n", employee.getLastName());
		System.out.printf("Monthly salary: %.2f%n", employee.getMonthlySalary());
		System.out.printf("Yearly salary: %.2f%n", (employee.getMonthlySalary()*12));
	}
}
public class EmployeeTest {
	public static void main(String[] args) {
		
		CommissionCompansationModel ccm = new CommissionCompansationModel(1000.0, 0.3);
		BasePlusCommissionCompensationModel bpccm = new BasePlusCommissionCompensationModel(5000.0, 0.25, 1000.0);
		
		Employee employee1 = new Employee("John", "Brown", "1234-5678", ccm);
		Employee employee2 = new Employee("Snoop", "Dog", "2222-3333", bpccm);
		
		System.out.printf("Employee 1:%n%s",employee1);				   // polymorphic behavior
		System.out.printf("Earnings: %.2f%n%n", employee1.earnings()); // polymorphic behavior
		
		System.out.printf("Employee 2:%n%s",employee2);				   // polymorphic behavior
		System.out.printf("Earnings: %.2f%n%n", employee2.earnings()); // polymorphic behavior
		
		// swapping the compensation model objects in employees
		employee1.setCompensationModel(bpccm);
		employee2.setCompensationModel(ccm);
		
		System.out.println("After swapping the compansation models: ");
		
		System.out.printf("Employee 1:%n%s",employee1);				   // polymorphic behavior
		System.out.printf("Earnings: %.2f%n%n", employee1.earnings()); // polymorphic behavior
		
		System.out.printf("Employee 2:%n%s",employee2);				   // polymorphic behavior
		System.out.printf("Earnings: %.2f%n%n", employee2.earnings()); // polymorphic behavior	
		
	}
}
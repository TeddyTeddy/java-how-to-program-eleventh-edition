public class Employee {
	private String name;
	private String lastName;
	private double monthlySalary;
	
	public Employee(String name, String lastName, double monthlySalary) {
		setMonthlySalary(monthlySalary);
		this.name = name;
		this.lastName = lastName;
	}
	
	public void setMonthlySalary(double monthlySalary) {
		if(monthlySalary > 0.0) {
			this.monthlySalary = monthlySalary;
		}
	}
	
	public double getMonthlySalary() {
		return monthlySalary;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}	
}
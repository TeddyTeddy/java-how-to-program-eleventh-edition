class HourlyEmployee extends Employee {
	// instance variables
	private double hours;
	private double wage;
	
	public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double hours, double wage) {
		super(firstName, lastName, socialSecurityNumber);
		
		if((hours < 0) || (hours > 168)) {
			throw new IllegalArgumentException("HourlyEmployee constructor : Exception : hours must be in the range [0-168]");
		}
		
		if(wage < 0) {
			throw new IllegalArgumentException("HourlyEmployee constructor : Exception : wage cannot be negative");
		}
		
		this.hours = hours;
		this.wage = wage;
	}
	
	public void setHours(double hours) {
		if((hours < 0) || (hours > 168)) {
			throw new IllegalArgumentException("HourlyEmployee setHours() : Exception : hours must be in the range [0-168]");
		}
		this.hours = hours;
	}
	
	public double getHours() {
		return hours;
	}
	
	public void setWage(double wage) {
		if(wage < 0) {
			throw new IllegalArgumentException("HourlyEmployee setWage() : Exception : wage cannot be negative");
		}
		this.wage = wage;		
	}
	
	public double getWage() {
		return wage;
	}
	
	public double earnings() {
		double result = 0.0;
		double hoursWorked = getHours();
		if(hoursWorked > 40) {
			result += (hoursWorked - 40) * getWage() * 1.5; // gets paid with time and a half for hours worked over 40 hours
			hoursWorked -= 40;
		}
		result += hoursWorked * getWage(); // for hours worked under 40 hours
		return result;
	}
	
	@Override
	public String toString() {
		return String.format("Hourly employees hours : %.2f and wage: %.2f. %s%n", getHours(), getWage(), super.toString());
	}
}
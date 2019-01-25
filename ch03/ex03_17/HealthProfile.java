import java.time.LocalDate;
import java.time.Period;

public class HealthProfile {
	private String firstName;
	private String lastName;
	private String gender;
	private LocalDate dateOfBirth;
	double height;
	double weight;
	
	public HealthProfile(String firstName, String lastName, String gender, 
			double height, double weight, LocalDate dateOfBirth) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.dateOfBirth = dateOfBirth;
	}
	
	public double getBMI() {
		return weight / (height * height);
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight; 
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height; 
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setDateOfBirth(LocalDate date) {
		this.dateOfBirth = date;
	}
	
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getPersonsAge() {
		LocalDate today = LocalDate.now();
		Period period = Period.between(dateOfBirth, today);
		return period.getYears();
	}
	
	public int getMaxHeartRate() {
		return 220 - getPersonsAge();
	}
	
	public int getTargetHeartRangeMin() {
		return (int) (getMaxHeartRate()*.5);
	}
	
	public int getTargetHeartRangeMax() {
		return (int) (getMaxHeartRate()*.85);
	}	
}
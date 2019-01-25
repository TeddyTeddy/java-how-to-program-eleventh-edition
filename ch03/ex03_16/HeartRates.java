import java.time.LocalDate;
import java.time.Period;

public class HeartRates {
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	
	public HeartRates(String firstName, String lastName, LocalDate dateOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
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
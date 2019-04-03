import java.nio.channels.IllegalChannelGroupException;

public class HourlyEmployee extends Employee {
    // instance variables
    private double hourlyWage;
    private double hoursWorked;

    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double hourlyWage,
                          double hoursWorked) {
        super(firstName, lastName, socialSecurityNumber); // call Employee constructor

        if(hourlyWage < 0) {
            throw new IllegalArgumentException("HourlyEmployee() constructor : Exception : hourlyWage cannot be negative");
        }

        if((hoursWorked < 0) || (hoursWorked > 168)) {
            throw new IllegalArgumentException(("HourlyEmployee() constructor : Exception : hoursWorked must be in range [0,168]"));
        }

        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
    }

    public void setHourlyWage(double hourlyWage) {
        if(hourlyWage < 0) {
            throw new IllegalArgumentException("HourlyEmployee.setHourlyWage() : Exception : hourlyWage cannot be negative");
        }

        this.hourlyWage = hourlyWage;
    }

    public void setHoursWorked(double hoursWorked) {
        if((hoursWorked < 0) || (hoursWorked > 168)) {
            throw new IllegalArgumentException(("HourlyEmployee.setHoursWorked() : Exception : hoursWorked must be in range [0,168]"));
        }
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public double earnings() {
        if(getHoursWorked() <= 40) {
            return getHourlyWage() * getHoursWorked();
        } else { // if(getHoursWorked() > 40) {
            return ((getHoursWorked() - 40) * getHourlyWage() * 1.5) + (40 * getHourlyWage());
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s%n%s %.2f; %s %.2f", "hourly employee:", super.toString(), "hourly wage:"
                , getHourlyWage(), "hours worked", getHoursWorked());
    }
}
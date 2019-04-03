public class SalariedEmployee extends Employee {

    // instance variables
    private double weeklySalary;

    public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary) {
        super(firstName, lastName, socialSecurityNumber); // call Employee constructor

        if(weeklySalary < 0) {
            throw new IllegalArgumentException("SalariedEmployee() : exception : weeklySalary cannot be less than zero");
        }

        this.weeklySalary = weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    @Override
    public double earnings() {
        return getWeeklySalary();
    }

    @Override
    public String toString() {
        return String.format("%s %s%n%s %.2f", "salaried employee:", super.toString(), "weekly salary:", getWeeklySalary());
    }
}
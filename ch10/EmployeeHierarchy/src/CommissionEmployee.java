public class CommissionEmployee extends Employee {
    // instance variables
    private double grossSales;
    private double commissionRate;

    public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber,
                              double grossSales, double commissionRate) {
        super(firstName, lastName, socialSecurityNumber); // call Employee constructor
        if(grossSales < 0) {
            throw new IllegalArgumentException("CommissionEmployee constructor : exception : grossSales cannot be less than zero");
        }

        if((commissionRate < 0) || (commissionRate > 1.0)) {
            throw new IllegalArgumentException("CommissionEmployee constructor : exception : commissionRate must be in range [0,1]");
        }
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }

    public void setGrossSales(double grossSales) {
        if(grossSales < 0) {
            throw new IllegalArgumentException("CommissionEmployee.setGrossSales() : exception : grossSales cannot be less than zero");
        }
        this.grossSales = grossSales;
    }

    public void setCommissionRate(double commissionRate) {
        if((commissionRate < 0) || (commissionRate > 1.0)) {
            throw new IllegalArgumentException("CommissionEmployee.setCommissionRate() : exception : commissionRate must be in range [0,1]");
        }
        this.commissionRate = commissionRate;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    @Override
    public double earnings() {
        return getCommissionRate() * getGrossSales();
    }

    @Override
    public String toString() {
        return String.format("%s %s%n%s %.2f;%n%s %.2f", "commission employee:", super.toString(), "gross sales:", getGrossSales(),
                "commission rate:", getCommissionRate());
    }
}
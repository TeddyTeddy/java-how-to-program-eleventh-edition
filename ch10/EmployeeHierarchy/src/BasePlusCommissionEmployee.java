class BasePlusCommissionEmployee extends CommissionEmployee {
    // instance variables
    private double baseSalary;

    public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber,
                                      double grossSales, double commissionRate, double baseSalary) {
        super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate); // call CommissionEmployee constructor
        if(baseSalary < 0.0) {
            throw new IllegalArgumentException("BasePlusCommissionEmployee constructor : exception : baseSalary cannot be less than zero");
        }
        this.baseSalary = baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if(baseSalary < 0.0) {
            throw new IllegalArgumentException("BasePlusCommissionEmployee.setBaseSalary() : exception : baseSalary cannot be less than zero");
        }
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    @Override
    public double earnings() {
        return getBaseSalary() + super.earnings();
    }

    @Override
    public String toString() {
        return String.format("%s %s%n%s %.2f", "base salaried ", super.toString(), "base salary:", getBaseSalary());
    }
}
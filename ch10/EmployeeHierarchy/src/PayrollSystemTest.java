public class PayrollSystemTest {
    public static void main(String[] args) {
        SalariedEmployee salariedEmployee = new SalariedEmployee("John", "Smith",
                "111-11-1111", 800.0);
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Karen", "Price",
                "222-22-2222", 16.75, 40);
        CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Jones",
                "333-33-3333", 10000, .06);
        BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee(
                "Bob", "Lewis", "444-44-4444", 5000, 0.04,
                300
        );

        System.out.println("Employees processed individually:");
        System.out.printf("%n%s%n%s: $%,.2f%n%n",
                salariedEmployee, "earned", salariedEmployee.earnings());
        System.out.printf("%s%n%s: $%,.2f%n%n",
                hourlyEmployee, "earned", hourlyEmployee.earnings());
        System.out.printf("%s%n%s: $%,.2f%n%n",
                commissionEmployee, "earned", commissionEmployee.earnings());
        System.out.printf("%s%n%s: $%,.2f%n%n",
                basePlusCommissionEmployee,
                "earned", basePlusCommissionEmployee.earnings());

        // create a four element Employee array
        Employee[] employees = new Employee[4];

        employees[0] = salariedEmployee;
        employees[1] = hourlyEmployee;
        employees[2] = commissionEmployee;
        employees[3] = basePlusCommissionEmployee;

        System.out.printf("Employees processed polymorphically:%n%n");
        for(Employee employee : employees) {
            System.out.println(employee); // invokes toString
            if(employee instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee basePlusCommissionEmployee1 = (BasePlusCommissionEmployee) employee;
                basePlusCommissionEmployee1.setBaseSalary(1.10 * basePlusCommissionEmployee1.getBaseSalary());

                System.out.printf(
                        "new base salary with %%10 increase is: $%.2f%n", basePlusCommissionEmployee1.getBaseSalary()
                );
            }
            System.out.printf("earned $%.2f%n%n", employee.earnings());
        }

        // get the type name of each object in employees array
        for(int j = 0; j < employees.length; ++j) {
            System.out.printf("Employee %d is a %s%n", j, employees[j].getClass().getName());
        }
    }
}
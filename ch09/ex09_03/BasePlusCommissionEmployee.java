// Fig. 9.11: BasePlusCommissionEmployee.java
// BasePlusCommissionEmployee class inherits from CommissionEmployee 
// and accesses the superclass�s private data via inherited 
// public methods.
public class BasePlusCommissionEmployee extends Object {
   private CommissionEmployee commisionEmployee;
   private double baseSalary; // base salary per week

   // six-argument constructor
   public BasePlusCommissionEmployee(String firstName, String lastName, 
      String socialSecurityNumber, double grossSales, 
      double commissionRate, double baseSalary) {
	   
	  commisionEmployee = new CommissionEmployee(firstName, lastName, socialSecurityNumber, 
		         grossSales, commissionRate);                     

      // if baseSalary is invalid throw exception
      if (baseSalary < 0.0) {                  
         throw new IllegalArgumentException("Base salary must be >= 0.0");
      }       

      this.baseSalary = baseSalary;
   }
   
   // set base salary
   public void setBaseSalary(double baseSalary) {
      if (baseSalary < 0.0) {                  
         throw new IllegalArgumentException("Base salary must be >= 0.0");
      }       

      this.baseSalary = baseSalary;                
   } 

   // return base salary
   public double getBaseSalary() {return baseSalary;}
   
   // return first name
   public String getFirstName() { return commisionEmployee.getFirstName(); }

   // return last name
   public String getLastName() { return commisionEmployee.getLastName(); }

   // return social security number 
   public String getSocialSecurityNumber() {return commisionEmployee.getSocialSecurityNumber(); }

   // set gross sales amount
   public void setGrossSales(double grossSales) {
	   commisionEmployee.setGrossSales(grossSales);
   } 

   // return gross sales amount
   public double getGrossSales() {return commisionEmployee.getGrossSales();}

   // set commission rate
   public void setCommissionRate(double commissionRate) {
	   commisionEmployee.setCommissionRate(commissionRate);
   } 

   // return commission rate
   public double getCommissionRate() {return commisionEmployee.getCommissionRate();}
   

   // calculate earnings
   public double earnings() {return getBaseSalary() + commisionEmployee.earnings();}

   // return String representation of BasePlusCommissionEmployee
   @Override
   public String toString() {
      return String.format("%s %s%n%s: %.2f", "base-salaried",
    		 commisionEmployee.toString(), "base salary", getBaseSalary());   
   } 
}

public class Employee extends Object {
   private final String firstName;                        
   private final String lastName;                         
   private final String socialSecurityNumber;
   private CompensationModel compensationModel; // the composed reference

   // five-argument constructor
   public Employee(String firstName, String lastName, String socialSecurityNumber,
		   CompensationModel compensationModel) {
      // implicit call to Object constructor occurs here
      this.firstName = firstName;                                    
      this.lastName = lastName;                                    
      this.socialSecurityNumber = socialSecurityNumber;
      this.compensationModel = compensationModel;
   } 

   public void setCompensationModel(CompensationModel compensationModel) {
	   this.compensationModel = compensationModel;
   }
   // return first name
   public String getFirstName() {return firstName;}

   // return last name
   public String getLastName() {return lastName;}

   // return social security number 
   public String getSocialSecurityNumber() {return socialSecurityNumber;}

   public double earnings() {
	   // when you invoke earnings via the superclass CompensationReference to a subclass object,
	   // the subclass object's earnings method executes. This is called polymorphic behavior
	   return compensationModel.earnings();
   }
   
   // return String representation of Employee object
   @Override 
   public String toString() {
      String part1 = String.format("%s: %s %s%n%s: %s%n", "Employee", getFirstName(), getLastName(), "social security number", getSocialSecurityNumber());
      return String.format("%s%s", part1, compensationModel);
   }
}

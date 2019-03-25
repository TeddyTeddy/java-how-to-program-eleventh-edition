public class Employee extends Object {
   private final String firstName;                        
   private final String lastName;                         
   private final String socialSecurityNumber;

   // five-argument constructor
   public Employee(String firstName, String lastName, String socialSecurityNumber) {
      // implicit call to Object constructor occurs here
      this.firstName = firstName;                                    
      this.lastName = lastName;                                    
      this.socialSecurityNumber = socialSecurityNumber;
   } 

   // return first name
   public String getFirstName() {return firstName;}

   // return last name
   public String getLastName() {return lastName;}

   // return social security number 
   public String getSocialSecurityNumber() {return socialSecurityNumber;}

   // return String representation of Employee object
   @Override 
   public String toString() {
      return String.format("%s: %s %s%n%s: %s%n", "Employee", getFirstName(), getLastName(), "social security number", getSocialSecurityNumber());
   }
}

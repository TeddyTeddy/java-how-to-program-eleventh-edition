// Fig. 8.8: Employee.java
// Employee class with references to other objects.

public class Employee {
   private final String firstName;
   private final String lastName;
   private final Date birthDate;
   private final Date hireDate; 

   // constructor to initialize name, birth date and hire date
   public Employee(String firstName, String lastName, Date birthDate, 
      Date hireDate) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.birthDate = birthDate;
      this.hireDate = hireDate;
   } 

   // convert Employee to String format
   public String toString() {
      return String.format("%s, %s  Hired: %s  Birthday: %s", 
         lastName, firstName, hireDate, birthDate);
   } 
}

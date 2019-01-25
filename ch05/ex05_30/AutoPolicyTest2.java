// Fig. 5.12: AutoPolicyTest.java
// Demonstrating Strings in switch.
public class AutoPolicyTest2 {
   public static void main(String[] args) {
      // create two AutoPolicy objects
      AutoPolicy2 policy1 = new AutoPolicy2(11111111, "Toyota Camry", "NJ");
      AutoPolicy2 policy2 = new AutoPolicy2(22222222, "Ford Fusion", "ME");

      // display whether each policy is in a no-fault state
      policyInNoFaultState(policy1);
      policyInNoFaultState(policy2);
      
      policy1.setState("CT");
      policy1.setState("GA");
   } 

   // method that displays whether an AutoPolicy 
   // is in a state with no-fault auto insurance 
   public static void policyInNoFaultState(AutoPolicy2 policy) {
      System.out.println("The auto policy:");
      System.out.printf(
         "Account #: %d; Car: %s;%nState %s %s a no-fault state%n%n", 
         policy.getAccountNumber(), policy.getMakeAndModel(), 
         policy.getState(), 
         (policy.isNoFaultState() ? "is": "is not"));
   } 
} 


// Fig. 5.13: BreakTest.java
// break statement exiting a for statement.
public class BreakTest2 {
   public static void main(String[] args) {
      int count; // control variable also used after loop terminates
      
      for (count = 1; ((count <= 10) && (count != 5)); count++) { // loop 10 times
         System.out.printf("%d ", count);
      } 

      System.out.printf("%nBroke out of loop at count = %d%n", count);
   }
}
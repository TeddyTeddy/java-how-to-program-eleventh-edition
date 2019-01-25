// Fig. 5.6: Interest.java
// Compound-interest calculations with for.

public class Interest2 {
   public static void main(String[] args) {
      double principal = 1000.0; // initial amount before interest



      for (int rate = 5; rate <= 10; ++rate) {

          // display headers
          System.out.printf("%s%20s%20s%d%n", "Year", "Amount on deposit", "Interest rate %", rate );
          // calculate amount on deposit for each of ten years 
          for (int year = 1; year <= 10; ++year) {                  
             // calculate new amount on deposit for specified year  
             double amount = principal * Math.pow(1.0 + ((double) rate / 100), year);
                                                                    
             // display the year and the amount                     
             System.out.printf("%4d%,20.2f%n", year, amount);       
          }    	  
      }
      
   } 
} 


// Fig. 5.6: Interest.java
// Compound-interest calculations with for.

public class Interest3 {
   public static void main(String[] args) {
	      long principalinPennies = 100000L; // initial amount before interest
	      double rate = 0.05; // interest rate

	      // display headers
	      System.out.printf("%s%20s%n", "Year", "Amount on deposit");

	      // calculate amount on deposit for each of ten years
	      for (int year = 1; year <= 10; ++year) {                  
	         // calculate new amount on deposit for specified year  
	         long amountinPennies = (long) (principalinPennies * Math.pow(1.0 + rate, year));
	         long dollarPortion = amountinPennies / 100;
	         long pennyPortion = amountinPennies % 1000;
	        		 
	         // display the year and the amount                     
	         System.out.printf("%4d%20d,%d%n", year, dollarPortion, pennyPortion);       
	      }
      
   } 
} 


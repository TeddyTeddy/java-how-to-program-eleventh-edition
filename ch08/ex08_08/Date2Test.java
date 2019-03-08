// Fig. 8.9: EmployeeTest.java
// Composition demonstration

public class Date2Test {
   public static void main(String[] args) {
	  
	  // month is too much
	  testDate2Constructor(30, 24, 1949);  // month/day/year
	  
	  // month is too little
	  testDate2Constructor(0, 24, 1949);  // month/day/year
	  
	  // month is ok, day is too little
	  testDate2Constructor(4, 0, 1949);   // month/day/year

	  // month is ok, day is too much
	  testDate2Constructor(4, 37, 1949);  // month/day/year
	  
	  // month is ok, day is too much
	  testDate2Constructor(2, 37, 1949); // month = 2
	  
	  // month is ok, day is too much
	  testDate2Constructor(2, 29, 1949); // month = 2, day = 29
	  
	  // month is ok, day is too much
	  testDate2Constructor(3, 29, 1949); // month = 2, day = 29 & not a leap year
	  
	  // month is ok, day is too much
	  testDate2Constructor(2, 29, 2000); // month = 2, day = 29 & leap year
	  
	  // month is ok, day is too much
	  testDate2Constructor(2, 29, 2004); // month = 2, day = 29 & leap year
	  
	  // month is ok, day is ok, year is too low
	  testDate2Constructor(4, 27, 1775); // month/day/year
	  
	  // month is ok, day is ok, year is too much
	  testDate2Constructor(4, 27, 2500); // month/day/year
	  
	  
	  // constructor testing almost complete, test now nextDay()
	  Date2 date = new Date2(1, 1, 2000);  // month/day/year
	  // (a) test incrementing into the next month
	  for(int day = 1; day <= 31; ++day) {
		  try {
			  date.nextDay();
			  System.out.println(date);
		  } catch(Exception e) {
			  System.out.println(e.getMessage());
		  }
	  }
	  
	  // (b) test incrementing into the next year
	  date = new Date2(12, 15, 2000);  // month/day/year
	  // (a) test incrementing into the next month
	  for(int day = 1; day <= 31; ++day) {
		  try {
			  date.nextDay();
			  System.out.println(date);
		  } catch(Exception e) {
			  System.out.println(e.getMessage());
		  }
	  }
	  
	  // (b) test incrementing over into 2211, which is not acceptable
	  date = new Date2(12, 15, 2210);  // month/day/year
	  // (a) test incrementing into the next month
	  for(int day = 1; day <= 31; ++day) {
		  try {
			  date.nextDay();
			  System.out.println(date);
		  } catch(Exception e) {
			  System.out.println(e.getMessage());
		  }
	  }
   }
   
   private static void testDate2Constructor(int month, int day, int year) {
		  try {
			  // month is ok, day is too little
			  System.out.printf("Calling Date2(%d, %d, %d)%n", month, day, year);
			  Date2 date = new Date2(month, day, year); // month/day/year
		  } catch(IllegalArgumentException e) {
			  System.out.printf("%s%n%n", e.getMessage());
		  }
   }
}

// Fig. 8.9: EmployeeTest.java
// Composition demonstration

public class Date3Test {
   public static void main(String[] args) {
	  
	  // month is too much
	  testDate3Constructor(30, 24, 1949);  // month/day/year
	  
	  // month is too little
	  testDate3Constructor(0, 24, 1949);  // month/day/year
	  
	  // month is ok, day is too little
	  testDate3Constructor(4, 0, 1949);   // month/day/year

	  // month is ok, day is too much
	  testDate3Constructor(4, 37, 1949);  // month/day/year
	  
	  // month is ok, day is too much
	  testDate3Constructor(2, 37, 1949); // month = 2
	  
	  // month is ok, day is too much
	  testDate3Constructor(2, 29, 1949); // month = 2, day = 29
	  
	  // month is ok, day is too much
	  testDate3Constructor(3, 29, 1949); // month = 2, day = 29 & not a leap year
	  
	  // month is ok, day is too much
	  testDate3Constructor(2, 29, 2000); // month = 2, day = 29 & leap year
	  
	  // month is ok, day is too much
	  testDate3Constructor(2, 29, 2004); // month = 2, day = 29 & leap year
	  
	  // month is ok, day is ok, year is too low
	  testDate3Constructor(4, 27, 1775); // month/day/year
	  
	  // month is ok, day is ok, year is too much
	  testDate3Constructor(4, 27, 2500); // month/day/year
	  
	  
	  // constructor testing almost complete, test now nextDay()
	  Date3 date = new Date3(1, 1, 2000);  // month/day/year
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
	  date = new Date3(12, 15, 2000);  // month/day/year
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
	  date = new Date3(12, 15, 2210);  // month/day/year
	  // (a) test incrementing into the next month
	  for(int day = 1; day <= 31; ++day) {
		  try {
			  date.nextDay();
			  System.out.println(date);
		  } catch(Exception e) {
			  System.out.println(e.getMessage());
		  }
	  }
	  
	  testDate3Constructor("January", 15, 2210);
	  testDate3Constructor("February", 15, 2210);
	  testDate3Constructor("March", 15, 2210);
	  testDate3Constructor("April", 15, 2210);
	  testDate3Constructor("May", 15, 2210);
	  testDate3Constructor("June", 15, 2210);
	  testDate3Constructor("July", 15, 2210);
	  testDate3Constructor("August", 15, 2210);
	  testDate3Constructor("September", 15, 2210);
	  testDate3Constructor("October", 15, 2210);
	  testDate3Constructor("November", 15, 2210);
	  testDate3Constructor("December", 15, 2210);
	  testDate3Constructor("Some crap", 15, 2210);
	  
	  int leapYear = 2000;
	  for(int dayNumber = 1; dayNumber <= Date3.DAYS_OF_LEAP_YEAR; ++dayNumber) {
		  testDate3Constructor(dayNumber, leapYear);
	  }
	  
	  int noLeapYear = 2001;
	  for(int dayNumber = 1; dayNumber <= Date3.DAYS_OF_NO_LEAP_YEAR; ++dayNumber) {
		  testDate3Constructor(dayNumber, noLeapYear);
	  }	  
   }
   
   private static void testDate3Constructor(int month, int day, int year) {
		  try {
			  // month is ok, day is too little
			  System.out.printf("Calling Date3(%d, %d, %d)%n", month, day, year);
			  Date3 date = new Date3(month, day, year); // month/day/year
		  } catch(IllegalArgumentException e) {
			  System.out.printf("%s%n%n", e.getMessage());
		  }
   }
   
   private static void testDate3Constructor(String month, int day, int year) {
		  try {
			  // month is ok, day is too little
			  System.out.printf("Calling Date3(%s, %d, %d)%n", month, day, year);
			  Date3 date = new Date3(month, day, year); // month/day/year
		  } catch(IllegalArgumentException e) {
			  System.out.printf("%s%n%n", e.getMessage());
		  }
   }
   
   private static void testDate3Constructor(int dayNumber, int year) {
		  try {
			  // month is ok, day is too little
			  System.out.printf("Calling Date3(%d, %d)%n", dayNumber, year);
			  Date3 date = new Date3(dayNumber, year); // month/day/year
		  } catch(IllegalArgumentException e) {
			  System.out.printf("%s%n%n", e.getMessage());
		  }
}
}

// Ex. 8.8: Date2.java 
// Date2 class declaration

public class Date2 {
   private int month; // 1-12
   private int day; // 1-31 based on month
   private int year; // any year

   private static final int[] daysPerMonth = 
      {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
   
   // constructor: confirm proper value for month and day given the year
   public Date2(int month, int day, int year) {
      // check if month in range
      if (month <= 0 || month > 12) {
         throw new IllegalArgumentException(
            "month (" + month + ") must be 1-12");
      }

      // check if day in range for month
      if (day <= 0 || 
         (day > daysPerMonth[month] && !(month == 2 && day == 29))) {
         throw new IllegalArgumentException("day (" + day + 
            ") out-of-range for the specified month and year");
      }

      // check for leap year if month is 2 and day is 29
      if (month == 2 && day == 29 && !(year % 400 == 0 || 
           (year % 4 == 0 && year % 100 != 0))) {
         throw new IllegalArgumentException("day (" + day +
            ") out-of-range for the specified month and year");
      }
      
      // https://www.chegg.com/homework-help/questions-and-answers/java-88-enhancing-class-date-modify-class-date-fig-87-perform-error-checking-initializer-v-q25606008
      if(year < 1776 || year > 2210) {
    	  throw new IllegalArgumentException("year (" + year 
    			  + ") out-of-range. It should be between 1776 and 2210 inclusive");
      }
   
      this.month = month;
      this.day = day;
      this.year = year;

      System.out.printf("Date2 object constructor for Date2 %s%n", this);
   }
   
   // sets the day (and month and year)
   public void nextDay() throws Exception {
	   int nextYear = year;
	   int nextMonth = month;
	   int nextDay = day + 1;
	   if(nextDay > daysPerMonth[month]) { //if the incremented day leaps to the next month
		   nextDay = 1;   // the first day of next month
		   nextMonth = month + 1;
		   if(nextMonth == 13) { // the incremented month leaps to the next year
			   nextMonth = 1; // the first month of next year
			   ++nextYear;
			   if(nextYear > 2210) {
				   throw new Exception("year reached beyond its max limit 2210");
			   }
		   }
	   }
	   
	   // do not change the state of the object if the method is supposed to throw an exception
	   day = nextDay;
	   month = nextMonth;
	   year = nextYear;
   }
   
   // return a String of the form month/day/year
   public String toString() {
      return String.format("%d/%d/%d", month, day, year); 
   } 
}

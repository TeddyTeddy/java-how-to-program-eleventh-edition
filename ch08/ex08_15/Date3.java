// Ex. 8.8: Date3.java 
// Date3 class declaration

public class Date3 {
   private int month; // 1-12
   private int day; // 1-31 based on month
   private int year; // any year

   private static final int[] daysPerMonthNoLeapYar = 
      {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
   
   private static final int[] daysPerMonthWithLeapYar = 
	  {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // note the Feb 29
   
   public static final int DAYS_OF_LEAP_YEAR = 366;
   public static final int DAYS_OF_NO_LEAP_YEAR = 365;
   
   
   public Date3(int dayNumber, int year) {
	   // dayNumber must be in the correct range
	   int maxDays = isLeapYear(year) ? DAYS_OF_LEAP_YEAR : DAYS_OF_NO_LEAP_YEAR;
	   if((dayNumber <= 0) || (dayNumber > maxDays)) {
	         throw new IllegalArgumentException("dayNumber (" + dayNumber + ") out-of-range 1-366");		   
	   }
	   // valid dayNumber
	   // get day & month from dayNumber
	   // initialize
	   int month = 1;
	   int[] daysPerMonth = isLeapYear(year) ? daysPerMonthWithLeapYar : daysPerMonthNoLeapYar;
	   // figure out which month we are in for the current dayNumber
	   while ( dayNumber > daysPerMonth[month] ) { // is dayNumber such that we are in the month+1 ? (i.e. am i in February?)
		   dayNumber -= daysPerMonth[month];
	   		++month;
	   }
	   int day = dayNumber; // whatever value left in dayNumber is the day of the month
	   
	   verify(month, day, year); // if it does not throw an exception, then values are correct
	   this.month = month;
	   this.day = day;
	   this.year = year;

	   System.out.printf("Date3 object constructor for Date3 %s%n", this);
	    
   }
   
   private static boolean isLeapYear(int year) {
	   return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
   }
   
   private static void verify(int month, int day, int year) {
	      // check if month in range
	      if (month <= 0 || month > 12) {
	         throw new IllegalArgumentException(
	            "month (" + month + ") must be 1-12");
	      }

	      // check if day in range for month
	      if (day <= 0 || 
	         (day > daysPerMonthNoLeapYar[month] && !(month == 2 && day == 29)) ) {
	         throw new IllegalArgumentException("day (" + day + 
	            ") out-of-range for the specified month and year");
	      }

	      // check for leap year if month is 2 and day is 29
	      if (month == 2 && day == 29 && !isLeapYear(year)) {
	         throw new IllegalArgumentException("day (" + day +
	            ") out-of-range for the specified month and year");
	      }
	      
	      // https://www.chegg.com/homework-help/questions-and-answers/java-88-enhancing-class-date-modify-class-date-fig-87-perform-error-checking-initializer-v-q25606008
	      if(year < 1776 || year > 2210) {
	    	  throw new IllegalArgumentException("year (" + year 
	    			  + ") out-of-range. It should be between 1776 and 2210 inclusive");
	      }	   
   }

   public Date3(String monthString, int day, int year) {
	   int month = 0; // invalid value from the start
	   switch(monthString) {
	   		case "January":
	   			month = 1;
	   			break;
	   		case "February":
	   			month = 2;
	   			break;
	   		case "March":
	   			month = 3;
	   			break;
	   		case "April":
	   			month = 4;
	   			break;
	   		case "May":
	   			month = 5;
	   			break;
	   		case "June":
	   			month = 6;
	   			break;
	   		case "July":
	   			month = 7;
	   			break;
	   		case "August":
	   			month = 8;
	   			break;
	   		case "September":
	   			month = 9;
	   			break;
	   		case "October":
	   			month = 10;
	   			break;
	   		case "November":
	   			month = 11;
	   			break;
	   		case "December":
	   			month = 12;
	   			break;
	   		default:
	            throw new IllegalArgumentException("Month not recognized. (" + monthString + ") must start with a capital letter (i.e. November)");
	   			
	   }
	   
	   verify(month, day, year); // if it does not throw an exception, then values are correct
	   this.month = month;
	   this.day = day;
	   this.year = year;

	   System.out.printf("Date3 object constructor for Date3 %s%n", this);
   }
   
   // constructor: confirm proper value for month and day given the year
   public Date3(int month, int day, int year) {
	  verify(month, day, year); // if it does not throw an exception, then values are correct
      this.month = month;
      this.day = day;
      this.year = year;

      System.out.printf("Date3 object constructor for Date3 %s%n", this);
   }
   
   // sets the day (and month and year)
   public void nextDay() throws Exception {
	   
	   int[] daysPerMonth = isLeapYear(year) ? daysPerMonthWithLeapYar : daysPerMonthNoLeapYar;
	   
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

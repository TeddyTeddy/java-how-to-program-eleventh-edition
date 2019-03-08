class DateAndTime {
	
	// static variables
	public static final int MAX_YEAR = 2210;
	
	// date instance variables
	private int month; // 1-12
	private int day; // 1-31 based on month
	private int year; // any year

	// time instance variables
	private int hour; // 0 - 23
	private int minute; // 0 - 59
	private int second; // 0 - 59

	private static final int[] daysPerMonth = 
	{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	   
	// constructor: confirm proper value for month and day given the year
	// 				confirm proper value for hour, minute and second
	public DateAndTime(int month, int day, int year, int hour, int minute, int second) {
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
	   
	    if (hour < 0 || hour >= 24) {
	    	throw new IllegalArgumentException("hour must be 0-23");
	    } 

	    if (minute < 0 || minute >= 60) {
	        throw new IllegalArgumentException("minute must be 0-59");
	    } 

	    if (second < 0 || second >= 60) {
	        throw new IllegalArgumentException("second must be 0-59");
	    }
	    
	    this.month = month;
	    this.day = day;
	    this.year = year;

	    this.hour = hour;
	    this.minute = minute; 
	    this.second = second; 
	      
	    System.out.printf("DateAndTime object constructor returns %s%n", this);
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
			   if(nextYear > MAX_YEAR) {
					   throw new Exception("year reached beyond its max limit 2210");
			   }
			}
		 }
		   
		 // do not change the state of the object if the method is supposed to throw an exception
		 day = nextDay;
		 month = nextMonth;
		 year = nextYear;
	}

	public void tick() throws Exception {
		int nextSecond = second + 1;
		if(nextSecond == 60) {
			nextSecond = 0;
			incrementMinute(); // do not modify second, if incrementMinute() is to throw an exception
		}
		
		// it did not throw one, if the execution reached here
		// so it is safe to update the second
		second = nextSecond;
	}

	public void incrementMinute() throws Exception {
		int nextMinute = minute + 1;
		if(nextMinute == 60) {
			nextMinute = 0;
			incrementHour(); // do not modify minute, if incrementHour() is to throw an exception
		}
		
		// it did not throw one, if the execution reached here
		// so it is safe to update the minute
		minute = nextMinute;
	}
	
	public void incrementHour() throws Exception {
		int nextHour = hour + 1;
		if(nextHour == 24) {
			nextHour = 0; // next days hour
			nextDay(); // do not modify hour if nextDay() is to throw an exception
		}
		
		// it didn't throw one, if the execution reached here
		// so it is safe to update the hour
		hour = nextHour;
	}
	   
	// Get Methods         
	// get hour value      
	public int getHour() {return hour;}

	// get minute value      
	public int getMinute() {return minute;} 

	// get second value      
	public int getSecond() {return second;}
	
	// get day value
	public int getDay() {return day;}
	
	// get month value
	public int getMonth() {return month;}
	
	// get year value
	public int getYear() {return year;}

	// convert to String in universal-time format (MM:DD:YY HH:MM:SS)
	public String toUniversalString() {
		String timePart = String.format(
	         "%02d:%02d:%02d", getHour(), getMinute(), getSecond());
		String datePart = String.format("%d/%d/%d ", getMonth(), getDay(), getYear());
		return datePart + timePart;
	 } 
	   
	// return a String of the form (MM/DD/YY H:MM:SS AM/PM) 
	public String toString() {
		String datePart = String.format("%d/%d/%d ", getMonth(), getDay(), getYear());
		String timePart = String.format("%d:%02d:%02d %s", 
				((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
		        getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
		return datePart + timePart;
	}
}
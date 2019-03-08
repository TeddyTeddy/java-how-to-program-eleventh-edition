public class DateAndTimeTest {
	public static void main(String[] args) {
		//							          month, day, year, 				hour, minute, second
		DateAndTime dateTime = new DateAndTime(12,    31, DateAndTime.MAX_YEAR,   23,     59,     59);
		testTick(dateTime); // will catch an exception as the year hits MAX_YEAR + 1
	
		//					       month, day, year, 					hour, minute, second		
		dateTime = new DateAndTime(12,    31, DateAndTime.MAX_YEAR - 1,   23,     59,     59);
		testTick(dateTime); // tick() will move the date the last acceptable year: 1/1/2210 12:00:00 AM
		
		//					       month, day, year, 					hour, minute, second		
		dateTime = new DateAndTime(12,    31, DateAndTime.MAX_YEAR - 1,   23,     59,     49);
		testTick(dateTime); // tick() will move the date the last acceptable year: 1/1/2210 12:00:00 AM
		
		//					       month, day, year, 					hour, minute, second		
		dateTime = new DateAndTime(12,    31, DateAndTime.MAX_YEAR - 1,   23,     49,     59);
		testTick(dateTime); // tick() will move the date the last acceptable year: 1/1/2210 12:00:00 AM		

		//					       month, day, year, 					hour, minute, second		
		dateTime = new DateAndTime(12,    31, DateAndTime.MAX_YEAR - 1,   20,     59,     59);
		testTick(dateTime); // tick() will move the date the last acceptable year: 1/1/2210 12:00:00 AM	
		
		System.out.printf("Date in (MM/DD/YY H:MM:SS AM/PM):   %s%n", dateTime);
		System.out.printf("Date in (MM:DD:YY HH:MM:SS):        %s%n", dateTime.toUniversalString());		
	}
	
	private static void testTick(DateAndTime dateTime) {
		System.out.printf("Date:        %s%n", dateTime);
		
		try {
			dateTime.tick(); 
			System.out.printf("Date ticked: %s%n%n", dateTime);
		} catch(Exception e) {
			System.out.printf("When the year is ticked %s%n", e.getMessage());
			System.out.printf("The dateTime is untouched %s%n%n", dateTime);
		}		
	}
}
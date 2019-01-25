public class DateTest {
	public static void main(String[] args) {
		Date date1 = new Date(27, 4, 1978);
		date1.displayDate();
		
		System.out.println("Attempting to set -1 to day:");
		date1.setDay(-1); // should do nothing
		date1.displayDate();
		
		System.out.println("Setting 30 to day:");
		date1.setDay(30);
		date1.displayDate();
		
		System.out.println("Attempting to set -1 to month:");
		date1.setMonth(-1); // should do nothing
		date1.displayDate();
		
		System.out.println("Setting 12 to month:");
		date1.setMonth(12);
		date1.displayDate();
		
		System.out.println("Attempting to set -1 to year:");
		date1.setYear(-1); // should let it set
		date1.displayDate();
		
		System.out.println("Setting 2018 to year:");
		date1.setYear(2018);
		date1.displayDate();
		
	}
}
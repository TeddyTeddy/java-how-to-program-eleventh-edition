// https://en.wikipedia.org/wiki/The_Twelve_Days_of_Christmas_(song)

public class TwelveDaysOfChristmasSong {
	
	public static void main(String[] args) {
		for(int dayNumber = 1; dayNumber <= 12; ++dayNumber) {
			System.out.printf("%nOn the %s day of Christmas my true love sent to me%n", getDay(dayNumber));
			for(int j = dayNumber; j >= 1; --j) {
				if((j == 1) && (dayNumber >= 2)) {
					System.out.print("And ");
				}
				System.out.printf("%s%n", getGift(j));
			}
		}
	}
	
	private static String getGift(int dayNumber) {
		String gift = "";
		switch(dayNumber) {
			case 1:
				gift = "A partridge in a pear tree.";
				break;
			case 2:
				gift = "Two turtle doves";
				break;
			case 3:
				gift = "Three French hens";
				break;
			case 4:
				gift = "calling birds";
				break;
			case 5:
				gift = "gold rings";
				break;
			case 6:
				gift = "geese a-laying";
				break;
			case 7:
				gift = "swans a-swimming";
				break;
			case 8:
				gift = "maids a-milking";
				break;
			case 9:
				gift = "ladies dancing";
				break;
			case 10:
				gift = "lords a-leaping";
				break;
			case 11:
				gift = "pipers piping";
				break;
			case 12:
				gift = "drummers drumming";
				break;
		}
		return gift;
	}
	
	private static String getDay(int dayNumber) {
		String day = "";
		switch(dayNumber) {
			case 1:
				day = "first";
				break;
			case 2:
				day = "second";
				break;
			case 3:
				day = "third";
				break;
			case 4:
				day = "fourth";
				break;
			case 5:
				day = "fifth";
				break;
			case 6:
				day = "sixth";
				break;
			case 7:
				day = "seventh";
				break;
			case 8:
				day = "eighth";
				break;
			case 9:
				day = "nineth";
				break;
			case 10:
				day = "tenth";
				break;
			case 11:
				day = "eleventh";
				break;
			case 12:
				day = "twelveth";
				break;
		}
		return day;
	}
}
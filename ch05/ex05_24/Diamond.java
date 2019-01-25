public class Diamond {
	public static void main(String[] args) {
		for(int i = 1; i <= 9; ++i) {
			int numberOfAsterisks = getNumberOfAsterisks(i);
			int numberOfSpaces = getNumberOfSpaces(i);
			display(" ", numberOfSpaces);
			display("*", numberOfAsterisks);
			display(" ", numberOfSpaces);
			System.out.println();
		}
	}
	
	private static int getNumberOfAsterisks(int i) {
		int numberOfAsterisks = 1;
		for(int j = 1; j < 5; ++j) {
			if(j == i) {
				break;
			}
			numberOfAsterisks += 2;
		}
		
		for(int j = 6; j <= 9; ++j ) {
			if(j > i) {
				break;
			}
			numberOfAsterisks -= 2;
		}
		return numberOfAsterisks;
	}
	
	private static int getNumberOfSpaces(int i) {
		int numberOfSpaces = 4;
		for(int j = 1; j < 5; ++j) {
			if( j == i ) {
				break;
			}
			--numberOfSpaces;
		}
		
		for(int j = 6; j <= 9; ++j) {
			if( j > i) {
				break;
			}
			++numberOfSpaces;
		}
		return numberOfSpaces;
	}
	
	private static void display(String s, int times) {
		String temp = "";
		for(int j = 1; j <= times; ++j) {
			temp += s;
		}
		System.out.printf("%s", temp); // minimize the number of output statements
	}
}
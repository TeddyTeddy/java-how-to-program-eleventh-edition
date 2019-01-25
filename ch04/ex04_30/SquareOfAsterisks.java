import java.util.Scanner;

public class SquareOfAsterisks {
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		// prompt user to enter the size of a square
		System.out.print("Enter the size of square (-1 to exit): ");
		int size = input.nextInt();
		
		while(size != -1) {
			System.out.println();
			// call squareOfAsterisks method with the size of the square
			squareOfAsterisks(size);
			
			System.out.print("Enter the size of square(-1 to exit): ");
			size = input.nextInt();
		}
	}
	
	private static void squareOfAsterisks(int size) {
		
		// call getFullSide passing size
		String fullSide = getFullSide(size);
		
		// print top row (fullSide)
		System.out.printf("%s%n", fullSide);
		// if size is greater than 2
		if(size > 2) {
			// call getHollowSide passing size
			String hollowSide = getHollowSide(size);
			// set counter to 1
			int counter = 1;
			// while counter <= size - 2
			while(counter <= (size - 2)) {
				// print a hollow row
				System.out.printf("%s%n", hollowSide);	
				// increment counter by 1
				counter += 1;
			}
		}
		if(size >= 2) {
			// print bottom side
			System.out.printf("%s%n", fullSide);
		}
	}
	
	// TODO: throw an error when size is less than or equal to zero 
	private static String getFullSide(int size) {
		int counter = 1;
		String fullSide = "";
		while(counter <= size) {
			fullSide += "*";
			++counter;
		}
		return fullSide;
	}
	
	private static String getHollowSide(int size) {
		if(size > 2) {
			int counter = 1;
			String hollowSide = "*";
			while(counter <= (size - 2)) {
				hollowSide += " ";
				++counter;
			}
			hollowSide += "*";
			return hollowSide;			
		} else {
			// TODO: throw an exception, this function expects size greater than 2
			return "";
		}
	}
}
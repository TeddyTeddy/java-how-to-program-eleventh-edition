import java.util.Scanner;

public class SquareOfAnyCharacter {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a fill character: ");
		char fill = input.next().charAt(0);
		
		for(int size = 1; size <= 10; ++size) {
			squareOfAsterisks(size, fill);
		}
		
		input.close();
	}
	
	private static void squareOfAsterisks(int size, char fillCharacter) {
		System.out.printf("%nSquare of size %d%n", size);
		for(int i = size; i >= 1; --i) {
			for(int j = size; j >= 1; --j) {
				System.out.printf("%c", fillCharacter);
			}
			System.out.println();
		}
	}
}
import java.util.Scanner;
import java.util.Arrays;

public class ex07_09 {
	public static void main(String[] args) {
		int[][] t = new int[2][3];
		Arrays.fill(t[0], -1);
		Arrays.fill(t[1], -1);
		displayArray(t, "Array t created: ");
		// e
		System.out.println();
		System.out.printf("t[1][0]: %d%n", t[1][0]);
		System.out.printf("t[1][1]: %d%n", t[1][1]);
		System.out.printf("t[1][2]: %d%n", t[1][2]);
		// f
		System.out.printf("t[0][2]: %d%n", t[0][2]);
		System.out.printf("t[1][2]: %d%n", t[1][2]);
		
		// g
		t[0][1] = 0;
		
		// h
		t[0][0] = 0;
		t[0][1] = 0;
		t[0][2] = 0;
		t[1][0] = 0;
		t[1][1] = 0;
		t[1][2] = 0;
		displayArray(t, "Resetted array t's content to zero:");
		
		// i
		for(int row = 0; row < t.length; ++row) {
			for(int column = 0; column < t[row].length; ++column) {
				t[row][column] = 1;
			}
		}
		displayArray(t, "Resetted array t's content to one:");
		
		// j
		System.out.println();
		Scanner input = new Scanner(System.in);
		for(int row = 0; row < t.length; ++row) {
			for(int column = 0; column < t[row].length; ++column) {
				System.out.printf("Enter t[%d][%d] value: ", row, column);
				int value = input.nextInt();
				t[row][column] = value;
			}
		}
		input.close();
		displayArray(t, "Array t's contents after user has inputted:");
		
		// k
		int smallest = t[0][0];
		for(int row = 0; row < t.length; ++row) {
			for(int column = 0; column < t[row].length; ++column) {
				if(t[row][column] < smallest) {
					smallest = t[row][column];
				}
			}
		}
		System.out.printf("Smallest int value in t array is: %d%n", smallest);
		
		// l
		System.out.printf("%d %d %d", t[0][0], t[0][1], t[0][2]);
		// m
		int total = t[0][2] + t[1][2];
	}
	
	// n
	private static void displayArray(int[][] array, String description) {
		System.out.printf("%n%s%n", description);
		
		// output the heading
		System.out.print("     ");
		for(int column = 0; column < array[0].length; ++column) {
			System.out.printf("%-6d", column);
		}
		System.out.println();
		
		for(int row = 0; row < array.length; ++row) {
			// output the individual contents of each row
			System.out.printf("%-5d", row);
			for(int column = 0; column < array[row].length; ++column) {
				System.out.printf("%-5d ", array[row][column]);
			}
			System.out.println();
		}
	}
}
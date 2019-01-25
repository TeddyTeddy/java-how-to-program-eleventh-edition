public class Checkerboard {
	public static void main(String[] args) {
		// initialize
			// rows to 8
			// i to 1
		int rows = 8, i = 1;
		
		// for every ith row
		while(i <= rows) {
			int j = 1;
			// if i is even, print space
			if(i%2 == 0) {
				System.out.print(" ");
			}
			// print 8 times "* "
			while(j <= rows) {
				System.out.print("* ");
				++j;
			}
			// print a newline
			System.out.println();
			// increment i by 1
			++i;
		}
	}
}
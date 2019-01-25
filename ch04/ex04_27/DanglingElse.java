public class DanglingElse {
	public static void main(String[] args) {
		logic(1, 6); //
		logic(1, 2); // 
		logic(2, 5); //
		logic(5, 5); //
		logic(5, 6); // 
		logic(6, 6); //
		logic(6, 1); // 
		logic(6, 5); //
	}
	
	public static void logic(int x, int y) {
		if(x > 5) {
			if( y > 5) {
				System.out.println("x and y are > 5");
			}
		} else {
			System.out.println("x is <= 5");
		}
	}
}
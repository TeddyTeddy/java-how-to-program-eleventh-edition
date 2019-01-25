public class ex04_29 {
	public static void main(String[] args) {
		logic_a(5, 8);
		System.out.println();
		logic_b_d(5,8);
		System.out.println();
		logic_c(5,8);
		System.out.println();
		logic_b_d(5,7);		
	}
	
	private static void logic_a(int x, int y) {
		if(y == 8)
		if(x == 5)
		System.out.println("@@@@@");
		else
		System.out.println("#####");
		System.out.println("$$$$$");
		System.out.println("&&&&&");
	}
	
	private static void logic_b_d(int x, int y) {
		if(y == 8) {
			if(x == 5) {
				System.out.println("@@@@@");
			}
		}
		else {
			System.out.println("#####");
			System.out.println("$$$$$");
			System.out.println("&&&&&");
		}
	}
	
	private static void logic_c(int x, int y) {
		if(y == 8) {
			if(x == 5) {
				System.out.println("@@@@@");
			}
		}
		else {
			System.out.println("#####");
			System.out.println("$$$$$");
		}
		System.out.println("&&&&&");
	}	
}
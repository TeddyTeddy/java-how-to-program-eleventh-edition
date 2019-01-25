public class DanglingElseProblem2 {
	public static void main(String[] args) {
		logic_a(9,11);
		logic_a(11, 9);
		System.out.println();
		logic_b(9, 11);
		logic_b(11, 9);
	}
	
	public static void logic_a(int x, int y) {
		System.out.printf("x: %d, y:%d%n", x, y);
		if(x < 10)
		if(y > 10)
		System.out.println("*****");
		else
		System.out.println("#####");
		System.out.println("$$$$$");
	}
	
	public static void logic_b(int x, int y) {
		System.out.printf("x: %d, y:%d%n", x, y);
		if(x < 10) {
		if(y > 10)
		System.out.println("*****");
		}
		else {
		System.out.println("#####");
		System.out.println("$$$$$");
		}
	}
}
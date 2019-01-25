public class DeMorgansLaws {
	public static void main(String[] args) {
		test_a();
		test_b();
	}
	
	private static void test_a() {
		System.out.println("Testing (a)");
		for(int x = -3; x <= 7; ++x) {
			for(int y = -3; y <= 8; ++y) {
				boolean match = a(x,y);
				if(match) {
					System.out.println("A match occurred");
				} else {
					System.out.println("Error: A match did not occur");
				}
				System.out.println();
			}
		}
	}
	
	private static boolean a(int x, int y) {
		boolean condition1 = !(x < 5) || !(y >= 7);
		boolean condition2 = !((x < 5) && (y >= 7));
		System.out.printf("!(%d < 5) || !(%d >= 7) returns %b%n", x, y, condition1);
		System.out.printf("!((%d < 5) && (%d >= 7)) returns %b%n", x, y, condition2);		
		return condition1 == condition2;
	}
	
	private static boolean _b(int a, int b, int g) {
		boolean condition1 = !(a==b) || !(g != 5);
		boolean condition2 = !((a==b) && (g != 5));
		
		System.out.printf("!(%d == %d) || !(%d != 5) returns %b%n", a, b, g, condition1);
		System.out.printf("!((%d == %d) && (%d != 5)) returns %b%n", a, b, g, condition2);
		return condition1 == condition2;
	}
	
	private static void test_b() {
		System.out.println("Testing (b)");
		for(int a = -3; a <= 3; ++a) {
			for(int b = -3; b <= 3; ++b) {
				for(int g = -3; g <= 5; ++g) {
					boolean match = _b(a,b, g);
					if(match) {
						System.out.println("A match occurred");
					} else {
						System.out.println("Error: A match did not occur");
					}
					System.out.println();		
				}
			}
		}
	}	
}
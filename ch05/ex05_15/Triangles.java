public class Triangles {
	public static void main(String[] args) {
		print_triangle_a();
		print_triangle_b();
		print_triangle_c();
		print_triangle_d();
	}
	
	public static void print_triangle_a() {
		System.out.println("(a)");
		for(int i = 1; i <= 10; ++i) {
			for(int j = i; j >= 1; --j) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void print_triangle_b() {
		System.out.println("(b)");
		for(int i = 10; i >= 1; --i) {
			for(int j = i; j >= 1; --j) {
				System.out.print("*");
			}
			System.out.println();	
		}
		System.out.println();
	}
	
	public static void print_triangle_c() {
		System.out.println("(c)");
		for(int i = 10; i >= 1; --i) {
			// print spaces
			for(int space = (10 - i); space >=1; --space) {
				System.out.print(' ');
			}
			// print asterisks
			for(int j = i; j >= 1; --j) {
				System.out.print("*");
			}
			System.out.println();	
		}
		System.out.println();
	}
	
	public static void print_triangle_d() {
		System.out.println("(d)");
		for(int i = 1; i <= 10; ++i) {
			// print spaces
			for(int space = 10 - i; space >= 1; --space) {
				System.out.print(' ');
			}
			
			// print asterisks
			for(int j = i; j >= 1; --j) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();		
	}
}
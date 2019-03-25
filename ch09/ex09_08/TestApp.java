public class TestApp {
	public static void main(String[] args) {
		testQuadrilateral();
		testTrapezoid();
		testParallelogram();
		testRectangle();
		testSquare();
	}
	
	private static void testSquare() {
		Point A = new Point(0, 0);
		Point B = new Point(10, 0);
		Point C = new Point(10, 10);
		Point D = new Point(0, 10);
		Square square = new Square(A, B, C, D);
		System.out.println();
		System.out.println(square);
		System.out.printf("Square area: %.2f%n", square.area());
		System.out.printf("isTrapezoid: %b%n", square.isTrapezoid());
		System.out.printf("isSquare: %b%n", square.isSquare());
		
		// intentionally pass on a rectangle coordinates
		A = new Point(0, 0);
		B = new Point(10, 0);
		C = new Point(10, 5);
		D = new Point(0, 5);
		try {
			square = new Square(A, B, C, D);
			System.out.println();
			System.out.println(square);
			System.out.printf("Square area: %.2f%n", square.area());
			System.out.printf("isTrapezoid: %b%n", square.isTrapezoid());
			System.out.printf("isSquare: %b", square.isSquare());
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void testRectangle() {
		Point A = new Point(0, 0);
		Point B = new Point(10, 0);
		Point C = new Point(10, 5);
		Point D = new Point(0, 5);
		Rectangle rectangle = new Rectangle(A, B, C, D);
		System.out.println();
		System.out.println(rectangle);
		System.out.printf("Rectangle area: %.2f%n", rectangle.area());
		System.out.printf("isTrapezoid: %b", rectangle.isTrapezoid());
	}
	
	private static void testParallelogram() {
		Point A = new Point(-10.5, -3.3);
		Point B = new Point(10, -3.3);
		Point C = new Point(5, 5);
		Point D = new Point(-5, 5);
		Parallelogram parallelogram = new Parallelogram(A, B, C, D);
		System.out.println(parallelogram);
		System.out.printf("parallelogram area: %.2f%n", parallelogram.area());
		System.out.printf("isTrapezoid: %b", parallelogram.isTrapezoid());
	}
	
	private static void testTrapezoid() {
		Point A = new Point(-10.5, -3.3);
		Point B = new Point(10, -3.3);
		Point C = new Point(5, 5);
		Point D = new Point(-5, 5);
		Trapezoid trapezoid = new Trapezoid(A, B, C, D);
		System.out.println(trapezoid);
		System.out.printf("Trapezoid area: %.2f%n", trapezoid.area());
		System.out.printf("isTrapezoid: %b", trapezoid.isTrapezoid());
	}
	
	private static void testQuadrilateral() {
		Point A = new Point(-10.5, -3.3);
		Point B = new Point(10, -3.3);
		Point C = new Point(5, 5);
		Point D = new Point(-5, 5);
		Quadrilateral q = new Quadrilateral(A, B, C, D);
		System.out.println(q);
	}
}
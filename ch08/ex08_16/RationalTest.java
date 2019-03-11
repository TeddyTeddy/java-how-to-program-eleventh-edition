public class RationalTest {
	public static void main(String[] args) {
		
		testRationalConstructor(10, 0); // numerator, denominator
		testRationalConstructor(10, -2); // numerator, denominator
		testRationalConstructor(0, 5); // numerator, denominator
		testRationalConstructor(9, 3); // numerator, denominator
		testRationalConstructor(-9, 3); // numerator, denominator		
		testRationalConstructor(3, 9); // numerator, denominator
		testRationalConstructor(-3, 9); // numerator, denominator
		testRationalConstructor(7, 5); // numerator, denominator
		
		//		num1  denom1  num2	denom2
		testAdd(10,        2,    7,      1);
		testAdd(15,        2,    7,      3);
		
		//			num1  	denom1  num2	denom2
		testSubtract(10,        2,    7,      1);
		testSubtract(15,        2,    7,      3);
		
		//			num1  	denom1  num2	denom2
		testMultiply(10,        2,    7,      1);
		testMultiply(15,        2,    7,      3);
		
		//			num1  	denom1  num2	denom2
		testDivide(10,        2,    7,      1);
		testDivide(15,        2,    7,      3);
		
		Rational r = new Rational(1,3);
		System.out.println(r.floatingPoint(2)); // 0.33
		
		r = new Rational(22,7); // pi
		System.out.println(r.floatingPoint(2)); // 3.14
	}
	
	private static void testRationalConstructor(int numerator, int denominator) {
		try {
			System.out.printf("Attempting to call Rational(%d, %d)%n", numerator, denominator);
			Rational r = new Rational(numerator, denominator);
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
	}
	
	private static void testAdd(int num1, int denom1, int num2, int denom2) {
		try {
			Rational r1 = new Rational(num1, denom1);
			Rational r2 = new Rational(num2, denom2);
			Rational r3 = Rational.add(r1, r2);
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
	}
	
	private static void testSubtract(int num1, int denom1, int num2, int denom2) {
		try {
			Rational r1 = new Rational(num1, denom1);
			Rational r2 = new Rational(num2, denom2);
			Rational r3 = Rational.subtract(r1, r2);
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
	}

	private static void testMultiply(int num1, int denom1, int num2, int denom2) {
		try {
			Rational r1 = new Rational(num1, denom1);
			Rational r2 = new Rational(num2, denom2);
			Rational r3 = Rational.multiply(r1, r2);
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
	}
	
	private static void testDivide(int num1, int denom1, int num2, int denom2) {
		try {
			Rational r1 = new Rational(num1, denom1);
			Rational r2 = new Rational(num2, denom2);
			Rational r3 = Rational.divide(r1, r2);
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
	}
}
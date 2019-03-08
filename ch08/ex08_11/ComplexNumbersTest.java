public class ComplexNumbersTest {
	
	public static void main(String[] args) {
		Complex c1 = new Complex();
		System.out.printf("new Complex() returns %s%n", c1);
		
		Complex c2 = new Complex(3.3, 3.3);
		Complex c3 = new Complex(7.7, 7.7);
		Complex c4 = c3.add(c2);
		Complex c5 = c3.subtract(c2);
		System.out.printf("Complex c2 = new Complex(3.3, 3.3) returns %s%n", c2);
		System.out.printf("Complex c3 = new Complex(7.7, 7.7) returns %s%n", c3);
		System.out.printf("c3.add(c2) returns %s%n", c4);
		System.out.printf("c3.subtract(c2) returns %s%n", c5);
	}
}

class Complex {
	double realPart;
	double imaginaryPart;
	
	Complex(double realPart, double imaginaryPart) {
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}
	
	Complex() {
		this(0.0, 0.0);
	}
	
	Complex add(Complex c) {
		return new Complex(realPart + c.realPart, imaginaryPart + c.imaginaryPart);
	}
	
	Complex subtract(Complex c) {
		return new Complex(realPart - c.realPart, imaginaryPart - c.imaginaryPart);
	}
	
	public String toString() {
		return String.format("(%.2f, %.2f)", realPart, imaginaryPart);
	}
}
public class RectangleTest {
	public static void main(String[] args) {
		Rectangle rect1 = new Rectangle();
		displayRectangle("Rect1 default initialized:", rect1);
		
		// set length and width accepted values
		rect1.setLength(10.0f);
		rect1.setWidth(5.0f);
		displayRectangle("Rect1 width & length set to accepted values:", rect1);
		
		// setting length to unacceptable value
		try {
			rect1.setLength(100.0f);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		displayRectangle("Rect1 after attempting to set its length to 100.0:", rect1);

		// setting width to unacceptable value
		try {
			rect1.setWidth(-100.0f);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		displayRectangle("Rect1 after attempting to set its width to -100.0:", rect1);
	}
	
	private static void displayRectangle(String desc, Rectangle r) {
		System.out.println(desc);
		System.out.printf("Length: %.2f%n", r.getLength());
		System.out.printf("Width: %.2f%n", r.getWidth());
		System.out.printf("Area: %.2f%n", r.area());
		System.out.printf("Perimeter: %.2f%n%n", r.perimeter());
	}
}

// note the package access in the fields and member functions
class Rectangle {
	private float length = 1.0f;
	private float width = 1.0f;
	
	float perimeter() {
		return 2*(length + width);
	}

	float area() {
		return length * width;
	}
	
	void setLength(float length) {
		if(!isValid(length)) {
			throw new IllegalArgumentException("argument length must be greater than zero and less than 20");
		}
		this.length = length;
		
	}
	
	float getLength() {
		return length;
	}
	
	void setWidth(float width) {
		if(!isValid(width)) {
			throw new IllegalArgumentException("argument width must be greater than zero and less than 20");
		}
		this.width = width;
		
	}
	
	float getWidth() {
		return width;
	}
	
	private boolean isValid(float value) {
		return (value > 0.0) && (value < 20.0);
	}
}
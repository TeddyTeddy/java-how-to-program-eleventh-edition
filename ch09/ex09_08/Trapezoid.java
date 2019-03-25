class Trapezoid extends Quadrilateral {
	// sides
	private final double a;
	private final double b;
	private final double c;
	private final double d;
	
	private final double h;
	
	// https://en.wikipedia.org/wiki/Trapezoid
	// DC is a
	// AB is b
	// note that AB and DC must be in parallel to each other
	Trapezoid(Point A, Point B, Point C, Point D) {
		super(A, B, C, D);
				
		a = Point.distance(C, D);
		b = Point.distance(A, B);
		c = Point.distance(C, B); // CB -> c
		d = Point.distance(D, A); // AD -> d
		h = Math.abs(C.getY() - B.getY());
	}
	
	public double getSideA() {
		return a;
	}
	
	public double getSideB() {
		return b;
	}
	
	public double getSideC() {
		return c;
	}
	
	public double getSideD() {
		return d;
	}
	
	public double getH() {
		return h;
	}
	
	public double area() {
		return (getSideA() + getSideB()) * (getH() /2);
	}
	
	// check given A, B, C, D as corners, is trapezoid?
	// https://en.wikipedia.org/wiki/Trapezoid > Condition of existence
	public boolean isTrapezoid() {
		double absDMinusC = Math.abs(getSideD()-getSideC());
		double absBMinusA = Math.abs(getSideB()-getSideA());
		boolean conditionExistence = ( (absDMinusC < absBMinusA) && (absBMinusA < (getSideD()+getSideC()) ));
		return conditionExistence;
	}
	
	@Override
	public String toString() {
		return String.format("Trapezoid a: %.2f, b: %.2f, h: %.2f %s", getSideA(), getSideB(), getH(), super.toString());
	}
}
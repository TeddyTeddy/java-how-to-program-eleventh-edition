class Parallelogram extends Trapezoid {
	Parallelogram(Point A, Point B, Point C, Point D) {
		super(A, B, C, D);
	}
	
	@Override
	public double area() {
		return getSideB() * getH();
	}
	
	@Override
	public String toString() {
		return String.format("Parallelogram with %s", super.toString());
	}
}
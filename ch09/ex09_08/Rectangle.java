class Rectangle extends Parallelogram {
	Rectangle(Point A, Point B, Point C, Point D) {
		super(A, B, C, D);
	}
	
	@Override
	public double area() {
		return getSideA() * getSideC();
	}
	
	@Override
	public String toString() {
		return String.format("Rectangle with %s", super.toString());
	}
}
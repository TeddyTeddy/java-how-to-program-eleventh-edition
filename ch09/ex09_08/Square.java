class Square extends Rectangle {
	Square(Point A, Point B, Point C, Point D) {
		super(A, B, C, D);
		
		// check if indeed square
		boolean isSquare = (getSideA() == getSideB()) && (getSideB() == getSideC()) && (getSideC() == getSideD());
		if( !isSquare ) {
			throw new IllegalArgumentException("Square() constructor: exception : A, B, C, D does not form a square");
		}
		
	}
	
	public boolean isSquare() {
		boolean condition = (getSideA() == getSideB()) && (getSideB() == getSideC()) && (getSideC() == getSideD());
		return condition;
	}
	
	@Override
	public double area() {
		return Math.pow(getSideA(), 2.0);
	}
	
	@Override
	public String toString() {
		return String.format("Square with %s", super.toString());
	}
}
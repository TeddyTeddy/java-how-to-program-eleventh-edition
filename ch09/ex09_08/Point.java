class Point {
	private double x;
	private double y;
	
	Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	// https://orion.math.iastate.edu/dept/links/formulas/form2.pdf
	public static double distance(Point p, Point q) {
		double x2Minusx1Square = Math.pow((p.x-q.x), 2);
		double y2Minusy1Square = Math.pow((p.y - q.y), 2);
		return Math.sqrt(x2Minusx1Square + y2Minusy1Square);
	}
	
	@Override
	public String toString() {
		return String.format("Point x: %.2f y: %.2f%n", x, y );
	}
}
class Quadrilateral extends Object {
	private final Point A;
	private final Point B;
	private final Point C;
	private final Point D;
	
	Quadrilateral(Point A, Point B, Point C, Point D) {
		this.A = A;
		this.B = B;
		this.C = C;
		this.D = D;
	}
	
	public Point getCornerA() {
		return A;
	}
	
	public Point getCornerB() {
		return B;
	}
	
	public Point getCornerC() {
		return C;
	}
	
	public Point getCornerD() {
		return D;
	}
	
	@Override
	public String toString() {
		return String.format("Quadrilateral: %nA=%s%nB=%s%nC=%s%nD=%s%n", getCornerA(), getCornerB(), getCornerC(), getCornerD());
	}
}
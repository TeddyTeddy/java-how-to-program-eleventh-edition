public class Floor {
	public static final int ROW_COUNT = 20;
	public static final int COLUMN_COUNT = 20;
	private static final int FLOOR_MARKED = 1;
	
	private int[][] floor; // instance variable
	
	public Floor() {
		floor = new int[ROW_COUNT][COLUMN_COUNT]; // 20 x 20 array initialized to zeros
	}
	
	public void markElement(int row, int column) {
		try {
			floor[row][column] = FLOOR_MARKED;
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
			System.out.printf("floor[%d][%d] element does not exist", row, column);
		}
	}
	
	public void display() {
		System.out.println("Floor status:");
		// loop through rows of floor array
		for(int[] row : floor) {
			for(int floorElement : row) {
				if(floorElement == FLOOR_MARKED) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
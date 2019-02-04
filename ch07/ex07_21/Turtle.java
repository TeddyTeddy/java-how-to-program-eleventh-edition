public class Turtle {
	public static final int PEN_UP = 1;
	public static final int PEN_DOWN = 2;
	private static final int INITIAL_POSITION_ROW_INDEX = 0;
	private static final int INITIAL_POSITION_COLUMN_INDEX = 0;
	
	private enum Direction {UP, DOWN, LEFT, RIGHT};
	
	// instance variables of Turtle
	private Floor floor;
	private int row;    // row position in the floor
	private int column; // column position in the floor
	private int pen;
	private Direction direction;
	
	public Turtle(Floor floor) {
		this.floor = floor;
		row = INITIAL_POSITION_ROW_INDEX;
		column = INITIAL_POSITION_COLUMN_INDEX;
		pen = PEN_UP;
		direction = Direction.RIGHT;
	}
	
	// TODO: throw an error if pen is not PEN_UP or PEN_DOWN
	public void setPen(int pen) {
		this.pen = pen;
	}
	
	// returns the row index of the move based on the current direction
	private int getNextRowIndex(int numberOfElementsToMove) {
		--numberOfElementsToMove; // i.e. 5,12 command would mark 12 elements including the current element on the floor
		int nextRowIndex;
		switch(direction) {
			case UP:
				nextRowIndex = row - numberOfElementsToMove;
				break;
			case DOWN:
				nextRowIndex = row + numberOfElementsToMove;
				break;
			case LEFT:
			case RIGHT:
			default: // need to add this to avoid compiler error
				nextRowIndex = row;
				break;
		}

		return nextRowIndex;
	}
	
	// returns the column index of the move based on the current direction
	private int getNextColumnIndex(int numberOfElementsToMove) {
		--numberOfElementsToMove; // i.e. 5,12 command would mark 12 elements including the current element on the floor
		int nextColumnIndex;
		switch(direction) {
			case LEFT:
				nextColumnIndex = column - numberOfElementsToMove;
				break;
			case RIGHT:
				nextColumnIndex = column + numberOfElementsToMove;
				break;
			case UP:
			case DOWN:
			default:
				nextColumnIndex = column;
				break;
		}
		return nextColumnIndex;
	}
	
	private boolean isOutOfField(int numberOfElementsToMove) {
		boolean outOfField = false;
		// calculate nextRow index
		int nextRowIndex = getNextRowIndex(numberOfElementsToMove);
		
		// calculate nextColumn index
		int nextColumnIndex = getNextColumnIndex(numberOfElementsToMove);
		
		if ((nextRowIndex >= Floor.ROW_COUNT) || (nextColumnIndex >= Floor.COLUMN_COUNT) || (nextRowIndex < 0) || (nextColumnIndex < 0)) {
			outOfField = true;
		}
		
		return outOfField;
	}
	
	private void traceOnTheFloor(int numberOfElementsToMove) {
		// calculate nextRow index
		int nextRowIndex = getNextRowIndex(numberOfElementsToMove);
		
		// calculate nextColumn index
		int nextColumnIndex = getNextColumnIndex(numberOfElementsToMove);
		
		// are we tracing horizontally? LEFT, RIGHT
		switch(direction) {
			case LEFT:
				for(int column = nextColumnIndex; column <= this.column; ++column) {
					floor.markElement(row, column);
				}
				break;
			case RIGHT:
				for(int column = this.column; column <= nextColumnIndex ; ++column) {
					floor.markElement(row, column);
				}
				break;
			case UP:
				for(int row = nextRowIndex; row <= this.row; ++row) {
					floor.markElement(row, this.column);
				}
				break;
			case DOWN:
				for(int row = this.row; row <= nextRowIndex; ++row) {
					floor.markElement(row, this.column);
				}
				break;
		}
	}
	
	public void moveForward(int numberOfElementsToMove) {
		if(isOutOfField(numberOfElementsToMove)) {
			System.out.printf("WARNING! Cant move that much. Would run out of boundries of %dx%d field%n", Floor.ROW_COUNT, Floor.COLUMN_COUNT);
			return;
		}
		// turtle can safely move within the boundaries of Floor.ROW_COUNT x FLOOR.COLUMN_COUNT field array
		if(pen == PEN_DOWN) {
			traceOnTheFloor( numberOfElementsToMove );
		}

		// update Turtle's row & column indices in the Floor array
		row = getNextRowIndex(numberOfElementsToMove);
		column = getNextColumnIndex(numberOfElementsToMove);		
	}
	
	public void turnRight() {
		switch(direction) {
			case UP:
				direction = Direction.RIGHT;
				break;
			case RIGHT:
				direction = Direction.DOWN;
				break;
			case DOWN:
				direction = Direction.LEFT;
				break;
			case LEFT:
				direction = Direction.UP;
				break;
		}
	}
	
	public void turnLeft() {
		switch(direction) {
			case UP:
				direction = Direction.LEFT;
				break;
			case RIGHT:
				direction = Direction.UP;
				break;
			case DOWN:
				direction = Direction.RIGHT;
				break;
			case LEFT:
				direction = Direction.DOWN;
				break;
		}
	}
}
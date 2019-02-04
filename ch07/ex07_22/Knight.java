public class Knight {
	
	// the eight moves can be described by two one dimensional arrays
	private static final int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
	private static final int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1};
	
	// instance variables
	private ChessBoard cb; // cb stands for Chess Board
	private int currentRow;
	private int currentColumn;
	
	// TODO: Throw an error if row or column are out of chessboard
	public void putOnChessBoard(int row, int column) {
		currentRow = row;
		currentColumn = column;
	}
	
	public Knight(ChessBoard chessBoard) {
		cb = chessBoard;
	}
	
	public void makeATour() {
		// initialize counter to 1
		// for each moveNumber
			// check if the moveNumber.th move is on the board
				// if so, mark the chessBoard with counter value
				// ++counter
		
	}
}
public class ChessBoard {
	public static final int CHESS_BOARD_SIZE = 8;
	
	// instance variables
	private int[][] cb; // cb stands for Chess Board
	
	public ChessBoard() {
		cb = new int[CHESS_BOARD_SIZE][CHESS_BOARD_SIZE]; // initialized to zero
	}
	
	public void print() {
		// print header
		System.out.print("  ");;
		for(int column = 0 ; column < cb[0].length; ++ column) {
			System.out.printf("%2d ", column);
		}
		System.out.println();
		
		// print cb's contents along with the row indexes on the left side
		for(int row = 0; row < cb.length; ++row) {
			System.out.printf("%d ", row );
			for(int column = 0; column < cb[row].length; ++column) {
				System.out.printf("%2d ", cb[row][column]);
			}
			System.out.println();
		}
	}
}
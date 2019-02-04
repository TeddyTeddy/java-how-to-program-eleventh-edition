public class KnightsTour {
	public static void main(String[] args) {
		ChessBoard chessBoard = new ChessBoard();
		Knight knight = new Knight(chessBoard);
		knight.putOnChessBoard(3, 4); // acc.to Fig 7.30
		chessBoard.print();
	}
}
import java.util.Scanner;

public class TicTacToeTest {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		TicTacToe gameBoard = new TicTacToe();
		System.out.printf("%s", gameBoard); // empty board
		
		for(int move = 1; move <= (TicTacToe.SIZE * TicTacToe.SIZE) ; ++move) {
			if(move % 2 != 0) { // if move is an odd number, use player 1 variables
				makeMove("PLAYER 1", BoardElement.X, gameBoard, input);
			} else {// if move is an even number, use player 2 variables
				makeMove("PLAYER 2", BoardElement.O, gameBoard, input);
			}
			// after each move, determine whether the game has been WON and whether it's a DRAW
			GameStatus gameStatus = gameBoard.getGameStatus();
			if( gameStatus.getState() == GameState.WON ) {
				System.out.printf("Game ended: The winner is %s%n", gameStatus.getWinner() );
				break; // out of the for loop
			} else if(gameStatus.getState() == GameState.DRAW ) {
				System.out.printf("Game ended: The result is a draw (no winner)");	
				break;
			} // else (GameState.CONTINUE)
		}
		
		input.close();
	}
	
	private static void makeMove(String playerName, BoardElement be, TicTacToe gameBoard, Scanner input) {
		
		try {
			boolean markingSuccessful = false;
			while(!markingSuccessful) {
				System.out.println(playerName);
				int row =    getIndex("Enter row index: ", input);    // enter row between 1-3
				int column = getIndex("Enter column index: ", input); // enter column between 1-3
				markingSuccessful = gameBoard.mark(row, column, be);  // throws an Exception if row / column invalid
				if(markingSuccessful) {
					System.out.printf("%s", gameBoard);
				} else {
					System.out.printf("%nError: Each move must be to an empty square.%nPlease re-enter row and column indexes for %s%n", playerName);
				}
			}
			
		} catch(Exception e) {
			System.out.println(e.getMessage()); // this code should never execute
		}	
	}
	
	private static int getIndex(String msg, Scanner input) {
		System.out.printf("%s", msg);
		int index = input.nextInt();
		while( ( index < 1 ) || ( index > TicTacToe.SIZE ) ) {
			System.out.printf("Error: index must be between 1 and 3, inclusive. Enter it again: ");
			index = input.nextInt();
		}
		return index;
	}
}
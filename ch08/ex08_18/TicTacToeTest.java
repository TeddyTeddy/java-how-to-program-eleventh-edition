import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToeTest {
	private static BoardElement computer = BoardElement.EMPTY; // invalid initialized on purpose
	private static BoardElement human = BoardElement.EMPTY;	   // invalid initialized on purpose	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		askWhoIsFirst(input);
		
		TicTacToe gameBoard = new TicTacToe();
		System.out.printf("%s", gameBoard);
		for(int move = 1; move <= (TicTacToe.SIZE * TicTacToe.SIZE) ; ++move) {
			// X plays first!
			if(human == BoardElement.O) {
				if(move % 2 != 0) { // if move is an odd number, use player 1 variables
					makeComputerMove( gameBoard );
				} else {// if move is an even number, use player 2 variables
					makePlayerMove("Your turn:", human, gameBoard, input);
				}		
			} else if(human == BoardElement.X) {
				if(move % 2 != 0) { // if move is an odd number, human plays
					makePlayerMove("Your turn:", human, gameBoard, input);
				} else {// if move is an even number, computer plays
					makeComputerMove( gameBoard );
				}					
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
			    // do nothing
		}
		
		input.close();
	}
	
	private static void askWhoIsFirst(Scanner input) {
		System.out.println("Do you wanna be the first? (Y/N) or (y/n): ");
		char answer = input.nextLine().charAt(0);
		if(answer == 'Y' || answer == 'y') {
			computer = BoardElement.O;
			human = BoardElement.X;
		} else {
			computer = BoardElement.X;
			human = BoardElement.O;
		}
	}
	
	private static void makeComputerMove(TicTacToe gameBoard) {
		try {
			BoardElementDetails winnerBoardElement = new BoardElementDetails(); // create with invalid row & column indexes
			boolean isHumanWinningSoon = gameBoard.isWinningSoon(human, winnerBoardElement);
			boolean isComputerWinningSoon = gameBoard.isWinningSoon(computer, winnerBoardElement);
			
			if(isHumanWinningSoon && isComputerWinningSoon) { // prefer computer victory
				// update winnerBoardElement
				gameBoard.isWinningSoon(computer, winnerBoardElement);
				makeMove(computer, winnerBoardElement, gameBoard); // make computer to move to the winner board element
			} else if( gameBoard.isWinningSoon(human, winnerBoardElement) ) { // is opponent winning soon?
				makeMove(computer, winnerBoardElement, gameBoard); // make computer to move to the winner board element
			} else if( gameBoard.isWinningSoon(computer, winnerBoardElement) ) { // is computer winning soon?
				makeMove(computer, winnerBoardElement, gameBoard);  // computer places to the winnerBoardElement
			} else {
				makeMoveInPriority(computer, gameBoard);
			}
			System.out.println("And computer made its move: ");
			System.out.printf("%s", gameBoard);
		} catch(Exception e) {
			System.out.println(e.getMessage()); // this code should never execute
		}
	}
	
	private static void makeMoveInPriority(BoardElement playerMark, TicTacToe gameBoard) throws Exception {
		final int[][] priorityBoard = { {2,1,2},
										{1,3,1},
										{2,1,2}};
		ArrayList<BoardElementDetails> emptyElements = gameBoard.getEmptyBoardElements();
		// pick the highest priority empty element
		BoardElementDetails highestPriorityEmptyElement = new BoardElementDetails();
		int maxPriority = Integer.MIN_VALUE;
		for(BoardElementDetails e : emptyElements) {
			if( priorityBoard[e.getRow()][e.getColumn()] > maxPriority) {
				highestPriorityEmptyElement.setRow(e.getRow());
				highestPriorityEmptyElement.setColumn(e.getColumn());
				maxPriority = priorityBoard[e.getRow()][e.getColumn()];
			}
		}
		
		makeMove(playerMark, highestPriorityEmptyElement, gameBoard);
	}
	
	private static void makeMove(BoardElement playerMark, BoardElementDetails winningBoardElement, TicTacToe gameBoard) {
		try {
			gameBoard.mark(winningBoardElement.getRow(), winningBoardElement.getColumn(), playerMark);
		} catch(Exception e) {
			System.out.println(e.getMessage()); // this code should never execute
		}
	}
	
	private static void makePlayerMove(String playerName, BoardElement be, TicTacToe gameBoard, Scanner input) {
		
		try {
			boolean markingSuccessful = false;
			while(!markingSuccessful) {
				System.out.println(playerName);
				int row =    getIndex("Enter row index: ", input);    // enter row between 0-2
				int column = getIndex("Enter column index: ", input); // enter column between 0-2
				markingSuccessful = gameBoard.mark(row, column, be);  // throws an Exception if row / column invalid
				if(markingSuccessful) {
					System.out.println("After your move the board is: ");
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
		while( ( index < 0 ) || ( index >= TicTacToe.SIZE ) ) {
			System.out.printf("Error: index must be between 0 and 2, inclusive. Enter it again: ");
			index = input.nextInt();
		}
		return index;
	}
}
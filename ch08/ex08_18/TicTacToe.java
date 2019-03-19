enum BoardElement { X, O, EMPTY }

enum GameState { WON, DRAW, CONTINUE }

class GameStatus {
	private final GameState state;
	private final String winner;
	
	GameStatus(GameState state, String winner) {
		this.state = state;
		this.winner = winner;
	}
	
	GameState getState() {
		return state;
	}
	
	String getWinner() {
		return winner;
	}
}

class TicTacToe {
	public static final int SIZE = 3;
	private BoardElement[][] board;
	
	public TicTacToe() {
		board = new BoardElement[SIZE][SIZE];
		
		// initialize the board elements to EMPTY
		for(int i = 0; i < SIZE; ++i) {
			for(int j = 0; j < SIZE; ++j) {
				board[i][j] = BoardElement.EMPTY;
			}
		}
	}
	
	public GameStatus getGameStatus() {
		// check has X won
		boolean hasXWon = checkHasPlayerWon( BoardElement.X );
		boolean hasOWon = checkHasPlayerWon( BoardElement.O );
		GameStatus status = null;
		
		if(hasXWon) {
			status = new GameStatus( GameState.WON , "X");
		} else if(hasOWon) {
			status = new GameStatus( GameState.WON , "O");
		} else if( isBoardFullyMarked() ) { // neither X nor O won and board is full -> DRAW
			status = new GameStatus ( GameState.DRAW, "");
		} else { // board is not full and nobody won yet, continue
			status = new GameStatus ( GameState.CONTINUE, "");
		}
		
		return status; // must never return null
	}
	
	private boolean isBoardFullyMarked() {
		boolean isMarkedFully = true;
		for(int i = 0; i < SIZE; ++i) {
			for(int j = 0; j < SIZE; ++j) {
				if ( board[i][j] == BoardElement.EMPTY ) {
					isMarkedFully = false;
					break;
				}
			}
		}
		return isMarkedFully;
	}
	
	private boolean checkHasPlayerWon( BoardElement playerMark ) {
		boolean winnerFound = checkWinnerHorizontally(playerMark);
		if(!winnerFound) {
			winnerFound = checkWinnerVertically(playerMark);
			if(!winnerFound) {
				winnerFound = checkWinnerDiagonally(playerMark);
			}
		}
		return winnerFound;
	}
	
	private boolean checkWinnerDiagonally( BoardElement playerMark ) {
		boolean isDiagonalWinner = false;
		isDiagonalWinner = (board[0][0] == playerMark) && (board[1][1] == playerMark) && (board[2][2] == playerMark);
		isDiagonalWinner = isDiagonalWinner || ((board[0][2] == playerMark) && (board[1][1] == playerMark) && (board[2][0] == playerMark));
		return isDiagonalWinner;
	}
	
	private boolean checkWinnerVertically ( BoardElement playerMark ) {
		boolean isVerticalWinner = false;
		for(int j = 0; j < SIZE; ++j) {
			int matchCount = 0;
			for(int i = 0; i < SIZE; ++i) {
				if ( board[i][j] == playerMark ) {
					++matchCount;
				}
			}
			if(matchCount == SIZE) {
				isVerticalWinner = true;
				break;
			}
		}		
		
		return isVerticalWinner;
	}
	
	private boolean checkWinnerHorizontally( BoardElement playerMark ) {
		boolean isHorizontalWinner = false;
		for(int i = 0; i < SIZE; ++i) {
			int matchCount = 0;
			for(int j = 0; j < SIZE; ++j) {
				if ( board[i][j] == playerMark ) {
					++matchCount;
				}
			}
			if(matchCount == SIZE) {
				isHorizontalWinner = true;
				break;
			}
		}
		return isHorizontalWinner;
	}
	
	
	public boolean mark(int row, int column, BoardElement be) throws Exception {
		if( (row < 1) || (row > SIZE) ) {
			throw new Exception("mark() exception: row index " + row + " must be in range [1,3]");
		}
		if( (row < 1) || (row > SIZE) ) {
			throw new Exception("mark() exception: column index " + column + " must be in range [1,3]");
		}
		
		--row;
		--column;
		boolean markingSuccessful = false;
		if(board[row][column] == BoardElement.EMPTY) {
			board[row][column] = be;
			markingSuccessful = true;
		}
		return markingSuccessful;
	}
	
	public String toString() {
		String result = "";
		
		result = "  ";
		for(int i = 0; i < SIZE; ++i) {
			result += String.format(" %d ", i+1);
		}
		result += "\n";
		
		for(int i = 0; i < SIZE; ++i) {
			result += String.format("%d ", i+1);
			for(int j = 0; j < SIZE; ++j) {
				switch( board[i][j] ) {
					case X: 
						result += "[X]";
						break;
					case O:
						result += "[O]";
						break;
					case EMPTY:
						result += "[ ]";
						break;
				}
			}
			result += "\n";
		}		
		return result;
	}
}
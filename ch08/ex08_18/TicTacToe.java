import java.util.ArrayList;

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

class BoardElementDetails {
	private static final int INITIAL_INDEX = -1;
	private int row; // 0-SIZE-1
	private int column; // 0-SIZE-1
	
	BoardElementDetails() throws Exception {
		this(INITIAL_INDEX, INITIAL_INDEX);
	}
	
	BoardElementDetails(int row, int column) throws Exception {
		if( (row != INITIAL_INDEX) && ((row < 0) || (row >= TicTacToe.SIZE)) ) {
			throw new Exception("BoardElementDetails() exception: row " + row + " has to be in between 0-" + (TicTacToe.SIZE -1) );
		}
		if( (column != INITIAL_INDEX) && ((column < 0) || (column >= TicTacToe.SIZE)) ) {
			throw new Exception("BoardElementDetails() exception: column " + column + " has to be in between 0-" + (TicTacToe.SIZE -1) );
		}
		this.row = row;
		this.column = column;
	}
	
	void setRow(int row) {
		this.row = row;
	}
	
	int getRow() {
		return row;
	}
	
	void setColumn(int column) {
		this.column = column;
	}
	
	int getColumn() {
		return column;
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
	
	public boolean isWinningSoon(BoardElement playerMark, BoardElementDetails winningBoardElement) throws Exception {
		boolean isWinningSoon = false;
		// get all the current empty elements
		ArrayList<BoardElementDetails> winnerCandidates = getEmptyBoardElements();
		for(BoardElementDetails e : winnerCandidates) {
			// set temporarily boards element, which corresponds to e's row and column, the playerMark 
			board[e.getRow()][e.getColumn()] = playerMark;
			isWinningSoon = checkHasPlayerWon( playerMark );
			if(isWinningSoon) {
				winningBoardElement.setRow(e.getRow());
				winningBoardElement.setColumn(e.getColumn());
				board[e.getRow()][e.getColumn()] = BoardElement.EMPTY; // set temporary board element (e's board element) back to EMPTY;
				break;
			}
			board[e.getRow()][e.getColumn()] = BoardElement.EMPTY; // set temporary board element back to EMPTY;
		}
		return isWinningSoon;
	}
	
	public ArrayList<BoardElementDetails> getEmptyBoardElements() throws Exception {
		ArrayList<BoardElementDetails> emptyBoardElements = new ArrayList<BoardElementDetails>(SIZE*SIZE);
		for(int i = 0; i < SIZE; ++i) {
			for(int j = 0; j < SIZE; ++j) {
				if ( board[i][j] == BoardElement.EMPTY ) {
					emptyBoardElements.add(new BoardElementDetails(i , j));
				}
			}
		}
		return emptyBoardElements;
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
	
	// accepts row in [0-2]
	// accepts column in [0-2]
	public boolean mark(int row, int column, BoardElement be) throws Exception {
		if( (row < 0) || (row >= SIZE) ) {
			throw new Exception("mark() exception: row index " + row + " must be in range [0,2]");
		}
		if( (row < 0) || (row >= SIZE) ) {
			throw new Exception("mark() exception: column index " + column + " must be in range [0,2]");
		}
		
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
			result += String.format(" %d ", i);
		}
		result += "\n";
		
		for(int i = 0; i < SIZE; ++i) {
			result += String.format("%d ", i);
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
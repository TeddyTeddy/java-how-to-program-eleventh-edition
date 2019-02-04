import java.security.SecureRandom;
public class TheTortoiseAndTheHare {
	
	private static final int INITIAL_POSITION = 1;
	private static final int FINAL_POSITION = 70;
	private static final int CLOCK_START = 1;
	private static SecureRandom randomNumbers = new SecureRandom();
	
	private enum Winner {NOT_YET, TIE, TORTOISE_WINS, HARE_WINS};
	
	public static void main(String[] args) {
		
		int harePosition = INITIAL_POSITION;
		int tortoisePosition = INITIAL_POSITION;
		int clockTick = CLOCK_START;
		Winner winner = Winner.NOT_YET;
		
		System.out.println("BANG !!!!!");
		System.out.println("AND THEY ARE OFF !!!!!");
		do {
			// calculate tortoise position
			tortoisePosition = calculateTortoisePosition(tortoisePosition);
			// calculate hares position
			harePosition = calculateHarePosition(harePosition);
			// show hare and tortoise positions
			showCurrentStatus(tortoisePosition, harePosition);
			// get the winner (i.e. -1 is no winner yet)
			winner = getWinner(tortoisePosition, harePosition);
			++clockTick;
		} while(winner == Winner.NOT_YET);
		// while a winner is not found
		
		if(winner == Winner.HARE_WINS) {
			System.out.println("Hare wins. Yuch");
		} else if(winner == Winner.TORTOISE_WINS) {
			System.out.println("TORTOISE WINS!!! YAY!!!");
		} else if(winner == Winner.TIE) {
			System.out.println("Its a tie.");
		}
		System.out.printf("The game ended in %d clock ticks", clockTick);
	}
	
	private static Winner getWinner(int tortoisePosition, int harePosition) {
		Winner winner = Winner.NOT_YET;
		if((FINAL_POSITION == tortoisePosition) && (harePosition == tortoisePosition)) {
			// they both made it to the final position at the same time
			winner = Winner.TIE;
		} else if(tortoisePosition == FINAL_POSITION) {
			winner = Winner.TORTOISE_WINS;
		} else if(harePosition == FINAL_POSITION) {
			winner = Winner.HARE_WINS;
		}
		return winner;
	}
	
	private static void showCurrentStatus(int tortoisePosition, int harePosition) {
		for(int i = INITIAL_POSITION; i <= FINAL_POSITION; ++i ) {
			if((i == tortoisePosition) && (harePosition == tortoisePosition)) { // the contenders are on the same square
				System.out.print("OUCH!!!");
			} else if(i == tortoisePosition) {
				System.out.print("T");
			} else if(i == harePosition) {
				System.out.print("H");
			} else {
				System.out.print(" "); // all output positions other than T, the H or the OUCH should be blank
			}
		}
		System.out.println();
	}
	
	private static int calculateHarePosition(int harePosition) {
		int nextPosition;
		int random = 1 + randomNumbers.nextInt(10); // a random number between 1-10
		if((1 <= random) && (random <= 2)) { // Sleep, no move at all
			nextPosition = harePosition;
		} else if((random >= 3) && (random <= 4)) { // Big Hop
			nextPosition = harePosition + 9; // 9 squares to the right
		} else if(random == 5) { // Big slip
			nextPosition = harePosition - 12; // 12 squares to the left
		} else if((random >= 6) && (random <= 8)) { // Small hop
			nextPosition = harePosition + 1; // 1 square to the right
		} else { // small slip
			nextPosition = harePosition - 2; // 2 squares to the left
		}
		
		// if an animal slips let before square 1, move it back to square 1
		if(nextPosition < INITIAL_POSITION) {
			nextPosition = INITIAL_POSITION;
		} else if(nextPosition > FINAL_POSITION) {
			nextPosition = FINAL_POSITION;
		}
		return nextPosition;
	}
	
	private static int calculateTortoisePosition(int currentPosition) {
		int nextPosition;
		int i = 1 + randomNumbers.nextInt(10); // a random number between 1-10
		if((i >= 1) && (i <= 5)) { // Fast Plod
			nextPosition = currentPosition + 3; // 3 squares to the right
		} else if((i >= 6) && (i <= 7)) {  // Slip
			nextPosition = currentPosition - 6;  // 6 squares to the left
		} else { // slow plod
			nextPosition = currentPosition + 1; // 1 square to the right
		}
		// if an animal slips let before square 1, move it back to square 1
		if(nextPosition < INITIAL_POSITION) {
			nextPosition = INITIAL_POSITION;
		}else if(nextPosition > FINAL_POSITION) {
			nextPosition = FINAL_POSITION;
		}
		return nextPosition;
	}
}
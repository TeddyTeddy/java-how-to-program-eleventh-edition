import java.util.Scanner;

public class AirlineReservationSystem {
	private static final int NUMBER_OF_SEATS = 10;
	private static final int SENTINEL = -1;
	private static final int FIRST_CLASS = 1;
	private static final int ECONOMY_CLASS = 2;
	private static final int NO_FREE_SEAT = -1;
	
	public static void main(String[] args) {
		// initialize seats array
		boolean[] seats = new boolean[NUMBER_OF_SEATS];
		
		Scanner input = new Scanner(System.in);
		// read getSeatType into seatType
		int seatType = getSeatType(input);
		while (seatType != SENTINEL ) {
			// calculate otherSeatType
			int otherSeatType = (seatType == FIRST_CLASS) ? ECONOMY_CLASS : FIRST_CLASS;
			// call processReservation with seatType, otherSeatType, seats
			processReservation(seatType, otherSeatType, seats, input);
			// read getSeatType into seatType
			seatType = getSeatType(input);
		}
		input.close();
	}
	
	private static int getSeatType(Scanner input) {
		System.out.println("Please type 1 for First Class");
		System.out.println("Please type 2 for Economy Class");
		System.out.print("Enter the class of your choice (or -1 to exit): ");
		int seatType = input.nextInt();
		while(!((seatType == FIRST_CLASS) || (seatType == ECONOMY_CLASS) || (seatType == SENTINEL))) {
			System.out.print("Incorrect input. Enter the class of your choice (or -1 to exit): ");
			seatType = input.nextInt();		
		}
		return seatType;
	}
	
	// returns -1 if no free seat of specified seatType is found
	// returns the index of the next free seat otherwise
	private static int checkFreeSeat(int seatType, boolean[] seats) {
		final int FIRST_CLASS_LAST_SEAT_INDEX = 4;
		final int FIRST_CLASS_FIRST_SEAT_INDEX = 0;
		final int ECONOMY_CLASS_FIRST_SEAT_INDEX = 5;
		int index = NO_FREE_SEAT;
		if(seatType == FIRST_CLASS) {
			for(int i = FIRST_CLASS_FIRST_SEAT_INDEX; i <= FIRST_CLASS_LAST_SEAT_INDEX; ++i) {
				if(!seats[i]) {
					index = i;
					break;
				}
			}
		} else if(seatType == ECONOMY_CLASS) {
			for(int i = ECONOMY_CLASS_FIRST_SEAT_INDEX; i < NUMBER_OF_SEATS ; ++i) {
				if(!seats[i]) {
					index = i;
					break;
				}
			}	
		}
		return index;
	}
	
	private static void displayBoardingPass(int seatNumber, int seatType) {
		System.out.print("\nBoarding Pass\n");
		if(seatType == ECONOMY_CLASS) {
			System.out.print("ECONOMY CLASS ");
		} else if(seatType == FIRST_CLASS) {
			System.out.print("FIRST CLASS ");
		}
		System.out.printf("with seat no: %d%n", seatNumber);
		System.out.println();
	}
	
	private static char getAnswer(Scanner input, int otherSeatType) {
		if(otherSeatType == ECONOMY_CLASS) {
			System.out.println("Do you want a seat in ECONOMY class?");
		} else if(otherSeatType == FIRST_CLASS) {
			System.out.println("Do you want a seat in FIRST class?");
		}
		System.out.print("Enter y/Y or n/N to continue");
		char answer = input.next().charAt(0);
		while(!((answer == 'Y') || (answer == 'y') || (answer == 'n') || (answer == 'N'))) {
			System.out.print("Wrong input. Enter y/Y or n/N to continue");
			answer = input.next().charAt(0);	
		}
		return answer;
	}
	
	private static void processReservation(int seatType, int otherSeatType, boolean[] seats, Scanner input) {
		// check if there is any seat left of seatType
		int freeSeatIndex = checkFreeSeat(seatType, seats);
		// if there is, reserve a seat and display a boarding pass
		if(freeSeatIndex != NO_FREE_SEAT) {
			seats[freeSeatIndex] = true;
			displayBoardingPass(freeSeatIndex, seatType);
		} else if(freeSeatIndex == NO_FREE_SEAT) {
			// there is not any seat left of seatType...
			// check if there is any seat left of otherSeatType
			freeSeatIndex = checkFreeSeat(otherSeatType, seats);
			// if there is a seat available in otherSeatType
			if(freeSeatIndex != NO_FREE_SEAT) {
				// Ask passenger if he wants an otherSeatType seat
				char answer = getAnswer(input, otherSeatType);
				// if the answer is yes, make a reservation and display the boarding pass
				if((answer == 'Y') || (answer == 'y')) {
					seats[freeSeatIndex] = true;
					displayBoardingPass(freeSeatIndex, otherSeatType);
				} else {
					// if the answer is no, display "next flight is in 3 hours"
					System.out.println("\nNext flight is in 3 hours");
				}

			} else {
				// Plane is full. There is no seat available in otherSeatType either
				// display "plane is full. The next flight is in 3 hours"
				System.out.println("\nIMPORTANT!! Plane is full. The next flight is in 3 hours\n");
			}
		}

	}
}
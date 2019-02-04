import java.util.Scanner;

public class TurtleGraphics {
	private static final int TURN_RIGHT = 3;
	private static final int TURN_LEFT = 4;
	private static final int MOVE_FORWARD = 5;
	private static final int DISPLAY = 6;
	private static final int SENTINEL = 9;
	private static final int MOVE_FORWARD_COMMAND_MIN_LENGTH = 3; // i.e. 5,3 -> 3 chars
	private static final int MIN_COMMAND_LENGHT = 1; // all commands other than MOVE_FORWARD have 1 character length in a String
	private static final int INITIAL_INVALID_VALUE = 0; // intentional invalid value for command & numberOfSpacesToMoveForward
	
	private static int command = INITIAL_INVALID_VALUE;
	private static int numberOfSpacesToMoveForward = INITIAL_INVALID_VALUE;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Floor floor = new Floor();
		Turtle turtle = new Turtle(floor);
		
		do {
			getVerifiedUserChoice(input); // will set command (& numberOfSpacesToMoveForward)
			handleCommand(turtle, floor);
		} while(command != SENTINEL);
		
		input.close();
	}
	
	private static void handleCommand(Turtle turtle, Floor floor) {
		switch(command) {
			case Turtle.PEN_UP:
				turtle.setPen( Turtle.PEN_UP );
				break;
			case Turtle.PEN_DOWN:
				turtle.setPen( Turtle.PEN_DOWN );
				break;
			case DISPLAY:
				floor.display();
				break;
			case TURN_RIGHT:
				turtle.turnRight();
				break;
			case TURN_LEFT:
				turtle.turnLeft();
				break;
			case MOVE_FORWARD:
				turtle.moveForward(numberOfSpacesToMoveForward);
				break;
			case SENTINEL: // do nothing for sentinel value, we are to exit
				break;
			case INITIAL_INVALID_VALUE:
			default:
				System.out.printf("Command %d is invalid. Check getVerifiedUserChoice() method to fix the issue %n", command);
				break;
		}
	}
	
	private static void outputCommands(boolean invalidChoice) {
		System.out.println("Turtle Graphics Game Commands");
		System.out.println("1 : Pen Up");
		System.out.println("2 : Pen Down");
		System.out.println("3 : Turn right");
		System.out.println("4 : Turn left");
		System.out.println("5,10 : Move forward 10 spaces (replace 10 for a different number of spaces");
		System.out.println("6: Display 20 by 20 array");
		System.out.println("9: End of data (sentinel)");
		if(invalidChoice) {
			System.out.print("Invalid input! ");
		}
		System.out.print("Enter your choice: ");
	}
	
	// will set command (& numberOfSpacesToMoveForward)
	private static void getUserChoice(Scanner input) {
		String choice = input.next();
		// check if the command is MOVE_FORWARD
		if(choice.length() >= MOVE_FORWARD_COMMAND_MIN_LENGTH) { // i.e. 5,3 : Move forward 3 spaces
			// user has entered MOVE_FORWARD command, parse it
			command = Integer.parseInt(choice.substring(0, 1)); // supposed to be 5 always!
			numberOfSpacesToMoveForward = Integer.parseInt(choice.substring(2, choice.length())); // i.e. 3
		} else if( choice.length() == MIN_COMMAND_LENGHT){
			// any other command than MOVE_FORWARD
			command = Integer.parseInt(choice);
		}
	}
	
	private static boolean isInvalidUserChoice() {
		boolean result = true; // invalid by default
		if((command == Turtle.PEN_UP) || (command == Turtle.PEN_DOWN) || (command == TURN_RIGHT) || (command == TURN_LEFT) || (command == DISPLAY) || (command == SENTINEL)) {
			result = false; // user had entered a valid value
		} else if((command == MOVE_FORWARD) && (numberOfSpacesToMoveForward > 0)) {
			result = false; // user entered valid values
		}
		return result;
	}
	
	private static void getVerifiedUserChoice(Scanner input) {
		boolean invalidChoice = false;
		do {
			// reset command & numberOfSpacesToMoveForward invalid values intentionally
			// so that we can re-set them in getUserChoice()
			command = INITIAL_INVALID_VALUE;
			numberOfSpacesToMoveForward = INITIAL_INVALID_VALUE;
			outputCommands(invalidChoice);
			getUserChoice(input);
			invalidChoice = isInvalidUserChoice();
		} while(invalidChoice);	
	}
}
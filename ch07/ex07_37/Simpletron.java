import java.util.Scanner;

public class Simpletron {
	private static final int MEMORY_SIZE = 100;
	private static final int MIN_VALID_WORD = -9999;
	private static final int MAX_VALID_WORD = 9999;
	private static final int SENTINEL = -99999;
	
	// SML OPERATION CODES
	private static final int READ = 10;
	private static final int WRITE = 11;
	private static final int LOAD = 20;
	private static final int STORE = 21;
	private static final int ADD = 30;
	private static final int SUBTRACT = 31;
	private static final int DIVIDE = 32;
	private static final int MULTIPLY = 33;
	private static final int BRANCH = 40;
	private static final int BRANCHNEG = 41;
	private static final int BRANCHZERO = 42;
	private static final int HALT = 43;
	
	private static int[] memory = new int[MEMORY_SIZE];
	private static int accumulator = 0;
	private static int instructionCounter = 0;
	private static int operationCode = 0;
	private static int operand = 0;
	private static int instructionRegister = 0;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		loadSMLProgram(input);		
		dump();
		executeSMLProgram(input);
		dump();
		input.close();
	}
	
	private static void executeSMLProgram(Scanner input) {
		System.out.println();
		System.out.println("*** Program execution begins ***");
		// read into instructionRegister memory[instructionCounter] value
		do {
			instructionRegister = memory[instructionCounter];
			operationCode = instructionRegister / 100;
			operand = instructionRegister % 100;  // bound to be between 0-99
			executeSMLInstruction(input);  		  // will modify the instructionCounter
		} while((operationCode != HALT) && (instructionCounter < MEMORY_SIZE));
	}
	
	// executes the instruction stored in the instructionRegister, operationCode and operand
	private static void executeSMLInstruction(Scanner input) {
		switch(operationCode) {
			case READ: // Tested
				// read a valid word from keyboard into memory[operand]
				memory[operand] = readValidSMLWord(operand, input);
				++instructionCounter; // move to the next instruction in memory
				break;
			case WRITE: // Tested
				// write a word from a specific location in memory to the screen
				System.out.printf("memory[%d]: %+05d%n", operand, memory[operand]);
				++instructionCounter;
				break;
			case LOAD: // Tested
				// Load a word from a specific location in memory into the accumulator
				accumulator = memory[operand];
				++instructionCounter;  // move to the next instruction in memory
				break;
			case STORE: // Tested
				// Store a word from the accumulator into a specific location in memory
				memory[operand] = accumulator;
				++instructionCounter;  // move to the next instruction in memory
				break;
			case ADD: // Tested
				// Add a word from memory[operand] to the word in the accumulator
				// Leave the result in accumulator
				int temporary = memory[operand] + accumulator;
				if((temporary < MIN_VALID_WORD ) || (temporary > MAX_VALID_WORD)) { // addition would cause accumulator overflow
					printErrorMessage("*** ADD command would cause an overflow in accumulator ***");
					operationCode = HALT;
					// leave instructionCounter at its current value so that user can pinpoint his error
				} else { // no accumulator overflow
					accumulator = temporary;
					++instructionCounter;  // move to the next instruction in memory
				}
				break;
			case SUBTRACT: // Tested
				// Subtract a word from memory[operand] from the word in the accumulator
				// Leave the result in accumulator
				temporary = accumulator - memory[operand];
				if((temporary < MIN_VALID_WORD ) || (temporary > MAX_VALID_WORD)) { // addition would cause accumulator overflow
					printErrorMessage("*** SUBTRACT command would cause an overflow in accumulator ***");
					operationCode = HALT;
					// leave instructionCounter at its current value so that user can pinpoint his error
				} else { // no accumulator overflow
					accumulator = temporary;
					++instructionCounter;   // move to the next instruction in memory
				}
				break;
			case DIVIDE:  // Tested
				// Divide a word from a specific location in memory into the word in the accumulator
				// Leave the result in accumulator
				if(memory[operand] == 0) { // division by zero to occur
					printErrorMessage("*** DIVIDE command would cause a division by zero ***");
					operationCode = HALT;
				} else { // no division by zero
					accumulator /= memory[operand]; // division result would always be in the valid range [MIN_VALID_WORD, MAX_VALID_WORD]
					++instructionCounter; // move to the next instruction in memory
				}
				break;
			case MULTIPLY: // Tested
				// Multiply a word from a specific location in memory by the word in the accumulator
				// leave the result in accumulator
				temporary = accumulator * memory[operand];
				if((temporary < MIN_VALID_WORD ) || (temporary > MAX_VALID_WORD)) { // addition would cause accumulator overflow
					printErrorMessage("*** MULTPLY command would cause an overflow in accumulator ***");
					operationCode = HALT;
					// leave instructionCounter at its current value so that user can pinpoint his error
				} else { // no accumulator overflow
					accumulator = temporary;
					++instructionCounter;   // move to the next instruction in memory
				}
				break;
			case BRANCH:  // TESTED
				// branch to a specific location in memory
				instructionCounter = operand; // operand with values 00-99
				break;
			case BRANCHZERO: // TESTED
				// branch to a specific location in memory if the accumulator is zero
				if(accumulator == 0) {
					instructionCounter = operand; // operand with values 00-99
				} else {
					++instructionCounter; // move to the next instruction in memory 
				}
				break;
			case BRANCHNEG: // TESTED
				// branch to a specific location in memory if the accumulator is negative
				if(accumulator < 0) {
					instructionCounter = operand;
				} else { // accumulator is positive, jump to the next instruction in memory
					++instructionCounter; // move to the next instruction in memory
				}
				break;
			case HALT: // TESTED
				System.out.println("*** Simpletron execution terminated ***");
				break;
			default: // TESTED
				// unknown operationCode
				printErrorMessage("*** UNKNOWN operation code, instruction counter pointing at the UNKNOWN command ***");
				operationCode = HALT;
				break;
		}
	}
	
	private static void printErrorMessage(String reason) {
		System.out.printf("%s%n", reason);
		System.out.println("*** Simpletron execution abnormally terminated ***");	
	}
	
	private static int readValidSMLWord(int loadingCounter, Scanner input) {

		System.out.printf("%02d ? ", loadingCounter);
		int word = input.nextInt();
		boolean isValid = (((word >= MIN_VALID_WORD) && (word <= MAX_VALID_WORD)));
		while(!isValid) {
			System.out.printf("Invalid SML word. Word must be in [%d, %d] range%n", MIN_VALID_WORD, MAX_VALID_WORD);
			System.out.printf("%02d ? ", loadingCounter);
			word = input.nextInt();
			isValid = (((word >= MIN_VALID_WORD) && (word <= MAX_VALID_WORD)));
		}

		return word;
	}	
	
	private static void loadSMLProgram(Scanner input) {
		// initialize loadingCounter to zero and instruction to SENTINEL value
		int loadingCounter = 0;
		int instruction = SENTINEL;
		displayWelcomeMessage();
		do {
			// read a valid instruction or a sentinel value
			instruction = readValidInstruction(loadingCounter, input);
			// if it is a valid instruction 
			if(instruction != SENTINEL) {
				// write the instruction into memory[loadingCounter]
				memory[loadingCounter] = instruction;
				++loadingCounter;			
			}

		} while((instruction != SENTINEL) && (loadingCounter < MEMORY_SIZE ));
		
		System.out.println("*** Program loading completed  ***");
	}

	// method for displaying the welcome message to the user
	private static void displayWelcomeMessage() {
		System.out.printf ("\n%s\n%s\n%s\n%s\n%s\n%s\n\n", 
			"*** Welcome to Simpletron! ***",
			"*** Please enter your program one instruction    ***",
			"*** (or data word) at a time. I will display     ***",
			"*** the location number and a question mark (?). *** ",
			"*** You then type the word for that location.    ***",
			"*** Type -99999 to stop entering your program    ***");
	} 
	
	private static int readValidInstruction(int loadingCounter, Scanner input) {

		System.out.printf("%02d ? ", loadingCounter);
		int instruction = input.nextInt();
		boolean isValid = (((instruction >= MIN_VALID_WORD) && (instruction <= MAX_VALID_WORD)) || (instruction == SENTINEL));
		while(!isValid) {
			System.out.printf("Invalid SML instruction or data. Instruction must be in [%d, %d] range%n", MIN_VALID_WORD, MAX_VALID_WORD);
			System.out.printf("%02d ? ", loadingCounter);
			instruction = input.nextInt();
			isValid = (((instruction >= MIN_VALID_WORD) && (instruction <= MAX_VALID_WORD)) || (instruction == SENTINEL));
		}

		return instruction;
	}
	
	private static void dump() {
		final int COLUMN = 10;
		
		System.out.println();
		System.out.println("REGISTERS:");
		System.out.printf("accumulator          %+05d%n", accumulator);
		System.out.printf("instructionCounter:     %02d%n" , instructionCounter);
		System.out.printf("instructionRegister: +%04d%n", instructionRegister);
		System.out.printf("operationCode:          %02d%n", operationCode);
		System.out.printf("operand                 %02d%n%n", operand);
		
		System.out.println("MEMORY:");
		// print the header
		System.out.print("    ");
		for(int column = 0; column < COLUMN; ++column) {
			System.out.printf("%4d  ", column);
		}
		System.out.println();
		
		for(int i = 0; i < MEMORY_SIZE; ++i) {
			if(i % 10 == 0) {
				// print the row index (i.e. 0, 10, 20, ..., 90)
				System.out.printf("%2d ", i);
			}
			
			// print the i.th memory location
			System.out.printf("%+05d ", memory[i]);
			
			if(((i+1) % COLUMN) == 0) {
				System.out.println();
			}
		}
	}
}
// SOURCES:
// https://coderanch.com/t/40/676573/engineering/Building-computer-compiler
// https://github.com/carlosrevespt/Simpletron/blob/version3/SMLProcessor.java
// https://www.geeksforgeeks.org/bitwise-shift-operators-in-java/
// https://www.geeksforgeeks.org/1s-2s-complement-binary-number/

import java.util.Scanner;

public class SimpletronEnhanced {
	private static final int MEMORY_SIZE = 1000;
	private static final int MIN_VALID_WORD = -0xFFFF; // -65535
	private static final int MAX_VALID_WORD = 0xFFFF;  //  65535
	private static final int SENTINEL = -0x99999;
	
	public static final int BASE_16 = 16;
	
	// SML OPERATION CODES
	private static final int READ = 0x10;
	private static final int WRITE = 0x11;
	private static final int LOAD = 0x20;
	private static final int STORE = 0x21;
	private static final int ADD = 0x30;
	private static final int SUBTRACT = 0x31;
	private static final int DIVIDE = 0x32;
	private static final int MULTIPLY = 0x33;
	private static final int BRANCH = 0x40;
	private static final int BRANCHNEG = 0x41;
	private static final int BRANCHZERO = 0x42;
	private static final int HALT = 0x43;
	
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
		do {
			// read into instructionRegister memory[instructionCounter] value
			instructionRegister = memory[instructionCounter];
			operationCode = instructionRegister >> 8;
			operand = instructionRegister & 0xff;  // bound to be between 00-FF --> 0 - 255
			executeSMLInstruction(input);  		  // will modify the instructionCounter(, operationCode, accumulator)
		} while((operationCode != HALT) && (instructionCounter < MEMORY_SIZE));
	}
	
	// executes the instruction stored in the instructionRegister, operationCode and operand
	private static void executeSMLInstruction(Scanner input) {
		switch(operationCode) {
			case READ: // TESTED
				// read a valid word from keyboard into memory[operand]
				memory[operand] = readValidSMLWord(operand, input);
				++instructionCounter; // move to the next instruction in memory
				break;
			case WRITE: // TESTED
				// write a word from a specific location in memory to the screen
				int wordHex = memory[operand];
				System.out.printf("memory[0x%-5s]: 0x%-5s%n", 
						Integer.toString(operand, BASE_16).toUpperCase(), 
						Integer.toString(wordHex, BASE_16).toUpperCase());
				++instructionCounter;
				break;
			case LOAD: // TESTED
				// Load a word from a specific location in memory into the accumulator
				accumulator = memory[operand];
				++instructionCounter;  // move to the next instruction in memory
				break;
			case STORE: // TESTED
				// Store a word from the accumulator into a specific location in memory
				memory[operand] = accumulator;
				++instructionCounter;  // move to the next instruction in memory
				break;
			case ADD: // TESTED
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
			case SUBTRACT: // TESTED
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
			case DIVIDE: // TESTED
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
			case MULTIPLY: // TESTED
				// Multiply a word from a specific location in memory by the word in the accumulator
				// leave the result in accumulator
				temporary = accumulator * memory[operand];
				if((temporary < MIN_VALID_WORD ) || (temporary > MAX_VALID_WORD)) { // addition would cause accumulator overflow
					printErrorMessage("*** MULTIPLY command would cause an overflow in accumulator ***");
					operationCode = HALT;
					// leave instructionCounter at its current value so that user can pinpoint his error
				} else { // no accumulator overflow
					accumulator = temporary;
					++instructionCounter;   // move to the next instruction in memory
				}
				break;
			case BRANCH: // TESTED
				// branch to a specific location in memory
				instructionCounter = operand; // operand with values 00-99
				break;
			case BRANCHZERO: // TESTED
				// branch to a specific location in memory if the accumulator is zero
				if(accumulator == 0) {
					instructionCounter = operand; // operand with values 00-99
				} else { // accumulator is not zero
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
			case HALT:  // TESTED
				System.out.println("*** Simpletron execution terminated ***");
				break;
			default: // TESTED
				// unknown operationCode
				printErrorMessage("*** UNKNOWN operation code, instruction counter pointing at an UNKNOWN command ***");
				operationCode = HALT;
				break;
		}
	}
	
	private static void printErrorMessage(String reason) {
		System.out.printf("%s%n", reason);
		System.out.println("*** Simpletron execution abnormally terminated ***");	
	}
	
	private static int readValidSMLWord(int loadingCounter, Scanner input) {

		System.out.printf("0x%-5s ? ", Integer.toString(loadingCounter, BASE_16).toUpperCase());
		int word = input.nextInt(BASE_16);
		boolean isValid = (((word >= MIN_VALID_WORD) && (word <= MAX_VALID_WORD)));
		while(!isValid) {
			System.out.printf("Invalid SML instruction or data. Instruction must be in [0x%-5s, 0x%-5s] range. %n", 
					Integer.toString(MIN_VALID_WORD, BASE_16).toUpperCase(),
					Integer.toString(MAX_VALID_WORD, BASE_16).toUpperCase()
			);
			System.out.printf("0x%-5s ? ", Integer.toString(loadingCounter, BASE_16).toUpperCase());
			word = input.nextInt(BASE_16);
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
			"*** Please enter your program one instruction       ***",
			"*** (or data word) in HEX at a time. I will display ***",
			"*** the location number and a question mark (?).    *** ",
			"*** You then type the word for that location.       ***",
			"*** Type -99999 to stop entering your program       ***");
	} 
	
	private static int readValidInstruction(int loadingCounter, Scanner input) {

		System.out.printf("0x%-5s ? ", Integer.toString(loadingCounter, BASE_16).toUpperCase());
		int instruction = input.nextInt(BASE_16);
		boolean isValid = (((instruction >= MIN_VALID_WORD) && (instruction <= MAX_VALID_WORD)) || (instruction == SENTINEL));
		while(!isValid) {
			System.out.printf("Invalid SML instruction or data. Instruction must be in [0x%-5s, 0x%-5s] range. Or sentinel 0x%-5s. %n", 
					Integer.toString(MIN_VALID_WORD, BASE_16).toUpperCase(),
					Integer.toString(MAX_VALID_WORD, BASE_16).toUpperCase(), 
					Integer.toString(SENTINEL, BASE_16).toUpperCase()
			);
			System.out.printf("0x%-5s ? ", Integer.toString(loadingCounter, BASE_16).toUpperCase());
			instruction = input.nextInt(BASE_16);
			isValid = (((instruction >= MIN_VALID_WORD) && (instruction <= MAX_VALID_WORD)) || (instruction == SENTINEL));
		}

		return instruction;
	}
	
	private static void dump() {
		final int COLUMN = 16;

		System.out.println();
		System.out.println("REGISTERS:");
		System.out.printf("accumulator          0x%-5s%n",  Integer.toString(accumulator, BASE_16).toUpperCase());
		System.out.printf("instructionCounter:  0x%-5s%n" , Integer.toString(instructionCounter, BASE_16).toUpperCase());
		System.out.printf("instructionRegister: 0x%-5s%n",  Integer.toString(instructionRegister, BASE_16).toUpperCase());
		System.out.printf("operationCode:       0x%-5s%n",  Integer.toString(operationCode, BASE_16).toUpperCase());
		System.out.printf("operand              0x%-5s%n%n",Integer.toString(operand, BASE_16).toUpperCase());
		
		System.out.println("MEMORY:");
		// print the header
		System.out.print("        ");
		for(int column = 0; column < COLUMN; ++column) {
			System.out.printf("%-7s ", Integer.toString(column, BASE_16).toUpperCase());
		}
		System.out.println();

		for(int i = 0; i < MEMORY_SIZE; ++i) {
			if(i % BASE_16 == 0) {
				// print the row index (i.e. 0x0, 0x1, 0x2, ...)
				System.out.printf("0x%-5s ", Integer.toString(i >> 4, BASE_16).toUpperCase());
			}
			
			// print the i.th memory location
			System.out.printf("0x%-5s ", Integer.toString(memory[i], BASE_16).toUpperCase());
			
			if(((i+1) % COLUMN) == 0) {
				System.out.println();
			}
		}
	}
}
// SOURCES:
// [1] https://coderanch.com/t/40/676573/engineering/Building-computer-compiler
// [2] https://github.com/carlosrevespt/Simpletron/blob/version3/SMLProcessor.java
// [3] https://www.geeksforgeeks.org/bitwise-shift-operators-in-java/
// [4] https://www.geeksforgeeks.org/1s-2s-complement-binary-number/
// [5] https://www.geeksforgeeks.org/bitwise-shift-operators-in-java/
// [6] https://stackoverflow.com/questions/16040601/why-is-nextline-returning-an-empty-string

import java.util.Scanner;
import java.lang.StringBuilder;

public class SimpletronEnhanced {
	private static final int MEMORY_SIZE = 1000;
	private static final int MIN_VALID_WORD = -0xFFFF; // -65535
	private static final int MAX_VALID_WORD = 0xFFFF;  //  65535
	private static final int SENTINEL = -0x99999;
	
	public static final int BASE_16 = 16;
	
	// SML OPERATION CODES
	private static final int READ = 0x10;
	private static final int WRITE = 0x11;
	private static final int NEWLINE = 0x12;
	private static final int READ_STRING = 0x13;
	private static final int WRITE_STRING = 0x14;
	private static final int LOAD = 0x20;
	private static final int STORE = 0x21;
	private static final int ADD = 0x30;
	private static final int SUBTRACT = 0x31;
	private static final int DIVIDE = 0x32;
	private static final int MULTIPLY = 0x33;
	private static final int REMAINDER = 0x34;
	private static final int POWER = 0x35; 
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
	
	private static final int halfWord = 8;
	
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
			operationCode = instructionRegister >> 8; // bitwise signed right shift operator
			operand = instructionRegister & 0xff;  // bound to be between 00-FF --> 0 - 255
			executeSMLInstruction(input);  		  // will modify the instructionCounter(, operationCode, accumulator)
		} while((operationCode != HALT) && (instructionCounter < MEMORY_SIZE));
	}
	
	// 7.38 (g)
	// inputString = "Hakan"
	private static void storeString(String inputString) {
		int stringLength = inputString.length(); // 5
		if(stringLength == 0) {
			return; // do nothing
		}
		accumulator = stringLength << halfWord;  // 0x500 --> 1280
		accumulator += inputString.charAt(0); // 1352 --> 0x548 --> 'H' character ASCII equivalent is decimal 72 --> 0x48, first char 'H' is stored in to the memory
		memory[operand] = accumulator; // 0x548
		++operand; // move to the next word in memory
		
		// the first char in the inputString has been handled on line 76.
		// that's why charIndex starts from 1 in the for loop
		for(int charIndex = 1; charIndex < stringLength ; charIndex += 2) {
			accumulator = inputString.charAt(charIndex) << halfWord; // 'a' = 97 in decimal = 0x61
			if(charIndex + 1 < stringLength) {
				accumulator += inputString.charAt(charIndex + 1); // 'k' = 107 in decimal = 0x6B
			}
			memory[operand] = accumulator; // 0x616B
			++operand; // move to the next Simpletron word in memory
		}
		
	}
	
	private static String getString() {
		int stringLength = memory[operand] >> halfWord; // the first half word is the length of the string
		StringBuilder buffer = new StringBuilder(stringLength); // initial buffer capacity of stringLength
		
		for(int charIndex = 0; charIndex < stringLength; ++charIndex) {
			if(charIndex % 2 == 0) {
				buffer.append((char) (memory[operand] & 0xFF));
				++operand; // move to the next Simpletron word in memory
			} else {
				buffer.append((char) (memory[operand] >> halfWord));
			}
		}
		return buffer.toString();
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
			case NEWLINE:
				System.out.println();
				++instructionCounter;
				break;
			case READ_STRING:
				System.out.print("Enter a string: ");
				String inputString = input.nextLine();
				storeString(inputString);
				++instructionCounter;
				break;
			case WRITE_STRING:
				String string = getString();
				System.out.printf("%nString stored is: %s%n", string);
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
			case REMAINDER: // TESTED
				// Remainder a word from a specific location in memory by the word in the accumulator
				// Leave the result in accumulator
				if(memory[operand] == 0) { // remainder operation would throw ArithmeticException
					printErrorMessage("*** REMAINDER command would cause a division by zero  ***");
					operationCode = HALT;			
				} else {
					accumulator %= memory[operand];
					++instructionCounter;
				}
				break;
			case POWER:
				temporary = (int) Math.pow(accumulator, memory[operand]); // TODO: I am not sure about int down casting. is this a valid solution?
				if((temporary < MIN_VALID_WORD ) || (temporary > MAX_VALID_WORD)) { // addition would cause accumulator overflow
					printErrorMessage("*** POWER command would cause an overflow in accumulator ***");
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
		int word = Integer.parseInt(input.nextLine(), BASE_16);
		boolean isValid = (((word >= MIN_VALID_WORD) && (word <= MAX_VALID_WORD)));
		while(!isValid) {
			System.out.printf("Invalid SML instruction or data. Instruction must be in [0x%-5s, 0x%-5s] range. %n", 
					Integer.toString(MIN_VALID_WORD, BASE_16).toUpperCase(),
					Integer.toString(MAX_VALID_WORD, BASE_16).toUpperCase()
			);
			System.out.printf("0x%-5s ? ", Integer.toString(loadingCounter, BASE_16).toUpperCase());
			word = Integer.parseInt(input.nextLine(), BASE_16);
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
		int instruction = Integer.parseInt(input.nextLine(), BASE_16); // Refer to [6]
		boolean isValid = (((instruction >= MIN_VALID_WORD) && (instruction <= MAX_VALID_WORD)) || (instruction == SENTINEL));
		while(!isValid) {
			System.out.printf("Invalid SML instruction or data. Instruction must be in [0x%-5s, 0x%-5s] range. Or sentinel 0x%-5s. %n", 
					Integer.toString(MIN_VALID_WORD, BASE_16).toUpperCase(),
					Integer.toString(MAX_VALID_WORD, BASE_16).toUpperCase(), 
					Integer.toString(SENTINEL, BASE_16).toUpperCase()
			);
			System.out.printf("0x%-5s ? ", Integer.toString(loadingCounter, BASE_16).toUpperCase());
			instruction = Integer.parseInt(input.nextLine(), BASE_16); // Refer to [6]
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
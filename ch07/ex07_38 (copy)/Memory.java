public class Memory {
	private static int[] memory = new int[SimpletronEnhanced.MEMORY_SIZE];
	
	// instructionCounter contains a HEX value that gets converted to its DECIMAL equivalent
	// returns memory arrays instructionCounter
	public static int getMemoryLocation(int locationHex) {
		int locationDecimal = toDecimal(locationHex);
		return memory[locationDecimal];
	}
	
	public static void setMemoryLocation(int locationHex, int word) {
		int locationDecimal = toDecimal(locationHex);
		memory[locationDecimal] = word;
	}

	private static int toDecimal(int hex) {
		String locationHexString = Integer.toString(hex, SimpletronEnhanced.BASE_16);
		int decimal = Integer.parseInt(locationHexString, SimpletronEnhanced.BASE_16);
		return decimal;
	}
}
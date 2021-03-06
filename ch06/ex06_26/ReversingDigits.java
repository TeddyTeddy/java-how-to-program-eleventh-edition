public class ReversingDigits {
	public static void main(String[] args) {
		for(long number = 1; number <= 10000; ++number) {
			long reversedNumber = reverseDigits(number);
			System.out.printf("%d reversed is %d", number, reversedNumber);
			if(verify(number, reversedNumber)) {
				System.out.println();
			} else {
				System.out.print(" --> conversion incorrect\n");
			}
		}

	}
	
	// i.e number 7080 and reversedNumber is 807
	private static boolean verify(long number, long reversedNumber) {
		boolean isMatch = false;
		String reversedNumberString = Long.toString(reversedNumber); // (i.e. "807")
		
		// reverse the characters (i.e. "807" to "708")
		String reversedReversedNumberString = "";
		for(int position = reversedNumberString.length() - 1; position >= 0 ; --position) {
			reversedReversedNumberString += reversedNumberString.charAt(position);
		}
		// i.e. number is 10000 and reversedNumber is 1 --> needToMatch = 1
		// add zeros to needToMatch to see if it matches with the number
		long needToMatch = Long.parseLong(reversedReversedNumberString);
		while(needToMatch <= number) {
			if(needToMatch == number) {
				isMatch = true;
				break;
			}
			needToMatch *= 10;
		}
			
		return isMatch;
	}
	
	// i.e. number is 7631 --> 1367
	private static long reverseDigits(long number) {
		// get the highest number, which is powers of 10 and less
		// than number (i.e. highest10sPower = 1000)
		long highest10sPower = 1;
		while (highest10sPower <= number) {
			highest10sPower *= 10;
		}
		highest10sPower /= 10;
		
		// initialize tensPower to 1
		long tensPower = 1;
		// initialize revertedNumber to 0
		long revertedNumber = 0;
		while(highest10sPower >= 1) {
			// get the leftMostDigit = number / highest10sPower (i.e. 7)
			long leftMostDigit = number / highest10sPower;
			// get the number = number % highest10sPower (i.e. 631)
			number = number % highest10sPower;
			// set revertedNumber += leftMostDigit * tensPower (i.e. 7)
			revertedNumber += leftMostDigit * tensPower;
			// tensPower *= 10 (i.e. 10)
			tensPower *= 10;
			// highest10sPower /= 10; (i.e. 100)
			highest10sPower /= 10;
		}
		
		return revertedNumber;
	}
}
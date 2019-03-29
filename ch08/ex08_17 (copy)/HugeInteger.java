/* Exercise 8.17 solution: This class is capable of handling + and - HugeInteger values
 * In addition to add/subtract/multiply and divide methods, it implements remainder.
 */

// For verification you can use the following online calculators
// [1] https://web2.0calc.com/
// [2] http://www.webmath.com/divide.html
import java.util.Arrays;

// has package access
class AnalysisResult {
	final boolean isValid; // true if number is true, false otherwise
	final String  reason;  // contains the analysis result of the failure
	
	AnalysisResult(boolean isValid, String reason) {
		this.isValid = isValid;
		this.reason = reason;
	}
}

// utilized by divide() and getHeadA() methods
// divide() passes an object of HeadOfHugeInteger to getHeadA() method, which then utilizes index value to give the next head of a
class HeadOfHugeInteger {
	public static final int INVALID_INDEX = -1; 
	private int index;
	private String subDivisionsRemainder;
	
	HeadOfHugeInteger(int index) {
		this.index = index;
		this.subDivisionsRemainder = ""; // no sub division remainder at the beginning
	}
	void setIndex(int index) {
		this.index = index;
	}
	
	int getIndex() {
		return index;
	}
	
	void setSubDivisionRemainder(String subDivisionsRemainder) {
		this.subDivisionsRemainder = subDivisionsRemainder;
	}
	
	String getSubDivisionRemainder() {
		return this.subDivisionsRemainder;
	}
}

public class HugeInteger {
	// static variables
	private static final int MAX_DIGITS = 40;
	
	// instance variables
	int[] digits;
	boolean isMinusSign = false;
	
	// number can contain at most MAX_DIGITS (40) digits
	// supported formats: 
	// number = "1234"
	// number = "+1234"
	// number = "-1234"
    // number = ""  sets HugeInteger to +zero
	// number = "+" sets HugeInteger to +zero
	// number = "-" sets HugeInteger to -zero
	public HugeInteger(String number) {

		final AnalysisResult analysisResult = isValidNumber(number);
		if(!analysisResult.isValid) {
			throw new IllegalArgumentException("Incorrect (" + number + ") passed to constructor." + analysisResult.reason);
		}
		
		digits = new int[MAX_DIGITS];
		
		// number is a valid string, do parse it into digits
		parse(number);
		
		//System.out.printf("HugeInteger constructed with %s%n", this);
	}
	
	private HugeInteger(HugeInteger source) {
		digits = new int[MAX_DIGITS];
		System.arraycopy(source.digits, 0, digits, 0, MAX_DIGITS);
		isMinusSign = source.isMinusSign;
	}
	
	private static AnalysisResult isValidNumber(String number){
		boolean isValid = true;
		String reason = "";
		
		if(number.length() == 0) {// number is an empty string, it is valid
			isValid = true;
			return new AnalysisResult(isValid, reason);
		}
		
		// number contains something, check its content:
		// if it contains '-' or '+' sign, then expect at most MAX_DIGITS + 1 characters in number
		if((number.charAt(0) == '+') || (number.charAt(0) == '-')) {
			isValid = (number.length() <= (MAX_DIGITS + 1));
			if(!isValid) {
				reason = number + " contains more than " + String.format("%d", (MAX_DIGITS + 1)) + " characters";
				return new AnalysisResult(isValid, reason);
			}
		} else if((number.charAt(0) != '+') && (number.charAt(0) != '-')) { // if it does not contain '-' or '+' sign, then expect at most MAX_DIGITS characters in number
			isValid = (number.length() <= MAX_DIGITS );
			if(!isValid) {
				reason = number + " contains more than " + String.format("%d", MAX_DIGITS) + " characters";
				return new AnalysisResult(isValid, reason);
			}		
		}
		
		// if we reached this far, it means that number.length() is correct
		// now lets check the content of number, if it contains the valid digits but not invalid characters
		int i = 0;
		if ((number.charAt(0) == '-') || (number.charAt(0) == '+')) { // i.e. number = "-3" or "+3"
			i = 1; // start from the character at index 1
		}
		
		for(; i < number.length(); ++i) {
			if(!Character.isDigit(number.charAt(i))) {
				isValid = false;
				break;
			}
		}
		if(!isValid) {
			reason = number + " contains non-digit characters";
		}
		return new AnalysisResult(isValid, reason);
	}
	
	// expects a valid number as an argument
	// https://stackoverflow.com/questions/46343616/how-can-i-convert-a-char-to-int-in-java/46343671
	private void parse(String number) {
		if(number.length() == 0) { // number is an empty string, it is valid
			return; // no need to do any parsing
		}		

		int i = 0; // start from the character index 0
		int j = MAX_DIGITS - number.length();
		if(number.charAt(0) == '-') { // i.e. number = "-3"
			i = 1; // start from the character at index 1
			isMinusSign = true;
			++j; // taking into account the '-' sign
		} else if(number.charAt(0) == '+') { // i.e. number = "+3"
			i = 1; // start from the character at index 1
			isMinusSign = false;
			++j; // taking into account the '-' sign
		}
		
		for(; i < number.length(); ++i, ++j) {
			digits[j] = Character.getNumericValue(number.charAt(i));
		}
	}
	
	public static HugeInteger remainder(HugeInteger a, HugeInteger b) throws Exception {
		if(a.isMinusSign) {
			throw new Exception("remainder() exception: a cannot have minus sign");
		}
		
		if(b.isMinusSign) {
			throw new Exception("remainder() exception: b cannot have minus sign");
		}
		
		HugeInteger quotient = HugeInteger.divide(a, b);
		HugeInteger quotientTimesDivisor = HugeInteger.multiply(quotient, b);
		HugeInteger remainder = HugeInteger.subtract(a, quotientTimesDivisor);
		return remainder;
	}
	
	// a = -9
	// b = 3
	// note that a - b == a + (-b) ==> you can use the addition operator by flipping b's sign
	public static HugeInteger subtract(HugeInteger a, HugeInteger b) throws Exception {
		// do not modify b directly, as subtract method is not supposed to change the state of b at all
		HugeInteger negativeB = new HugeInteger(b);
		negativeB.isMinusSign = !b.isMinusSign;
		
		HugeInteger result;
		try {
			result = HugeInteger.add(a, negativeB); // do the subtraction operation
	
		} catch(Exception e) {
			throw new Exception("subtracting " + b + " from " + a + " causes overflow");
		}
		
		return result;
	}
	
	// a = 23
	// b = 45
	public static HugeInteger multiply(HugeInteger a, HugeInteger b) throws Exception {
		HugeInteger result = new HugeInteger(""); // start with zero as result
		// initialize
		int numberOfZerosToAppend = 0;
		int mostSignificantDigitsIndex = getMostSignificantDigitsIndex(b); // MAX_DIGITS - 2 = 38
		// for all digits in b (from right to left)
		for(int i = MAX_DIGITS - 1; i >= mostSignificantDigitsIndex; --i) {
			String digitString = String.format("%d", b.digits[i]); // i.e. 5 -> "5"
			String signString = (b.isMinusSign) ? "-" : "+"; // we need b's sign as well
			HugeInteger subB = new HugeInteger(signString + digitString); // HugeInteger("+5")
			HugeInteger subMultiplication = doMultiply(a, subB);  // this can throw an exception
			subMultiplication.appendZeros(numberOfZerosToAppend); // this can throw an exception, will modify subMultiplication object
			result = HugeInteger.add(subMultiplication, result);  // this can throw an exception
			++numberOfZerosToAppend;
		}
		return result;
	}
	
	// calculates a/b result; b is the divisor
	public static HugeInteger divide(HugeInteger a, HugeInteger b) throws Exception {
		
		final HugeInteger PLUS_ZERO =  new HugeInteger("+0");
		final HugeInteger MINUS_ZERO = new HugeInteger("-0");

		
		// check first if there is a division by zero
		if(HugeInteger.isEqualTo(b, PLUS_ZERO) || HugeInteger.isEqualTo(b, MINUS_ZERO)) {
			throw new Exception("Exception in divide(): division by zero. Divisor is " + b);
		}
		
		// no division by zero, cool. move on with the division
		// if abs(a) is less than abs(b), return 0 with a sign that is in-line with a/b
		if( HugeInteger.isLessThan(abs(a), abs(b))) {
			String signString = (a.isMinusSign ^ b.isMinusSign) ? "-" : "+"; // (a.isMinusSign ^ b.isMinusSign) is the result's isMinusSign
			String signedZero = signString + "0"; // +0 or -0
			return new HugeInteger(signedZero);
		}
		
		if( HugeInteger.isEqualTo(abs(a), abs(b)) ) { // i.e. (-3, 3), (3, -3), (-3, -3), (3, 3)
			String signString = (a.isMinusSign ^ b.isMinusSign) ? "-" : "+"; // (a.isMinusSign ^ b.isMinusSign) is the result's isMinusSign
			String signedOne = signString + "1"; // +1 or -1
			return new HugeInteger(signedOne);	
		}
		
		// if execution reaches here, then abs(a) is greater than abs(b) : -5/6 or -5/2 or 6/3 etc
		// lets say: a = 12345678912345678912345678912 and b = 9
		// initialize
		final HeadOfHugeInteger head = new HeadOfHugeInteger( HeadOfHugeInteger.INVALID_INDEX );
		String resultString = (a.isMinusSign ^ b.isMinusSign) ? "-" : "+";
		
		while( head.getIndex() < (MAX_DIGITS-1) ) {
			HugeInteger headA = getHeadA(a, b, head); // i.e. headA = "12"
			// System.out.printf("headA: %s%n", headA);
			
			HugeInteger subDivisionResult = HugeInteger.subDivide(headA, b); // "1"
			// System.out.printf("subDivisionResult: %s%n", subDivisionResult);
						
			String subDivisionResultString = subDivisionResult.getString();  // "1"
			// System.out.printf("subDivisionResultString: %s%n", subDivisionResultString);
			resultString += subDivisionResultString;
			
			HugeInteger subDivisionsRemainder = HugeInteger.subtract(headA, HugeInteger.multiply(abs(b), subDivisionResult));
			// System.out.printf("subDivisionsRemainder: %s%n", subDivisionsRemainder);
			
			head.setSubDivisionRemainder( subDivisionsRemainder.getString() );

			// System.out.printf("resultString: %s%n", resultString);			
		}

		return new HugeInteger(resultString);
	}
	
	// say this = "+0000000000000000000000000000000000000002" then this method returns "2"
	// it returns the meaningful digits represented as a string skipping the sign
	private String getString() {
		String result = "";
		int mostSignificantDigitIndex = getMostSignificantDigitsIndex(this); // 39
		for (int i = mostSignificantDigitIndex; i < MAX_DIGITS; ++i ) {
			result += String.format("%d", digits[i]);
		}
		return result;
	}
	
	// important: getHeadA can only be called if abs(a) > abs(b) => a has the same (or more) number of digits
	// lets say: a = 12345678912345678912345678912 and b = 9
	// getHeadA method returns 12, which is divisible by b 
	private static HugeInteger getHeadA(HugeInteger a, HugeInteger b, HeadOfHugeInteger head) throws Exception {
	
		int mostSignificantDigitA = getMostSignificantDigitsIndex(a); // 2
		int numberOfLeadingZerosA = mostSignificantDigitA; // 2
		int asDigits = MAX_DIGITS - numberOfLeadingZerosA; // a's digits : 38
	
		int numberOfLeadingZerosB = getMostSignificantDigitsIndex(b);	// 39
		int bsDigits = MAX_DIGITS - numberOfLeadingZerosB; // b's digits : 1
		if(asDigits < bsDigits) {
			throw new Exception("getHeadA() throws exception: a has fewer digits than b"); // this code should never execute
		}

		
		String headA = head.getSubDivisionRemainder(); // should be an empty string
		if( head.getIndex() == HeadOfHugeInteger.INVALID_INDEX ) {
			for(int i = mostSignificantDigitA; i < MAX_DIGITS ; ++i) {
				headA += String.format("%d", a.digits[i]); // "1" 
				HugeInteger temp = new HugeInteger(headA); // "1"
				if( HugeInteger.isGreaterThanOrEqualTo(temp, b) ) {
					head.setIndex(i); // store i for the next call to getHeadA()
					break; // headA is ready "12"
				}
			}	
		} else {
			int i = head.getIndex() + 1;
			headA += String.format("%d", a.digits[i]);
			head.setIndex(i); // store i for the next call to getHeadA()			
		}

		// headA is ready
		return new HugeInteger(headA); // "12"
	}
	
	/*private int getNumberOfDigits() {
		int numberOfLeadingZeros = getMostSignificantDigitsIndex(this);
		return MAX_DIGITS - numberOfLeadingZeros;
	}*/
	
	// say headA = "12" and b is "9"
	// subdivide returns headA / b = 12 / 9 = "1"
	private static HugeInteger subDivide(HugeInteger headA, HugeInteger b ) throws Exception {
		final HugeInteger PLUS_ONE = new HugeInteger("+1");
		HugeInteger result = new HugeInteger("+0");
		HugeInteger absB = abs(b);
		HugeInteger absheadA = abs(headA);
		HugeInteger multiplication = HugeInteger.multiply(  HugeInteger.add(result, PLUS_ONE) , absB);
		// while result+1 x abs(b) (multiplication) is less than or equal to abs(a)
		while( HugeInteger.isLessThanOrEqualTo(multiplication, absheadA) ) {
			result = HugeInteger.add(result, PLUS_ONE); // ++result
			multiplication = HugeInteger.multiply( HugeInteger.add(result, PLUS_ONE) , absB);
		}
		// at this point, we have the division result. 
		return result;	
	}
	
	// returns a new HugeInteger obj = abs(a)
	private static HugeInteger abs(HugeInteger a) {
		HugeInteger result = new HugeInteger(a);
		result.isMinusSign = false;
		return result;
	}
	
	// say this = HugeInteger("92") -> +0000000000000000000000000000000000000092
	// numberOfZerosToAppend = 1
	// then this = HugeInteger("920") after the method call
	private void appendZeros(int numberOfZerosToAppend) throws Exception {
		if(numberOfZerosToAppend == 0) {
			return; // do nothing
		}
		
		// we should have enough number of meaningless zeros in the front if we are to append (and shift!) zero's to the back
		int mostSignificantDigitsIndex = getMostSignificantDigitsIndex(this); // 38
		int numberOfLeadingZeros = mostSignificantDigitsIndex; // number of leading zeros equals to most significant digits index
		if(numberOfLeadingZeros < numberOfZerosToAppend) {
			throw new Exception("AppendZeros failed with overflow. HugeInteger value is " + this + " .numberOfZerosToAppend is " + numberOfZerosToAppend);
		}
		
		// looks like we can append zero's to the back and shift the value (i.e. 92 -> 920 )
		int[] temp = new int[MAX_DIGITS];
		// copy the shifted contents of digits padded with zeroes into the temp array
		//                       38									37 = 38 - 1											  2 = 40 - 38
		System.arraycopy(digits, mostSignificantDigitsIndex, temp, (mostSignificantDigitsIndex - numberOfZerosToAppend) , (MAX_DIGITS - mostSignificantDigitsIndex));
		
		// array copy successful. digits array can point at the temp array
		digits = temp;
	}
	
	// say b is  +0000000000000000000000000000000000000045
	// the zeros in front of 45 have no meaning
	// the most significant digit is 4
	// the most significant digit's index is MAX_DIGITS - 2 = 38
	private static int getMostSignificantDigitsIndex(HugeInteger b) {
		int i = 0;
		for(; i <= MAX_DIGITS - 1; ++i) {
			if( b.digits[i] != 0 || (i == MAX_DIGITS - 1)) { // if i reached MAX_DIGITS - 1, that means b is 0-9
				break;
			}
		}
		return i;
	}
	
	// a = -23
	// b = 5 
	// it is important to note that this method expects b as a 1 digit number
	public static HugeInteger doMultiply(HugeInteger a, HugeInteger b) throws Exception {
		HugeInteger result = new HugeInteger("");
		int tens = 0;
		int aSign = a.isMinusSign ? -1 : 1; // -1
		int bSign = b.isMinusSign ? -1 : 1; //  1
		for(int i = MAX_DIGITS - 1; i >= 0; --i) {
			int digitsSum = (aSign * a.digits[i]) * (bSign * b.digits[MAX_DIGITS - 1]) + tens; // i.e. -15 
			tens = digitsSum / 10; // i.e. -1
			digitsSum %= 10;	   // i.e. -5
			result.digits[i] = Math.abs(digitsSum); // i.e. 5
		}
		if(tens != 0) {
			throw new Exception("doMultiply() : multiplying " + a + " and " + b + " causes overflow");
		}

		// no overflow, good, now calculate the sign of the result
		result.isMinusSign = a.isMinusSign ^ b.isMinusSign; // false
		return result;
	}
	
	public static HugeInteger add(HugeInteger a, HugeInteger b) throws Exception {
		HugeInteger result = null;
		if(a.isMinusSign ^ b.isMinusSign) { // a's and b's signs are opposite to each other
			result = doSubtract(a,b); // throws an exception if overflow
		} else {
			result = doAdd(a,b);      // throws an exception if overflow
		}
		// no overflow, good, now calculate the sign of the result
		result.isMinusSign = getAdditionSign(a, b);
		return result;
	}
	
	// a = -9
	// b = -3
	private static HugeInteger doAdd(HugeInteger a, HugeInteger b) throws Exception {
		HugeInteger result = new HugeInteger("");
		int carry = 0;
		int aSign = a.isMinusSign ? -1 : 1; // -1
		int bSign = b.isMinusSign ? -1 : 1; // -1
		for(int i = MAX_DIGITS - 1; i >= 0; --i) {
			int digitsSum = (aSign * a.digits[i]) + (bSign * b.digits[i]) + carry; // i.e. -12
			carry = digitsSum / 10; // i.e. -1
			digitsSum %= 10;	   // i.e. -2
			result.digits[i] = Math.abs(digitsSum); // i.e. 2
		}
		if(carry != 0) {
			throw new Exception("summing " + a + " and " + b + " causes overflow");
		}
		return result;
	}
	
	// doSubtract assumes that a has a minus sign and b has a plus sign or vice versa
	// otherwise call doAdd()
	// a = 102, b = -9 or a = -102, b = 9
	private static HugeInteger doSubtract(HugeInteger a, HugeInteger b) throws Exception {
		
		// swap a & b if abs(a) is less than abs(b)
		if( HugeInteger.isLessThan(abs(a), abs(b)) ) {
			HugeInteger temp = b;
			b = a;
			a = temp;
		}
		HugeInteger result = new HugeInteger("");
		int borrow = 0;
		int aSign = a.isMinusSign ? -1 : 1; // -1
		int bSign = b.isMinusSign ? -1 : 1; // -1
		int ai = 0;
		boolean isBorrowedFromNextDigit = false;
		for(int i = MAX_DIGITS - 1; i >= 0; --i) {
			if(borrow == 10 || isBorrowedFromNextDigit ) { // if borrowed in the previous iteration, decrement from current a.digits[i]
				ai = (a.digits[i] == 0) ? 9 : (a.digits[i] - 1);
				isBorrowedFromNextDigit = (ai == 9); // we borrowed from i+1's step
			} else {
				ai = a.digits[i];
			}
			
			// if a.digits[i] is less than b.digits[i] then we need to borrow from a.digits[i+1]
			if(ai < b.digits[i]) {
				borrow = 10;
			} else {
				borrow = 0;
			}
			
			int digitsSubtract = (aSign * (ai + borrow) ) + (bSign * b.digits[i]) ; // i.e. -3
			result.digits[i] = Math.abs(digitsSubtract); // 3
		}
		if(borrow == 10) {
			throw new Exception("doSubtract() caused an overflow a:" + a + " b:" + b);
		}

		return result;
	}
	
	// returns the sign of the output when a & b are added
	public static boolean getAdditionSign(HugeInteger a, HugeInteger b) {
		if(isEqualTo(a, b)) {  // a is equal to b
			return a.isMinusSign; // sign of a & b are equal
		}
		
		// a is not equal to b, investigate further..
		
		// check if Math.abs(a) is greater than or equal to Math.abs(b)
		boolean isAbsAGreaterThanOrEqualToAbsB = absGreaterThanOrEqualTo(a, b);
		return isAbsAGreaterThanOrEqualToAbsB ? a.isMinusSign : b.isMinusSign;
	}
	
	// is a less than b? if so return true, return false otherwise
	public static boolean isLessThan(HugeInteger a, HugeInteger b) {
		if(isEqualTo(a, b) || isGreaterThan(a, b)) {
			return false;
		}
		return true;
	}
	
	public static boolean isLessThanOrEqualTo(HugeInteger a, HugeInteger b) {
		return (isEqualTo(a, b) || isLessThan(a, b));
	}
	
	// is a equal to b? return true, return false otherwise
	public static boolean isEqualTo(HugeInteger a, HugeInteger b) {
		return ((a.isMinusSign == b.isMinusSign) && Arrays.equals(a.digits, b.digits));
	}
	
	// is a equal to b? return true, return false otherwise
	public static boolean isNotEqualTo(HugeInteger a, HugeInteger b) {
		return !isEqualTo(a, b);
	}
	
	// is a greater than or equal to b? if so, return true. Return false otherwise
	public static boolean isGreaterThanOrEqualTo(HugeInteger a, HugeInteger b) {
		return (isEqualTo(a, b) || isGreaterThan(a, b));
	}
	
	// is a greater than b? if so, return true, return false otherwise
	public static boolean isGreaterThan(HugeInteger a, HugeInteger b) {

		// if a equals b, return false
		if(isEqualTo(a,b)) {
			return false;
		}
		
		// a is not equal to b, move on..
		
		if(a.isMinusSign && !b.isMinusSign) { 			// if a is negative and b is positive (i.e. a: -9, b: 3)
			return false; // a is not greater than b
		} else if(!a.isMinusSign && b.isMinusSign) {	// if b is negative and a is positive (i.e. a: 9, b: -3)
			return true; // a is greater than b
		}
		
		// at this point, both a & b are positive or negative
		// i.e. a = -9, b = -5  OR
		// i.e. a = 9, b = 5 OR
		// i.e. a = -5, b = -9 OR
		// i.e. a = 5, b = 9
		
		// check if Math.abs(a) is greater than Math.abs(b)
		boolean isAbsAGreaterThanOrEqualToAbsB = absGreaterThanOrEqualTo(a, b);
		return  isAbsAGreaterThanOrEqualToAbsB ? !a.isMinusSign : b.isMinusSign;
	}

	// returns true if Math.abs(a) is greater than or equal to Math.abs(b)
	// returns false otherwise
	private static boolean absGreaterThanOrEqualTo(HugeInteger a, HugeInteger b) {
		boolean isAbsAGreaterThanAbsB = true;
		for(int i = 0; i < MAX_DIGITS; ++i) { // start from most significant digit first
			if((a.digits[i] - b.digits[i]) < 0) {
				isAbsAGreaterThanAbsB = false; // a is less than b in as far as absolute values are concerned
				break;
			} else if((a.digits[i] - b.digits[i]) > 0) {
				isAbsAGreaterThanAbsB = true;
				break;
			}
		}
		return isAbsAGreaterThanAbsB;
	}
	
	@Override
	public String toString() {
		String stringValue = isMinusSign ? "-" : "+";
		for(int i : digits) {
			stringValue += i;
		}
		return stringValue;
	}
}
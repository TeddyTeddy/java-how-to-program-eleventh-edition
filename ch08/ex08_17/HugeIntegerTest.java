public class HugeIntegerTest {
	public static void main(String[] args) {

		testHugeIntegerConstructor(); 
		testAdd();
		testIsEqualTo();
		testIsGreaterThan();
		testIsLessThan();
		testSubtract(); 
		testIsNotEqualTo(); 
		testIsGreaterThanOrEqualTo(); 
		testIsLessThanOrEqualTo();
		testMultiply();
		testDivide();
		testRemainder();
	}
	
	private static void testRemainder() {

		// testing exceptions
		testRemainder("-1", "1");
		testRemainder("1", "-1");
		testRemainder("0", "0");
		testRemainder("100", "0");
		
		// testing two digit regular numbers
		testRemainder("0", "1");
		testRemainder("10", "1");
		testRemainder("10", "2");
		testRemainder("10", "3");
		testRemainder("10", "4");
		testRemainder("10", "5");
		testRemainder("10", "6");
		testRemainder("10", "7");
		testRemainder("10", "8");
		testRemainder("10", "9");
		testRemainder("10", "10");
		testRemainder("10", "11");
		testRemainder("10", "12");
		
		// testing three digit regular numbers
		testRemainder("100", "12");
		testRemainder("100", "13");
		testRemainder("100", "14");
		testRemainder("100", "15");
		testRemainder("100", "16");
		
		// testing four digit regular numbers
		testRemainder("1000", "12");
		testRemainder("1000", "13");
		testRemainder("1000", "14");
		testRemainder("1000", "15");
		testRemainder("1000", "16");

		
		// testing with very large numbers
		testRemainder("1234567891234567891234567891234567891234", "1234"); // remainder 900 is correct. Reference [2] returns 450 as remainder, which is incorrect. Reference [1] returns 900 as remainder, which is correct
		testRemainder("1234567891234567891234567891234567891234", "999999");
		testRemainder("1234567891234567891234567891234567891234", "9876543210");

	}
	
	private static void testRemainder(String number1, String number2) {
		System.out.println();
		try {
			HugeInteger a = new HugeInteger(number1);
			HugeInteger b = new HugeInteger(number2);
			HugeInteger remainder = HugeInteger.remainder(a, b);
			
			System.out.printf(" %s%n %s%n(modulus)---------------------------------%n %s", a, b, remainder);
			
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println();		
	}
	
	private static void testAdd() {
		// test add method
		// test cases where abs(a) == abs(b)
		testAdd("-3", "3");
		testAdd("3", "-3");
		testAdd("3", "3");
		
		// test cases where abs(a) > abs(b)
		testAdd("-9", "3");
		testAdd("-9", "-3");
		testAdd("9", "-3");
		testAdd("9", "-3");
		testAdd("9", "3");
		
		// test cases where abs(a) < abs(b)
		testAdd("-4", "-5");
		testAdd("-4", "5");
		testAdd("4", "5");
		testAdd("4", "-5");
		
		// more addition test cases with more than one digit numbers
		testAdd("444", "-555");
		testAdd("-444", "-555");
		testAdd("-444", "555");
		testAdd("444", "555");
		testAdd("555", "555");
		
		// overflow cases
		testAdd("9999999999999999999999999999999999999999", "7"); // would cause an overflow
		testAdd("6666666666666666666666666666666666666666", "7777777777777777777777777777777777777777"); // would cause an overflow
		testAdd("5555555555555555555555555555555555555555", "8888888888888888888888888888888888888888"); // would cause an overflow
		
		testAdd("12", "-9");
		testAdd("-12", "9");
		testAdd("102", "-9");
		testAdd("-102", "9");
		testAdd("-1002", "9");
		testAdd("1002", "-9");
		testAdd("100000000000000000000002", "-9");
		testAdd("-100000000000000000000002", "+9"); 
		testAdd("-1234567891234567891234567891234567891234", "1234"); 
		testAdd("+1234567891234567891234567891234567891234", "-1234"); 
		testAdd("+1234567891234567891234567891234567891234", "-9999");
		testAdd("+1234567891234567891234567891234567899999", "-9999");
		testAdd("+9999", "-9999"); 
		testAdd("+9999999999999999999999999999999999999999", "-9999");
		testAdd("+9999999999999999999999999999999999999999", "-9999999999999999999999999999999999999999");
	
		// testing add method complete		
	}
	
	private static void testAdd(String number1, String number2) {
		System.out.println();
		try {
			//System.out.printf("Attempting to call the constructor with %s%n", number1);
			HugeInteger a = new HugeInteger(number1);
			//System.out.printf("Attempting to call the constructor with %s%n", number2);
			HugeInteger b = new HugeInteger(number2);
			HugeInteger sum = HugeInteger.add(a, b);
			
			System.out.printf(" %s%n %s%n+----------------------------------------%n %s", a, b, sum);
			
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
	}
	
	public static void testDivide( ) {
		
		// test dividing by +0
		testDivide("1", "+0");
		testDivide("1", "-0");
		
		// test divisor b is larger than a
		testDivide("3", "5");
		testDivide("3", "-5");
		testDivide("-3", "5");
		testDivide("-3", "-5");
		
		// test dividend abs(a) is equal to abs(b)
		testDivide("3", "3");
		testDivide("3", "-3");
		testDivide("-3", "-3");
		testDivide("3", "-3");

		// test dividend abs(a) is greater than abs(b)
		testDivide("4", "3");
		testDivide("4", "-3");
		testDivide("-4", "-3");
		testDivide("4", "-3");

		// test dividend abs(a) is greater than abs(b)
		testDivide("4", "2");
		testDivide("4", "-2");
		testDivide("-4", "-2");
		testDivide("4", "-2");
		
		// test dividend abs(a) is equal to abs(b)
		testDivide("33", "33");
		testDivide("33", "-33");
		testDivide("-33", "-33");
		testDivide("33", "-33");
	
		// test dividend abs(a) is equal to abs(b)
		testDivide("333", "333");
		testDivide("333", "-333");
		testDivide("-333", "-333");
		testDivide("333", "-333");
		
		// test dividend abs(a) is larger than abs(b)
		testDivide("1000", "3");
		testDivide("1000", "-3");
		testDivide("-1000", "-3");
		testDivide("1000", "-3");
		
		// test dividend abs(a) is larger than abs(b)
		testDivide("1000", "4");
		testDivide("1000", "-4");
		testDivide("-1000", "-4");
		testDivide("1000", "-4");

		// test dividend abs(a) is larger than abs(b)
		testDivide("1234567891234567891234567891234", "9");
		testDivide("1234567891234567891234567891234", "-4");
		testDivide("-1234567891234567891234567891234", "-4");
		testDivide("-1234567891234567891234567891234", "-4");
		
		// test dividend abs(a) is larger than abs(b)
		testDivide("1234567891234567891234567891234", "9999");
		testDivide("1234567891234567891234567891234", "-4444");
		testDivide("-1234567891234567891234567891234", "-4444");
		testDivide("1234567891234567891234567891234", "-4444");
	}
	
	private static void testDivide(String number1, String number2) {
		System.out.println();
		try {
			// System.out.printf("Attempting to call the constructor with %s%n", number1);
			HugeInteger a = new HugeInteger(number1);
			// System.out.printf("Attempting to call the constructor with %s%n", number2);
			HugeInteger b = new HugeInteger(number2);
			HugeInteger result = HugeInteger.divide(a, b);
			
			System.out.printf(" %s%n %s%n(divide)----------------------------------------%n %s", a, b, result);
			
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
	}
	
	public static void testMultiply() {
		// testing with +0 and -0
		testMultiply("", "");
		testMultiply("+", "-"); // fails
		testMultiply("-", "+"); // fails
		testMultiply("-", "-");
		
		// test multiplication of +0 and +1 or -1
		testMultiply("", "-1");
		testMultiply("", "1");
		testMultiply("-1", "");
		testMultiply("1", "");
		
		// test multiplication of -0 and +1 or -1
		testMultiply("-", "-1");
		testMultiply("-", "1");
		testMultiply("-1", "-");
		testMultiply("1", "-");
		
		// test multiplication of +1 and -1
		testMultiply("1", "1");
		testMultiply("1", "-1");
		testMultiply("-1", "-1");
		testMultiply("-1", "1");

		// test multiplication of +1 with other numbers
		testMultiply("1", "100");
		testMultiply("1", "-100");
		// test multiplication of -1 with other numbers
		testMultiply("-1", "-100");
		testMultiply("-1", "100");
		
		// test with one digit integers
		testMultiply("3", "7");
		testMultiply("-3", "7");
		testMultiply("3", "-7");
		testMultiply("-3", "-7");
		
		// test with two digit integers
		testMultiply("11", "77");
		testMultiply("-23", "45");
		testMultiply("99", "-100");
		testMultiply("-99", "-100");

		// test with three digit integers
		testMultiply("111", "777");
		testMultiply("-234", "456");
		testMultiply("999", "-100");
		testMultiply("-999", "-100");

		// test with four digit integers
		testMultiply("1111", "7777");
		testMultiply("-2345", "4567");
		testMultiply("9999", "-1000");
		testMultiply("-9999", "-1000");

		// even larger multiplications
		testMultiply("999999999999999999999", "7777");
		testMultiply("999999999999999999999", "1000");
		//             20 digits			   20 trailing zeros
		testMultiply("12345678912345678912",  "100000000000000000000");
		testMultiply("-12345678912345678912", "100000000000000000000");
		testMultiply("12345678912345678912", "-100000000000000000000");
		testMultiply("-12345678912345678912","-100000000000000000000");
		testMultiply("-12345678912345678912345678912345678912", "+100");   // 38 digits
		testMultiply("-123456789123456789123456789123456789123", "+10");   // 39 digits

		// multiplication would cause an overflow
		testMultiply("12345678912345678912",  "1000000000000000000000");  // 20 digits, 21 trailing zeros
		testMultiply("-12345678912345678912", "1000000000000000000000");  // 20 digits, 21 trailing zeros
		testMultiply("-12345678912345678912", "-1000000000000000000000"); // 20 digits, 21 trailing zeros
		testMultiply("-12345678912345678912", "+1000000000000000000000"); // 20 digits, 21 trailing zeros
		testMultiply("-12345678912345678912345678912345678912", "+1000"); // 38 digits, 3 trailing zeros
		testMultiply("-123456789123456789123456789123456789123", "+100"); // 39 digits, 2 trailing zeros
		testMultiply("-1234567891234567891234567891234567891234", "+9"); // 40 digits, overflow



	}

	private static void testMultiply(String number1, String number2) {
		System.out.println();
		try {
			System.out.printf("Attempting to call the constructor with %s%n", number1);
			HugeInteger a = new HugeInteger(number1);
			System.out.printf("Attempting to call the constructor with %s%n", number2);
			HugeInteger b = new HugeInteger(number2);
			HugeInteger result = HugeInteger.multiply(a, b);
			
			System.out.printf(" %s%n %s%n(*)----------------------------------------%n %s", a, b, result);
			
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
	}
	
	private static void testIsLessThanOrEqualTo() {
		testIsLessThanOrEqualTo("", "");   // true
		testIsLessThanOrEqualTo("+", "+"); // true
		testIsLessThanOrEqualTo("-", "-"); // true
		testIsLessThanOrEqualTo("-", "+"); // true
		testIsLessThanOrEqualTo("-", "-"); // true
		
		testIsLessThanOrEqualTo("-9", "+5"); // true
		testIsLessThanOrEqualTo("9", "5");   // false
		testIsLessThanOrEqualTo("-5", "-9"); // false
		testIsLessThanOrEqualTo("5", "9");   // true
		testIsLessThanOrEqualTo("5", "-9");   // false
		testIsLessThanOrEqualTo("9", "-5");   // false
	
		testIsLessThanOrEqualTo("999", "-555");    // false
		testIsLessThanOrEqualTo("999", "+555");    // false
		testIsLessThanOrEqualTo("999", "-1000");   // false
		testIsLessThanOrEqualTo("999", "+1000");   // true
		
		testIsLessThanOrEqualTo("999", "999");     // true
		testIsLessThanOrEqualTo("-999", "-999");   // true
		
		testIsLessThanOrEqualTo("-555", "999");   // true
		testIsLessThanOrEqualTo("+555", "999");   // true
		testIsLessThanOrEqualTo("-1000", "999");  // true
		testIsLessThanOrEqualTo("1000", "999");   // false
	}
	
	private static void testIsLessThanOrEqualTo(String number1, String number2) {
		System.out.println();
		try {
			System.out.printf("Attempting to call the constructor with %s%n", number1);
			HugeInteger a = new HugeInteger(number1);
			System.out.printf("Attempting to call the constructor with %s%n", number2);
			HugeInteger b = new HugeInteger(number2);
			boolean isLessThanOrEqualTo = HugeInteger.isLessThanOrEqualTo(a, b);
			
			System.out.printf("%s %s less than or equal to %s ", a, (isLessThanOrEqualTo ? "is" : "is not"), b);
			
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();		
	}	
	
	private static void testIsGreaterThanOrEqualTo() {
		testIsGreaterThanOrEqualTo("", "");   // true
		testIsGreaterThanOrEqualTo("+", "+"); // true
		testIsGreaterThanOrEqualTo("-", "-"); // true
		testIsGreaterThanOrEqualTo("-", "+"); // false
		testIsGreaterThanOrEqualTo("-", "-"); // true
		
		testIsGreaterThanOrEqualTo("-9", "+5"); // false
		testIsGreaterThanOrEqualTo("9", "5");   // true
		testIsGreaterThanOrEqualTo("-5", "-9"); // true
		testIsGreaterThanOrEqualTo("5", "9");   // false
		testIsGreaterThanOrEqualTo("5", "-9");   // true
		testIsGreaterThanOrEqualTo("9", "-5");   // true
	
		testIsGreaterThanOrEqualTo("999", "-555");    // true
		testIsGreaterThanOrEqualTo("999", "+555");    // true
		testIsGreaterThanOrEqualTo("999", "-1000");   // true
		testIsGreaterThanOrEqualTo("999", "+1000");   // false
		
		testIsGreaterThanOrEqualTo("999", "999");     // true
		testIsGreaterThanOrEqualTo("-999", "-999");   // true
		
		testIsGreaterThanOrEqualTo("-555", "999");   // false
		testIsGreaterThanOrEqualTo("+555", "999");   // false
		testIsGreaterThanOrEqualTo("-1000", "999");  // false
		testIsGreaterThanOrEqualTo("1000", "999");   // true
	}
	
	private static void testIsGreaterThanOrEqualTo(String number1, String number2) {
		System.out.println();
		try {
			System.out.printf("Attempting to call the constructor with %s%n", number1);
			HugeInteger a = new HugeInteger(number1);
			System.out.printf("Attempting to call the constructor with %s%n", number2);
			HugeInteger b = new HugeInteger(number2);
			boolean isGreaterThanOrEqualTo = HugeInteger.isGreaterThanOrEqualTo(a, b);
			
			System.out.printf("%s %s greater than or equal to %s ", a, (isGreaterThanOrEqualTo ? "is" : "is not"), b);
			
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();		
	}	
	
	private static void testIsNotEqualTo() {
		// comparing zeros with + or - signs
		testIsNotEqualTo("", "");   // false
		testIsNotEqualTo("+", "+"); // false
		testIsNotEqualTo("+", "-"); // true
		testIsNotEqualTo("-", "+"); // true
		
		testIsNotEqualTo("3", "3"); // false
		testIsNotEqualTo("3", "-3"); // true
		testIsNotEqualTo("-3", "3"); // true
		testIsNotEqualTo("-3", "-3"); // false
		
		testIsNotEqualTo("1234", "5678"); // true		
	}
	
	private static void testIsNotEqualTo(String number1, String number2) {
		System.out.println();
		try {
			System.out.printf("Attempting to call the constructor with %s%n", number1);
			HugeInteger a = new HugeInteger(number1);
			System.out.printf("Attempting to call the constructor with %s%n", number2);
			HugeInteger b = new HugeInteger(number2);
			boolean isNotEqual = HugeInteger.isNotEqualTo(a, b);
			
			System.out.printf("%s %s equal to %s%n", a, (isNotEqual ? "is not" : "is"), b);
			
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
	}

	private static void testSubtract() {
		// test add method
		// test cases where abs(a) == abs(b)
		testSubtract("-3", "3");
		testSubtract("3", "-3");
		testSubtract("3", "3");
		
		// test cases where abs(a) > abs(b)
		testSubtract("-9", "3");
		testSubtract("-9", "-3");
		testSubtract("9", "-3");
		testSubtract("9", "-3");
		testSubtract("9", "3");

		// test cases where abs(a) < abs(b)
		testSubtract("-4", "-5");
		testSubtract("-4", "5");
		testSubtract("4", "5");
		testSubtract("4", "-5");
		
		// more addition test cases with more than one digit numbers
		testSubtract("444", "-555");
		testSubtract("-444", "-555");
		testSubtract("-444", "555");
		testSubtract("444", "555");
		testSubtract("555", "555");
		testSubtract("9999999999999999999999999999999999999999", "7");
		testSubtract("6666666666666666666666666666666666666666", "7777777777777777777777777777777777777777");
		testSubtract("5555555555555555555555555555555555555555", "8888888888888888888888888888888888888888");
		testSubtract("-5555555555555555555555555555555555555555", "-8888888888888888888888888888888888888888");
		
		// overflow cases
		testSubtract("-5555555555555555555555555555555555555555", "8888888888888888888888888888888888888888"); // would cause an overflow
		testSubtract("+5555555555555555555555555555555555555555", "-8888888888888888888888888888888888888888"); // would cause an overflow
		// testing subtract method complete
	}
	
	private static void testSubtract(String number1, String number2) {
		System.out.println();
		try {
			System.out.printf("Attempting to call the constructor with %s%n", number1);
			HugeInteger a = new HugeInteger(number1);
			System.out.printf("Attempting to call the constructor with %s%n", number2);
			HugeInteger b = new HugeInteger(number2);
			HugeInteger result = HugeInteger.subtract(a, b);
			
			System.out.printf(" %s%n %s%n(-)----------------------------------------%n %s", a, b, result);
			
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
	}
	
	private static void testIsLessThan() {
		testIsLessThan("", "");     // false
		testIsLessThan("+", "+");   // false		
		testIsLessThan("-", "-");   // false
		testIsLessThan("-", "+");   // true
		testIsLessThan("+", "-");   // false
		
		testIsLessThan("-9", "+5"); // true
		testIsLessThan("9", "5");   // false
		testIsLessThan("-5", "-9"); // false
		testIsLessThan("5", "9");   // true
		testIsLessThan("5", "-9");  // false
		testIsLessThan("9", "-5");  // false
	
		testIsLessThan("999", "-555");    // false
		testIsLessThan("999", "+555");    // false
		testIsLessThan("999", "-1000");   // false
		testIsLessThan("999", "+1000");   // true
		
		testIsLessThan("999", "999");     // false
		testIsLessThan("-999", "-999");   // false
		
		testIsLessThan("-555", "999");    // true
		testIsLessThan("+555", "999");    // true
		testIsLessThan("-1000", "999");   // true
		testIsLessThan("1000", "999");    // false
	}
	
	private static void testIsLessThan(String number1, String number2) {
		System.out.println();
		try {
			System.out.printf("Attempting to call the constructor with %s%n", number1);
			HugeInteger a = new HugeInteger(number1);
			System.out.printf("Attempting to call the constructor with %s%n", number2);
			HugeInteger b = new HugeInteger(number2);
			boolean isLessThan = HugeInteger.isLessThan(a, b);
			
			System.out.printf("%s %s less than %s ", a, (isLessThan ? "is" : "is not"), b);
			
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();		
	}
	
	
	private static void testIsGreaterThan() {
		testIsGreaterThan("", "");   // false
		testIsGreaterThan("+", "+"); // false
		testIsGreaterThan("-", "-"); // false
		testIsGreaterThan("-", "+"); // false
		testIsGreaterThan("-", "-"); // false
		
		testIsGreaterThan("-9", "+5"); // false
		testIsGreaterThan("9", "5");   // true
		testIsGreaterThan("-5", "-9"); // true
		testIsGreaterThan("5", "9");   // false
		testIsGreaterThan("5", "-9");   // true
		testIsGreaterThan("9", "-5");   // true
	
		testIsGreaterThan("999", "-555");    // true
		testIsGreaterThan("999", "+555");    // true
		testIsGreaterThan("999", "-1000");   // true
		testIsGreaterThan("999", "+1000");   // false
		
		testIsGreaterThan("999", "999");   	 // false
		testIsGreaterThan("-999", "-999");   // false
		
		testIsGreaterThan("-555", "999");   // false
		testIsGreaterThan("+555", "999");   // false
		testIsGreaterThan("-1000", "999");   // false
		testIsGreaterThan("1000", "999");   // true


	}
	
	private static void testIsGreaterThan(String number1, String number2) {
		System.out.println();
		try {
			System.out.printf("Attempting to call the constructor with %s%n", number1);
			HugeInteger a = new HugeInteger(number1);
			System.out.printf("Attempting to call the constructor with %s%n", number2);
			HugeInteger b = new HugeInteger(number2);
			boolean isGreaterThan = HugeInteger.isGreaterThan(a, b);
			
			System.out.printf("%s %s greater than %s ", a, (isGreaterThan ? "is" : "is not"), b);
			
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();		
	}
	
	private static void testHugeIntegerConstructor(){
		// test the constructor with invalid values
		testHugeIntegerConstructor("#2333"); // invalid character
		testHugeIntegerConstructor("2#333"); // invalid character
		testHugeIntegerConstructor("12345678912345678912345678912345678912345");  // 41 chars
		testHugeIntegerConstructor("+12345678912345678912345678912345678912345"); // 42 chars
		testHugeIntegerConstructor("-12345678912345678912345678912345678912345"); // 42 chars
	
		// test the constructor with valid values
		testHugeIntegerConstructor(""); 	 // empty string initializing to zero
		testHugeIntegerConstructor("+"); 	 // +zero
		testHugeIntegerConstructor("-"); 	 // -zero
		
		testHugeIntegerConstructor("2345");
		testHugeIntegerConstructor("23456");
		testHugeIntegerConstructor("234567");
		testHugeIntegerConstructor("-234567");
		testHugeIntegerConstructor("-8888888");
		testHugeIntegerConstructor("+1234567891234567891234567891234567891234"); // 41 chars
		testHugeIntegerConstructor("-1234567891234567891234567891234567891234"); // 41 chars
		testHugeIntegerConstructor("1234567891234567891234567891234567891234");  // 40 chars


		// constructor testing complete
	}
	private static void testHugeIntegerConstructor(String number) {
		try {
			System.out.printf("Attempting to call the constructor with %s%n", number);
			HugeInteger hi = new HugeInteger(number);
			
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
	}
		
	private static void testIsEqualTo() {
		// comparing zeros with + or - signs
		testIsEqualTo("", "");   // true
		testIsEqualTo("+", "+"); // true
		testIsEqualTo("+", "-"); // false
		testIsEqualTo("-", "+"); // false
		
		testIsEqualTo("3", "3"); // true
		testIsEqualTo("3", "-3"); // false
		testIsEqualTo("-3", "3"); // false
		testIsEqualTo("-3", "-3"); // false
		
		testIsEqualTo("1234", "5678"); // false		
	}
	
	private static void testIsEqualTo(String number1, String number2) {
		System.out.println();
		try {
			System.out.printf("Attempting to call the constructor with %s%n", number1);
			HugeInteger a = new HugeInteger(number1);
			System.out.printf("Attempting to call the constructor with %s%n", number2);
			HugeInteger b = new HugeInteger(number2);
			boolean isEqual = HugeInteger.isEqualTo(a, b);
			
			System.out.printf("%s %s equal to %s%n", a, (isEqual ? "is" : "is not"), b);
			
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
	}
}
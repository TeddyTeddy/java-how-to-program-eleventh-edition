import java.security.SecureRandom;

public class AssignRandom2 {
	
	// for function a, refer to page 231 in the book
	private static final int shiftingValue_a = 2;
	private static final int differenceBetweenValues_a = 2;
	private static final int scalingFactor_a = 5;

	// for function b, refer to page 231 in the book
	private static final int shiftingValue_b = 3;
	private static final int differenceBetweenValues_b = 2;
	private static final int scalingFactor_b = 5;
	
	// for function c, refer to page 231 in the book
	private static final int shiftingValue_c = 6;
	private static final int differenceBetweenValues_c = 4;
	private static final int scalingFactor_c = 5;
	
	private static final SecureRandom randomNumbers = new SecureRandom();
	
	public static void main(String[] args) {
		test_a();
		test_b();
		test_c();
	}
	
	private static void test_a() {
		boolean isFailed = false;
		for(int i = 1; i <= 1000; ++i) {
			int value = a();
			if( !((value == 2) || (value == 4) || (value == 6) || (value == 8) || (value == 10)) ) {
				System.out.printf("a() returned %d%n", value);
				isFailed = true;
				break;
			}
		}
		if(isFailed) {
			System.out.println("a() failed");
		} else {
			System.out.println("a() passed");		
		}
	}
	
	private static int a() {
		return shiftingValue_a 
				+ differenceBetweenValues_a * randomNumbers.nextInt(scalingFactor_a);
	}
	
	private static void test_b() {
		boolean isFailed = false;
		for(int i = 1; i <= 1000; ++i) {
			int value = b();
			if( !((value == 3) || (value == 5) || (value == 7) || (value == 9) || (value == 11)) ) {
				System.out.printf("b() returned %d%n", value);
				isFailed = true;
				break;
			}
		}
		if(isFailed) {
			System.out.println("b() failed");
		} else {
			System.out.println("b() passed");		
		}
	}
	
	private static int b() {
		return shiftingValue_b 
				+ differenceBetweenValues_b * randomNumbers.nextInt(scalingFactor_b);
	}
	
	private static void test_c() {
		boolean isFailed = false;
		for(int i = 1; i <= 1000; ++i) {
			int value = c();
			if( !((value == 6) || (value ==10) || (value == 14) || (value == 18) || (value == 22)) ) {
				System.out.printf("c() returned %d%n", value);
				isFailed = true;
				break;
			}
		}
		if(isFailed) {
			System.out.println("c() failed");
		} else {
			System.out.println("c() passed");		
		}
	}
	
	private static int c() {
		return shiftingValue_c 
				+ differenceBetweenValues_c * randomNumbers.nextInt(scalingFactor_c);
	}

}
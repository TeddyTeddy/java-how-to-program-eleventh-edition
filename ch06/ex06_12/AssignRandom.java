import java.security.SecureRandom;

public class AssignRandom {
	private static final int LOOP_COUNT = 1000;
	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final int HUNDRED = 100;
	private static final int TEN = 10;
	private static final int NINE = 9;
	private static final int THOUSAND = 1000;
	private static final int HUNDRED_THIRTEEN = 113;
	private static final int MINUS_ONE = -1;
	private static final int THREE = 3;
	private static final int MINUS_THREE = -3;
	private static final int ELEVEN = 11;
	private static final int FIFTEEN = 15;
	
	private static final SecureRandom randomNumbers = new SecureRandom();
	
	public static void main(String[] args) {
		test_a();
		test_b();
		test_c();
		test_d();
		test_e();
		test_f();
	}
	
	private static void test_a() {
		boolean isFailed = false;
		for(int i = 1; i <= LOOP_COUNT; ++i ) {
			int randomNumber = a();
			if((randomNumber != ONE) && (randomNumber != TWO)) {
				System.out.printf("Calling a() returned %d", randomNumber);
				isFailed = true;
				break;
			}
		}
		if(!isFailed) {
			System.out.println("a() passed the test");
		} else {
			System.out.println("a() failed the test");
		}
	}
	
	// 1 <= n <= 2; n integer
	private static int a() {
		return ONE + randomNumbers.nextInt(TWO);
	}
	
	private static void test_b() {
		boolean isFailed = false;
		for(int i = 1; i <= LOOP_COUNT; ++i ) {
			int randomNumber = b();
			if(!((randomNumber >= ONE) && (randomNumber <= HUNDRED))) {
				System.out.printf("Calling b() returned %d", randomNumber);
				isFailed = true;
				break;
			}
		}
		if(!isFailed) {
			System.out.println("b() passed the test");
		} else {
			System.out.println("b() failed the test");
		}
	}
	
	// 1 <= n <= 100; n integer
	private static int b() {
		return ONE + randomNumbers.nextInt(HUNDRED);
	}
	
	private static void test_c() {
		boolean isFailed = false;
		for(int i = 1; i <= LOOP_COUNT; ++i ) {
			int randomNumber = c();
			if(!((randomNumber >= 0) && (randomNumber <= NINE))) {
				System.out.printf("Calling c() returned %d", randomNumber);
				isFailed = true;
				break;
			}
		}
		if(!isFailed) {
			System.out.println("c() passed the test");
		} else {
			System.out.println("c() failed the test");
		}
	}
	
	// 0 <= n <= 9; n integer
	private static int c() {
		return randomNumbers.nextInt(TEN);
	}
	
	private static void test_d() {
		boolean isFailed = false;
		for(int i = 1; i <= LOOP_COUNT; ++i ) {
			int randomNumber = d();
			if(!((randomNumber >= THOUSAND) && (randomNumber <= THOUSAND + HUNDRED_THIRTEEN - 1 ))) {
				System.out.printf("Calling d() returned %d", randomNumber);
				isFailed = true;
				break;
			}
		}
		if(!isFailed) {
			System.out.println("d() passed the test");
		} else {
			System.out.println("d() failed the test");
		}
	}
	
	// 1000 <= n <= 1112; n integer
	private static int d() {
		return THOUSAND + randomNumbers.nextInt(HUNDRED_THIRTEEN);
	}
	
	private static void test_e() {
		boolean isFailed = false;
		for(int i = 1; i <= LOOP_COUNT; ++i ) {
			int randomNumber = e();
			if(!((randomNumber >= MINUS_ONE) && (randomNumber <= ONE ))) {
				System.out.printf("Calling e() returned %d", randomNumber);
				isFailed = true;
				break;
			}
		}
		if(!isFailed) {
			System.out.println("e() passed the test");
		} else {
			System.out.println("e() failed the test");
		}
	}
	
	// -1 <= n <= 1; n integer
	private static int e() {
		return MINUS_ONE + randomNumbers.nextInt(THREE);
	}
	
	private static void test_f() {
		boolean isFailed = false;
		for(int i = 1; i <= LOOP_COUNT; ++i ) {
			int randomNumber = f();
			if(!((randomNumber >= MINUS_THREE) && (randomNumber <= ELEVEN ))) {
				System.out.printf("Calling f() returned %d", randomNumber);
				isFailed = true;
				break;
			}
		}
		if(!isFailed) {
			System.out.println("f() passed the test");
		} else {
			System.out.println("f() failed the test");
		}
	}
	
	// -3 <= n <= 11; n integer
	private static int f() {
		return MINUS_THREE + randomNumbers.nextInt(FIFTEEN);
	}	
}
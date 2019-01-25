import java.util.Scanner;

public class Cryptography {
	private static int constant1 = 7;
	private static int constant2 = 10;
	private static int constant3 = 3;
	
	public static void main(String[] args) {

		test_power();
		test_getithDigit();
		test_all_four_digit_values_encrypted_decrypted();
		
		Scanner input = new Scanner(System.in);
		// set fourDigitValue with the value obtained from getFourDigitValue()
		int fourDigitValue = getFourDigitValue(input);
		// while fourDigitValue is different than -1 (sentinel)
		while(fourDigitValue != -1) {
			// Output the encrypted value from encrypt(fourDigitValue)
			int encriptedFourDigitValue = encrypt(fourDigitValue);
			System.out.printf("%d encrypted is %d%n", fourDigitValue, encriptedFourDigitValue);
			// Output decrypted value from decrypt (encript(fourDigitValue))
			int decriptedFourDigitValue = decrypt(encriptedFourDigitValue);
			System.out.printf("%d decrypted is %d%n", encriptedFourDigitValue, decriptedFourDigitValue);
			// set fourDigitValue with the value obtained from getFourDigitValue()
			fourDigitValue = getFourDigitValue(input);
		}
		input.close();
	}
	
	public static void test_all_four_digit_values_encrypted_decrypted() {
		System.out.println();
		// initialize fourDigitValue to 1000
		int fourDigitValue = 1000;
		// while fourDigitValue is less than or equal to 9999
		while(fourDigitValue <= 9999) {
			// get encryptedFourDigitValue
			int encryptedFourDigitValue = encrypt(fourDigitValue);
			// if isCorrect encryptedFourDigitValue based on fourDigitValue
			if( isCorrectlyEncrypted(encryptedFourDigitValue, fourDigitValue) ) {
				// output "fourDigitValue encrypted: encryptedFourDigitValue"
				System.out.printf("%d encrypted correctly to %d%n", fourDigitValue, encryptedFourDigitValue);
				// get decryptedFourDigitValue from encryptedFourDigitValue
				int decryptedFourDigitValue = decrypt(encryptedFourDigitValue);
				// if decryptedFourDigitValue is equal to fourDigitValue
				if(decryptedFourDigitValue == fourDigitValue) {
					// output "encryptedFourDigitValue decrypted successfully to decryptedFourDigitValue"
					System.out.printf("%d successfully decrypted to %d%n", encryptedFourDigitValue, decryptedFourDigitValue );
				} else {
					// output "encryptedFourDigitValue decrypted with error to decryptedFourDigitValue, it should have been fourDigitValue"
					System.out.printf("Error in decryption: %d decrypted with error to %d%n", encryptedFourDigitValue, decryptedFourDigitValue );
				
				}	
			}
			else {
				// output encryptedFourDigitValue is incorrect for fourDigitValue
				System.out.printf("Error in encryption: encrypted %d is incorrect for the value %d%n", encryptedFourDigitValue , fourDigitValue );		
			}
			// increment fourDigitValue by 1
			++fourDigitValue;
			System.out.println();
		}
	}
	
	private static boolean isCorrectlyEncrypted(int encryptedFourDigitValue, int fourDigitValue) {
		boolean isCorrect = false;
		
		// get all four digits from fourDigitValue
		int firstDigit = getithDigit(1, fourDigitValue);
		int secondDigit = getithDigit(2, fourDigitValue);
		int thirdDigit = getithDigit(3, fourDigitValue);
		int fourthDigit = getithDigit(4, fourDigitValue);
		
		// make a mapping of the four digits in encrypted form
		int e_firstDigit = _get_encrypted_value(firstDigit);
		int e_secondDigit = _get_encrypted_value(secondDigit);
		int e_thirdDigit = _get_encrypted_value(thirdDigit);
		int e_fourthDigit = _get_encrypted_value(fourthDigit);
		
		// initialize targetEncryptedValue = 0
		int targetEncryptedValue = 0;
		targetEncryptedValue += e_thirdDigit;
		targetEncryptedValue += (e_fourthDigit * 10);
		targetEncryptedValue += (e_firstDigit * 100);
		targetEncryptedValue += (e_secondDigit * 1000);
		
		// if targetEncryptedValue equals to encryptedFourDigitValue
		if(targetEncryptedValue == encryptedFourDigitValue) {
			isCorrect = true;	
		}

		return isCorrect;
	}
	
	private static int _get_encrypted_value(int digit) {
		int result = -1;
		if(digit == 0) {
			result = 7;
		} else if(digit == 1) {
			result = 8;
		} else if (digit == 2) {
			result = 9;
		} else if (digit == 3) {
			result = 0;
		} else if (digit == 4) {
			result = 1;
		} else if (digit == 5) {
			result = 2;
		} else if (digit == 6) {
			result = 3;
		} else if (digit == 7) {
			result = 4;
		} else if (digit == 8) {
			result = 5;
		} else if (digit == 9) {
			result = 6;
		}
		return result;
	}
	
	// returns -1 or a 4 digit positive integer
	public static int getFourDigitValue(Scanner input) {
		int result = -1;
		System.out.println();
		System.out.print("Enter a four digit positive number (or -1 to exit): ");
		result = input.nextInt();
		while( !(((result >= 1000) && (result <= 9999)) || (result == -1)) ) {
			System.out.print("Invalid input. Enter a four digit positive number (or -1 to exit): ");
			result = input.nextInt();			
		}
		return result;
	}
	
	public static int encrypt(int fourDigitValue) {
		// initialize
			// firstDigit from getiThDigit(1)
			// secondDigit from getithDigit(2)
			// thirdDigit from getithDigit(3)
			// fourthDigit from getithDigit(4)
			// en to zero 0;
		int firstDigit = getithDigit(1, fourDigitValue);
		int secondDigit = getithDigit(2, fourDigitValue);
		int thirdDigit = getithDigit(3, fourDigitValue);
		int fourthDigit = getithDigit(4, fourDigitValue);
		int en = 0; // en stands for encrypted number
		
		// calculate the encrypted digits
		int e_firstDigit = (firstDigit + constant1) % constant2;
		int e_secondDigit = (secondDigit + constant1) % constant2;
		int e_thirdDigit = (thirdDigit + constant1) % constant2;
		int e_fourthDigit = (fourthDigit + constant1) % constant2;
		
		// calculate the encrypted number (en)
		en += e_secondDigit * 1000;
		en += e_firstDigit * 100;
		en += e_fourthDigit * 10;
		en += e_thirdDigit;
		
		return en;
	}
	
	// (d + 7) % 10 = z then
	// d = (z + 3) % 10
	public static int decrypt(int encriptedFourDigitValue) {
		// initialize
		int firstDigit = getithDigit(1, encriptedFourDigitValue);
		int secondDigit = getithDigit(2, encriptedFourDigitValue);
		int thirdDigit = getithDigit(3, encriptedFourDigitValue);
		int fourthDigit = getithDigit(4, encriptedFourDigitValue);
		int dn = 0; // dn stands for decrypted number
		
		// calculate the decrypted digits
		int d_firstDigit = (firstDigit + constant3) % constant2;
		int d_secondDigit = (secondDigit + constant3) % constant2;
		int d_thirdDigit = (thirdDigit + constant3) % constant2;
		int d_fourthDigit = (fourthDigit + constant3) % constant2;
		
		// calculate the decrypted number (dn)
		dn += d_secondDigit * 1000;
		dn += d_firstDigit * 100;
		dn += d_fourthDigit * 10;
		dn += d_thirdDigit;
		
		return dn;
	}
	
	// TODO: check : i cannot be negative or zero
	private static int getithDigit(int i, int fourDigitValue) {
		// check if ith digit exists
			// form expectAtLeast with ith digit (i.e. i = 3 then expectAtLeast is 100)
			// if fourDigitValue is greater than or equal to expectAtLeast, then ith digit exists
				// attempt to retrive the ith digit
					// set temp to fourDigitValue % (power(10, i))
					// set ithDigit = temp / (power(10, (i-1))
		// else
			// return 0
		int expectAtLeast = power(10, (i-1));
		if(fourDigitValue >= expectAtLeast) {
			// attempt to retrive the ith digit
			// set temp to fourDigitValue % (power(10, i))
			int temp = fourDigitValue % (power(10, i));
			// set ithDigit = temp / (power(10, (i-1))
			int ithDigit = temp / power(10, (i-1));
			return ithDigit;
			
		} else {
			return 0; // indicating that a digit after most significant digit is meaningless 0 
		}
		
	}
		
	private static int power(int a, int b) {
		int counter = 1;
		int result = (b == 0) ? 1 : a;
		while(counter < b) {
			result *= a;
			++counter;
		}
		return result;
	}
	
	private static void test_getithDigit() {
		int fourDigitValue = 2321;
		
		int i = 1;
		System.out.printf("getithDigit(%d, %d) returns %d%n", i, fourDigitValue, getithDigit(i, fourDigitValue) );
		i = 2;
		System.out.printf("getithDigit(%d, %d) returns %d%n", i, fourDigitValue, getithDigit(i, fourDigitValue) );
		i = 3;
		System.out.printf("getithDigit(%d, %d) returns %d%n", i, fourDigitValue, getithDigit(i, fourDigitValue) );
		i = 4;
		System.out.printf("getithDigit(%d, %d) returns %d%n", i, fourDigitValue, getithDigit(i, fourDigitValue) );
		i = 5;
		System.out.printf("getithDigit(%d, %d) returns %d%n", i, fourDigitValue, getithDigit(i, fourDigitValue) );
		i = 6;
		System.out.printf("getithDigit(%d, %d) returns %d%n", i, fourDigitValue, getithDigit(i, fourDigitValue) );
		i = 7;
		System.out.printf("getithDigit(%d, %d) returns %d%n", i, fourDigitValue, getithDigit(i, fourDigitValue) );	
	}
	
	private static void test_power() {
		System.out.printf("power(10, 0) is %d%n", power(10, 0));
		System.out.printf("power(10, 1) is %d%n", power(10, 1));
		System.out.printf("power(10, 2) is %d%n", power(10, 2));
		System.out.printf("power(10, 3) is %d%n", power(10, 3));
		System.out.println();
		System.out.printf("power(2, 0) is %d%n", power(2, 0));
		System.out.printf("power(2, 1) is %d%n", power(2, 1));
		System.out.printf("power(2, 2) is %d%n", power(2, 2));
		System.out.printf("power(2, 3) is %d%n", power(2, 3));
		System.out.println();		
	}	
	
}
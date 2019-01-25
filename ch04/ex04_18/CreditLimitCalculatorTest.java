public class CreditLimitCalculatorTest {
	public static void main(String[] args) {
		
		Customer customer1 = new Customer("FI-3838-4834-3939-3838", 27000, 1500, 0, 5000);
		printCustomer(customer1);
		
		Customer customer2 = new Customer("FI-9999-1111-5555-7777", 400, 1500, 3000, 1000);
		printCustomer(customer2);		
	}
	
	private static void printCustomer(Customer customer) {
		System.out.println();
		if(customer.isCreditLimitExceeded()) {
			System.out.printf("Account %s has credit limit exceeded", customer.getAccountNumber());		
		} else {
			System.out.printf("Account %s is within the credit limit", customer.getAccountNumber());		
		}
	}
}
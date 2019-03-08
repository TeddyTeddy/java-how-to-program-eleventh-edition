public class SavingsAccountTest {
	public static void main(String[] main) {
		SavingsAccount account1 = new SavingsAccount(2000.0);
		SavingsAccount account2 = new SavingsAccount(3000.0);
		
		SavingsAccount.modifyInterestRate(4.0); // percent
		System.out.println("Annual interest Rate is %4");
		displayBalances("Account 1 monthly balances:", account1);
		displayBalances("Account 2 monthly balances:", account2);
		
		SavingsAccount.modifyInterestRate(5.0); // percent
		account1 = new SavingsAccount(2000.0);
		account2 = new SavingsAccount(3000.0);
		System.out.println("Annual interest Rate is %5");
		displayBalances("Account 1 monthly balances:", account1);
		displayBalances("Account 2 monthly balances:", account2);
	}
	
	private static void displayBalances(String desc, SavingsAccount account) {
		System.out.println(desc);
		for(int month = 1; month <= 12; ++month) {
			double monthlyBalance = account.calculateMonthlyInterest();
			System.out.printf("Month %d's balance is %.2f%n", month, monthlyBalance );
		}
		System.out.println();
	}
}
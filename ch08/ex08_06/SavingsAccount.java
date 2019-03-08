class SavingsAccount {
	// static variables
	private static double annualInterestRate;
	
	// instance variables
	private double savingsBalance;
	
	public static void modifyInterestRate(double rate) {
		annualInterestRate = rate;
	}
	
	SavingsAccount(double savingsBalance) {
		if(savingsBalance < 0.0) {
			throw new IllegalArgumentException("savingsBalance cannot be negative");
		}
		
		this.savingsBalance = savingsBalance;
	}
	
	// calculate the monthly interest by multiplying the savingsBalance by annualInterestRate
	// divided by 12. This interest should be added to savingsBalance
	public double calculateMonthlyInterest() {
		savingsBalance += (savingsBalance * annualInterestRate / 12);
		return savingsBalance;
	}
}
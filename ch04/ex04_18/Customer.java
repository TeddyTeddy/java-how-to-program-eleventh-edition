class Customer {
	private String accountNumber;
	private int balance; // balance at the beginning of this month
	private int totalChargedAmount; // total of all items charged by the customer this month
	private int totalCreditsAppliedAmount; // total of all credis applied to the customer's account this month
	private int creditLimit; // allowed credit limit
	
	public Customer(String accountNumber, int balance, int totalChargedAmount, int totalCreditsAppliedAmount,
			int creditLimit) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.totalChargedAmount = totalChargedAmount;
		this.totalCreditsAppliedAmount = totalCreditsAppliedAmount;
		this.creditLimit = creditLimit;
	}
	
	public int calculateNewBalance() {
		return balance + totalChargedAmount - totalCreditsAppliedAmount;
	}
	
	public boolean isCreditLimitExceeded() {
		return calculateNewBalance() < (-1 * creditLimit);
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
}
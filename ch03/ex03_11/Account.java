public class Account {
	private String name;
	private double balance;
	
	public Account(String name, double balance) {
		this.name = name;
		
		if(balance > 0.0) {
			this.balance = balance;
		}
	}
	
	public void withdraw(double withdrawAmount) {
		if(withdrawAmount <= balance) {
			balance -= withdrawAmount;
		} else {
			System.out.println("Withdrawal amunt exceeded account balance");
		}
	}
	
	public void deposit(double depositAmount) {
		if(depositAmount > 0.0) {
			balance += depositAmount;
		}
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
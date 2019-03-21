import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Currency;

public class Account {
	private String name;
	private BigDecimal balance;
	
	public Account(String name, double balance) {
		this.name = name;
		
		if(balance > 0.0) {
			this.balance = BigDecimal.valueOf(balance);
		} else {
			this.balance = BigDecimal.valueOf(0.0);
		}
	}
	
	public void deposit(double depositAmount) {
		if(depositAmount > 0.0) {
			BigDecimal augend = BigDecimal.valueOf(depositAmount);
			balance = balance.add(augend);
		}
	}

	// https://stackoverflow.com/questions/7828364/formatting-currencies-in-foreign-locales-in-java
	public String getBalance() {
		Currency eur = Currency.getInstance("EUR");
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.GERMAN);
		numberFormat.setCurrency(eur);
		return numberFormat.format(balance);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
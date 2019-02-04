import java.util.ArrayList;
import java.security.SecureRandom;

public class Slip {
	
	public static final int SALES_PEOPLE_COUNT = 4;
	public static final int PRODUCT_COUNT = 5;
	
	private int salesPersonNumber; // between 0-3
	private int productNumber;     // between 0-4
	private double valueSold;      // any positive value
	
	private static SecureRandom randomNumbers = new SecureRandom();
	
	// TODO: verify the parameters and throw an error if mismatch occurs
	public Slip(int salesPersonNumber, int productNumber, double valueSold) {
		this.salesPersonNumber = salesPersonNumber;
		this.productNumber = productNumber;
		this.valueSold = valueSold;
	}
	
	int getSalesPersonNumber() {
		return salesPersonNumber;
	}
	
	int getProductNumber() {
		return productNumber;
	}
	
	double getValueSold() {
		return valueSold;
	}
	
	public static ArrayList<Slip> getLastMonthsSales() {
		final int MONTH = 30;
		
		ArrayList<Slip> slips = new ArrayList<Slip>(100); // with initial capacity 100
		for(int day = 1; day <= MONTH; ++day) {
			for(int salesPerson = 0; salesPerson < SALES_PEOPLE_COUNT; ++salesPerson) {
				for(int product = 0; product < PRODUCT_COUNT; ++product) {
					if(randomNumbers.nextBoolean()) { // if true, create a Slip for that product
						double valueSold = randomNumbers.nextDouble() * 1000.00;
						Slip s = new Slip(salesPerson, product, valueSold);
						slips.add(s);
					}
				}
			}
		}
		
		return slips;
	}
}
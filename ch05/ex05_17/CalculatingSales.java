import java.util.Scanner;

public class CalculatingSales {
	public static void main(String[] args) {
		// initialize
		Scanner input = new Scanner(System.in);
		// set productNumber to 1
		int productNumber = 1; // a valid productNumber (i.e. 1 to 5)
		// totalRetailValue1 to zero
		double totalRetailValue1 = 0.0;
		// totalRetailValue2 to zero
		double totalRetailValue2 = 0.0;
		// totalRetailValue3 to zero
		double totalRetailValue3 = 0.0;
		// totalRetailValue4 to zero
		double totalRetailValue4 = 0.0;
		// totalRetailValue5 to zero
		double totalRetailValue5 = 0.0;
		

		// while productNumber is not sentinel value -1
		while( productNumber != -1) {
			// get productNumber
			productNumber = getProductNumber(input);
			if(productNumber != -1) {
				// prompt user to enter quantity sold
				System.out.print("Enter the quantity sold: ");
				// set quantitySold to inputed value
				double quantitySold = input.nextDouble();
				// set retailPrice = getPrice(productNumber)
				double retailPrice = getPrice(productNumber);
				// switch productNumber
					// case 1
						// totalRetailValue1 += ( quantitySold * retailPrice)
					// case 2
						// totalRetailValue2 += ( quantitySold * retailPrice)
					// ...
				switch(productNumber) {
					case 1:
						totalRetailValue1 += ( quantitySold * retailPrice);
						break;
					case 2:
						totalRetailValue2 += ( quantitySold * retailPrice);
						break;
					case 3:
						totalRetailValue3 += ( quantitySold * retailPrice);
						break;
					case 4:
						totalRetailValue4 += ( quantitySold * retailPrice);
						break;
					case 5:
						totalRetailValue5 += ( quantitySold * retailPrice);
						break;						
				}
			}
		}
		
		// display totalRetailValue1 to 5
		System.out.printf("Total retail value of product 1 sold: %.2f%n", totalRetailValue1);
		System.out.printf("Total retail value of product 2 sold: %.2f%n", totalRetailValue2);
		System.out.printf("Total retail value of product 3 sold: %.2f%n", totalRetailValue3);
		System.out.printf("Total retail value of product 4 sold: %.2f%n", totalRetailValue4);
		System.out.printf("Total retail value of product 5 sold: %.2f%n", totalRetailValue5);
		
		input.close();
	}
	
	private static int getProductNumber(Scanner input) {
		System.out.print("Enter product number between 1 and 5 (or -1 to exit): ");
		int result = input.nextInt();
		while(  (!((result >= 1 ) && (result <= 5))) && (result != -1) ) {
			System.out.print("Incrorrect product number. Enter product number between 1 and 5 (or -1 to exit): ");
			result = input.nextInt();
		}
		return result;
	}
	
	private static double getPrice(int productNumber) {
		double price = 0.0;
		
		switch(productNumber) {
		case 1:
			price = 2.98;
			break;
		case 2:
			price = 4.5;			
			break;
		case 3:
			price = 9.98;
			break;
		case 4:
			price = 4.49;
			break;
		case 5:
			price = 6.87;
			break;						
		}
		return price;
	}
}
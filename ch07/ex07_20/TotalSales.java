import java.util.ArrayList;
public class TotalSales {
	
	public static void main(String[] args) {
		double[][] sales = new double[Slip.PRODUCT_COUNT][Slip.SALES_PEOPLE_COUNT];
		populateSalesArray( sales, Slip.getLastMonthsSales() );
		displayResultsInTabularFormat(sales);
	}
	
	private static void displayResultsInTabularFormat(double[][] sales) {
		// print the header
		System.out.print("             ");
		for(int salesPerson = 0; salesPerson < Slip.SALES_PEOPLE_COUNT; ++salesPerson) {
			System.out.printf("SalesPerson %d     ", salesPerson + 1);
		}
		System.out.print("CROSS TOTAL");
		System.out.println();
		
		double crossTotalRow = 0.0;
		for(int product = 0; product < Slip.PRODUCT_COUNT; ++product) {
			System.out.printf("Product %d   ", product+1);
			for(int salesPerson = 0; salesPerson < Slip.SALES_PEOPLE_COUNT; ++salesPerson) {
				crossTotalRow += sales[product][salesPerson];
				System.out.printf(" %-17.2f", sales[product][salesPerson]);
			}
			System.out.printf(" %-16.2f", crossTotalRow);
			crossTotalRow = 0.0;
			System.out.println();
		}
		
		// print the footer
		System.out.print("CROSS TOTAL ");
		double crossTotalColumn = 0.0;
		for(int salesPerson = 0; salesPerson < Slip.SALES_PEOPLE_COUNT; ++salesPerson) {
			for(int product = 0; product < Slip.PRODUCT_COUNT; ++product) {
				crossTotalColumn += sales[product][salesPerson];
			}
			System.out.printf(" %-16.2f ", crossTotalColumn);
		}
	}
	
	private static void populateSalesArray(double[][] sales, ArrayList<Slip> monthlySales) {
		for(Slip slip : monthlySales) {
			int row = slip.getProductNumber(); // 0-4
			int column = slip.getSalesPersonNumber(); // 0-3
			try {
				sales[row][column] += slip.getValueSold();
			} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println(e);
				System.out.printf("sales[%d][%d] gave out of bounds exception", row, column);
			}
		}
	}
}
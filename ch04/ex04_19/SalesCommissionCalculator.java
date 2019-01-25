import java.util.Scanner;

public class SalesCommissionCalculator {
	public static void main(String[] args) {
		int itemCount = 1;
		double weeklySalary = 200.0;
		double totalSales = 0.0;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the salesperson's items sold for last week:");
		while(itemCount <= 4) {
			System.out.printf("Enter item %d's number of items sold: ", itemCount);
			int amount = input.nextInt();
			double itemValue = getItemValue(itemCount);
			totalSales += (itemValue * amount);
			++itemCount;
		}
		input.close();
		weeklySalary += (totalSales * 0.09);
		System.out.println();
		System.out.printf("Weekly Salary : %f%n", weeklySalary);
	}
	
	private static double getItemValue(int itemNo) {
		double result = 0.0;
		if(itemNo == 1) {
			result = 239.99;
		} else if(itemNo == 2) {
			result = 129.75;
		} else if(itemNo == 3) {
			result = 99.95;
		} else if(itemNo == 4) {
			result = 350.89;
		} else {
			// TODO: throw an error
		}
		return result;
	}
}
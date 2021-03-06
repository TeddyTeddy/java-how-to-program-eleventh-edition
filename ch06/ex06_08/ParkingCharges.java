import java.util.Scanner;

public class ParkingCharges {
	private static final double MINIMUM_FEE_PER_HOUR = 2.0;
	private static final double MAXIMUM_FEE_PER_HOUR = 2.5;
	private static final double MAX_CHARGE_24H = 10.0;
	
	public static void main(String[] args) {
	
		// initialize
		double runningTotal = 0.0;
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the hours parked (-1 to exit): ");
		double hoursParked = input.nextDouble();
		while(hoursParked > 0) {
			double charge = calculateCharges(hoursParked);
			System.out.printf("The charge for current customer is %f%n", charge);
			runningTotal += charge;
			System.out.print("Enter the hours parked (-1 to exit): ");
			hoursParked = input.nextDouble();			
		}
		System.out.printf("Total of yesterday's receipts: %f%n", runningTotal);
		input.close();
	}
	
	private static double calculateCharges(double hoursParked) {
		double charge = 0.0;
		if(hoursParked <= 3.0) {
			charge += hoursParked * MINIMUM_FEE_PER_HOUR;
		} else {
			charge += (3.0 * MINIMUM_FEE_PER_HOUR);
			hoursParked -= 3.0;
			charge += (hoursParked * MAXIMUM_FEE_PER_HOUR);
			charge = Math.min(MAX_CHARGE_24H, charge);
		}
		return charge;
	}
}
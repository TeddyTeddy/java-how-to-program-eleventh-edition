import java.util.Scanner;

public class CarPoolSavingsCalculator {
	public static void main(String[] args) {
		
		double miles = 0;
		double costPerGallonOfGasoline = 0;
		double averageMilesPerGallon = 0;
		double parkingFees = 0;
		double tolls = 0;
		double drivingCostPerDay = 0;
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter total miles driven per day: ");
		miles = input.nextDouble();

		System.out.print("Enter cost per gallon of gasoline: ");
		costPerGallonOfGasoline = input.nextDouble();
		
		System.out.print("Enter average miles per gallon: ");
		averageMilesPerGallon = input.nextDouble();
		
		System.out.print("Enter parking fees per day: ");
		parkingFees = input.nextDouble();
		
		System.out.print("Enter tolls per day: ");
		tolls = input.nextDouble();
		
		drivingCostPerDay = ((miles / averageMilesPerGallon) * costPerGallonOfGasoline) + parkingFees + tolls;
		System.out.printf("Total cost of driving per day: %f", drivingCostPerDay);
		
		input.close();
	}
}
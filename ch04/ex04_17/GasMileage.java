import java.util.Scanner;

// Problem: Calculating gas mileage for individual trip and the average gas mileage for
// all the trips

public class GasMileage {
	public static void main(String[] args) {
		// Init milesDrivenTrip to 0
		int milesDrivenTrip = 0;
		// Init gallonsUsedTrip to 0
		int gallonsUsedTrip = 0;
		// Init totalMiles to 0
		int totalMiles = 0;
		// Init totalGallons to 0
		int totalGallons = 0;
		
		// Instentiate Scanner
		Scanner input = new Scanner(System.in);
		
		// Prompt user to enter miles driven (or -1 to exit)
		System.out.print("Enter the miles driven for the trip (or -1 to exit): ");
		// Input the miles driven to milesDrivenTrip
		milesDrivenTrip = input.nextInt();
		
		// While miles driven is not -1
		while(milesDrivenTrip != -1) {
			// Prompt user to enter gallons used for the trip
			System.out.print("Enter the gallons used for the trip: ");
			// Input the gallons used for the trip to gallonsUsedTrip
			gallonsUsedTrip = input.nextInt();
			// Calculate average gas milage for the trip in question
			System.out.printf("Miles per gallon for the trip: %.2f%n", (float) milesDrivenTrip / gallonsUsedTrip);
			// Add milesDrivenTrip to totalMiles
			totalMiles += milesDrivenTrip;
			// Add gallonsUsedTrip to totalGallons
			totalGallons += gallonsUsedTrip;
			// Prompt user to enter miles driven (or -1 to exit)
			System.out.print("Enter the miles driven for the trip (or -1 to exit): ");
			// Input the miles driven to milesDrivenTrip
			milesDrivenTrip = input.nextInt();
		}
		System.out.println();
		input.close();
		
		// if totalGallons is not 0
		if(totalGallons > 0) {
			// Calculate the miles per gallon for whole trips = totalMiles / totalGallons
			System.out.printf("Miles per gallon for all trips: %.2f%n", (float) totalMiles / totalGallons);

		} else {
			System.out.print("no mileage is entered. Calculations cannot be made");
	
		}	
	}
}



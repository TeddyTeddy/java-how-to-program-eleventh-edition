import java.util.Scanner;

public class SalesCommissions {
	public static void main(String[] args) {
		
		int[] counters = new int[11]; // each element initialized to zero
		Scanner input = new Scanner(System.in);
		
		int sales = getSales(input);
		while(sales != -1) {
			// calculate the weekly salary
			int salary = 200 + (sales/100)*9;
			// calculate the index in the counters array
			int index = salary / 100;
			if(index > 10) {
				index = 10; // over $1000
			}
			// increment counters[index] by one
			++counters[index]; // TODO: try/catch
			// get new salary
			sales = getSales(input);
		}
		
		// output the counters arrays elements, counters[0] and counters[1] not used
		System.out.println("\nEarned salaries count in each of the following ranges:");
		for(int i = 2; i < counters.length; ++i) {
			if(i != 10) {
				System.out.printf("$%d-$%d:", i*100, ((i*100)+99));
			} else {
				System.out.print("$1000 and over: ");
			}
			System.out.printf("%d%n", counters[i]); 
		}
		input.close();
	}
	
	// returns either a positive salary or -1 to exit
	private static int getSales(Scanner input) {
		System.out.print("Enter weekly gross sale for the salesperson (or -1 to exit): ");
		return input.nextInt();		
	}
}
public class ex07_08e {
	public static void main(String[] args) {
		double[] w = { 1.0, 2.0, -0.1, -5.4, 4.5, 3.3, 7.7, 8.8, 9.9 };
		
		displayArray(w, "Array w");
		
		System.out.print("Smallest value in array w is:");
		double smallest = w[0];
		for(double value : w) {
			if(value < smallest) {
				smallest = value;
			}
		}
		System.out.printf("%.2f%n", smallest);
		
		System.out.print("Largest value in array w is:");
		double largest = w[0];
		for(double value : w) {
			if(value > largest) {
				largest = value;
			}
		}
		System.out.printf("%.2f%n", largest);		
	}
	
	private static void displayArray(double[] array, String description) {
		System.out.printf("%s%n", description);
		for(double value : array) {
			System.out.printf("%.2f ", value);
		}
		System.out.println();
	}
}
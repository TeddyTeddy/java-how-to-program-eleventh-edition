// https://www.programiz.com/java-programming/examples/round-number-decimal
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class RoundingNumbers2 {
	private static final double TEN = 10.0;
	private static final double HUNDRED = 100.0;
	private static final double THOUSAND = 1000.0;
	
	public static void main(String[] args) {

		System.out.printf("PI = %.10f%n", Math.PI);
		System.out.printf("PI = %d%n", roundToInteger(Math.PI));
		System.out.printf("PI = %f%n", roundToTenths(Math.PI));
		System.out.printf("PI = %f%n", roundToHundreds(Math.PI));
		System.out.printf("PI = %f%n", roundToThousands(Math.PI));
		
		System.out.println();
		
		System.out.printf("PI = %.10f%n", Math.PI);
		System.out.printf("PI = %s%n", roundToInteger2(Math.PI));
		System.out.printf("PI = %s%n", roundToTenths2(Math.PI));
		System.out.printf("PI = %s%n", roundToHundreds2(Math.PI));
		System.out.printf("PI = %s%n", roundToThousands2(Math.PI));
		
		System.out.println();
		
		System.out.printf("E = %.10f%n", Math.E);
		System.out.printf("E = %d%n", roundToInteger(Math.E));
		System.out.printf("E = %f%n", roundToTenths(Math.E));
		System.out.printf("E = %f%n", roundToHundreds(Math.E));
		System.out.printf("E = %f%n", roundToThousands(Math.E));
		
		System.out.println();
		
		System.out.printf("E = %.10f%n", Math.E);
		System.out.printf("E = %s%n", roundToInteger2(Math.E));
		System.out.printf("E = %s%n", roundToTenths2(Math.E));
		System.out.printf("E = %s%n", roundToHundreds2(Math.E));
		System.out.printf("E = %s%n", roundToThousands2(Math.E));
		
	}
	
	private static int roundToInteger(double number) {
		return (int) Math.floor(number + 0.5);
	}
	
	private static double roundToTenths(double number) {
		return Math.floor( number * TEN + 0.5) / TEN;
	}
	
	private static double roundToHundreds(double number) {
		return Math.floor(number * HUNDRED + 0.5) / HUNDRED;
	}
	
	private static double roundToThousands(double number) {
		return Math.floor(number * THOUSAND + 0.5) / THOUSAND;
	}
	
	
	private static String roundToInteger2(double number) {
        DecimalFormat df = new DecimalFormat("#");
        df.setRoundingMode(RoundingMode.CEILING);
        return df.format(number);
	}
	
	private static String roundToTenths2(double number) {
        DecimalFormat df = new DecimalFormat("#.#");
        df.setRoundingMode(RoundingMode.HALF_DOWN);
        return df.format(number);
	}
	
	private static String roundToHundreds2(double number) {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_DOWN);
        return df.format(number);
	}
	
	private static String roundToThousands2(double number) {
        DecimalFormat df = new DecimalFormat("#.###");
        df.setRoundingMode(RoundingMode.HALF_DOWN);
        return df.format(number);
	}

}
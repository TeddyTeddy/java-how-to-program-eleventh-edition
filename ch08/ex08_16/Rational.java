public class Rational {

	// instance variables
	private int numerator;
	private int denominator;
	
	// numerator can be negative, zero or positive
	// denominator cannot be negative or zero
	public Rational(int numerator, int denominator) {
		if(denominator <= 0) {
			throw new IllegalArgumentException("denominator " + denominator + " cannot be less than or equal to zero");
		}
		this.numerator = numerator;
		this.denominator = denominator;
		reduce(this);
		System.out.printf("Rational constructor successfully returns %s%n", this);
	}
	
	public static Rational add(Rational r1, Rational r2) {
		int sumNumerator = ( (r1.numerator * r2.denominator) + (r2.numerator * r1.denominator) );
		int sumDenominator = (r1.denominator * r2.denominator);
		Rational sum = new Rational(sumNumerator, sumDenominator);
		System.out.printf(" %s + %s = %s%n", r1, r2, sum);
		return sum;
	}
	
	public static Rational subtract(Rational r1, Rational r2) {
		int subtractionNumerator = ( (r1.numerator * r2.denominator) - (r2.numerator * r1.denominator) );
		int subtractionDenominator = (r1.denominator * r2.denominator);
		Rational subtractionResult = new Rational(subtractionNumerator, subtractionDenominator);
		System.out.printf("%s - %s = %s%n", r1, r2, subtractionResult);
		return subtractionResult;
	}
	
	public static Rational multiply(Rational r1, Rational r2) {
		int multiplicationNumerator =   (r1.numerator * r2.numerator);
		int multiplicationDenominator = (r1.denominator * r2.denominator);
		Rational multiplicationResult = new Rational(multiplicationNumerator, multiplicationDenominator);
		System.out.printf("%s multiplied by %s = %s%n", r1, r2, multiplicationResult);
		return multiplicationResult;
	}	
	
	public static Rational divide(Rational r1, Rational r2) {
		int divisionNumerator = (r1.numerator * r2.denominator);
		int divisionDenominator = (r1.denominator * r2.numerator);
		Rational divisionResult = new Rational(divisionNumerator, divisionDenominator);
		System.out.printf("%s divided by %s = %s%n", r1, r2, divisionResult);
		return divisionResult;
	}
	
	// this function assumes that denominator is greater than or equal to 1 (checked at constructor)
	private static void reduce(Rational r) {
		
		// initialize
		int absNumerator = Math.abs(r.numerator); // because numerator can be negative
		int minimum = Math.min(absNumerator, r.denominator);
		int commonFactor = 1;
		int i = commonFactor;
		
		// look for a largest commonFactor dividing numerator and denominator with zero remainder
		while (i <= minimum) {
			// if i divides both numerator & denominator with no remainder
			if( ((r.numerator % i) == 0) && ((r.denominator % i) == 0) ) {
				commonFactor = i;
			}
			++i;
		}
		
		// reduce
		r.numerator   /= commonFactor;
		r.denominator /= commonFactor;
	}
	
	public String floatingPoint(int digitsOfPrecision) {
		String formattingString = "%s equals to %." + digitsOfPrecision + "f";
		return String.format(formattingString, this, (double) numerator / denominator);
	}
	
	public String toString() {
		return String.format("%d/%d", numerator, denominator);
	}
}
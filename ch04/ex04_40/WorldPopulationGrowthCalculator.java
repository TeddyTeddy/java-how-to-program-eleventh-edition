// verified using
// http://www.metamorphosisalpha.com/ias/population.php
public class WorldPopulationGrowthCalculator {
	public static void main(String[] args) {
		
		long initialPopulation = 7_700_000_000L; // population as of 2019
		double growthRate = 1.09;
		
		System.out.printf("Current world population: %d%n", initialPopulation);
		System.out.printf("Current growth rate: %f%n " , growthRate);
		System.out.println();
		
		// initialize year to 1 (i.e.next year)
		int year = 1;
		// print the table header
		System.out.print("Year\tWorld Population\tIncrease in that year\n");
		// while year is less than or equal to 75
		while(year <= 75) {

			// set nextPopulation to the value returned by getPopulation(year, init population, growthRate)
			long nextPopulation = getPopulation(year, initialPopulation, growthRate);
					
			// set increase to the value returned by getIncrease( population, year )
			long previousYearsPopulation = getPopulation(year-1, initialPopulation, growthRate);
			long increaseInPopulationInThisYear = nextPopulation - previousYearsPopulation;
			
			String mark = "";
			if(nextPopulation >= (2*initialPopulation)) {
				mark = "*";
			}
			
			System.out.printf("%d%s\t%d\t\t%d%n", year, mark, nextPopulation, increaseInPopulationInThisYear );
			// print year to column one
			// print population to column two, 
				// if population is greater than or equal to two times of the initial population, then put an asterisk
			// print increase to column three
			++year;
		}
	}
	
	private static long getPopulation(int year, long initialPopulation, double growthRate) {
		long newPopulation = initialPopulation;
		
		while(year > 0) {
			newPopulation *= growthRate;
			--year;
		}
		
		return newPopulation;
		
	}
}
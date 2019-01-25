public class WorldPopulationGrowthCalculator {
	public static void main(String[] args) {
		
		long population = 7_700_000_000L;
		double growthRate = 1.09;
		double yearlyIncrease = population * growthRate / 100;
		
		System.out.println("Current world population: " + population);
		System.out.println("Current growth rate: " + growthRate);
		
		System.out.println("World population in 1 year: " + (population + yearlyIncrease));
		System.out.println("World population in 2 years: " + (population + yearlyIncrease * 2));
		System.out.println("World population in 3 years: " + (population + yearlyIncrease * 3));
		System.out.println("World population in 4 years: " + (population + yearlyIncrease * 4));
		System.out.println("World population in 5 years: " + (population + yearlyIncrease * 5));
		
	}
}
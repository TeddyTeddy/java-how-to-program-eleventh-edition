import java.util.Random;


public class DiceRolling {
	public static void main(String[] args) {
		Random generator = new Random();
		int[] frequency = new int[13];
		long i = 1;
		while(i <= 36_000_000L) {
			int dice1 = 1 + generator.nextInt(6);
			int dice2 = 1 + generator.nextInt(6);
			int sum = dice1 + dice2;
			++frequency[sum]; // TODO: try/catch
			++i;
		}
		
		// output the number of times each possible sum appears
		System.out.println("Frequencies of the sum of two dices: ");
		for(int sum = 2; sum < frequency.length; ++sum) {
			System.out.printf("Sum %d frequency is %d%n", sum, frequency[sum]);
		}
	}
}
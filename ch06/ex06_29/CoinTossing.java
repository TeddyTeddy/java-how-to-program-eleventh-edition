import java.security.SecureRandom;

public class CoinTossing {
	private enum Coin { HEADS, TAILS };
	private static final SecureRandom randomNumbers = new SecureRandom();
	
	public static void main(String[] args) {
		int headsCount = 0;
		int tailsCount = 0;
		for(int i = 0; i <= 10000; ++i) {
			Coin coin = flip();
			if(coin == Coin.HEADS) {
				++headsCount;
			} else {
				++tailsCount;
			}
		}
		System.out.printf("heads count %d, tails count %d", headsCount, tailsCount);
	}
	
	private static Coin flip() {
		int coin = 1 + randomNumbers.nextInt(2);
		Coin result;
		if(coin == 1) { // HEADS
			result = Coin.HEADS;
		} else {
			result = Coin.TAILS;
		}
		return result;
	}
}
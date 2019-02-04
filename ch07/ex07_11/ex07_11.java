public class ex07_11 {
	public static void main(String[] args) {
		// (a)
		int[] counts = new int[10];
		for(int i = 0; i < counts.length; ++i) {
			counts[i] = 0;
		}
		
		// (b)
		int[] bonus = new int[15];
		for(int i = 0; i < bonus.length; ++i) {
			++bonus[i];
		}
		
		// (c)
		int[] bestScores = new int[5];
		for(int i = 0; i < bestScores.length; ++i) {
			System.out.printf("%d%n", bestScores[i]);
		}
	}
}
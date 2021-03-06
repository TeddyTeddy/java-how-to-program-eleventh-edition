public class Multiples {
	public static void main(String[] args) {
		
		for(int b = 10; b >= 1; --b) {
			for(int a = 1; a <= 10; ++a) {
				if(isMultiple(a,b)) {
					System.out.printf("%d is multiple of %d%n", b, a);
				}
			}
		}
	}
	
	private static boolean isMultiple(int a, int b) {
		boolean result = false;
		if(b >= a) {
			result = ((b % a) == 0);
		}
		return result;
	}
}
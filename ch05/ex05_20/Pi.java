public class Pi {
	
	private static final int PI = 314159;
	
	public static void main(String[] args) {
		long term = 1;
		long i = 1;
		double pi = 0.0;
		String mark;
		
		System.out.print("Term\tPi\n");
		while(term <= 200000L) {
			if((term % 2) == 1) {
				pi += ( (double) 4 / i);
			} else {
				pi -= ( (double) 4 / i);
			}
			
			mark = getMark(pi);
			
			System.out.printf("%d%s\t%.10f\n", term, mark, pi);
			i += 2;
			++term;
		}
	}
	
	private static String getMark(double pi) {
		int temp = (int) (pi * 100000);
		if(temp == PI) {
			return "*";
		}
		return "";
	}
}
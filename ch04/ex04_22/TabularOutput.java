public class TabularOutput {
	public static void main(String[] args) {
		System.out.println("N\t10*N\t100*N\t1000*N");
		System.out.println();
		printRow(1);
		printRow(2);
		printRow(3);
		printRow(4);
		printRow(5);
	}
	
	private static void printRow(int n) {
		System.out.printf("%d\t%d\t%d\t%d%n", n, n*10, n*100, n*1000);		
	}
}
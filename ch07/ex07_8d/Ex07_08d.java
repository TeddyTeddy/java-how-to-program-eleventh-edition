// https://www.tutorialspoint.com/java/lang/system_arraycopy.htm
public class Ex07_08d {
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9,10,11};
		int[] b = new int[14];
		b[0] = -1;
		b[1] = -1;
		b[2] = -1;
		displayArray(a, "Array a");
		displayArray(b, "Array b");
		
		System.out.print("\n\nCopying array a to array b results in:\n");
		int[] temp = new int[3];
		System.arraycopy(b, 0, temp, 0, temp.length);
		System.arraycopy(a, 0, b, 0, a.length);
		System.arraycopy(temp, 0, b, a.length, temp.length);
		displayArray(b, "Array b");	
	}
	
	private static void displayArray(int[] array, String description) {
		System.out.printf("%n%s%n", description);
		for(int value : array) {
			System.out.printf("%d ", value);
		}
	}
}
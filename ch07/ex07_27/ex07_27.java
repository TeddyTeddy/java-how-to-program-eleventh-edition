import java.util.Arrays;

public class ex07_27 {
	public static void main(String[] args) {
		final int ARRAY_SIZE = 1000;
		final int STARTING_INDEX = 2;
		
		boolean[] array = new boolean[ARRAY_SIZE];
		Arrays.fill(array, true);
		
		for(int i = STARTING_INDEX; i < ARRAY_SIZE; ++i) {
			if(array[i]) {
				// loop through the remainder of the array
				for(int j = i+1; j < ARRAY_SIZE; ++j ) {
					if(j%i == 0) { // set to false every element
						// whose index is a multiple of the index
						// for the element with value true (i.e. array[i])
						array[j] = false;
					}
				}
			}
		}
		
		int counter = 1;
		for(int i = STARTING_INDEX; i < ARRAY_SIZE; ++i) {
			if(array[i]) { // i is a prime number
				System.out.printf("%3d ", i);
				++counter;
				if((counter%10)==0) {
					System.out.println();
				}
			}
		}
		
	}
}
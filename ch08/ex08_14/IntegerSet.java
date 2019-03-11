class IntegerSet {
	// static variables
	private static int SET_SIZE = 101;
	
	// instance variables
	boolean[] a;
	
	IntegerSet() {
		a = new boolean[SET_SIZE];
	}
	
	void insertElement(int i) {
		a[i] = true;
	}
	
	void deleteElement(int i) {
		a[i] = false;
	}
	
	static IntegerSet union(IntegerSet setA, IntegerSet setB) {
		IntegerSet result = new IntegerSet(); // create an empty set
		
		for(int i = 0; i < SET_SIZE; ++i) {
			if(setA.a[i] || setB.a[i]) { // if either of the element is true
				result.a[i] = true;
			}
		}
		
		return result;
	}
	
	static IntegerSet intersection(IntegerSet setA, IntegerSet setB) {
		IntegerSet result = new IntegerSet(); // create an empty set
		
		for(int i = 0; i < SET_SIZE; ++i) {
			if(setA.a[i] && setB.a[i]) { // if either of the element is true
				result.a[i] = true;
			}
		}
		
		return result;
	}
	
	private boolean isEmpty() {
		boolean empty = true;
		for(int i = 0; i < SET_SIZE; ++i) {
			if(a[i]) {
				empty = false;
				break;
			}
		}
		return empty;
	}
	
	public String toString() {
		
		if(isEmpty()) {
			return "---";  // empty set
		}
		
		// set is not empty, return the list of numbers separated by spaces
		String set = "";
		for(int i = 0; i < SET_SIZE; ++i) {
			if(a[i]) {
				set += String.format("%d ", i);
			}
		}
		
		return set;
	}
}
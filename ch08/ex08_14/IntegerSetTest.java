public class IntegerSetTest {
	public static void main(String[] args) {
		IntegerSet setA = new IntegerSet();
		IntegerSet setB = new IntegerSet();
		
		System.out.printf("setA = new IntegerSet() returns %s%n", setA);
		System.out.printf("setB = new IntegerSet() returns %s%n%n", setB);
		
		setA.insertElement(1);
		setA.insertElement(10);
		setA.insertElement(20);
		setA.insertElement(30);
		setA.insertElement(40);
		setA.insertElement(50);
		setA.insertElement(60);
		System.out.printf("setA is set to: %s%n", setA);
		
		setB.insertElement(1);
		setB.insertElement(10);
		setB.insertElement(20);
		setB.insertElement(31);
		setB.insertElement(41);
		setB.insertElement(51);
		setB.insertElement(61);
		System.out.printf("setB is set to: %s%n%n", setB);
		
		IntegerSet setC = IntegerSet.intersection(setA, setB);
		System.out.printf("IntegerSet.intersection(setA, setB) returns %s%n", setC);
		
		IntegerSet setD = IntegerSet.union(setA, setB);
		System.out.printf("IntegerSet.union(setA, setB) returns %s%n%n", setD);
		
		setA.deleteElement(1);
		System.out.printf("setA is set to: %s%n", setA);
		System.out.printf("setB is set to: %s%n%n", setB);
		
		setC = IntegerSet.intersection(setA, setB);
		System.out.printf("IntegerSet.intersection(setA, setB) returns %s%n", setC);
		
		setD = IntegerSet.union(setA, setB);
		System.out.printf("IntegerSet.union(setA, setB) returns %s%n%n", setD);
		
	}
}
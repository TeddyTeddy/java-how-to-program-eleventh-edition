import java.util.Scanner;

public class QualityPoints {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int studentAverage = qualityPoints(input);
		System.out.printf("Student average: %d", studentAverage);
		input.close();
	}
	
	private static int qualityPoints(Scanner input) {
		System.out.printf("Enter a students average (0-100): ");
		int average = input.nextInt();
		while(!((average >= 0) && (average <= 100))) {
			System.out.printf("Incorrect value. Enter a students average (0-100): ");
			average = input.nextInt();	
		}
		
		int result;
		if((average <= 100) && (average >=90)) {
			result = 4;
		} else if((average <= 89) && (average >=80)) {
			result = 3;
		} else if((average <= 79) && (average >=70)) {
			result = 2;
		} else if((average <= 69) && (average >=60)) {
			result = 1;
		} else {
			result = 0;
		}
		
		return result;
	}
}
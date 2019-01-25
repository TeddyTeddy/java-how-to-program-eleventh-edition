import java.util.Scanner;

public class Questionare {
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		
		// initialize correctAnswerCount to zero
		int correctAnswerCount = 0;
				
		// for questionNo 1 to 5
		for(int questionNo = 1; questionNo <= 5; ++questionNo) {
			// get the question
			Question question = new Question(questionNo);
			question.show();
			
			// input the answer (from 1-4)
			int answer = getAnswer(input);
			
			// check if the answer is correct
			if(question.isCorrect(answer)) {
				// increment correctAnswerCount by 1
				++correctAnswerCount;
			}
		}
		
		// print different results based on the correctAnswerCount
		String message;
		switch(correctAnswerCount) {
			case 5:
				message = "Excellent";
				break;
			case 4:
				message = "Very good";
				break;
			default:
				message = "Time to brush up on your knowledge";
				break;
			
		}
		System.out.printf("%n%s", message);
		input.close();
	}
	
	public static int getAnswer(Scanner input) {
		System.out.print("Enter the answer no (1-4)");
		int answer = input.nextInt();
		while(!((answer >= 1) &&(answer <= 4))) {
			System.out.print("Invalid input. Enter the answer no (1-4) ");
			answer = input.nextInt();	
		}
		return answer;
	}
}
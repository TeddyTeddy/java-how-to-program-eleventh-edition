// ex7.40
import java.util.Scanner;

public class PollingTest {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] topics = {"Topic 1", "Topic 2", "Topic 3", "Topic 4", "Topic 5"};
		Polling polling = new Polling(topics);
		
		System.out.println("Enter polling answers:");		
		char answer;
		int rate;
		do {
			// make a survey round for 5 topics
			for(int row = 1; row <= Polling.NUM_OF_TOPICS; ++row) {
				rate = getRate(input, row, topics );
				polling.setResponse(row, rate);
			}	
			// continue y/Y or n/N
			System.out.print("Do you want to continue? (y/Y or n/N): ");
			answer = input.next().charAt(0);
		} while( (answer == 'y') || (answer == 'Y'));
		
		polling.printTabularReport();
	}
	
	private static int getRate(Scanner input, int topicNo, String[] topics) {
		final int MIN_RATE = 1;
		System.out.printf("%s's rate (between 1 - %d): ", topics[topicNo-1], Polling.NUM_OF_RATINGS );
		int rate = input.nextInt();
		boolean isValid = ((rate >= MIN_RATE) && (rate <= Polling.NUM_OF_RATINGS));
		while(!isValid) {
			System.out.printf("Invalid number. %s's rate (between 1 - %d): ", topics[topicNo-1], Polling.NUM_OF_RATINGS );	
			rate = input.nextInt();
			isValid = ((rate >= MIN_RATE) && (rate <= Polling.NUM_OF_RATINGS));
		}
		return rate;
	}
}
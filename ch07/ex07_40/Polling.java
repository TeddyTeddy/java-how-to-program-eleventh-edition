import java.util.ArrayList;

public class Polling {
	public static final int NUM_OF_TOPICS = 5;	 // 5 topics
	public static final int NUM_OF_RATINGS = 10; // Ratings 1-10
	
	// instance variables
	private String[] topics;
	private int[][] responses;
	
	public Polling(String[] topics) {
		this.topics = topics;
		this.responses = new int[NUM_OF_TOPICS][NUM_OF_RATINGS]; // init to zero
	}
	
	// TODO: throw an error if topicNo is negative or greater than NUM_OF_TOPICS
	// TODO: throw an error if response is negative, zero or grater than NUM_OF_RATINGS
	public void setResponse(int topicNo, int response) {
		++responses[topicNo-1][response-1];
	}
	
	public void printTabularReport() {
		// print the header
		System.out.print("         ");
		for(int column = 0; column < NUM_OF_RATINGS; ++column) {
			System.out.printf("Rating %d ", column + 1);
		}
		System.out.print("AVERAGE");
		System.out.println();
		
		for(int topic = 0; topic < NUM_OF_TOPICS; ++topic) {
			System.out.printf("%s  ", topics[topic]);
			// Values required to calculate weighted average
			// https://sciencing.com/calculate-weighted-average-5328019.html
			int totalRow = 0;
			int totalResponse = 0;
			for(int response = 0; response < NUM_OF_RATINGS; ++response) {
				System.out.printf("%8d ", responses[topic][response]);
				totalRow += ((response + 1) * responses[topic][response]);
				totalResponse += (response + 1);
			}
			double averageRow = (double) totalRow / totalResponse;
			System.out.printf("    %.2f", averageRow);
			System.out.println();
		}
		
		// (c)
		printHighestPointTotal();
		
		// (d)
		printLowestPointTotal();
	}

	private void printLowestPointTotal() {
		// initialize lowestPointTotal to Integer.MAX
		int lowestPointTotal = Integer.MAX_VALUE;
		// initialize topics array to empty list
		ArrayList<String> topics = new ArrayList<String>(); // empty list
		
		// for each topic in responses array
		for(int topic = 0; topic < NUM_OF_TOPICS; ++topic) {
			// calculate the sum of all rates into ratesSum
			int ratesSum = 0;
			for(int response = 0; response < NUM_OF_RATINGS; ++response) {
				ratesSum += ((response + 1) * responses[topic][response]);
			}
			// if ratesSum is equal to highestPointTotal
			if(ratesSum == lowestPointTotal) {
				// push the topic into the topics array
				topics.add(this.topics[topic]);
			} else if(ratesSum < lowestPointTotal) { // if ratesSum is greater than highestPointTotal
				// empty the topics arrtopics.add(this.topics[topic]);ay
				topics.clear();
				// push the topic into the topics array
				topics.add(this.topics[topic]);
				// set highestPointTotatopics.add(this.topics[topic]) to ratesSum
				lowestPointTotal = ratesSum;
			}	
			// else
				// do nothing
		}
		// output: "The following topic(s) received highestPointTotal points
		System.out.printf("%nThe following topic(s) received lowest %d points: ", lowestPointTotal);
		// for each topic in the topics array
		for(String topic : topics) {
			System.out.printf("%s ", topic); // // output each topic
		}	
				
	}
	
	private void printHighestPointTotal() {
		// initialize highestPointTotal to zero
		int highestPointTotal = 0;
		// initialize topics array to empty list
		ArrayList<String> topics = new ArrayList<String>(); // empty list
		
		// for each topic in responses array
		for(int topic = 0; topic < NUM_OF_TOPICS; ++topic) {
			// calculate the sum of all rates into ratesSum
			int ratesSum = 0;
			for(int response = 0; response < NUM_OF_RATINGS; ++response) {
				ratesSum += ((response + 1) * responses[topic][response]);
			}
			// if ratesSum is equal to highestPointTotal
			if(ratesSum == highestPointTotal) {
				// push the topic into the topics array
				topics.add(this.topics[topic]);
			} else if(ratesSum > highestPointTotal) { // if ratesSum is greater than highestPointTotal
				// empty the topics arrtopics.add(this.topics[topic]);ay
				topics.clear();
				// push the topic into the topics array
				topics.add(this.topics[topic]);
				// set highestPointTotatopics.add(this.topics[topic]) to ratesSum
				highestPointTotal = ratesSum;
			}	
			// else
				// do nothing
		}
		// output: "The following topic(s) received highestPointTotal points
		System.out.printf("%nThe following topic(s) received highest %d points: ", highestPointTotal);
		// for each topic in the topics array
		for(String topic : topics) {
			System.out.printf("%s ", topic); // // output each topic
		}	
				
	}
}
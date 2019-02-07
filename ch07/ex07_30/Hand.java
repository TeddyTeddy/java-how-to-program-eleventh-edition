public class Hand {
	private static final int FIVE_CARDS = 5;
	
	// instance variables
	private Card2[] cards;
	
	public Hand(DeckOfCards2 deck) {
		cards = new Card2[FIVE_CARDS];
		for(int i = 0; i < FIVE_CARDS; ++i) {
			cards[i] = deck.dealCard();
		}
	}
	
	public void show() {
		  System.out.println("\n\nHand contains:");
	      // print all 5 Cards in the order in which they are dealt
	      for (int i = 0; i < FIVE_CARDS; ++i) {
	         // display a Card
	         System.out.printf("%-19s", cards[i]);
	      } 
	}
	
}
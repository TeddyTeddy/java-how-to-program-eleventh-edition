// Fig. 7.11: DeckOfCardsTest.java
// Card shuffling and dealing.

public class DeckOfCardsTest2 {
   // execute application
   public static void main(String[] args) {
      DeckOfCards2 myDeckOfCards = new DeckOfCards2();
      
      myDeckOfCards.shuffle(); // place Cards in random order
      myDeckOfCards.show();
      
      Hand hand = new Hand(myDeckOfCards);
      hand.show();
      
      myDeckOfCards.show();
   }
}

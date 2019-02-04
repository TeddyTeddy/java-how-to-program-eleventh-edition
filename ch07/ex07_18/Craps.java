// Fig. 6.8: Craps.java
// Craps class simulates the dice game craps.
import java.security.SecureRandom;

public class Craps {
   // create secure random number generator for use in method rollDice
   private static final SecureRandom randomNumbers = new SecureRandom();

   // enum type with constants that represent the game status
   public enum Status {CONTINUE, WON, LOST};                

   // constants that represent common rolls of the dice
   private static final int SNAKE_EYES = 2;
   private static final int TREY = 3;      
   private static final int SEVEN = 7;     
   private static final int YO_LEVEN = 11; 
   private static final int BOX_CARS = 12; 
   
   private static final int MAX_ROLL_COUNT = 21; // up to 20.th roll and after the 20.th roll

   // plays one game of craps
   public static void main(String[] args) {
	   final int NUMBER_OF_GAMES = 1_000_000;
	   int[] gamesWonFrequencies = new int[MAX_ROLL_COUNT + 1];
	   int[] gamesLostFrequencies = new int[MAX_ROLL_COUNT + 1];
	   for(int gameCount = 1; gameCount <= NUMBER_OF_GAMES; ++gameCount) {
		   GameResult result = playCraps();
		   // process the result object
		   if(result.getStatus() == Status.WON) {
			   updateCount(gamesWonFrequencies, result.getRollCount());
		   } else if(result.getStatus() == Status.LOST) {
			   updateCount(gamesLostFrequencies, result.getRollCount());
		   } else {
			   System.out.println("Error: playCraps() returned an invalid result!");
		   }
	   }

	   displayArray(gamesWonFrequencies, "Games won on the:");
	   displayArray(gamesLostFrequencies, "Games lost on the:");
	   // (d)
	   calculateChancesOfWinningCraps(gamesWonFrequencies, gamesLostFrequencies, NUMBER_OF_GAMES);
	   // (e)
	   calculateAverageGameLength(gamesWonFrequencies, gamesLostFrequencies);
   }
   
   // https://sciencing.com/calculate-weighted-average-5328019.html
   private static void calculateAverageGameLength(int[] wins, int[] loses) {
	   
	   int winsTotal = 0;
	   for(int win : wins) {
		   winsTotal += win;
	   }
	   
	   // for all items in wins
	   double weightedSum = 0.0;
	   double weightSum = 0.0;
	   for(int roll = 1; roll < wins.length; ++roll) {
	   	// measurement m = roll
	   	// calculate weighting factor of each roll
		   double weight = ((double) wins[roll] / winsTotal );
		   weightedSum += roll * weight;
		   weightSum += weight; 
	   }
	   
	   double weightedMeanWins = weightedSum / weightSum;
	   
	   int losesTotal = 0;
	   for(int lost : loses) {
		   losesTotal += lost;
	   }
	   
	   // for all items in wins
	   weightedSum = 0.0;
	   weightSum = 0.0;
	   for(int roll = 1; roll < loses.length; ++roll) {
	   	// measurement m = roll
	   	// calculate weighting factor of each roll
		   double weight = ((double) loses[roll] / losesTotal );
		   weightedSum += roll * weight;
		   weightSum += weight; 
	   }
	   
	   double weightedMeanLoses = weightedSum / weightSum;
	   double averageLengthOfGameOfCraps = (weightedMeanWins + weightedMeanLoses) / 2;
	   // Google: The average length of a game (found using upper level mathematics) is 3.37575... rolls.
	   System.out.printf("%nAverage length of game of craps is %.2f%n", averageLengthOfGameOfCraps); // 3.37
	   
   }
   
   private static void calculateChancesOfWinningCraps(int[] wins, int[] loses, int rolls) {
	   int winsTotal = 0;
	   for(int win : wins) {
		   winsTotal += win;
	   }
	   
	   int losesTotal = 0;
	   for(int lost : loses) {
		   losesTotal += lost;
	   }
	   
	   if(winsTotal + losesTotal == rolls) {
		   System.out.printf("total number of wins and loses matches to %d%n", rolls);
	   } else {
		   System.out.printf("total number of wins and loses does NOT match to %d%n", rolls);
	   }
	   
	   double chances = ((double) winsTotal / rolls) * 100;
	   System.out.printf("Chances of winning are %.2f out of %d rolls", chances, rolls);
   }
   
   private static void displayArray(int[] frequencies, String description) {
	   System.out.printf("%s%n", description);
	   for(int count = 1; count < frequencies.length; ++count) { // frequencies.length = 22
		   if(count == MAX_ROLL_COUNT) {
			   System.out.print("after the 20.th roll ");
		   } else {
			   System.out.printf("%d.th roll ", count);
		   }
		   System.out.printf("%d times%n", frequencies[count]);
	   }
	   System.out.println();
   }
   
   private static void updateCount(int[] frequencyArray, int rollCount) {
	   int index = (rollCount >= MAX_ROLL_COUNT) ? MAX_ROLL_COUNT : rollCount;
	   try {
		   ++frequencyArray[index];
	   } catch(ArrayIndexOutOfBoundsException e) {
		   System.out.println(e);
		   System.out.printf("ERROR: Failed to access element %d of array of length %d", index, frequencyArray.length);
	   }
   }

   private static GameResult playCraps() {
	   	  GameResult gameResult = new GameResult(Status.CONTINUE, 0);
	   	  
	      int myPoint = 0; // point if no win or loss on first roll
	      Status gameStatus; // can contain CONTINUE, WON or LOST

	      int sumOfDice = rollDice(); // first roll of the dice

	      // determine game status and point based on first roll 
	      switch (sumOfDice) {
	         case SEVEN: // win with 7 on first roll    
	         case YO_LEVEN: // win with 11 on first roll
	            gameStatus = Status.WON;
	            gameResult.setRollCount(1);
	            break;
	         case SNAKE_EYES: // lose with 2 on first roll
	         case TREY: // lose with 3 on first roll      
	         case BOX_CARS: // lose with 12 on first roll 
	            gameStatus = Status.LOST;
	            gameResult.setRollCount(1);
	            break;
	         default: // did not win or lose, so remember point  
	            gameStatus = Status.CONTINUE; // game is not over
	            myPoint = sumOfDice; // remember the point       
	            System.out.printf("Point is %d%n", myPoint);
	            break; 
	      }

	      // while game is not complete
	      int rollCount = 2; // first roll of dices played in the above lines 93-113
	      while (gameStatus == Status.CONTINUE) { // not WON or LOST
	         sumOfDice = rollDice(); // roll dice again

	         // determine game status
	         if (sumOfDice == myPoint) { // win by making point
	            gameStatus = Status.WON;
	            gameResult.setRollCount(rollCount);
	         } 
	         else { 
	            if (sumOfDice == SEVEN) { // lose by rolling 7 before point
	               gameStatus = Status.LOST;
		           gameResult.setRollCount(rollCount);
	            } 
	         }
	         ++rollCount;
	      } 

	      // display won or lost message
	      if (gameStatus == Status.WON) {
	         System.out.println("Player wins");
	         gameResult.setStatus(Status.WON);
	      } 
	      else {
	         System.out.println("Player loses");
	         gameResult.setStatus(Status.LOST);
	      }
	      
	      return gameResult;
   }
   // roll dice, calculate sum and display results
   public static int rollDice() {
      // pick random die values
      int die1 = 1 + randomNumbers.nextInt(6); // first die roll
      int die2 = 1 + randomNumbers.nextInt(6); // second die roll

      int sum = die1 + die2; // sum of die values

      // display results of this roll
      System.out.printf("Player rolled %d + %d = %d%n", die1, die2, sum);

      return sum; 
   } 
}

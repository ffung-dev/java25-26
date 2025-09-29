//***************************************
//    RandomCard.java
//    Author: Fiona Fung
//***************************************

public class RandomCard
{
   public static void printRandomCard(int numJokers)
   {
      final int standardDeck = 52; // 52 cards in a deck
      String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"}; 
      int cardNum;
      String result = "";
      
      // chance of getting joker: numJokers/(standardDeck + numJokers)
      if (((int)(Math.random() * (standardDeck + numJokers)) + 1) > 52) // joker
      {
         result = "Joker";
      } else { // other cards(ace to king)
         // number
         cardNum = (int)(Math.random() * 13) + 1;
         result += cardNum;
         // ace, jack, queen, or king
         if (cardNum == 1) 
         {
            result = "Ace";
         } else if (cardNum == 11) {
            result = "Jack";
         } else if (cardNum == 12) {
            result = "Queen";
         } else if (cardNum == 13) {
            result = "King";
         }
         result += " of " + suits[(int)(Math.random() * 4)];
         System.out.println(result);
         
      }            
   }
   
   public static void main (String[] args)
   {
      /* testing
      for (int i = 0 ; i < 35 ; i++)
      {
         printRandomCard((int)(Math.random() * 5));
      }
      */
   }
}
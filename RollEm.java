//************************************
//    RollEm.java
//    Author: Fiona Fung
//************************************

public class RollEm
{
   public static int roll()
   {
      int result = (int)(Math.random() * 6 + 1);
      return result;
   }
   
   public static boolean rollEm()
   {
      boolean result = false;
      for (int i = 0 ; i < 4 ; i++) // 4 games
      {
         if (roll() == 6)
         {
            result = false;
            break;
         } else {
            result = true;
         }
      }
      return result;
   }
   
   public static void main(String[] args)
   {
      int games = 1000000;
      int wins = 0;
      for (int i = 0 ; i < games ; i++)
      {
         if (rollEm())
         {
            wins++;
            // DEBUG System.out.println(wins);
         }
      }
      double result = (double)wins / games;
      System.out.println(result);
   }
}
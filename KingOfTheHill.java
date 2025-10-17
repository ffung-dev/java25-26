//********************************************
//    KingOfTheHill.java
//    Author: Fiona Fung
//********************************************

public class KingOfTheHill
{
   public static int max(int[] array)
   {
      int maxSoFar = array[0]; // initialize smallest to be first in array
      for (int i = 0 ; i < array.length ; i++)
      {
         if (array[i] > maxSoFar)
         {
            maxSoFar = array[i];
         }
      }
      return maxSoFar;
   }

   public static int min(int[] array)
   {
      int minSoFar = array[0]; // initialize smallest to be first in array
      for (int i = 0 ; i < array.length ; i++)
      {
         if (array[i] < minSoFar)
         {
            minSoFar = array[i];
         }
      }
      return minSoFar;
   }
   
   public static int range(int[] array)
   {
      // difference between max and min values of array
      return max(array) - min(array);
   }
   
   public static void main(String[] args)
   {
      /* test values
      int[] values = {-3, 8, 2, 17, 9, -3, 12, 0, 4, 11};
      System.out.println(min(values));
      System.out.println(max(values));
      System.out.println(range(values));
      */ 
   }
}
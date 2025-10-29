//****************************************
//    ResizeArray.java
//    Author: Fiona Fung
//****************************************

import java.util.Arrays;

public class ResizeArray
{
   public static int[] resize(int[] array, int newLength)
   {
      int[] result = new int[newLength];
      if (newLength < array.length) // shorten array
      {
         for (int i = 0 ; i < newLength ; i++)
         {
            result[i] = array[i];
            // TEST System.out.println(result[i]);
         }
         // TEST System.out.println(Arrays.toString(result));
      } else { // all elements from array and 0s for unassigned
         for (int i = 0 ; i < array.length ; i++)
         {
            result[i] = array[i];
            // TEST System.out.println(result[i]);
         }
      }
      return result;
   }
   
   public static void main (String[] args)
   {
      // test resize method
      int[] testArray = {3, 1, 4, 1, 5, 9};
      System.out.println(Arrays.toString(testArray));
      System.out.println(Arrays.toString(resize(testArray, 3)));
      System.out.println(Arrays.toString(resize(testArray, 7)));      
      System.out.println(Arrays.toString(resize(testArray, 0)));            
   }
}
//**********************************
//    MultiSearchResize.java
//    Author: Fiona Fung
//**********************************

import java.util.Arrays;

public class MultiSearchResize
{
   public static int[] multiSearch(int[] array, int key)
   {
      int[] result = new int[0];
      for (int i = 0 ; i < array.length ; i++) // checking array for keys
      {
         if (array[i] == key)
         {
            result = resize(result, (result.length + 1)); // add new element
            result[result.length - 1] = i; // add i to result array
         }
      }
      return result;
   }
   
   public static int[] resize(int[] array, int newLength)
   {
      int[] result = new int[newLength];
      if (newLength < array.length) // shorten array
      {
         for (int i = 0 ; i < newLength ; i++)
         {
            result[i] = array[i];
         }
      } else { // all elements from array and 0s for unassigned
         for (int i = 0 ; i < array.length ; i++)
         {
            result[i] = array[i];
         }
      }
      return result;
   }
   
   public static void main (String[] args)
   {
      /* test
      int[] nums = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
      System.out.println(Arrays.toString(multiSearch(nums, 7))); */
      
      int[] array = new int[100000];
      // System.out.println(Arrays.toString(multiSearch(array, 0))); // fast!
   }

}  
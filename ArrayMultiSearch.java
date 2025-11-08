//****************************************
//    ArrayMultiSearch.java
//    Author: Fiona Fung
//****************************************

import java.util.ArrayList;
// import java.util.Arrays; // for testing

public class ArrayMultiSearch
{
   public static int[] multiSearch(int[] array, int key)
   {;
      ArrayList<Integer> resultList = new ArrayList<Integer>();
      // add key indexes to resultList if i == key
      for (int i = 0 ; i < array.length ; i++)
      {
         if (array[i] == key)
         {
            resultList.add(i);
         }
      }
      // turn arrayList to array (to be returned)
      int[] result = new int[resultList.size()];
      for (int j = 0 ; j < resultList.size() ; j++)
      {
         result[j] = resultList.get(j);
      }  
      
      return result;
   }  
   
   public static void main(String[] args)
   {
      /* testing
      int[] nums = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
      System.out.println(Arrays.toString(multiSearch(nums, 3)));
      */
   }
}
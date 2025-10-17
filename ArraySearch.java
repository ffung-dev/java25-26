//**************************************************
//    ArraySearch.java
//    Author: Fiona Fung
//**************************************************

public class ArraySearch
{
   public static int search(int[] array, int key)
   {
      // start at array[0]
      for (int i = 0 ; i < array.length ; i++)
      {
         if (array[i] == key)
         {
            return i;
         }
      }
      // exit loop = not able to find key ; return -1
      return -1;
   }
   
   public static int search(int[] array, int key, int startIndex)
   {
      // start at startIndex
      for (int i = startIndex ; i < array.length ; i++)
      {
         if (array[i] == key)
         {
            return i;
         }
      }
      // exit loop = not able to find key ; return -1
      return -1;
   }
     
   public static void main(String[] args)
   {
      /* test values
      int[] data = {3,2,7,8,2,6,5,2,9};
      System.out.println(search(data, 2));
      System.out.println(search(data, 2, 2));
      System.out.println(search(data, 2, 8));
      */
   }
}
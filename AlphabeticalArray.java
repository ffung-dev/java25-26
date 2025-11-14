//**************************************
//    AlphabeticalArray.java
//    Author: Fiona Fung
//**************************************

import java.util.Scanner;

public class AlphabeticalArray
{
   public static boolean isAlphabetical(String[] words)
   {
      for (int i = 1 ; i < words.length ; i++)
      {
         // > 0 is ok, == 0 is ok
         if (words[i].compareToIgnoreCase(words[i-1]) < 0)
         {
            return false;
         }
      }
      // gets through the loop without returning false
      return true;
   }
   
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      System.out.println("insert an array of strings with each object separated by a space");
      System.out.println(isAlphabetical(input.nextLine().split(" ")));
      input.close();
    }
   
}
//****************************
//    PrimeFactor.java
//    Author: Fiona Fung
//****************************

import java.util.ArrayList;

public class PrimeFactor
{
   public static String primeFactor(int n)
   {
      ArrayList<Integer> pFactors = new ArrayList<Integer>();
      String result = "";
      for (int i = 2 ; i <= n ; i++) // check factors up to n starting from 2
      {
         while (n % i == 0)
         {
            pFactors.add(i);
            n = n/i; // divide by factor
         }
      }
      // add to string result
      for (int i = 0 ; i < pFactors.size() - 1 ; i++)
      {
         result += pFactors.get(i) + " " ;
      }
      // add last factor (no space at the end)
      result += pFactors.get(pFactors.size() -1);
      return result;
   }
   
   public static void main (String[] args)
   {
      /* test values
      System.out.println(primeFactor(42));
      System.out.println(primeFactor(12));
      System.out.println(primeFactor(65536));
      System.out.println(primeFactor(8675309));
      */
   }     
}
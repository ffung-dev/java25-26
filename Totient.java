//****************************************
//    Totient.java
//    Author: Fiona Fung
//****************************************

public class Totient
{
   public static void main(String[] args)
   {
      /*    test values
      System.out.println(totient(8));
      System.out.println(totient(24));
      System.out.println(totient(1));
      System.out.println(totient(105));
      System.out.println(totient(8675309));
      */ 
   } 
   
   public static int totient(int n)
   {
      int totient = 0;
      for (int i = 1 ; i <= n ; i++)
      {
         if (gcfEuclid(i, n) == 1)
         {
            totient++;
         }
      }
      return totient;
   }
   
   public static int gcf(int a, int b)
   {
      int gcf = 0;
      int numL = Math.max(a,b); // greater number
      int numS = Math.min(a,b); // smaller number
      
      for (int i = numS ; i > 0 ; i--)
      {
         // DEBUG System.out.println(numL + " " + i + " " + numS);
         if (numL % i == 0 && numS % i == 0) // no remainder
         {
            gcf = i;
            break;
         } 
      }
      
      return gcf;
   }
   
   // euclidean algorithm
   public static int gcfEuclid(int a, int b)
   {
      int gcf = -1;
      int numL = Math.max(a,b); // greater number
      int numS = Math.min(a,b); // smaller number
      int q, r ; // quotient and remainder
      do
      {  // numL = numS * q + r
         q = numL/numS;
         r = numL % numS;
         // DEBUG System.out.println(numL + " " + numS + " " + q + " " + r );
         // replace numL with numS, replace numS with r
         numL = numS;
         numS = r;
         if (r == 0)
         {
            gcf = numL;
         }
      } while (gcf == -1);
      return gcf;
   }
}
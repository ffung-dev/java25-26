//******************************************
//    GreatestCommonFactor.java
//    Author: Fiona Fung
//******************************************

public class GreatestCommonFactor
{
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
   
  /*test values
   public static void main(String[] args)
   {
      System.out.println(gcfEuclid(6,8));
      System.out.println(gcfEuclid(3,15));
      System.out.println(gcfEuclid(39,91));
      System.out.println(gcfEuclid(1, 350));
      System.out.println(gcfEuclid(100, 8675309));
      System.out.println(gcfEuclid(83,83));
   } */
}

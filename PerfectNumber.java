//***************************
//    PerfectNumber.java    
//    Author: Fiona Fung
//***************************

public class PerfectNumber
{
   public static boolean isPerfect(int n)
   {
      boolean isPerfect;
      int sum = 1; // first factor: 1 (do not include n)
      for (int i = 2 ; i < Math.sqrt(n) ; i++)
      {
         if (n % i == 0) // i is a divisor
         {
            sum += i; // sum = sum + i
            sum += n / i; // add other factor 
            // System.out.println(sum + " " + i + " " + n/i);
         }
      }
      if (n == sum)
      {
         isPerfect = true;
      } else {
         isPerfect = false;
      }
      return isPerfect;
   }
   
   public static void main(String[] args)
   {
      for (int i = 2 ; i < 50000000 ; i += 2)
      {
         if (isPerfect(i))
         {
            System.out.println(i);
         }
      }
      
   }
}
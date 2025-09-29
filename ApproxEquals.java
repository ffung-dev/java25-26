//***********************************************
//    ApproxEquals.java
//    Author: Fiona Fung
//***********************************************

import java.util.Scanner;

public class ApproxEquals
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      int again;
      
      // take points
      do
      {
         System.out.println("Input two doubles: ");
         double d1 = input.nextDouble();
         double d2 = input.nextDouble();
         System.out.println("Input tolerance: ");
         double tolerance = input.nextDouble();
         System.out.println(approxEquals(d1, d2, tolerance));
         
         System.out.println("Again? (1 = yes)");
         again = input.nextInt();
      } while (again == 1);     
   }
   
   public static boolean approxEquals(double a, double b, double tolerance) 
   {
      return (Math.abs(a - b) <= tolerance);
   }
}
//******************************************
//  QuadraticFormula.java 
//  Author: Fiona Fung
//******************************************

import java.util.Scanner;

public class QuadraticFormula
{
   public static void main(String[] args)
   {
      // create variables, scanner
      Scanner input = new Scanner(System.in);
      double a, b, c;
      System.out.println("Enter a: ");
      a = input.nextDouble();
      System.out.println("Enter b: ");
      b = input.nextDouble();
      System.out.println("Enter c: ");
      c = input.nextDouble();
      
      // parts of the quadratic formula
      double discrim = (b*b) - (4 * a * c);
      double quad1 = (-1 * b) / (2*a);
      double quad2;
      
      // determine discrim >/< 0 
      if (discrim >= 0)
      {
         quad2 = Math.sqrt(discrim)/(2*a) ;
         System.out.println("Solutions: " + (quad1 + quad2) + " and " + (quad1 - quad2));
      
      } else {
      // imaginary
         quad2 = Math.sqrt(discrim/-1)/(2*a) ;
         System.out.println("Solutions: " + quad1 + " + " + quad2 + "i and " + quad1 + " - " + quad2 + "i"); 
      }
      input.close();
   }
}
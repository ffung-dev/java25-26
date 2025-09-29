//*****************************************
//    LeapYears.java
//    Author: Fiona Fung
//*****************************************

import java.util.Scanner;

public class LeapYears
{
   public static boolean isLeapYear(int year)
   {
      if (year % 100 == 0) { // divisible by 100
         if (year % 400 == 0) // divisible by 400 -> leap year
         {
            return true;
         } else {
            return false;
         }
      } else if (year % 4 == 0) { // divisible by 4 -> leap year
         return true;
      } else {
         return false;
      }
   }
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      System.out.print("Year: ");
      int year = input.nextInt();
      // prints result
      if (isLeapYear(year)) 
      {
         System.out.println(year + " is a leap year.");
      } else {
         System.out.println(year + " is not a leap year.");
      }

      input.close();
   }
}
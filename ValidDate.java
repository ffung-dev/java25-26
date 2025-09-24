//*****************************************
//    ValidDate.java
//*****************************************

import java.util.Scanner;

public class ValidDate
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
   
   public static boolean isValidDate(int month, int day, int year)
   {
      boolean result = true;
      // month must be 1-12, year must be > 0, day must be > 0
      if (month >= 1 && month <= 12 && year > 0 && day > 0)
      {
         // days depend on the month
         if (month == 2) 
         { // february: depends on year
            if (isLeapYear(year))
            {
               if (day <= 29) { // 29 days
                  result = true;
               } else {
                  result = false;
               }
            } else { // 28 days
               if (day <= 28)
               {
                  result = true;
               } else {
                  result = false;
               }
            }
         } else if (month % 2 == 1 || month == 8) { // odd months + august: 31
            if (day <= 31)
            {
               result = true;
            } else {
               result = false;
            }

         } else if (month % 2 == 0) { // all other months
            if (day <= 30)
            {
               result = true;
            } else {
               result = false;
            }
         }
      } else {
         result = false;
      } 
      return result;     
   }
   
   
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      System.out.print("Month: ");
      int month = input.nextInt();
      System.out.print("Day: ");
      int day = input.nextInt();
      System.out.print("Year: ");
      int year = input.nextInt();
      
      
      // prints result
      String date = month + "/" + day + "/" + year;
      if (isValidDate(month,day,year)) 
      {
         System.out.println(date + " is a valid date.");
      } else {
         System.out.println(date + " is not a valid date.");
      }
   }
}
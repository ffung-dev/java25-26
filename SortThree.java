//***********************************************
//    SortThree.java    
//    Author: Fiona Fung
//***********************************************


import java.util.Scanner;

public class SortThree
{
   public static void main(String[] args)
   {
      // user inputs variables
      Scanner input = new Scanner(System.in);
      System.out.println("Enter a: ");
      int a = input.nextInt();   
      System.out.println("Enter b: ");
      int b = input.nextInt(); 
      System.out.println("Enter c: ");
      int c = input.nextInt(); 
      // variables for result
      int num1 = 0 ; 
      int num2 = 0 ; 
      int num3 = 0;
      
      if (a == b && a == c) { // a = b = c
         num1 = a; // biggest
         num2 = a;
         num3 = a; // smallest
      } else if (a == b || a == c) { // a = b or c
         if (a > b)
         {
            num1 = a;
            num2 = a;
            num3 = b;
         } else if (a > c) {
            num1 = a;
            num2 = a;
            num3 = c;
         } else if (a < b) {
            num1 = b;
            num2 = a;
            num3 = a;
         } else if (a < c) {
            num1 = c;
            num2 = a;
            num3 = a;
         }
      } else if (b == c) { // b = c
         if (b > a) 
         {
            num1 = b;
            num2 = b;
            num3 = a;
         } else {
            num1 = a;
            num2 = b;
            num3 = b;
         }
      } else if (b > a && b > c) { // b > 
         num1 = b;
         if (a >= c) // b > a > c
         {
            num2 = a; 
            num3 = c;
         } else if (c > a) { // b > c > a
            num2 = c;
            num3 = a;
         }
      } else if (c > a && c > b) { // c >
         num1 = c;
         if (a >= b) // c > a > b
         {
            num2 = a; 
            num3 = b;
         } else if (b > a) { // c > b > a
            num2 = b;
            num3 = a;
         }
      } else if (a > b && a > c) { // a 
         num1 = a;
         if (b >= c) // a > b > c
         {
            num2 = b; 
            num3 = c;
         } else if (c > b) { // a > c > b
            num2 = c;
            num3 = b;
         }      
      }
      
      System.out.println("In order: " + num3 + " " + num2 + " " + num1);
      input.close();
   }
}
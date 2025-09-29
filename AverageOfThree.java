//************************************
//    AverageOfThree.java 
//    Author: Fiona Fung
//************************************

import java.util.Scanner;

public class AverageOfThree 
{
   public static void main(String[] args)
   {
      // get variables from user input
      Scanner input = new Scanner(System.in);
      System.out.print("Enter 3 numbers: ");
      int a = input.nextInt();
      int b = input.nextInt();
      int c = input.nextInt();  
      
      double average = (a + b + c)/3.0;
      System.out.printf("Average (method 1): %.3f\n", average);
      
      // round to thousandths    
      average = Math.round(average * 1000)/1000.0;
      System.out.println("Average: " + average);
      
      
      input.close();
   }
}
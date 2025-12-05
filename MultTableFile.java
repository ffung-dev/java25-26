//****************************************
//    MultTableFile.java
//    Author: Fiona Fung
//****************************************

import java.io.PrintWriter;

public class MultTableFile
{
   //preconditions: size > 0
   // <filename>.txt is a valid Windows filename
   public static void multTableFile(int size, String filename)
   {
      PrintWriter outFile = null;
      int numToPrint = 0;
      try 
      {
         outFile = new PrintWriter(filename + ".txt");
         for (int r = 0 ; r < size ; r++)
         {
            for (int c = 0 ; c < size ; c++)
            {
               numToPrint = (r + 1) * (c + 1);
               outFile.print(numToPrint + " ");
            }
            outFile.println(""); // next line
         }
         outFile.close();
      } catch (Exception e) {
         System.err.println("Unable to open new file.");
         return; 
      }
   }
   
   public static void main(String[] args)
   {
      multTableFile(5, "MULTFILENAME");
   }
}
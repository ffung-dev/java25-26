//*************************************
//    SetChar.java
//    Author: Fiona Fung
//*************************************

public class SetChar
{
   public static String setChar(String str, int index, String ch)
   {
      char[] charArray = str.toCharArray();
      charArray[index] = ch.charAt(0); // change ch to char and set correct array element to it
      String resultStr = new String(charArray);// array -> string
      
      return resultStr;
   }
   
   public static String setChar(String str, int index, char ch)
   {
      char[] charArray = str.toCharArray();
      charArray[index] = ch; // set correct array element to ch
      String resultStr = new String(charArray); // array -> string
      
      return resultStr;
   }
   
   public static void main (String[] args)
   {  /* test 
      String word = "touch";
      System.out.println(word);
      word = setChar(word, 3, "g"); //calls String version
      System.out.println(word);
      word = setChar(word, 0, 'r'); //calls char version
      System.out.println(word);
      word = setChar(word,4,(char)(word.charAt(4) - 3));//calls char version
      System.out.println(word);
      */
   }
}
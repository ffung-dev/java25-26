//********************************
//    StringArrayList.java
//********************************

import java.util.ArrayList; 
import java.util.Arrays;

public class StringArrayList
{
   private String[] data;
   private int size;
   
   public StringArrayList(int initLength) 
   {
      data = new String[initLength];
      size = 0;
   }
   
   public StringArrayList() // default length to 10
   {
      this(10);
   }
   
   private int length() 
   {
      return data.length;
   }
   
   public int size()
   {
      return size;
   }
   
   private void changeLength(int newLength)
   {
      String[] newArray = new String[newLength];
      int length; 
      if (newLength < data.length)
      {
         length = newLength;
      } else {
         length = data.length;
      }
      
      for (int i = 0 ; i < length ; i++)
      {
         newArray[i] = data[i];
      }
      this.data = newArray;
   }
   
   public String toString()   
   {
      String result = "[";
      // add up to second to last
      for (int i = 0 ; i < size - 1; i++)
      {
         result += data[i] + ", ";
      }
      // add last String (no ending comma)
      result += data[size - 1];
      result += "]";
      return result;
   }
   
   public void add(int index, String str)
   {
      // 0 <= index < size
      if (index < 0 || index > size)
      {
         throw new IndexOutOfBoundsException();
      } else {
         // length > size (has space)
         if (data.length == size)
         {
            changeLength(data.length * 2);
         }
         // shift all elements between index and size-1 to the right to make space for str
         for (int i = size - 1 ; i >= index; i--) // start from right -> left
         {
            data[i+1] = data[i]; // the element to the right (empty) becomes previous element
            // System.out.println("i: " + i);
         }
         data[index] = str; // put in the str in the (now empty) index spot
         size++;
      }
   }
   
   public void add(String str)
   {
      add(size, str);
   }
   
   // for testing
   public static void main (String[] args)
   {
      /* test 1
      StringArrayList list1 = new StringArrayList();
      System.out.println(list1.length());
      System.out.println(list1.size());
      StringArrayList list2 = new StringArrayList(50);
      System.out.println(list2.length());
      System.out.println(list2.size()); */
      
      /* test 2
      StringArrayList list = new StringArrayList(4);
      //System.out.println(list.length());
      // list.data[0] = "Test"; //just for testing – don't do this normally
      //System.out.println(Arrays.toString(list.data));
      list.changeLength(2);
      //System.out.println(list.length());
      //System.out.println(Arrays.toString(list.data)); 
      //System.out.println(list.toString());
      list.add(0,"0");
      //System.out.println(list.size);
      list.add(1, "1");
      //System.out.println(list.size);
      list.add("2");
      //System.out.println(list.size);
      list.add(3, "3");
      list.add(2, "1.5");
      //System.out.println(list.size);
      System.out.println(list.length() + " " + list.size + " " + list.toString());
      */
   }
   
}
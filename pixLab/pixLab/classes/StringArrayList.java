//********************************
//    StringArrayList.java
//********************************

import java.util.ArrayList; 
import java.util.Arrays;
import java.util.Random;

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
         throw new IndexOutOfBoundsException("Index " + index + " is not in bounds");
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
   
   public String get(int index)
   {
      // if element does not exist
      if (index >= size)
      {
         throw new IndexOutOfBoundsException("Element does not exist at index " + index);
      } else {
         return data[index];
      }      
   }
   
   public String set(int index, String str)
   {
      // if element does not exist
      if (index >= size)
      {
         throw new IndexOutOfBoundsException("Element does not exist at index " + index);
      } else {
         String prev = data[index];
         data[index] = str; // change to new
         return prev;
      } 
   }
   
   public String remove(int index)
   {
      // if element does not exist
      if (index >= size)
      {
         throw new IndexOutOfBoundsException("Element does not exist at index " + index);
      } else {
         String removedStr = data[index];
         for (int i = index ; i < size - 1 ; i++)
         {
            data[i] = data[i + 1];
         }
         data[size -1] = null; // clear out last element
         size--; // decrease by 1
         return removedStr;
      } 
         
   }
   
   public boolean isEmpty()
   {
      return (size == 0);
   }
   
   public void trim() // change length to size
   {
      changeLength(size);
      // erases all nulls to save memory
   }
   
   public void clear() // set all elements to null
   {
      while (!isEmpty()) // while not empty
      {
         remove(0); // since remove shifts to left, keep removing first term
      }
   }
   
   public void addAll(String[] array) // add to end of list
   {
      for (int i = 0 ; i < array.length ; i++)
      {
         add(array[i]);
      }
   }
   
   public void addAll(StringArrayList other)
   {
      for (int i = 0 ; i < other.size() ; i++)
      {
         add(other.data[i]);
      }
   }
   
   public boolean contains(String key)
   {
      for (int i = 0 ; i < size ; i++)
      {
         if (data[i] == key)
         {
            return true;
         }
      }
      // gets out of loop = no element is key
      return false;
   }
   
   public int indexOf(String key)
   {
      if (contains(key))
      {
         for (int i = 0 ; i < size ; i++)
         {
            if (data[i] == key)
            {
               return i;
            }
         }
      }
      return -1;
   }   
   public void replace(String key, String repStr)
   {
      for (int i = 0 ; i < size ; i++)
      {
         if (data[i] == key)
         {
            data[i] = repStr;
         }
      }

   }
   
   public void reverse()
   {
      String temp;
      for (int i = 0 ; i < size/2 ; i++)
      {
         temp = data[i];
         data[i] = data[size - 1 - i];
         data[size - 1 - i] = temp;
      }
   }
   
   public void shuffle()
   {
      Random randomInt = new Random();
      for (int i = size - 1 ; i > -1 ; i--)
      {
         int j = randomInt.nextInt(i + 1); // inclusive pick from 0 to i (pick what to swtich)
         String temp = data[i];
         data[i] = data[j];
         data[j] = temp;
      }
   }
   
   // for testing
   public static void main (String[] args)
   {
      /* TEST
      StringArrayList list = new StringArrayList(4);
      StringArrayList list2 = new StringArrayList(3);
      //System.out.println(list.length());
      // list.data[0] = "Test"; //just for testing – don't do this normally
      //System.out.println(Arrays.toString(list.data));
      list.changeLength(2);
      //System.out.println(list.length());
      //System.out.println(Arrays.toString(list.data)); 
      //System.out.println(list.toString());
      list.add(0,"0");
      list.add(1, "1");
      list.add("2");
      list.add(3, "3");
      list.add(2, "1.5");
      list.set(3, "2 at third");
      list2.add("11");
      list2.add("13");
      list2.add(1, "12");
      System.out.println(list.toString()); // full
      System.out.println(Arrays.toString(list.data));
      list.addAll(list2);
      System.out.println(list.toString());
      list.shuffle();
      System.out.println(list.toString());
      System.out.println(list.indexOf("11")); */
      
   }
   
}
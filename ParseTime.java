//************************************
//    ParseTime.java
//    Author: Fiona Fung
//************************************

public class ParseTime
{
   public static int parseTime(String timeStr)
   {
      String fullTime = (timeStr.trim()).toUpperCase(); // remove spaces, set to uppercase (am -> AM) to get around case sensitivity
      int hours = 0, min = 0, minResult = 0;
      String timeF = ""; // ##:## part of timeStr
      String timeNum = ""; // ####
      boolean hasColon = false;
      
      // 24hr or AM/PM clock?
      if (fullTime.substring(fullTime.length() - 2, fullTime.length()).contains("M"))
      {
         String AMPM = fullTime.substring(fullTime.length() - 2, fullTime.length());
         // no spaces
         if (AMPM.contains(" "))
         {
            // DEBUG
            //System.out.println("AMPM has space");
            return -1;
         }
         
         // AM or PM?
         timeF = (fullTime.substring(0, fullTime.length() - 2)).trim(); // remove AM/PM and extra spaces
         if (AMPM.equals("AM"))
         {
            hours = 0;
         } else if (AMPM.equals("PM")) {
            minResult = 12 * 60; // 12 hours have already passed. add on later
         } else { // other characters not allowed
            // DEBUG
            //System.out.println("other character in AMPM");
            return -1;
         }
      } else {
        // 24 hr clock
        timeF = fullTime;
      }
      // check time
      //System.out.println(timeF);
      for (char c : timeF.toCharArray())
      {
         if (Character.isLetter(c) || Character.isWhitespace(c) ) // no letters or spaces allowed
         {
            // DEBUG
            //System.out.println("letter or space in time");
            return -1;
         }         
         if (c == ':') // colon is optional
         {
            hasColon = true;
         }
         if (Character.isDigit(c))
         {
            timeNum += String.valueOf(c);
         }
      }
      // DEBUG 
      // System.out.println(hours + " " + timeF + " " + timeNum);
      // time portion must have 3-4 digits and cannot contain a space
      if (timeNum.length() < 3 || timeNum.length() > 4 || timeF.contains(" ")) 
      {
        // DEBUG
        //System.out.println("has space or wrong timeNum (3-4)");
         return -1;
      }
      // check position of colon 
      if (hasColon)
      {
        if (timeF.indexOf(":") != timeF.length() - 3)
        {
            // DEBUG
            //System.out.println("colon in wrong spot");
            return -1;
        }
      }

      // check digit limits & assign hours and minutes
      // minutes: 0-59
      if (timeNum.length() == 3) 
      {
        // AM/PM: 1-12 
        try 
        {
            hours += Integer.valueOf(timeNum.substring(0, 1)); // +=; could be 0 from PM
            min += Integer.valueOf(timeNum.substring(1));
        } catch (Exception e) {
            //System.out.println("timeNum length = 3, exception in setting hours/min");
            return -1;
        }
        if (hours < 1 || hours > 12 || min < 0 || min > 59) 
        {
            // DEBUG
            //System.out.println("wrong hours/min AM/PM");
            return -1;
        }

      } else if (timeNum.length() == 4) {
        try 
        {
            hours += Integer.valueOf(timeNum.substring(0, 2));
            min += Integer.valueOf(timeNum.substring(2));
        } catch (Exception e) {
            //System.out.println("timeNum length = 4, exception in setting hours/min");
            return -1;
        }
        // 24-hr: 0-23
        if (hours < 0 || hours > 23 || min < 0 || min > 60)
        {
            // DEBUG
            //System.out.println("wrong hours/min 24hr");
            return -1;
        }
      } else {
        // too many digits
        // DEBUG
        //System.out.println("too many digits");
        return -1; 
      }
      
      // if AM/PM & PM: 12 * 60 already added to minResult
      minResult += 60 * hours + min;

      return minResult;
   }
   
   public static void main(String[] args)
   {
        System.out.println(parseTime("10:08 am"));
        System.out.println(parseTime("6:45 pm"));
        System.out.println(parseTime("03:12 AM"));
        System.out.println(parseTime("    7:23    Pm "));
        System.out.println(parseTime("444AM"));
        System.out.println(parseTime("0534"));
        System.out.println(parseTime("23:59"));
        System.out.println(parseTime("800"));
        System.out.println(parseTime("0035"));
        System.out.println("BELOW SHOULD BE INVALID");
        System.out.println(parseTime("10 08 AM"));
        System.out.println(parseTime("4:14 P M"));
        System.out.println(parseTime("006:45 pm"));
        System.out.println(parseTime("012:30 am"));
        System.out.println(parseTime("9:5 PM"));
        System.out.println(parseTime("102:3"));
        System.out.println(parseTime("1:47 AMM"));
        System.out.println(parseTime("PM 7:37"));
        System.out.println(parseTime("4:67 AM"));
        System.out.println(parseTime("2553"));
        System.out.println(parseTime("noon")); 
   }
}

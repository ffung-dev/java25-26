//*************************************************
//    PictureFilter.java      Author: Fiona Fung
//    use Picture.java
//*************************************************

import java.awt.Color;

public class PictureFilter
{   
   // check that rgb are between 0 and 255
   private static int checkRed(int inRed)
   {
      int red = inRed;
      if (red > 255) { red = 255; }
      if (red < 0) { red = 0; }
      return red;
   }
   
   private static int checkGreen(int inGreen)
   {
      int green = inGreen;
      if (green > 255) { green = 255; }
      if (green < 0) { green = 0; }
      return green;
   }
   
   private static int checkBlue(int inBlue)
   {
      int blue = inBlue;
      if (blue > 255) { blue = 255; }
      if (blue < 0) { blue = 0; }
      return blue;
   }
   
   // change brightness of a pic
   // setting should be between -100 and 100 
   public static void adjustBrightness(Picture pic, int setting) 
   {
      Pixel pixels[][] = pic.getPixels2D();
      double factor =  1 + (double) setting / 100; 
      // debug System.out.println(factor);
      for (int r = 0 ; r < pixels.length ; r++)
      {
         for (int c = 0 ; c < pixels[r].length ; c++)
         {
            int red = (int)(Math.floor((double) pixels[r][c].getColor().getRed() * factor));
            int green = (int)(Math.floor((double)pixels[r][c].getColor().getGreen() * factor));
            int blue = (int)(Math.floor((double)pixels[r][c].getColor().getBlue() * factor));
            // check rgb 
            red = checkRed(red);
            green = checkGreen(green);
            blue = checkBlue(blue);
            
            pixels[r][c].setColor(new Color(red, green, blue));
         }
      }
   }

   public static void adjustSaturation(Picture pic, int setting) // setting should be between -100 to 100
   {
      Pixel pixels[][] = pic.getPixels2D();
      double strength = 1 + (double)(setting / 100); // strength is >= 0 ; 0 = grayscale, > 1 = saturated, =1 = no change
     for (int r = 0 ; r < pixels.length ; r++)
      {
         for (int c = 0 ; c < pixels[r].length ; c++)
         {
            int red = pixels[r][c].getColor().getRed();
            int green = pixels[r][c].getColor().getGreen();
            int blue = pixels[r][c].getColor().getBlue();
            
            int gray = (red + green + blue) / 3; // gray average
            // change new rgb
            red = (int) (gray + (red - gray) * strength); 
            green = (int) (gray + (green - gray) * strength); 
            blue = (int) (gray + (blue - gray) * strength); 

            // check rgb 
            red = checkRed(red);
            green = checkGreen(green);
            blue = checkBlue(blue);
            
            pixels[r][c].setColor(new Color(red, green, blue));
         }
      }
   }
   
   // note: setting should be between 0-20 for best warmth and cool
   public static void adjustWarmth(Picture pic, int setting) 
   {
      Pixel pixels[][] = pic.getPixels2D();
      for (int r = 0 ; r < pixels.length ; r++)
      {
         for (int c = 0 ; c < pixels[r].length ; c++)
         {
            int red = (int)(Math.floor(pixels[r][c].getColor().getRed() + setting));
            int green = (int)(Math.floor(pixels[r][c].getColor().getGreen() + (setting * 0.25))); // maintain or slightly increase green
            int blue = (int)(Math.floor(pixels[r][c].getColor().getBlue() - setting));
            // check rgb 
            red = checkRed(red);
            green = checkGreen(green);
            blue = checkBlue(blue);
            
            pixels[r][c].setColor(new Color(red, green, blue));
         }
      }
   }
   
   public static void adjustCool(Picture pic, int setting) 
   {
      Pixel pixels[][] = pic.getPixels2D();
      for (int r = 0 ; r < pixels.length ; r++)
      {
         for (int c = 0 ; c < pixels[r].length ; c++)
         {
            int red = (int)(Math.floor(pixels[r][c].getColor().getRed() - setting));
            int green = (int)(Math.floor(pixels[r][c].getColor().getGreen() + (setting * 0.25))); // maintain or slightly increase green
            int blue = (int)(Math.floor(pixels[r][c].getColor().getBlue() + setting));
            // check rgb 
            red = checkRed(red);
            green = checkGreen(green);
            blue = checkBlue(blue);
            
            pixels[r][c].setColor(new Color(red, green, blue));
         }
      }
   }
   
   // strength is 0 - 100 (preferred, but i guess it can be > 100) where 0 is super super sensitive and 100 is not sensitive
   // IMPORTANT NOTE!!!!!!!!!! I changed the scale method in SimplePicture because row should correspond to height and col to width; more in paper
   public static Picture greenScreen(Picture oldPic, Picture background, Color bgRemove, int strength)
   {
      Pixel oldPixels[][] = oldPic.getPixels2D();
      Pixel bgPixels[][] = background.getPixels2D();
      double xFactor = (double) oldPic.getWidth() / background.getWidth();
      double yFactor = (double) oldPic.getHeight() / background.getHeight();
      Picture newBg = background.scale(xFactor, yFactor);
      // System.out.println(newBg.getWidth() + " " + newBg.getHeight());
      Pixel newBgPixels[][] = newBg.getPixels2D(); // scale to the same size as oldPic
      
      /* 
      System.out.println(xFactor + " " + yFactor);
      System.out.println(oldPixels[0].length + " " + oldPixels.length);
      System.out.println(bgPixels[0].length + " " + bgPixels.length);      
      System.out.println(newBgPixels[0].length + " " + newBgPixels.length);
      */ 
      Picture result = new Picture(oldPixels.length, oldPixels[0].length);
      Pixel resultPixels[][] = result.getPixels2D();
      
      for (int row = 0 ; row < oldPixels.length ; row++) 
      {
        for (int col = 0 ; col < oldPixels[0].length; col++)
        {
            if (oldPixels[row][col].colorDistance(bgRemove) > strength) // stays the same
            {
                resultPixels[row][col].setColor(oldPixels[row][col].getColor()); 
            } else { // change to new background
               // debug System.out.println(row + " " + col);
                resultPixels[row][col].setColor(newBgPixels[row][col].getColor());
            }
        }    
      }  
      return result;
   }
   
   public static void filter(Picture pic, int brightness, int saturation, int warmth, int tint)
   {
      adjustBrightness(pic, brightness);
      adjustSaturation(pic, saturation);
      adjustWarmth(pic, warmth);
      adjustCool(pic, tint);
   }
   
   // custom filters
   public static void vintageFilter(Picture pic)
   {
      adjustBrightness(pic, -10);
      adjustSaturation(pic, -100);
      adjustWarmth(pic, 30);
   }
   
   public static void goldenFilter(Picture pic)
   {
      adjustBrightness(pic, -20);
      adjustSaturation(pic, 10);
      adjustWarmth(pic, 60);
      adjustCool(pic, 25);
   }
   
   // newGoldenFilter: uses both filter and greenScreen, so it returns a new Picture
   public static Picture newGoldenFilter(Picture pic, Color bgRemove, int strength)
   {
      Picture sunsetBg = new Picture("sunset.jpg");
      Picture result = greenScreen(pic, sunsetBg, bgRemove, strength);
      goldenFilter(result);
      return result;
   }
   
   public static void winterFilter(Picture pic)
   {
      adjustBrightness(pic, -30);
      adjustSaturation(pic, 5);
      adjustWarmth(pic, 15);
      adjustCool(pic, 30);
   }
   
   // testing
   public static void main(String[] args)
   {
      // greenScreen
      Picture bunny = new Picture("bunny.jpg"); 
      Picture beach = new Picture("beach.jpg");
      bunny.explore();
      Picture newBunny = newGoldenFilter(bunny, new Color(27, 255, 93), 120);
      newBunny.explore();
      
      // filter
      Picture hall = new Picture("femaleLionAndHall.jpg");
      hall.explore();
      winterFilter(hall);
      hall.explore();
      
   }
}
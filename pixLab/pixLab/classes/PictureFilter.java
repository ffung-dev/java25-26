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
   public static void adjustBrightness(Picture pic, double setting) 
   {
      Pixel pixels[][] = pic.getPixels2D();
      double factor = 1 + (setting / 100); 
      for (int r = 0 ; r < pixels.length ; r++)
      {
         for (int c = 0 ; c < pixels[r].length ; c++)
         {
            int red = (int)(Math.floor(pixels[r][c].getColor().getRed() * factor));
            int green = (int)(Math.floor(pixels[r][c].getColor().getGreen() * factor));
            int blue = (int)(Math.floor(pixels[r][c].getColor().getBlue() * factor));
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
      double strength = 1 + (setting / 100); // strength is >= 0 ; 0 = grayscale, > 1 = saturated, =1 = no change
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
   
   public static void adjustCool(Picture pic, double setting) 
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
   
   // sensitivity is 0 - 100 where 0 is not sensitive at all and 100 is picky
   public static Picture greenScreen(Picture oldPic, Picture background, Color bgRemove, int sensitivity)
   {
      Pixel oldPixels[][] = oldPic.getPixels2D();
      Pixel newBgPixels[][] = background.getPixels2D();
      Picture result = new Picture(oldPixels.length, oldPixels[0].length);
      int distLimit = 100 - sensitivity; 

      for (int row = 0 ; row < oldPixels.length ; row++) 
      {
        for (int col = 0 ; col < oldPixels[0].length; col++)
        {
            if (oldPixels[row][col].colorDistance(bgRemove) > distLimit) // stays the same
            {
                result[row][col].setColor(oldPixels[row][col].getColor()); 
            } else { // change to new background
                result[row][col].setColor(newBgPixels[row][col].getColor());
            }
        }    
      }  
      return result;
   }
   
   public static void filter(Picture pic, double brightness, double saturation, double warmth, double tint)
   {
   
   }
   
   // testing
   public static void main(String[] args)
   {
      Picture beach = new Picture("beach.jpg");
      beach.explore();
      
      beach.explore();
   }
}
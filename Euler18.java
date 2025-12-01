//******************************************
//      Euler18.java
//      https://projecteuler.net/problem=18
//      uses smallTriangle.txt
//******************************************

import java.io.BufferedReader; // read data
import java.io.FileReader; // read file
import java.io.IOException;

public class Euler18
{
    // convert a file to jagged array (shape = triangle)
    public static int[][] fileToTriangle(String fileName, int rows) 
    {
        int[][] result = new int[rows][]; 
        // columns = rows +1
        for (int r = 0 ; r < rows ; r++)
        {
            result[r] = new int[r + 1];
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) 
        {
            String line;
            int rLoop = 0; // count rows in while loop
            while ((line = reader.readLine()) != null) 
            {   
                String[] fileLine = line.split(" "); // splits all values in line to array
                for (int i = 0 ; i < fileLine.length ; i++)
                {
                    result[rLoop][i] = Integer.parseInt(fileLine[i]); // add values into result array
                }
                rLoop++;
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("file reading error");
        }

        return result;
    }

    public static void main(String[] args)
    {
        // EULER 67
        int[][] triangle = fileToTriangle("triangle.txt", 100); // create jagged array from triangle in another file
        // EULER 18 fileToTriangle("smallTriangle.txt", 15);
        for (int r = triangle.length - 2 ; r > -1 ; r--) // start from bottom (second to last row)
        {
            for (int c = 0 ; c < triangle[r].length ; c++)
            {
                triangle[r][c] += Math.max(triangle[r + 1][c], triangle[r + 1][c + 1]); // change value to the better sum (based on the row below it)
            }
        }
        System.out.println(triangle[0][0]); // top value has been changed to best sum based on all possibilites below

        /* top-down does not get best sum 
        int sum = triangle[0][0]; // the first top value 
        int prevIndex = 0; // the previous index used (+0,+1)
        for (int r = 1 ; r < triangle.length ; r++) // each row in triangle; start from second row
        {
            // which adjacent value is larger
            if (triangle[r][prevIndex] > triangle[r][prevIndex + 1]) // left is larger
            {
                sum += triangle[r][prevIndex];
            } else if (triangle[r][prevIndex] < triangle[r][prevIndex + 1]) { // right is larger
                sum += triangle[r][prevIndex + 1];
                prevIndex++;
            }
        }
        System.out.println(sum);
        */
    }
}
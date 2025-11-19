//**********************************
//    MagicSquares.java
//    Author: Fiona Fung
//**********************************

public class MagicSquares
{
   public static boolean isMagicSquare(int[][] grid)
   {
      int sumRef = 0;
      int rowSum = 0, columnSum = 0;
      int diagonalLSum = 0, diagonalRSum = 0;
      // first row sum
      for (int c = 0; c < grid[0].length ; c++)
      {
         sumRef+= grid[0][c];
      }
      
      // if number of rows is not = to number of columns
      if (grid.length != grid[0].length)
      {
         //System.out.println("number of rows is not the same as number of columns");
          return false;
      } 
            
      // check sums of each row
      for (int r = 0 ; r < grid.length ; r++) // each row in the grid
      {
         // sum of diagonals
         diagonalLSum += grid[r][r];
         diagonalRSum += grid[r][(grid[r].length - 1 - r)];
         for (int c = 0 ; c < grid[r].length ; c++) // each value in the row
         {                    
            // sum of row
            rowSum += grid[r][c];            
         } 
         if (rowSum != sumRef) // check sum
         {
            //System.out.println("sum of rows are not the same");
            return false;
         }  
         rowSum = 0;
      }
      
      // check diagonals
      if (sumRef != diagonalLSum || sumRef != diagonalRSum)
      {
         //System.out.println(rowSum + " " + diagonalLSum + " " + diagonalRSum + " sum of diagonals are not the same");
         return false;
      }

      // check sum of each column
      for (int c = 0 ; c < grid.length ; c++) // each column in the grid
      {
         for (int r = 0 ; r < grid[c].length ; r++) // each value in the column
         {
            columnSum += grid[r][c];            
         } 
         if (columnSum != sumRef) // check sum
         {
            //System.out.println("sum of columns are not the same");
            return false;
         }  
         columnSum = 0;
      }      
      
      // passes each section (row sums, column sums, diagonal sums)
      return true;
   }

   /* test 
   public static void main(String[] args) 
   {
        int[][] grid = { {8,1,6} , {3,5,7} , {4,9,2}}; 
        int[][] grid2 = { {7} };
        int[][] grid3 = { {-1,1,0} , {1,0,-1} , {0,-1,1} , {0, 0, 1}};         
        System.out.println(isMagicSquare(grid3));
   }  */
}
import java.util.Scanner;
import java.io.*;

public class Diamonds
{
  public static void main(String[] args) throws IOException
  {
    Scanner in = new Scanner(new File("diamonds.dat"));
    int numd = in.nextInt();
    in.nextLine(); //clear cache
    
    for(int i = 0; i < numd; i++)
    {
      
      String letter = in.next();
      int d = in.nextInt();
      in.nextLine();
      String[][] diamond = new String[d][d];
      
      // initialize diamond
      for(int r = 0; r < d; r++)
        for(int c = 0; c < d; c++)
        diamond[r][c] = " ";  
      
      
      // fill in diamond
      for(int r = 0; r < d; r++)
      {
        int c = d / 2;  //set starting column to halfway value
        
        if (r < c) //top half
        {
          diamond[r][c-r] = letter; 
          diamond[r][c+r] = letter;
        }
        else //bottom half
        {
          diamond[r][3*c - r] = letter;  // c + 2c - r
          diamond[r][r - c] = letter; // c - (2c - r)
        }
        
      }
      
      // print diamond
      for(int r = 0; r < d; r++)
      {
        for(int c = 0; c < d; c++)
          System.out.print(diamond[r][c]);
        System.out.println();
      }
      System.out.println();
      
    }
  }
  
}

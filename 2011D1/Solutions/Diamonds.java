import java.util.Scanner;
import java.io.*;

public class Diamonds
{
  public static void main(String[] args) throws IOException
  {
    Scanner in = new Scanner(new File("../diamonds.dat"));
    int num = in.nextInt();
    in.nextLine();
    for(int i = 0; i < num; i++)
    {
      
      String letter = in.next();
      int d =in.nextInt();
      in.nextLine();
      for(int r = 0; r <= d/2; r++)
      {
        for(int c = 0; c < d/2 - r; c++)
          System.out.print(" ");
        System.out.print(letter);
        for(int c = 0; c < d/2 + r; c++)
        {
          if (c == 2*r-1)
            System.out.print(letter);
          else
            System.out.print(" ");
        }
        System.out.println();
      }
      for(int r = d/2 - 1; r >= 0; r--)
      {
        for(int c = 0; c < d/2 - r; c++)
          System.out.print(" ");
        System.out.print(letter);
        for(int c = 0; c < 2*r; c++)
        {
          System.out.print(" ");
          if (c == 2*r - 2)
            System.out.print(letter);
        }
        System.out.println();
      }
    }
  }
  
  
}
import java.util.Scanner;
import java.io.*;

public class Elevator
{
  public static void main(String[] args) throws IOException
  {
    Scanner in = new Scanner(new File("../elevator.dat"));
    int num = in.nextInt();
    in.nextLine();// clear buffer
    final int MAX_WEIGHT = 2000;
    
    for (int i = 0 ; i < num; i++)
    {
      
      Scanner nLine = new Scanner(in.nextLine());  //Scan the scanner
      /* I chose to do this because otherwise it is 
       * difficult to tell when you are at the end of a
       * line.  The alternative was to read in the line
       * and use String.split() method and make an array
       * of String and then parseInt each one.  This seemed 
       * more intuitive.
       */
      int currentWeight = 0;
      int numStudents = 0;
      
      while (currentWeight < MAX_WEIGHT && nLine.hasNextInt())
      {
        int nextWeight = nLine.nextInt();
        if ( currentWeight + nextWeight <= MAX_WEIGHT)
        {
          currentWeight += nextWeight;
          numStudents++;
        }
        else
          break;
      }
      System.out.println(numStudents);
    }
  }
  
  
}
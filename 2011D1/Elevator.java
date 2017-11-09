import java.util.Scanner;
import java.io.*;

public class Elevator 
{
 public static void main(String[] args) throws IOException
 {
   Scanner in = new Scanner(new File("elevator.dat"));
   int numElevators = in.nextInt();
   in.nextLine();
   
   for(int i = 0; i < numElevators; i++)
   {
    Scanner line = new Scanner(in.nextLine());
    int totalWeight = 0;
    int numStudents = 0;
    while (totalWeight < 2000)
    {
      if(line.hasNextInt())
      {
        int nextWeight = line.nextInt();
        if(totalWeight + nextWeight <= 2000)
        {
          numStudents++;
          totalWeight += nextWeight;
        }
        else
          break;
      }
      else 
      {
        break;
      }
        
    }
    System.out.println(numStudents);
   }
   
 }
  
}
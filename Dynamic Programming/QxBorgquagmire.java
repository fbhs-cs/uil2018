import java.util.*;
import java.io.*;

public class QxBorgquagmire
{
  public static void main(String[] args) throws IOException
  {
    Scanner in = new Scanner(new File("qxborgquagmire.dat"));
    int n = in.nextInt();
    in.nextLine();
    while (n-->0)
    {
      TreeMap<String,Double> coins = new TreeMap<String,Double>();
      Scanner coinString = new Scanner(in.nextLine());
      while (coinString.hasNext())
      {
        String[] temp = coinString.next().split(":"); 
        coins.put(temp[0],Double.parseDouble(temp[1]));
      }
      double cost = in.nextDouble();
      double paid = in.nextDouble();
      double change = paid - cost;
      Double[] coinArray = coins.values().toArray(new Double[coins.values().size()]);
      
      
      in.nextLine();
    }
    
    
  }
  
}
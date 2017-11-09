import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class MPGCalc
{
  
 public static void main(String[] args) throws IOException
 {
   Scanner in = new Scanner(new File("../mpgcalc.dat"));
   int aMiles = in.nextInt();
   in.nextLine();
   int bMiles = in.nextInt();
   double gallons = in.nextDouble();
   String category = in.nextLine();
   
   ArrayList<String> cats = new ArrayList<String>();
   ArrayList<Double> gals = new ArrayList<Double>();
   ArrayList<Integer> miles = new ArrayList<Integer>();
   
   if (!cats.contains(category))
     cats.add(category);
   
   
 }
  
}
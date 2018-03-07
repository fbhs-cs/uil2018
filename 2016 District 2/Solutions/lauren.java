

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Lauren {
	public static void main(String [] args) throws FileNotFoundException {
        Scanner f = new Scanner(new File("lauren.dat"));
        //System.out.println("Enter the number of nodes in the graph");
        int N = f.nextInt();f.nextLine();
        while(N-- > 0) {
        	int numCities = f.nextInt();f.nextLine();
            HashMap<String, Integer> citiesLookup = new HashMap<String, Integer>();
            HashMap<Integer, String> cities = new HashMap<Integer, String>();
            for(int i = 0; i < numCities; i ++) {
            	String city = f.nextLine();
            	cities.put(i, city);
            	citiesLookup.put(city, i);
            }
            int adjMatrix[][] = new int[numCities + 1][numCities + 1];
            int numLinks = f.nextInt();f.nextLine();
            //System.out.println("Enter the adjacency matrix");
            for(int i = 0; i < numLinks; i ++) {
            	String city1 = f.next();
            	String city2 = f.next();
            	int distance = f.nextInt();
            	//System.out.println(city1 + " " + city2);
            	adjMatrix[citiesLookup.get(city1) + 1][citiesLookup.get(city2) + 1] = distance;
            	adjMatrix[citiesLookup.get(city2) + 1][citiesLookup.get(city1) + 1] = distance;
            }
            //System.out.println("the citys are visited as follows");
            TravelingSalesman travelingSalesman = new TravelingSalesman();
            ArrayList<Integer> sol = travelingSalesman.travel(adjMatrix);
            StringBuffer sb = new StringBuffer();
            for(Integer i: sol) {
            	sb.append(cities.get(i-1) + " => ");
            }
            sb.delete(sb.length()-4, sb.length());
            System.out.println(sb.toString());
        }
	}
}
 
class TravelingSalesman
{
    private int numberOfNodes;
    private Stack<Integer> stack;
 
    public TravelingSalesman()
    {
        stack = new Stack<Integer>();
    }
 
    public ArrayList<Integer> travel(int adjacencyMatrix[][])
    {
        numberOfNodes = adjacencyMatrix[1].length - 1;
        int[] visited = new int[numberOfNodes + 1];
        visited[1] = 1;
        stack.push(1);
        int element, dst = 0, i;
        int min = Integer.MAX_VALUE;
        boolean minFlag = false;
        //System.out.print(1 + "\t");
        ArrayList<Integer> solution = new ArrayList<Integer>();
        solution.add(1);
        while (!stack.isEmpty())
        {
            element = stack.peek();
            i = 1;
            min = Integer.MAX_VALUE;
            while (i <= numberOfNodes)
            {
                if (adjacencyMatrix[element][i] > 1 && visited[i] == 0)
                {
                    if (min > adjacencyMatrix[element][i])
                    {
                        min = adjacencyMatrix[element][i];
                        dst = i;
                        minFlag = true;
                    }
                }
                i++;
            }
            if (minFlag)
            {
                visited[dst] = 1;
                stack.push(dst);
                //System.out.print(dst + "\t");
                solution.add(dst);
                minFlag = false;
                continue;
            }
            stack.pop();
        }
        return solution;
    }   
}
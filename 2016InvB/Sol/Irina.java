
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 
 * @author sno
 *
 * Given the weights and denominations of various bags of money, determine how much money each
 * one holds and the maximum amount that can be stolen with exceeding a weight limit.
 */
public class Irina {
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner f = new Scanner(new File("irina.dat"));
		int N = f.nextInt();f.nextLine();
        int W = 45;   // maximum weight of knapsack
        
        while(N-- >0) {
        	maxProfit = 0.0;
        	sol = null;
        	int numItems = f.nextInt();f.nextLine();
        	 double[] profit = new double[numItems];
        	 String[] coins = new String[numItems];
             int[] weight = new int[numItems];

             for (int i = 0; i < numItems; i++) {
            	 int kgs = f.nextInt();
            	 coins[i] = f.next();
                 weight[i] = kgs;
                 profit[i] = (double)(kgs)/getWeight(coins[i])*getDenomination(coins[i]);
                 //System.out.println(weight[i] + " " + profit[i]);
             }
             fan(profit, weight, numItems, W, 0, 0.0, new boolean[numItems], 0);
             ArrayList<SortObject> solution = new ArrayList<SortObject>();
             for(int i = 0; i < numItems; i++) {
            	 if(sol[i]) {
            		 solution.add(new SortObject(weight[i], coins[i]));
            	 }
             }
             Collections.sort(solution);
             for(SortObject o: solution) {
            	 System.out.println("GRAB THE " + o.weight + " KG BAG OF " + (o.denomination).toUpperCase()); 
             }
             System.out.println();
        }
	}
	public static double maxProfit = 0.0;
	public static boolean[] sol = null;
	
	/* attempts to add all the combinations */
	public static void fan(double[] profits, int[] weight, int maxItems, int maxWeight, 
			int curWeight, double curProfit, boolean [] curSol, int index) {
		
		if(curWeight > maxWeight) {
			//invalid solution
			return;
		}
		
		if(index == maxItems) {
			if(curProfit > maxProfit) {
				sol = curSol;
				maxProfit = curProfit;
			}
			return;
		}
		
		//don't take item
		fan(profits, weight, maxItems, maxWeight, curWeight, curProfit, curSol, index + 1);
		
		//take item
		boolean [] takeItem = copy(curSol);
		takeItem[index] = true;
		fan(profits, weight, maxItems, maxWeight, curWeight + weight[index], curProfit + profits[index], takeItem, index + 1);
		
	}
	
	public static boolean[] copy(boolean[] bools) {
		boolean [] c = new boolean[bools.length];
		for(int i = 0; i < bools.length; i++) {
			c[i] = bools[i];
		}
		return c;
	}
	
	public static double getDenomination(String coin) {
		switch(coin) {
			case "PENNIES": return 0.01;
			case "NICKELS" : return 0.05;
			case "DIMES" : return 0.1;
			case "QUARTERS" : return 0.25;
			case "DOLLARS" : return 1.0;
		}
		return 0.0;
	}
	
	public static double getWeight(String coin) {
		switch(coin) {
			case "PENNIES": return 2.5/1000;
			case "NICKELS" : return 5.0/1000;
			case "DIMES" : return 2.25/1000;
			case "QUARTERS" : return 5.6/1000;
			case "DOLLARS" : return 8.1/1000;
		}
		return 0.0;
	}
}

class SortObject implements Comparable<SortObject>{
	int weight;
	String denomination;
	@Override
	public int compareTo(SortObject o) {
		int compareWeights = o.weight - this.weight;
		if(compareWeights != 0) {
			return compareWeights;
		}
		return (int)(Irina.getDenomination(o.denomination)*100 - Irina.getDenomination(this.denomination)*100); 
	}
	public SortObject(int w, String d) {
		this.weight = w;
		this.denomination = d;
	}
}
/*
Test data:
10
3
40 DOLLARS
15 DIMES
4 DOLLARS
10
15 DIMES
4 DOLLARS
300 PENNIES
7 DOLLARS
5 QUARTERS
45 QUARTERS
40 NICKELS
40 PENNIES
35 NICKELS
20 QUARTERS
5
20 QUARTERS
26 DIMES
11 NICKELS
11 DIMES
12 NICKELS
5
25 QUARTERS
25 DIMES
15 NICKELS
15 DIMES
17 NICKELS
7
10 PENNIES
11 PENNIES
12 PENNIES
13 PENNIES
14 PENNIES
15 PENNIES
16 PENNIES
5
5 PENNIES
5 DIMES
5 QUARTERS
5 NICKELS
5 DOLLARS
6
50 PENNIES
50 DIMES
50 QUARTERS
50 NICKELS
50 DOLLARS
1 PENNIES
10
15 QUARTERS
45 DOLLARS
45 DIMES
5 DOLLARS
5 QUARTERS
45 QUARTERS
40 NICKELS
40 PENNIES
35 NICKELS
20 QUARTERS
10
43 QUARTERS
44 DIMES
45 DIMES
1 DOLLARS
5 QUARTERS
45 QUARTERS
40 NICKELS
40 PENNIES
35 NICKELS
20 QUARTERS
1
20 PENNIES

Test output:
GRAB THE 40 KG BAG OF DOLLARS
GRAB THE 4 KG BAG OF DOLLARS

GRAB THE 20 KG BAG OF QUARTERS
GRAB THE 7 KG BAG OF DOLLARS
GRAB THE 5 KG BAG OF QUARTERS
GRAB THE 4 KG BAG OF DOLLARS

GRAB THE 26 KG BAG OF DIMES
GRAB THE 11 KG BAG OF DIMES

GRAB THE 25 KG BAG OF QUARTERS
GRAB THE 15 KG BAG OF DIMES

GRAB THE 16 KG BAG OF PENNIES
GRAB THE 15 KG BAG OF PENNIES
GRAB THE 14 KG BAG OF PENNIES

GRAB THE 5 KG BAG OF DOLLARS
GRAB THE 5 KG BAG OF QUARTERS
GRAB THE 5 KG BAG OF DIMES
GRAB THE 5 KG BAG OF NICKELS
GRAB THE 5 KG BAG OF PENNIES

GRAB THE 1 KG BAG OF PENNIES

GRAB THE 45 KG BAG OF DOLLARS

GRAB THE 44 KG BAG OF DIMES
GRAB THE 1 KG BAG OF DOLLARS

GRAB THE 20 KG BAG OF PENNIES

*/
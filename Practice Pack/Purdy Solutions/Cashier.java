import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;

public class Cashier {

	public static void main(String[] args) throws IOException {
		
		Scanner in = new Scanner(new File("Cashier.dat"));
		int n = Integer.parseInt(in.nextLine());
		while(n-->0)
		{
			double price = in.nextDouble();
			double paid = in.nextDouble();
			in.nextLine(); // throw away the \n
			String coins = in.nextLine();
			Scanner coinReader = new Scanner(coins);
			ArrayList<Integer> coinList = new ArrayList<Integer>();
			while (coinReader.hasNextInt())
				coinList.add(coinReader.nextInt());
			
			
			int change = (int)(paid - price)*100;
			int[][] matrix = new int[coinList.size()+1][change+1];
			//System.out.println(coinList);
			
			for(int i = 0; i <= coinList.size();i++)
			{
				for(int j = 0; j<= change;j++)
				{
					if(i==0 || j==0)
						matrix[i][j] = 0;
					
					else 
					{
						if (coinList.get(i-1) <= j)
						{
							if(matrix[i-1][j]==0) {
								matrix[i][j] = j / coinList.get(i-1);
								//System.out.println(matrix[i][j]);
							}
							else
								matrix[i][j] = Math.min(matrix[i-1][j], j/coinList.get(i-1)+matrix[i-1][j-coinList.get(i-1)]);
					
						}
					}
				}
			}
			
			
			if (matrix[coinList.size()][change] == 0)
				System.out.println("CANNOT CREATE EXACT CHANGE");
			else
				System.out.println(matrix[coinList.size()][change]);
			
		}

	}

}

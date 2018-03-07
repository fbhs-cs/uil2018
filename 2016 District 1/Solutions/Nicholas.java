import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.*;
/**
 * Solution to Nicholas, UIL District 1, 2016
 * @author Owen
 
Nicholas is learning about how to manually count path lengths using adjacency matrices, but still needs your
help to confirm his counting.  He started with the simple two vertex graph shown, which produces the following 
adjacency matrix:

  A B
A 1 1
B 1 0

He has learned that this matrix means that given two vertices A and B in the graph displayed, there is a connection from A back to itself, 
and a two-way connection from A to B.  To count the number of paths of length one, or direct connections in
the graph, all he has to do is count the number of 1s in the graph, three in this case, represented in letter
notation as AA, AB, and BA. AA means that the connection starts and ends at A, AB means it starts at A and
ends at B, and so on.

However, counting the number of two-hop paths is a little more involved.  He can see that AAA is a possibility,
and then ABA, and then BAB, but wonders if AA could be a part of a path, since it counted in the first example. 
His teacher says, yes, it can, so he adds AAB and BAA, making a total of 5 2-hop paths.

"What about 3-hop paths?", he wonders. Hmmm, let's see, starting from A there would be AAAA, AAAB, AABA, ABAA, and ABAB.
Starting from B, the 3-hop paths are BAAA, BAAB, and BABA. All totaled, that would be 8 3-hop paths within this graph.

Your job is to take any graph with at least two, but no more than five vertices, and help Nicholas confirm his
counting of the number of paths of any length from 1 to 3 hops.

Input: Several lines of data, each consisting of an integer N indicating an NXN size matrix, followed by an 
integer P, the path length to calculate, followed by N strings, each of length N, containing 0s and 1s, 
indicating the adjacency matrix for the graph.

Output: The number of P length paths in the given matrix.
 
Sample Input:
2 1 11 10
2 2 11 10
2 3 11 10
3 1 111 001 001
4 2 0100 0010 0001 1000

Sample Output:
3
5
8
5
4

 */
public class Nicholas {
	
	static Scanner k;
	public static void main(String [] args) throws FileNotFoundException {
		Scanner f = new Scanner(new File("nicholas.dat"));
		k = new Scanner(in);
		while(f.hasNext()) 
		{
			args=f.nextLine().split(" ");
			int N = Integer.parseInt(args[0]);
			int P = Integer.parseInt(args[1]);
			int[][] M1 = new int[N][N];
			int[][] M2 = new int[N][N];
//			out.println(P);
			for(int x=0;x<N;x++)
			{
				String s = args[x+2];
				for(int y=0;y<s.length();y++)
					M1[x][y]=s.charAt(y)-48;
			}
			if(P==1){
//				showM(M1);
				out.println(countM(M1));
			}
			else
				if(P==2)
				{
					M2 = mult(M1,M1);
//					showM(M2);
					out.println(countM(M2));
				}
			else
				if(P==3)
				{
					M2 = mult(M1,M1);
					M2 = mult(M1,M2);
//					showM(M2);
					out.println(countM(M2));
				}

//			k.nextLine();
		}
	}
	static int[][] mult(int[][]m1,int[][]m2)
	{
		int[][]m=new int[m1.length][m1.length];
			for(int x=0;x<m.length;x++)
				for(int y=0;y<m.length;y++)
				{
					int sum=0;
					for(int z=0;z<m.length;z++)
						sum+=m1[x][z]*m2[z][y];
					m[x][y]=sum;
				}
		return m;
	}
	static int countM(int[][]m)
	{
			int count = 0;
			for(int x=0;x<m.length;x++)
				for(int y=0;y<m.length;y++)
					count+=m[x][y];
			return count;
	}
	static void showM(int[][]M){
		for(int x=0;x<M.length;x++)
			{
				for(int y=0;y<M.length;y++)
				 out.print(M[x][y]);
				out.println();
			}
	}

}
/*
Input
2 1 11 10
2 2 11 10
2 3 11 10
3 1 111 001 001
4 2 0100 0010 0001 1000
4 1 0110 0010 1001 1000
3 3 011 001 000
3 2 111 011 001
4 1 0100 0011 0001 1100
4 3 0110 0111 1001 1100
3 2 111 111 111
5 3 11011 00101 10000 00101 11000
5 1 11011 00101 10000 00101 11000
5 2 01010 10011 01000 10100 10010
5 3 01000 00000 01000 11101 10000

Output
3
5
8
5
4
6
0
10
6
49
27 
65
11
21
1

*/
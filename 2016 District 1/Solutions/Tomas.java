import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.*;
/**
 * Solution to Tomas, UIL District 1, 2016 - Tribonacci
 * @author Owen
 In doing some unusual scientific research, Tomas has discovered a peculiar sequence in various naturally occurring situations,
 where certain measurements of growth produce the consistent pattern 1, 1, 1, 3, 5, 9, 17, and so on.  He has
 recorded the data in stages, where stages 1, 2, and 3 are all value 1, and then stage 4 begins showing observable
 growth with the value 4, stage 5 the value 5, and so on.  He wants to predict any particular stage, and needs
 your help. For example, he wants to know what the value would be at stage 10 of this growth pattern.
 
Input: Several integer values N (1 <= N <= 50), each representing a stage of growth according to the pattern described above, each on one line.

Output: The growth size achieved at stage N in the growth pattern described above.
 
Sample Input:
1
3
5
7
9

Sample Output:
1
1
5
17
57


 */
public class Tomas {
	
	static Scanner k;
	public static void main(String [] args) throws FileNotFoundException {
		Scanner f = new Scanner(new File("tomas.dat"));
		k = new Scanner(in);
		BigInteger[] b = new BigInteger[51];
		b[1]=new BigInteger("1");
		b[2]=new BigInteger("1");
		b[3]=new BigInteger("1");
		for(int x=4;x<51;x++)
			b[x]=b[x-1].add(b[x-2].add(b[x-3]));
			
		while(f.hasNext()) 
		{
			int N = f.nextInt();
			out.println(b[N]);
		}
	}
}
/*
Input
1
3
5
7
9
10
20
30
40
50

Output
1
1
5
17
57
105
46499
20603361
9129195487
4045078385041

*/
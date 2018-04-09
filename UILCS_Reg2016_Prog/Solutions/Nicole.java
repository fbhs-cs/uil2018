/**
Nicole has been studying the Fibonacci sequence and has decided to come up with her own sequence, 
the "Nicole" series, but different each time based on new values. She decides to see what it would 
look like if she started with any three numbers and create a fourth one as the sum of the first three, 
minus 3. For example, if the first three values are 1, 0 and 4, the fourth value would be 1+0+4-3, 
which equals 2. The next value would be the sum of 0, 4 and 2, less 3, which would be 3. The next 
one would be 4+2+3-3 which is 6, and so on and on. The first 9 values in the series would 
be: 1, 0, 4, 2, 3, 6, 8, 14, 25, ...

Input - Several data sets of four integers A, B, C, and N, all on one line with single space separation.
Each integer A, B, and C can be any positive or negative value within the range -100...100, value, and 
which start a "Nicole" series, with the fourth integer N (2<=N<=20) indicating the value of that series 
to output.

Output - The Nth value of the "Nicole" series for the three given values.

Sample data:
1 0 4 9
1 1 2 5

Sample Output:
25
1

 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static java.lang.System.*;
public class Nicole {
	public static void main(String [] args) throws FileNotFoundException {
		Scanner f = new Scanner(new File("nicole.dat"));
		while(f.hasNext()) {
			int a = f.nextInt();
			int b = f.nextInt();
			int c = f.nextInt();
			int z = f.nextInt();
			out.println(nicole(a,b,c,z-3));
		}
	}
	static int nicole(int a, int b, int c, int z)
	{
//		out.println(a+" "+b+" "+c+" "+z);
		if(z<=1)
			return a+b+c-3;
		return nicole(b,c,a+b+c-3,z-1);
	}
}
/*
Test data:
1 0 4 9
1 1 2 5
1 1 1 10
1 3 5 12
-1 -2 -3 10
2 4 6 8
5 10 15 6

Test Output:
25
1
-51
670
-386
91
88

*/
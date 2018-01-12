/*
UIL Invitational B, 2016, Grace - Solution

Grace is just learning to program, and is exploring how to do some simple math.  The program she is solving
inputs an integer, and outputs the square of it if the number is divisible by 3, the square root of it if
the number has a remainder of 1 after being divided by 3, or the cube root of it if the remainder is 2, again after
dividing by 3. She has decided to format all of the values to one place of precision.

Your challenge is to write a program to help solve Grace's problem.

Input: Several integers N (0<N<=10000) arranged vertically in a data file.

Output: A value for each integer, as indicated above (square, square root, or cube root), as shown below.

Sample input:
9
10
11

Sample output:
81.0
3.2
2.2

*/
import java.util.*;
import java.io.*;
import java.util.function.*;
import static java.lang.System.*;
public class Grace
{
	public static void main(String...grrr) throws IOException
	{
		Scanner f = new Scanner(new File("grace.dat"));
		while(f.hasNext()){
			int n = f.nextInt();
			switch(n%3)
			{
				case 0:out.printf("%.1f\n",Math.pow(n,2));break;
				case 1:out.printf("%.1f\n",Math.sqrt(n));break;
				case 2:out.printf("%.1f\n",Math.cbrt(n));break;
			}
		}
	}
}
/*
Test data
9
10
11
1000
10000
9999
9998

Test output
81.0
3.2
2.2
31.6
100.0
99980001.0
21.5
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.*;
/**
 * Solution - Yash, UIL District 1, 2016
 * @author Owen

Yash has just learned about Order of Magnitude and wants to work out the numbers.
For example, he knows that any algorithm with an efficiency of O(1) takes generally 1 step to complete,
with varying values for the other levels of efficiency, such as O(log n), O(N), O(NlogN), and O(N^2).
He learned in class that for a data set of 10 items, these five values are 1, 4, 10, 40, and 100.
He was bit confused by O(log N), until his teacher said, "Think about the exponent for the power of 2 that equals or just exceeds 10."
He thought, "OK, 2^1 is 2, 2^2 is 4, 2^3 is 8, and 2^4 is 16.  That's why 4 is the log base 2 answer for the value 10!  I get it! It's just the exponent using base 2."

He then tried to work out higher values of N, but started to get confused, and needs your help.
 
Input: Several integers N, each on one line, representing the number of elements of data to be processed by an algorithm.

Output: The five values associated with five levels of Big O algorithm efficiency, as described above, for each value N, 
with values exceeding 999 shown using comma separation, and a single space between each value.

Sample Input:
10
50
100

Sample Output:
1 4 10 40 100
1 6 50 300 2,500
1 7 100 700 10,000
 
 */
public class Yash {
	public static void main(String [] args) throws FileNotFoundException {
		Scanner f = new Scanner(new File("yash.dat"));
		while(f.hasNext()) 
		{
			int a = f.nextInt();
			out.printf("%,d %,d %,d %,d %,d\n",1,log2(a),a,a*log2(a),(int)Math.pow(a,2));
		}
	
	}
	static int log2(int x)
	{
		int count=0;
		while(x>0){
			count++;
			x/=2;
		}
		return count;
	}
}

/*
Test Data
10
50
100
127
128
129
500
1000
5000
10000

Test Output
1 4 10 40 100
1 6 50 300 2,500
1 7 100 700 10,000
1 7 127 889 16,129
1 8 128 1,024 16,384
1 8 129 1,032 16,641
1 9 500 4,500 250,000
1 10 1,000 10,000 1,000,000
1 13 5,000 65,000 25,000,000
1 14 10,000 140,000 100,000,000
*/
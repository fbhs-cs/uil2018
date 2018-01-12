/*
UIL Invitational B, 2016, Adam - Solution

Lambda expressions are now available in Java 8!  Below is a program that uses the BiFunction lambda expression provided in the java.util.function package.  
The program reads a series of pairs of values and outputs true or false, indicating if the first value is greater than the second value.
You may use the BiFunction lambda expression to solve this problem, or if you're not using Java 8, an alternate solution is shown. 
Ultimately, it is up to you as to how you will solve it.  Have fun!

Input: Several pairs of integers, each pair on one line, separated by a single space.  

Output: The word "true" or "false", indicating whether the first integer of each pair is greater than the second integer.

Sample input:
1 2
2 1
14 -14
100 200

Sample output:
false
true
true
false

*/
import java.util.*;
import java.io.*;
import java.util.function.*;
import static java.lang.System.*;
public class Adam
{
	public static void main(String...args) throws IOException
	{
		Scanner f = new Scanner(new File("adam.dat"));
		BiFunction<Integer,Integer,Boolean> match = (Integer a, Integer b)->a.compareTo(b)>0;
		while(f.hasNext()){
			Integer x = f.nextInt();
			Integer y = f.nextInt();
			out.println(match.apply(x,y));
//			out.println(x.compareTo(y)>0);//non-lambda solution
		}
	}
}
/*
Test data
1 2
2 1
14 -14
100 200
500 1000
10000 32767
100000 89
2147483647 -2147483648

Test output
false
true
true
false
false
false
true
true

*/
/*
UIL Invitational A, 2016, Program Nine - 'Rithmetic

This is an easy one. Just write a program that does some simple 'rithmetic!

Input: An initial value N, followed by N pairs of positive integers A and B, with 0 < A <100,000 and 0 < B <100,000.

Output: The positive sum, difference, product, and quotient (formatted to two places) of each integer pair.  

Sample Input:
4
10 4
14 20
25 15
100 34

Sample Output:
14 6 40 2.50
34 6 280 1.43
40 10 375 1.67
134 66 3400 2.94

*/
import java.util.*;
import java.io.*;
import static java.lang.System.*;
public class A_Nine
{
	public static void main(String...yarn) throws IOException{
		Scanner f = new Scanner(new File("a_nine.dat"));
		int n = f.nextInt();
		while(n-->0)
		{
			int a=f.nextInt();
			int b=f.nextInt();
			out.print(a+b+" ");
			out.print((a>b?a-b:b-a)+" ");
			out.print(a*b+" ");
			out.printf("%.2f\n",a>b?(double)a/b:(double)b/a);
		}
	}
}
/*
8
10 4
14 20
25 15
100 34
100000 8
80 100000
888 999
7153 92836

14 6 40 2.50
34 6 280 1.43
40 10 375 1.67
134 66 3400 2.94
100008 99992 800000 12500.00
100080 99920 8000000 1250.00
1887 111 887112 1.13
99989 85683 664055908 12.98


*/
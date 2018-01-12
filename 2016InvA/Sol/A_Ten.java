/*
UIL Invitational A, 2016, Program Ten - Abundance

An abundant number is one whose sum of all proper divisors is greater than the number itself.
The first such number is 12, where 1+2+3+4+6 equals 16, which is greater than 12. Others include 18, 20, 24, 30, and so on.
Given an input value N, find and output the largest abundant number less than N.

Input: A data file with several values of N, all on one line, each separated by
a single space.

Output: The value N, followed by the largest abundant number less than N, formatted as shown below.

Sample input:
15
20
50
107
4050

Sample output:
12
18
48
104
4048

*/
import java.util.*;
import java.io.*;
import static java.lang.System.*;
class A_Ten
{
	static char[]list;
	static Scanner k;
	public static void main(String...bean) throws IOException{
		k = new Scanner(in);
		Scanner f = new Scanner(new File("a_ten.dat"));
		list=new char[100000];
		while(f.hasNext())
			{
			int b=f.nextInt();
			int largest=2;
			for(int x=12;x<b;x++)
				if(x>=largest&&isAbundant(x))
					largest=x;
			out.println(largest);				
			}
		}
	
	public static boolean isAbundant(int n){
		int divSum=1;
		for(int x=2;x<n;x++)
			if(n%x==0)
				divSum+=x;
		return divSum>n;
	}
}
/*
15
20
50
107
4050
155
372
500
625
616
690
850
1000
10000
32767
100000

12
18
48
104
4048
150
368
498
624
612
684
846
996
9996
32766
99996
*/
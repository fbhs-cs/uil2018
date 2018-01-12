/*
UIL Invitational A, 2016, Program Two

Twin Primes - Two consecutive odd numbers that are both prime numbers
are called twin primes. For example, 5 and 7 are twin primes.  So are 17 and 19.

Given an input integer N, find the largest pair of twin primes, both of which
are less than N.

Input: A data file with several values of N, all on one line, each separated by
a single space.

Output: The value N, followed by the largest pair of twin primes less than N.

*/
import java.util.*;
import java.io.*;
import static java.lang.System.*;
class A_Two
{
	static Scanner k;
	public static void main(String...bean) throws IOException{
		k = new Scanner(in);
		Scanner f = new Scanner(new File("a_two.dat"));
		while(f.hasNext())
			{
			int b=f.nextInt();
			int largest=2;
			for(int x=2;x<b-2;x++)
				if(x>=largest&&isPrime(x)&&isPrime(x+2))
					largest=x;
			out.println(largest+" "+(largest+2));				
			}
		}
	
	public static boolean isPrime(int n){
		for(int x=2;x<n/2;x++)
			if(n%x==0)
				return false;
		return true;
	}
}
/*
10
20
372
625
107
616
690
155
850
4050

5 7
17 19
347 349
617 619
101 103
599 601
659 661
149 151
827 829
4019 4021

*/
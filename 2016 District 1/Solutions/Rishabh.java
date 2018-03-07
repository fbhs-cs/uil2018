import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.*;
/**
 * Solution to Rishabu, UIL District 1, 2016 - Parity
 * @author Owen
 
In researching the concept of string parity, Rishabh encountered some work done by Richard Hamming in 1950. His work
produced an innovative way to improve this error-checking process to ensure data is accurately and reliably
transmitted.

Parity is often referred to as ODD or EVEN, by adding up the bit values in a string.  If it is agreed that EVEN
parity will be used, the string 10110101, which has 5 bits, is appended with the value 1 to make the total number 
of bits even. If ODD parity is agreed upon, the same string would be appended with a 0, to maintain an odd total
for all of the bits, resulting in 101101010 as the transmitted string.

Hamming's work produced not only a way to check IF there is an error, but WHERE the error is in the string.  Supposedly,
a parity code based on Hamming's technique is said to be a perfect code. 

Here is an example using even parity.  For a string of bits of length 8, which is 2^3, 4 bits can be added to create Hamming parity string.
The rule for 2^N bits is to add N+1 bits to the string. The bits added are in the positions 1, 2, 4, 8 and so on,
with the actual data bits starting in position 3, then 5, 6, 7, 9, 10, ... and so on. For the string 10110101,
which can be represented by the hex string B5, the Hammond parity string would start out as:

1 2 3 4 5 6 7 8 9 10 11 12
_ _ 1 _ 0 1 1 _ 0  1  0  1  

To find the bit value in position 1, add up all of the odd position bits, with any blank counting as a zero.
This would be 0+1+0+1+0+0, for a total of 2, which is even, therefore no bit needs to be added, making the value
of position 1 zero.

1 2 3 4 5 6 7 8 9 10 11 12
0 _ 1 _ 0 1 1 _ 0  1  0  1  

To find the bit value in position 2, start at position 2 and use two bits, then skip 2, use 2, skip 2, and so on
resulting in summing the values in positions 2, 3, 6, 7, 10, and 11, for a sum of 0+1+1+1+1+0, or 4, again even parity
resulting in zero for position 2.

1 2 3 4 5 6 7 8 9 10 11 12
0 0 1 _ 0 1 1 _ 0  1  0  1  

To find the bit value in position 4, start at position 4 and use 4 bits, then skip 4, use 4, skip 4, and so on
resulting in summing the values in positions 4,5,6,7, and 12, for a sum of 0+0+1+1+1, or 3, needing a 1 in position 4 to make it even parity.

1 2 3 4 5 6 7 8 9 10 11 12
0 0 1 1 0 1 1 _ 0  1  0  1  

The value of the 8 bit would use the same pattern as the others: use 8, skip 8, and so on, summing the bits
in positions 9, 10, 11, and 12, for a total of 2, even parity and zero for position 8.

1 2 3 4 5 6 7 8 9 10 11 12
0 0 1 1 0 1 1 0 0  1  0  1  

The added parity bits in positions 1, 2, 4, and 8 are: 0010.

For odd parity, the example above would result in: 

1 2 3 4 5 6 7 8 9 10 11 12
1 1 1 0 0 1 1 1 0  1  0  1  

for an odd parity bit string of 1101.

Using the initial hex value CF results in the string 11001111, which when the Hammond technique is applied 
produces the string 011010001111, with the values in the parity positions of 1, 2, 4 and 8 being 0100. 
The odd parity string would be 1011.

For the initial string F, or 1111, results in the even parity bits of 111, or odd parity bits of 000.

Input: Several strings in hex form, each followed by the word EVEN or ODD, to indicate the parity to use. 
It is guaranteed that the hex string will produce no more than 128 bits.

Output: The resulting Hammond parity string for the given hex string.
 
Sample Input:
B5 EVEN
B5 ODD
CF EVEN
F EVEN
ABC ODD

Sample Output:
0010
1101
0100
111
11101

 */
public class Rishabh {
	
	static Scanner k;
	public static void main(String [] args) throws FileNotFoundException {
		Scanner f = new Scanner(new File("rishabh.dat"));
		k = new Scanner(in);
		while(f.hasNext()) 
		{
			args=f.nextLine().split(" ");
			String hex = args[0];
			String par = args[1];
			
			String bin = Long.toBinaryString(Long.parseLong(hex,16));
			if(hex.charAt(0)<'2')
				bin="000"+bin;
			else
			if(hex.charAt(0)<'4')
				bin="00"+bin;
			else
			if(hex.charAt(0)<'8')
				bin="0"+bin;
			int N = hex.length();
			int P = log2(N);
			char[] c = new char[hex.length()*4+2+P];//create Hammond char array
			Arrays.fill(c,'-');
			c[0]='*';
			int p=1;
			int b=0;
			for(int x=1;x<c.length;x++)
				if(x==p){
					c[p]='@';
					p*=2;
				}
				else
					if(b<bin.length())
						c[x]=bin.charAt(b++);
			//process parity bits
			String ans="";
			p = 1;
			while(p<=Math.pow(2,P))
			{
				int use = 2*p;
				int sum=0;
				for(int i = p;i<c.length;)
				{
					
					if(i<use&&i<c.length)
					{
						if(c[i]=='1')
							sum++;
						i++;
					}
					else {
						use+=p;i=use;use+=p;}
				}
				char d = sum%2==0?'0':'1';
				if(par.equals("ODD"))
					d=sum%2==1?'0':'1';
				if(p<c.length)
				{	c[p]=d;
					ans+=d;
				}
				p*=2;
			}
			out.println(ans);
		}

	}
	static int log2(int n)
	{
		int x=0;
		while(Math.pow(2,x++)<n);
		return x+1;
	}
	}
/*
Input
B5 EVEN
B5 ODD
CF EVEN
F EVEN
ABC ODD
F ODD
22 EVEN
2A EVEN
0 ODD
AAAAAAA ODD
1 ODD
12EF EVEN
2020 ODD
FFFFF EVEN
ABCDEF ODD
123456789ABCDEF EVEN

Output
0010
1101
0100
111
11101
000
1011
0010
111
110100
000
00000
01101
01111
01011
1110011

*/
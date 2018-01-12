/*
UIL Invitational B, 2016, Eun-suh - Solution

Eun-suh has learned a fun new game with digit sequences, and is trying to write a program to simulate this game.  
Your job is to help her in this effort!

The rules are:
Given a sequence of digits, modify the sequence by:
Deleting all zeroes, if any, and all digits to the left of the zeroes.
Find the largest remaining digit and reduce it by 1 if it is odd, or by 2 if it is even.  
If there are two or more instances of the largest remaining digit, use the rightmost one as the largest.
Repeat these steps until the sequence of digits is completely deleted.

For example, for the starting sequence 3580254, the first step reduces it to 254, removing the zero and all digits to the left of the zero.
Next comes 244, where the largest digit 5 is reduced by 1 to 4, then 242, 222, 220, and then an empty sequence, for a total of 6 moves.
The sequence 830751 first becomes 751, then 651, 451, 441, 421, 221, 201, 1, 0, and finally empty, taking a total of 10 moves.

Input: Several sequences of digits, each on one line.

Output: The number of moves it takes to completely remove all the digits from the sequence.

Sample input:
3580254
830751
550604

Sample output:
6
10
4

*/
import java.util.*;
import java.io.*;
import java.util.function.*;
import static java.lang.System.*;
public class EunSuh
{
	public static void main(String...eui) throws IOException
	{
		Scanner f = new Scanner(new File("eunsuh.dat"));
		while(f.hasNext()){
			String s=f.next();
			int steps=0;
			while(s.length()>0){
				int i = s.lastIndexOf("0");
				if(i>=0)
					s=s.substring(i+1);
				else
				{
					i=findLargest(s);
					int d = s.charAt(i)-48;
					if(d%2==0)
						d-=2;
					else
						d-=1;
					s=s.substring(0,i)+d+s.substring(i+1);
				}
				steps++;
			}
			out.println(steps);
			
		}
	}
	static int findLargest(String s)
	{
		int largest=0;
		for(int x=1;x<s.length();x++)
			if(s.charAt(x)>=s.charAt(largest))
				largest=x;
		return largest;
	}
}
/*
Test data
3580254
830751
550604
135860
2040114
00050114
52365
0135752

Test output
6
10
4
1
4
4
9
11

*/
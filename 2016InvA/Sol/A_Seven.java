import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.*;
/**
UIL 2016 Invitational A, Program Seven
Mediant

In music, a mediant is the third tone of a major scale, sung in solfege as mi.  
In math there is likely no such thing as a mediant, but for now, we'll define one.

A mediant is a number that is a variation of another, based on the median of the digits of the number, 
according to the following rules:

	First find the median of the digits, then find the digit in the number which is closest to
	but not larger than the median value, and then change that digit according to the following rules.
	If that digit is 0, 1, or 2, replace it with the largest digit in the number.
	If that digit is 3, 4, or 5, replace it with the smallest digit in the number.
	If that digit is 6, 7, or 8, replace it with the ones place of the sum of the digits.
	If that digit is 9, replace it with 0.
	
For example, the median of the value 123 is 2, which is replaced by 3, the largest digit of the number.
The value 745 becomes 744 since the median is 5, which is replaced by 4, the smallest digit.
	
Input: A series of positive values between 99 and 10000, exclusive.
Output: The mediant of each value, according to the rules listed above.
	
Sample Input: 
123
745
1689
9999

Sample output:
133
744
1489
999 (note: 0999 is incorrect)


Test Input: 
123
745
1689
9999
879
12345
7652
17359
7699

Test output:
133
744
1489
999
479
12145
7622
17319
1699

 */
public class A_Seven {
	public static void main(String...ofPearls) throws IOException {
		Scanner f = new Scanner(new File("a_seven.dat"));
		while(f.hasNext())
		{
			String s = f.next();
			ofPearls=s.split("");
			//find median
			int[]sorted=new int[ofPearls.length];
			for(int x=0;x<ofPearls.length;x++)
				sorted[x]=Integer.parseInt(ofPearls[x]);
			Arrays.sort(sorted);
			//find sum
			int sum=0;
			for(int i:sorted)
				sum+=i;
			sum%=10;
			double median=(sorted.length%2==0)
				?(sorted[sorted.length/2]+sorted[sorted.length/2-1])/2
				:sorted[sorted.length/2];
			int med=0;
			for(int i:sorted)
				if(i>med&&i<=median)
					med=i;
			int medPos=0;
			for(int x=0;x<ofPearls.length;x++)
				if(ofPearls[x].equals(""+med))
				{medPos=x;break;}
			//find large, small
			int large=0;
			int small=0;
			int x=0;
			for(String t:ofPearls)//find leftmost largest position
			{
				int i = Integer.parseInt(t);//integer value of current String
				int l = Integer.parseInt(ofPearls[large]);//int value of large
				int sm = Integer.parseInt(ofPearls[small]);//int value of small
				if(i>l)//if current value is larger than large value
					large=x;//reassign position to current
				if(i<sm)//if current value is smaller than small value
					small=x;//reassign position to current
				x++;
			}
		
			if(med==0||med==1||med==2)
				ofPearls[medPos]=ofPearls[large];
			else
			if(med==3||med==4||med==5)
				ofPearls[medPos]=ofPearls[small];
			else
			if(med==6||med==7||med==8)
				ofPearls[medPos]=""+sum;
			else
				ofPearls[medPos]="0";
			String ans="";
			for(String z:ofPearls)
				ans+=z;
			out.println(Integer.parseInt(ans));
		}
		//
	}
}

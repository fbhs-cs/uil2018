import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.*;
/**
 * Solution to Isabel, UIL District 2, 2016
 * @author Owen
In computer science class, Isabel has been studying binary numbers, and has made up a 
game to practice her binary skills.

She understands the binary place value system, where the first (rightmost) column is 
worth 1, the second worth 2, and then 4, 8, and so on.

She has decided to label these columns A, B, C, and so on, with A being the label for the 
rightmost ones place, B the 2s place, etc.

It helps her to see the whole picture when she arranges the numbers in column format, 
like this:

C B A   Base ten value
0 0 0 =     0
0 0 1 =     1
0 1 0 =     2
0 1 1 =     3
1 0 0 =     4
1 0 1 =     5
1 1 0 =     6
1 1 1 =     7

She sees that for this range of values from 1 to 7, the number 6 has 1s in colums B and C.  
The numbers that all have 1s in the A column are 1, 3, 5, and 7. The number that have 1s 
in the B column are 2, 3, 6, and 7. In the C column, 1s correspond to the 
values 4, 5, 6 and 7.

Her game goes like this. She picks a random number between 1 and 500 representing the 
range of values within which her mystery number will be. 

She then picks a random letter that would represent one of the columns in the binary form of 
that number, and then one or more other letters, also column labels of that number's binary 
form.

She then tries to figure out the resulting number, where there would be a 1 in each of the 
binary columns represented by the letters she picked.

After she gets the number, she then counts how many other values have a 1 in the column 
of the first letter she picked.

For example, if she picked 7 as the maximum value in her mystery number range, 
then the letter B, and then another letter C, the binary form of the mystery number would 
be 110, since there is a 1 in both the C and B columns but not the A column.  This number 
converted to base ten is the value 6, her mystery number.

The other numbers between 1 and 7 that also have a 1 in the B column (the first letter she 
picked) of their binary forms are 2, 3, and 7, making a total of 4 values that have 1s 
in the B column within that range.

In another example, with 15 as the maximum range value, and only the letter A picked, the resulting
binary form of the mystery number only has a 1 in the A column, making 0001, which is equal
to the decimal value 1.  Other numbers from 1 to 15 that also have a 1 in the A column are the
values 3, 5, 7, 9, 11, 13, and 15, for a total of 8 values.

Input: Several data sets, each on one line with single space separation, consisting of an 
integer M for the maximum range value(1<M<=500), an integer N for the number of 
letters to follow, and then N capital letters. 
 
Output: Two integer values, the first of which represents the base ten mystery number 
represented by the input letter column labels, as described above, and then a value 
representing the number of integers within the given range, that contain a 1 in the 
column of their binary form, represented by the first letter listed in the data set.

Assumptions: The number of letters given in each data set will not exceed
the number of columns required for the binary form of the maximum value indicated.

Sample input:
7 2 B C
15 1 A
10 2 B A
130 4 F D E G

6 4
1 8
3 5
120 64

 */
public class Isabel {
	static Scanner k;
	public static void main(String [] args) throws FileNotFoundException {
		Scanner f = new Scanner(new File("isabel.dat"));
		while(f.hasNext())
		{
			String s = f.nextLine();
			args=s.split(" ");
			int num = Integer.parseInt(args[0]);
			int blanks = log2(num);
			int cols = Integer.parseInt(args[1]);
			char col = args[2].charAt(0);
			char[]lets=new char[blanks];
			Arrays.fill(lets,'0');
			for(int x=2;x<args.length;x++)
				lets[args[x].charAt(0)-65]='1';
			s=new String(lets);
			StringBuilder ss = new StringBuilder(s);
			ss.reverse();
			int ans = Integer.parseInt(new String(ss),2);
			
			Arrays.fill(lets,'0');
			lets[col-65]='1';
			s=new String(lets);
			ss = new StringBuilder(s);
			ss.reverse();
			int val = Integer.parseInt(new String(ss),2);
			
			int count=0;
			for(int x=0;x<=num;x++)
				if((x&val)==val)
					count++;
		 	out.println(ans+" "+count);
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
7 2 B C
15 1 A
10 2 B A
130 4 F D E G
20 4 D C B A
40 3 E D A
12 3 D B A
25 2 E A
211 3 G H A
250 3 D H A

6 4
1 8
3 5
120 64
15 8
25 16
11 5
17 10
193 84
137 123

*/
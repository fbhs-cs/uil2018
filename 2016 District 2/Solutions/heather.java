import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.*;
/**
 * Solution to Heather, UIL District 2, 2016
 * @author Owen

Heather has just learned that it is possible to have any base you want, other than base ten,
two, eight, and sixteen.  She figures since there are 10 counting digits and 26 letters of the
alphabet, you could easily represent a value up to base 36 if you wanted to.

She decided to make up an exercise where two values were represented, each value in a different base,
anywhere from base 2 to base 36, where three of the four value/base items were known, and the fourth
unknown.  She then proceeded to try and find the missing item.

For example, if she knew that 25 base 10 was equal to something in base 8, she would do
some math and determine that 31 was the missing value, and she would write the original
four items in the order 25 10 X 8, with X indicating the missing value.

On the other hand, she could write the expression 25 X 31 8, and try to find the correct base
that has 25 as the value, and is equal to 31 base 8.  The answer, of course, is 10.

The expression 25 10 31 X, would result in 8 as the missing value.

She then tried something really strange, using X 23 FACE 16, wondering if she could figure this one,
which she did by converting FACE, base 16 to base 10, and then to base 23, with a final answer
of 568D.

Given four items N1 B1 N2 B2 in an expression, with any of the four items replaces with an X,
write a program to find the missing value of X in each expression.

Input: Several sets of datas, each consisting of four items representing two pairs of 
value/base pairs, with one of the four items indicated by the letter X, representing
a missing value for one of the values, or one of the bases.

Output: The missing value for each data set, with any alphabetic characters shown in uppercase.

Sample input:
25 10 X 8
25 X 31 8
25 10 31 X
X 23 FACE 16
A5 X BC 13

Sample output:
31
10
8
568D
15

 */
public class Heather {
	public static void main(String [] args) throws FileNotFoundException {
		Scanner f = new Scanner(new File("heather.dat"));
		while(f.hasNext()) 
		{
			String s = f.nextLine();
			args=s.split(" ");
			int x = 0;
			while(x<args.length&&!args[x].equals("X")) x++;
			switch(x)
			{
				case 0:f0(args);break;
				case 1:f1(args);break;
				case 2:f2(args);break;
				case 3:f3(args);break;
			}
		}
	}
	static void f2(String [] a)	{
		String b1=a[0];
		int x1=Integer.parseInt(a[1]);
		int x2=Integer.parseInt(a[3]);
		int n = Integer.parseInt(b1,x1);
		out.println(Integer.toString(n,x2).toUpperCase());		
	}
	static void f0(String [] a)	{
		int x1=Integer.parseInt(a[1]);
		String b2=a[2];
		int x2=Integer.parseInt(a[3]);
		int n = Integer.parseInt(b2,x2);
		out.println(Integer.toString(n,x1).toUpperCase());		
	}
	static void f1(String [] a)	{
		String b1=a[0];
		String b2=a[2];
		int x2=Integer.parseInt(a[3]);
		int n = Integer.parseInt(b2,x2);
		int rad = 36;
		while(true){
//			out.println("rad="+rad);
			int n2 = Integer.parseInt(b1,rad);
			if(n2==n){
				out.println(rad);
				break;
			}
			rad--;
		}
	}
	static void f3(String [] a){
		String b1=a[0];
		int x1=Integer.parseInt(a[1]);
		String b2=a[2];
		int n = Integer.parseInt(b1,x1);
		int rad = 36;
		while(true)
		{

			int n2 = Integer.parseInt(b2,rad);
			if(n2==n){
				out.println(rad);
				break;
			}
			rad--;
		}
	}
}
/*
Test input:
25 10 X 8
25 X 31 8
25 10 31 X
X 23 FACE 16
A5 X BC 13
145 10 X 13
J3 30 X 10
X 10 51 36
X 11 29 19
X 10 31 8
X 10 568D 23
568D X 232BC 13
25 24 X 9
115 6 X 17
MN 25 X 30
573 10 X 25
64206 10 X 13
2A 16 42 X

Test output:
31
10
8
568D
15
B2
573
181
43
25
64206
23
58
2D
J3
MN
232BC
10

*/
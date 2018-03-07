import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.*;
/**
 * Solution to Walter, UIL District 1, 2016 - Mail Center
 * @author Owen
 Walter works at a mail center and must decide how to mail certain items brought in by customers, 
 according to the dimensions of the item, from small post cards to large packages. Some items don't fit
 any of the categories and are unmailable.
 
 Below are the category descriptions that Walter can choose from. All given dimension ranges are 
 inclusive and expressed in inches.
 
 SMALL POST CARD: The length must be between 3.5 and 4.25, width between 3.5 and 6, and thickness between .007 and .016.
 LARGE POST CARD: Length between 4.25 and 6, width between 6 and 11.5, thickness between .007 and .016.
 SMALL ENVELOPE: Length - 3.5 to 6.125, width - 5 to 11.5, thickness - .016 to .25.
 LARGE ENVELOPE: Length - 6.125 to 24, width - 11 to 18, thickness - .25 to .5.
 SMALL PACKAGE: Item dimensions exceed all rules for large envelope and length plus distance around the other sides of the package equals 84 inches or less.
 LARGE PACKAGE: Length plus distance around the other sides of the package exceeds 84 inches but is no more than 130 inches.
 
Input: Several data sets, each on one line, consisting of the three values of a mail item: length, width, thickness.

Output: The correct mail classification (in all caps) according to the specifications listed above, or the word UNMAILABLE if the item
does not fit within any of the descriptions.
 
Sample Input:
4 4 .009
5 7 .013
5 7 .2
10 12 .4
20 20 40

Sample Output:
SMALL POST CARD
LARGE POST CARD
SMALL ENVELOPE
LARGE ENVELOPE
UNMAILABLE


 */
public class Walter {
	
	static Scanner k;
	public static void main(String [] args) throws FileNotFoundException {
		Scanner f = new Scanner(new File("walter.dat"));
		k = new Scanner(in);
		while(f.hasNext()) 
		{
			args=f.nextLine().split(" ");
			double len = Double.parseDouble(args[0]);
			double wid = Double.parseDouble(args[1]);
			double thk = Double.parseDouble(args[2]);
		if(spc(len,wid,thk))
			out.println("SMALL POST CARD");
		else
		if(lpc(len,wid,thk))
			out.println("LARGE POST CARD");
		else
		if(se(len,wid,thk))
			out.println("SMALL ENVELOPE");
		else
		if(le(len,wid,thk))
			out.println("LARGE ENVELOPE");
		else
		if(sp(len,wid,thk))
			out.println("SMALL PACKAGE");
		else
		if(lp(len,wid,thk))
			out.println("LARGE PACKAGE");
		else
			out.println("UNMAILABLE");
	}
	}
	static boolean spc(double l, double w, double t)
	{
		if(l>=3.5&&l<=4.25&&w>=3.5&&w<=6&&t>=.007&&t<=.016)
			return true;
		return false;
	}
	static boolean lpc(double l, double w, double t)
	{
		if(l>=4.25&&l<=6&&w>=6&&w<=11.5&&t>=.007&&t<=.016)
			return true;
		return false;
	}
	static boolean se(double l, double w, double t)
	{
		if(l>=3.5&&l<=6.125&&w>=5&&w<=11.5&&t>=.015&&t<=.25)
			return true;
		return false;
	}
	static boolean le(double l, double w, double t)
	{
		if(l>=6.125&&l<=24&&w>=11&&w<=18&&t>=.25&&t<=.5)
			return true;
		return false;
	}
	static boolean sp(double l, double w, double t)
	{
		if(!(l>=3.5&&l<=6.125||w>=5&&w<=11.5||t>=.015&&t<=.25))
			if(l+2*w+2*t<=84)
				return true;
		return false;
	}
	static boolean lp(double l, double w, double t)
	{
		double span=l+2*w+2*t;
		if(span>=84&&span<=130)
			return true;
		return false;
	}
}
/*
Input
4 4 .009
5 7 .013
5 7 .2
10 12 .4
20 20 40
10 12 30
5 8 .011
4 6 .016
5 6 .016
7 10 .18
8.5 11 .36
10 20 30
6.125 11 .25
6.125 12 .25
3.5 5 .016
3.5 5 .017
3 5 .016

Output
SMALL POST CARD
LARGE POST CARD
SMALL ENVELOPE
LARGE ENVELOPE
UNMAILABLE
LARGE PACKAGE
LARGE POST CARD
SMALL POST CARD
LARGE POST CARD
UNMAILABLE
LARGE ENVELOPE
LARGE PACKAGE
SMALL ENVELOPE
LARGE ENVELOPE
SMALL POST CARD
SMALL ENVELOPE
UNMAILABLE

*/
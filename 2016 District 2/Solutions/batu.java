import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.*;
/**
 * Solution to Sudoku - Ba Tu, UIL District 2, 2016
 * @author Owen
Ba Tu has just learned to play Sudoku, but still needs your help figuring out what values
any particular square could be.  The rules are that every row, column, and every 3X3 sub-box within
the large grid have unique values from 1 to 9.  

Your job is to help Ba Tu get started with any particular empty box, showing him what digit, or digits,
could possibly work for that empty box.

In the puzzle shown here, the empty blank at position 1,1 at the top left corner of the puzzle cannot
be a 5, 1, or 4 since that row already contains those numbers, and it cannot be 2, 3, or 9 since that
column contains those, and it cannot be a 7 since there is a 7 in the sub-box for that blank. That means
that 6 or 8 would work in that blank.

For the blank at row 4, column 2, the only values that could work are 6 and 7, since that row already
has the digits 1, 2, 3, 5 and 8, the column also has 4, and that sub-box also has the 9. 
 ___________________
|_ 5 _| _ 1 _| _ 4 _|
|1 _ 7| _ _ _| 6 _ 2|
|_ _ _| 9 _ 5| _ _ _|
|_____|______|______|
|2 _ 8| _ 3 _| 5 _ 1|
|_ 4 _| _ 7 _| _ 2 _|
|9 _ 1| _ 8 _| 4 _ 6|
|_____|______|______|
|_ _ _| 4 _ 1| _ _ _| 
|3 _ 4| _ _ _| 7 _ 9|
|_ 2 _| _ 6 _| _ 1 _|
|_____|______|______|

Input: Nine strings of nine digits each, representing the beginning values of a typical Sudoku puzzle. 
 A zero digit represents an empty blank, and the digits 1-9 are the values in that corresponding column 
 of that row. After the initial nine strings, several pairs of integers representing the column and row 
 of an empty blank.
 
 Output: All the possible digits that could be placed in the empty blank indicated
 by each pair of digits. The digits are to be listed in ascending order with no spaces between.
 
 Sample input:
 
 */
public class BaTu {
	static Scanner k;
	public static void main(String [] args) throws FileNotFoundException {
		Scanner f = new Scanner(new File("batu.dat"));
//		k = new Scanner(in);
		int[][]sud=null;
		String[][]str=null;
//		for(int w=0;w<9;w++) 
		{
			sud = new int[10][10];
			str = new String[10][10];
			for(int r=1;r<=9;r++)
			{
				String s = f.nextLine();
				char[] row = s.toCharArray();
				for(int c=1;c<=9;c++){
					sud[r][c]=row[c-1]-48;
					str[r][c]=row[c-1]=='0'?"x":""+row[c-1];
				}
			}
		}
		while(f.hasNext())
		{
		int r=f.nextInt();
		int c=f.nextInt();
		boolean[]d=new boolean[10];
		
		checkRow(sud,d,r,c);
		checkCol(sud,d,r,c);
		checkNine(sud,d,r,c);
	
		String ss="";
		for(int x=1;x<=9;x++){
			if(!d[x])
				ss+=x;}
		out.println(ss);
		
		}
	}
	public static void checkNine(int[][]s,boolean[]row,int r,int c)
	{
		int rr=0,cc=0,re=0,ce=0,ccc=0;
		if(r<=3)rr=1;
			else
			if(r<=6)
				rr=4;
				else
					rr=7;
		if(c<=3)cc=1;
			else
			if(c<=6)
				cc=4;
				else
					cc=7;
		for(re=rr+2;rr<=re;rr++)
			for(ccc=cc,ce=cc+2;ccc<=ce;ccc++)
			{
//				out.println(rr+"-"+ccc+"-"+s[rr][ccc]);
			if(rr!=r&&ccc!=c&&s[rr][ccc]>0)
				row[s[rr][ccc]]=true;
			}
	}

	public static void checkRow(int[][]s,boolean[]row,int r,int c)
	{
		for(int x=1;x<=9;x++){
//			out.println(s[r][x]);
			if(x!=c&&s[r][x]>0)
				row[s[r][x]]=true;
		}
	}
	public static void checkCol(int[][]s,boolean[]row,int r,int c)
	{
		for(int x=1;x<=9;x++){
//			out.println(s[x][c]);
			if(x!=r&&s[x][c]>0)
				row[s[x][c]]=true;
		}
	}

}
/*
*/
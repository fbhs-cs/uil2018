/**
 * UIL Invitational A, 2016, Program Five
 * Bones - solution
 * @author Owen

A typical set of dominoes has 28 "bones", ranging in value from 0 to 6 on each half of a piece.  
For example the blank piece would be represented by 00, and the double six, often called the 
"boxcar", is 66. The pieces in ascending sequence would be 00, 01, 02, 03...32, 33, 34, 35...54, 
55, 56, and 66.  Keep in mind that 35 and 53 represent the same "bone".

For this problem you are given five dominoes randomly positioned in ten places, followed by five 
more dominoes that are guaranteed to fit the five blank positions.  For example, the first sample 
data line below represents an opening board that looks like this, where xx means a blank spot to be 
filled with the five remaining "bones":

53 xx 45 56 xx 61 13 xx xx xx, 

with 66, 34, 25, 36, and 62 to fill the blank spots, with a final solution of:  

53 34 45 56 66 61 13 36 62 25

Remembering that the dominoes can be reversed, the five remaining "bones" could be listed as in 
the second data example below:

66 43 52 63 26

with the same expected resulting board of:

53 34 45 56 66 61 13 36 62 25

Input: Several data sets, each line consisting of integers with single space separation, the first 
five indicating the positions (in the range 1-10) of the five "bones" already positioned on the board, 
followed by five pairs of integers representing the pieces in those positions, and then the remaining 
five pairs indicating the pieces to fill the blank spots.

Output: The resulting board with all pieces filled in correctly.  A unique and successful solution 
for each data set is guaranteed.

Sample input:
1 3 4 6 7 5 3 4 5 5 6 6 1 1 3 6 6 3 4 2 5 3 6 6 2
1 3 4 6 7 5 3 4 5 5 6 6 1 1 3 6 6 4 3 5 2 6 3 2 6
1 3 5 7 9 2 3 4 5 6 6 1 2 6 0 3 4 6 1 5 6 5 0 2 6

Sample output:
53 34 45 56 66 61 13 36 62 25
53 34 45 56 66 61 13 36 62 25
23 34 45 56 66 61 12 26 60 05

Test data:
1 3 4 6 7 5 3 4 5 5 6 6 1 1 3 6 6 3 4 2 5 3 6 6 2
1 3 4 6 7 5 3 4 5 5 6 6 1 1 3 6 6 4 3 5 2 6 3 2 6
1 3 5 7 9 2 3 4 5 6 6 1 2 6 0 3 4 6 1 5 6 5 0 2 6
2 4 6 8 9 2 2 3 3 4 4 5 5 5 1 1 6 4 5 3 4 2 3 2 4
1 2 3 4 5 0 0 0 1 1 2 2 3 3 4 3 3 3 1 5 4 6 5 1 6
1 3 4 6 8 5 2 0 4 4 1 5 3 6 0 4 5 0 5 6 3 1 5 0 2
1 2 6 9 10 2 3 3 5 6 2 4 1 1 2 5 5 4 5 2 5 1 6 1 5
1 3 5 7 9 0 0 1 1 2 2 3 3 4 4 2 4 4 3 3 2 2 1 1 0
1 2 3 4 5 2 5 5 6 6 3 3 5 5 1 4 1 4 2 6 2 6 0 0 3

Test Output:
53 34 45 56 66 61 13 36 62 25
53 34 45 56 66 61 13 36 62 25
23 34 45 56 66 61 12 26 60 05
42 22 23 33 34 44 45 55 51 16
00 01 12 23 34 45 56 61 13 33
52 20 04 41 15 53 36 60 05 54
23 35 55 51 16 62 25 54 41 12
00 01 11 12 22 23 33 34 44 42
25 56 63 35 51 14 42 26 60 03

 */
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.*;

public class A_Five {
	static int found;
	public static void main(String [] args) throws IOException {
		Scanner f = new Scanner(new File("a_five.dat"));
		while(f.hasNext())
		{
		//load board with first five tiles
			String[]board=new String[12];
			String s = f.nextLine();//first line
			args=s.split(" ");
			int x=0,y=0;
			for(x=0,y=5;x<5;x++,y+=2)
			{
				int i = Integer.parseInt(args[x]);
				String piece = ""+args[y]+args[y+1];
				board[i]=piece;
			}
			found=5;

			ArrayList<String> set = new ArrayList<String>();
			for(x=0;x<5;x++,y+=2)
			{
				String piece = ""+args[y]+args[y+1];
				set.add(piece);
			}
			while(found<10)
			{
			
			Integer pos = 1;
			while(pos<=10)
			{
				seekPiece(board,set,pos);

				pos++;
			}
			}
			for(int z=1;z<=10;z++)
				out.printf("%-3s",board[z]);
			out.println();
		}
	}
	static String revPiece(String s)
	{
		return s.substring(1)+s.substring(0,1);
	}
	static void seekPiece(String [] brd, ArrayList<String>pcs,Integer pos)
	{
		if(brd[pos]!=null)
			return;
		//look int Set s for all possible matches for position p
		{
			ArrayList<String>sub=new ArrayList<String>();
			for(String p:pcs)
				if(pieceFits(brd,pos,p)||pieceFits(brd,pos,revPiece(p)))
					sub.add(p);
			if(sub.size()==1)//if only one piece fits
			{	if(pieceFits(brd,pos,sub.get(0)))//if original piece position fits
					brd[pos]=sub.get(0);
				else
					brd[pos]=revPiece(sub.get(0));
				found++;
				pcs.remove(sub.get(0));
				return;
			}
			return;
		}
	}
	static boolean pieceFits(String[]brd,Integer pos,String p)
	{
		if(pos==1&&brd[pos+1]!=null&&p.charAt(1)==brd[pos+1].charAt(0))//looking for piece in first position
		{
			return true;
		}
		if(pos==10&&brd[pos-1]!=null&&p.charAt(0)==brd[pos-1].charAt(1))//looking for piece in last position
		{
			return true;
		}
		//looking for piece in any other position that has pieces before and after
		if(pos>1&&pos<10&&(brd[pos-1]!=null&&p.charAt(0)==brd[pos-1].charAt(1)&&
		   brd[pos+1]!=null&&p.charAt(1)==brd[pos+1].charAt(0)))
		   	{
			return true;
			}
		else
			//looking for piece between 1 and 10 that has a piece before, but null after
		if(pos>1&&pos<10&&(brd[pos-1]!=null&&p.charAt(0)==brd[pos-1].charAt(1)&&
		   brd[pos+1]==null))
		   	{
			return true;
			}
		else
			//looking for piece between 1 and 10 that has null before, but a piece after
		if(pos>1&&pos<10&&(brd[pos+1]!=null&&p.charAt(1)==brd[pos+1].charAt(0)&&
		   brd[pos-1]==null))
		   	{
			return true;
			}
		return false;
	}
}

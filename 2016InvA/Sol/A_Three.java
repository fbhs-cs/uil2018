/*
UIL Invitational A, 2016, Program Three

Penny Dreadful

A simple penny game involves a strip of several adjacent spaces, on which pennies are randomly placed.
The number of squares S is random, as are the number of pennies P placed, as long as P is less than S.

The rules are as follows:

After the pennies are randomly placed by one player, the players take turns moving pennies to the left.
A move can be 1, 2, 3, 4 or 5 spaces, as long as a penny does not share the same space as another penny
after the move, and a penny can't pass another penny during the move. The winner of the game is the last
player to move a penny.

-------------------------
|*| | |*| |*| |*|*|*| |*|
-------------------------

For example, on the game board shown above, with 12 squares, and 7 pennies at positions 1, 4, 6, 8, 9, 10 and 12,
4 pennies can move 1 space (the pennies at positions 4, 6, 8 and 12), 1 penny can move 2 spaces (the one in position 4),
but none can move any further.

Your job is to report the possible number of moves by the first player, itemized by possible number of spaces moved.  
The output for this situation would be: 4 1 0 0 0, which means there are 4 possible 1-space moves, 1 possible 2-space moves,
and no possible moves of 3, 4, or 5 spaces.

Input: A data file with several sets of data. Each data set is a series of integers, all on one line, with single space separation.
The first integer indicates the number of squares on the penny strip, the second shows the number P of pennies on the strip, followed
by P values indicating the penny positions on the board.

Output: Five values per data set, indicating the number of possible moves of 1, 2, 3, 4 or 5 by the pieces on the board.

*/
import java.util.*;
import java.io.*;
import static java.lang.System.*;
class A_Three
{
	public static void main(String...emUp) throws IOException{
		Scanner f = new Scanner(new File("a_three.dat"));
		while(f.hasNext())
			{
				String s = f.nextLine();
				emUp = s.split(" ");
				int[]board=new int[Integer.parseInt(emUp[0])+1];
				int numPieces = Integer.parseInt(emUp[1]);
				for(int x=2;x<emUp.length;x++){
					board[Integer.parseInt(emUp[x])]=1;
				}
				numMoves(board);
			}
		}
//calculate and print out the number of initial moves possible
	static void numMoves(int[]board)
	{
		int[]moves=new int[6];
		for(int x=1;x<board.length;x++)
		{
			if(board[x]==1)
				for(int y=1;y<moves.length;y++)
					if(canMoveM(board,x,y))
						moves[y]++;
		}
		for(int m=1;m<moves.length;m++)
			out.print(moves[m]+" ");
		out.println();
	}
	//given board, position c, and possible number of moves m
	//return true or false whether c can move m times
	static boolean canMoveM(int []b,int c,int m)
	{
		//start at position c-1
		int p=c;
		int x=1;
		for(;x<=m;x++)
		{
			if(c-x==0||b[c-x]==1)
				return false;
		}
		return true;
	}
}
/*
12 7 1 4 6 8 9 10 12
14 6 1 3 6 7 10 14
10 2 4 9
10 2 6 10
6 3 3 5 6
8 2 4 7
15 5 1 7 8 14 15
15 6 2 4 6 8 10 15
7 3 4 6 7

4 1 0 0 0
4 3 1 0 0
2 2 2 1 0
2 2 2 1 1
2 1 0 0 0
2 2 1 0 0
2 2 2 2 2
6 1 1 1 0
2 1 1 0 0
*/
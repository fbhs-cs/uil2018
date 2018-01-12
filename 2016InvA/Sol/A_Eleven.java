/*
UIL Invitational A, 2016, Program Eleven

Block

This two-player game is played on a standard 8X8 grid, as in checkers or chess. It involves rectangular 
blocks that span two squares, either vertically or horizontally. Each player takes a turn placing a piece, 
always in the same direction for each player.  The first player chooses the desired direction, and the 
second player uses the other direction.

The idea of the complete game is to be the last player to place a block on the board, preventing the other 
player from any more possible moves.

Below is a sample board after 5 moves by each player.  The H player (the one with horizontal pieces), owns 
the blocks indicated by "**" at positions (3,3), (4,5), (5,1), (6,2) and (8,1), and has the next move. 
The (8,1) block is located at the top left corner of the board.

The V blocks, shown as two vertically stacked “#” signs, are indicated by the lower of the two positions, 
which means there are V blocks at positions (3,7), (5,4), (5,6), (5,8) and (7,4). The “#” sign at (7,4) 
goes with the one at (8,4).

-----------------
|*|*| |#| | | | |
| | | |#| | | | |
| |*|*|#| |#| |#|
|*|*| |#| |#| |#|
| | | | |*|*|#| |
| | |*|*| | |#| |
| | | | | | | | |
| | | | | | | | |
-----------------

In the example shown, based on the first data sample, your job is to calculate onto how many 
places of the board an "H" block can be placed next.  The first letter of the data sample indicates
the player whose move is next.

For example, on the top row, an "H" block could be placed at position (8,5), (8,6), or (8,7), 
each position indicating the left-most of the two spaces required. In other words, an H piece 
placed at position (8,7) would also cover (8,8). There are 27 possible placements in this 
situation for the next move for an "H" block as the next move - 3 on the top row, 5 on the 
next, none on row 6 or 5, 3 on row 4, 2 on row 3, and 7 each on the bottom two rows.

Input: A data file with several sets of data. Each data set begins with the letter V or H, 
followed by an integer N indicating how many pieces each player has, followed by N marker positions 
for the first player, and then N positions for the second player. The first line of sample data below
indicates the board shown above.

Output: An integer M indicating the number of possible next moves for the first player.

Sample Input:
H 5 3 3 4 5 5 1 6 2 8 1 3 7 5 4 5 6 5 8 7 4
V 8 6 1 6 3 6 5 6 7 3 1 3 3 3 5 3 7 2 1 5 1 5 3 5 5 5 7 8 2 8 4 8 6
H 8 2 1 5 1 5 3 5 5 5 7 8 2 8 4 8 6 6 1 6 3 6 5 6 7 3 1 3 3 3 5 3 7

Sample Output:
27
18
12

*/
import java.util.*;
import java.io.*;
import static java.lang.System.*;
public class A_Eleven
{
	public static void main(String...theory) throws IOException{
		Scanner k = new Scanner(in);
		Scanner f = new Scanner(new File("a_eleven.dat"));
		while(f.hasNext())
			{
				String s = f.nextLine();
				theory = s.split(" ");
				char c = theory[0].charAt(0);
				char[][]board= new char[9][9];
				for(int x=0;x<=8;x++)
					Arrays.fill(board[x],'.');
				int p = Integer.parseInt(theory[1]);
				for(int x=0;x<2*p;x+=2)
					place(board,theory[x+2],theory[x+3],c);
				for(int x=0;x<2*p;x+=2)
					place(board,theory[x+2+2*p],theory[x+3+2*p],c=='H'?'V':'H');
				out.println(numMoves(board,c));
			}
		}
	static int numMoves(char[][]board,char p)
	{
		int num=0;
		if(p=='H')
		{
			for(int r=1;r<=8;r++)
				for(int c=1;c<8;c++)
					if(board[r][c]=='.'&&board[r][c+1]=='.')
					{
						num++;
					}
		}
		else
		{
			for(int r=1;r<8;r++)
				for(int c=1;c<=8;c++)
					if(board[r][c]=='.'&&board[r+1][c]=='.')
					{
						num++;
					}
		}
		return num;
	}
//place a marker on the board
	static void place(char[][]board,String r,String c,char d)
	{
		int row = Integer.parseInt(r);
		int col = Integer.parseInt(c);
		if(d=='V')
		{
			board[row][col]='#';
			board[row+1][col]='#';
		}
		else
		{
			board[row][col]='*';
			board[row][col+1]='*';
		}
	}
}
/*
H 5 3 3 4 5 5 1 6 2 8 1 3 7 5 4 5 6 5 8 7 4
V 8 6 1 6 3 6 5 6 7 3 1 3 3 3 5 3 7 2 1 5 1 5 3 5 5 5 7 8 2 8 4 8 6
H 8 2 1 5 1 5 3 5 5 5 7 8 2 8 4 8 6 6 1 6 3 6 5 6 7 3 1 3 3 3 5 3 7
V 6 6 2 6 6 4 2 3 6 1 2 1 6 8 3 8 7 5 3 5 7 2 3 2 7
V 8 1 1 3 1 5 1 7 1 1 8 3 8 5 8 7 8 1 4 2 4 3 4 4 4 5 4 6 4 7 4 8 4
H 11 8 1 7 2 6 3 5 4 4 5 3 6 2 7 3 2 2 3 8 6 7 7 6 1 5 2 4 3 3 4 2 5 1 6 7 4 6 5 5 6 4 7 3 8
H 8 8 4 6 4 4 4 2 4 7 1 7 7 2 1 2 7 1 3 3 3 5 3 7 3 1 6 4 6 5 1 7 6
V 12 7 1 6 2 5 3 4 4 3 5 2 6 1 7 2 2 3 3 5 5 6 6 7 7 1 2 1 4 2 3 3 7 4 1 4 6 5 1 5 7 6 7 7 3 8 2 8 4

27
18
12
22
28
8
17
4

*/
/**
Oleg loves board games, especially chess and tic-tac-toe.  After seeing an old Star Trek episode showing Spock and his 3D chess set, he thought about writing an AI program to play 3D chess, but decided to start with something easier, like 3D tic tac toe.

However, he needs your help to write this program.  He has decided to input a string of characters to represent the three boards, each with 3 rows and 3 columns, as you can see below.
the first board with positions numbered 1 through 9, the second 10 through 18, and the third 18 through 27.

To start with, he just wants to know if given a game already underway, will an additional move by X win the game, and with what already played positions of X.

For example, the display shows the current moves for X and O, with the string +O-O--X-XOO-X-X-OO-X-X-X---O" representing those moves.  If X plays on position 5 (row 2, col 2 of the top board), will X win the game?

The answer is yes, since positions 14 and 23 immediately below position 5 already have Xs on them.

Input - Several lines of data, each with two items: a 27 character string containing X, O and - indicating played and open positions on the three boards, followed by an integer representing the next move by X.

Output - All of the possible wins for X with this last move, showing all three position values (ascending order by combination and by individual values) that cause the win, or the words "NO WIN" if there is no win with this move. A blank line will follow the output result for each data set.

Sample data:
O-O--X-XOO-X-X-OO-X-X-X---O 5
XO--X-O--O---X-XXO--X---O-O 11
X-X-X-O-OO-O-O-X-XX-X---O-O 23

Sample Output:
5 14 23

1 11 21
11 14 17

NO WIN

 */
import java.io.*;
import java.util.*;
import static java.lang.System.*;
public class Oleg {
	public static void main(String [] args) throws FileNotFoundException {
		Scanner k = new Scanner(in);
		Scanner f = new Scanner(new File("oleg.dat"));

		ArrayList<ArrayList<Integer>> list = new ArrayList();
		ArrayList<Integer> com = new ArrayList<Integer>();
		com.add(1);com.add(2);com.add(3);list.add(com);
		com = new ArrayList<Integer>();
		com.add(1);com.add(4);com.add(7);list.add(com);
		com = new ArrayList<Integer>();
		com.add(1);com.add(5);com.add(9);list.add(com);
		com = new ArrayList<Integer>();
		com.add(1);com.add(14);com.add(27);list.add(com);
		com = new ArrayList<Integer>();
		com.add(1);com.add(10);com.add(19);list.add(com);
		com = new ArrayList<Integer>();
		com.add(1);com.add(13);com.add(25);list.add(com);
		com = new ArrayList<Integer>();
		com.add(1);com.add(11);com.add(21);list.add(com);
		com = new ArrayList<Integer>();

		com.add(2);com.add(5);com.add(8);list.add(com);
		com = new ArrayList<Integer>();
		com.add(2);com.add(11);com.add(20);list.add(com);
		com = new ArrayList<Integer>();
		com.add(2);com.add(14);com.add(26);list.add(com);

		com = new ArrayList<Integer>();
		com.add(3);com.add(6);com.add(9);list.add(com);
		com = new ArrayList<Integer>();
		com.add(3);com.add(5);com.add(7);list.add(com);
		com = new ArrayList<Integer>();
		com.add(3);com.add(12);com.add(21);list.add(com);
		com = new ArrayList<Integer>();
		com.add(3);com.add(14);com.add(25);list.add(com);
		com = new ArrayList<Integer>();
		com.add(3);com.add(15);com.add(27);list.add(com);
		com = new ArrayList<Integer>();
		com.add(3);com.add(11);com.add(19);list.add(com);

		com = new ArrayList<Integer>();
		com.add(4);com.add(5);com.add(6);list.add(com);
		com = new ArrayList<Integer>();
		com.add(4);com.add(14);com.add(24);list.add(com);
		com = new ArrayList<Integer>();
		com.add(4);com.add(13);com.add(22);list.add(com);

		com = new ArrayList<Integer>();
		com.add(5);com.add(14);com.add(23);list.add(com);

		com = new ArrayList<Integer>();
		com.add(6);com.add(14);com.add(22);list.add(com);
		com = new ArrayList<Integer>();
		com.add(6);com.add(15);com.add(24);list.add(com);

		com = new ArrayList<Integer>();
		com.add(7);com.add(8);com.add(9);list.add(com);
		com = new ArrayList<Integer>();
		com.add(7);com.add(16);com.add(25);list.add(com);
		com = new ArrayList<Integer>();
		com.add(7);com.add(14);com.add(21);list.add(com);
		com = new ArrayList<Integer>();
		com.add(7);com.add(13);com.add(19);list.add(com);
		com = new ArrayList<Integer>();
		com.add(7);com.add(17);com.add(27);list.add(com);

		com = new ArrayList<Integer>();
		com.add(8);com.add(17);com.add(26);list.add(com);
		com = new ArrayList<Integer>();
		com.add(8);com.add(14);com.add(20);list.add(com);

		com = new ArrayList<Integer>();
		com.add(9);com.add(18);com.add(27);list.add(com);
		com = new ArrayList<Integer>();
		com.add(9);com.add(14);com.add(19);list.add(com);
		com = new ArrayList<Integer>();
		com.add(9);com.add(17);com.add(25);list.add(com);
		com = new ArrayList<Integer>();
		com.add(9);com.add(15);com.add(21);list.add(com);

		com = new ArrayList<Integer>();
		com.add(10);com.add(11);com.add(12);list.add(com);
		com = new ArrayList<Integer>();
		com.add(10);com.add(14);com.add(18);list.add(com);
		com = new ArrayList<Integer>();
		com.add(10);com.add(13);com.add(16);list.add(com);
		
		com = new ArrayList<Integer>();
		com.add(11);com.add(14);com.add(17);list.add(com);
		com = new ArrayList<Integer>();
		com.add(12);com.add(15);com.add(18);list.add(com);
		com = new ArrayList<Integer>();
		com.add(12);com.add(14);com.add(16);list.add(com);
		com = new ArrayList<Integer>();
		com.add(13);com.add(14);com.add(15);list.add(com);
		com = new ArrayList<Integer>();
		com.add(16);com.add(17);com.add(18);list.add(com);

		com = new ArrayList<Integer>();
		com.add(19);com.add(20);com.add(21);list.add(com);
		com = new ArrayList<Integer>();
		com.add(19);com.add(22);com.add(25);list.add(com);
		com = new ArrayList<Integer>();
		com.add(19);com.add(23);com.add(27);list.add(com);

		com = new ArrayList<Integer>();
		com.add(20);com.add(23);com.add(26);list.add(com);
		com = new ArrayList<Integer>();
		com.add(21);com.add(24);com.add(27);list.add(com);
		com = new ArrayList<Integer>();
		com.add(21);com.add(23);com.add(25);list.add(com);
		com = new ArrayList<Integer>();
		com.add(22);com.add(23);com.add(24);list.add(com);
		com = new ArrayList<Integer>();
		com.add(25);com.add(26);com.add(27);list.add(com);
		
		while(f.hasNext()) {
			String s = " "+f.next();
			int pos = f.nextInt();
			s = s.substring(0,pos)+"X"+s.substring(pos+1);
//			out.println(" ---------*---------*------*");
//			out.println(s+" "+pos);
			boolean win = false;
			for(ArrayList<Integer> si:list)
			{
				if(si.contains(pos))
					if(s.charAt(si.get(0))=='X'&&s.charAt(si.get(1))=='X'&&s.charAt(si.get(2))=='X')
					{
						win = true;
						for(int x:si)
							out.print(x+" ");
						out.println();
					}
			}
			if(!win)
					out.println("NO WIN");
//			k.nextLine();
			out.println();
		}

	}
}
/*
Test Data:
O-O--X-XOO-X-X-OO-X-X-X---O 5
XO--X-O--O---X-XXO--X---O-O 11
X-X-X-O-OO-O-O-X-XX-X---O-O 23
-XO--XO-OOO--X-O-X--O-X-X-X 22
-X-OX-XOO-OXX----O-O-X--X-O 3
XO--X-OX-O-OXOOX-X-O--XOOXX 17
-OOXO-XX-OX-OO-XOXOOX-X--X- 25
OO-O-XXXO-OOXOOX-X-X-XX-O-- 19
OX--OOO-X-XXOO------XX----- 15
---OX-XOOX-OX-XOOX-OX-X---O 14
O--XX-OOX-O---O--XOXX-XX-OO 14
-O--OXOXOOXOXXOX-XXOXO-XOXO 23

Test Output:
5 14 23

1 11 21
11 14 17

NO WIN

6 14 22

3 5 7

8 17 26
16 17 18

7 16 25
21 23 25

7 13 19

9 15 21

5 14 23
7 14 21
10 14 18
13 14 15

4 14 24
5 14 23

NO WIN

*/
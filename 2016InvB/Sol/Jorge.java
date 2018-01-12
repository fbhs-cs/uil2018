/*
UIL Invitational B, 2016, Jorge - Solution

Jorge has just learned to play poker, but has some trouble remembering the different hand rankings.
He has decided to write a program, where he stores each card using a unique number, with the diamonds numbered from
1-13, hearts from 14-26, spades from 27-39, and clubs from 40-52. Card #1 is the Ace of Diamonds, and card #13 is the King of Diamonds,
#14 is the Ace of Hearts, and so on. Card #52 is the King of Clubs.

His program will input the five numbers of his hand, and will tell him what his best hand is, according the rules of poker,
the rankings of which are, in order of best to worst:
FOUR OF A KIND - all four of the same card from each suit, like four 2s or four Kings.
FULL HOUSE - three of one kind and two of another, like three 8s and two Aces.
FLUSH - five cards, all of the same suit, like five spades or five diamonds, in no particular order.
STRAIGHT - five cards, of at least two different suits, all in a row, like Ace, 2, 3, 4, 5, or 10, Jack, Queen, King, Ace, or any 
sequence somewhere in the middle of the suit.  Wraparound sequences, like Queen, King, Ace, 2, 3, do not count as a straight.
THREE OF A KIND - three of one kind, like three 7s or three Jacks.
TWO PAIRS - 2 different pairs of the same kind, like two 5s and two 9s.
PAIR - one pair of the same kind, like two 4s or two Kings.
NONE - a terrible hand indeed...you should fold, immediately, unless you are a good bluffer!

Input: Several poker hands of five cards each, represented by five integers, all on one line, separated by single spaces, according to the description above.

Output: The best poker hand for each set of five cards, as shown in the description above and examples below.

Sample input:
18 44 7 21 23
18 44 31 22 38
18 44 31 34 21
18 44 31 5 9

Sample output:
PAIR
THREE OF A KIND
FULL HOUSE
FOUR OF A KIND
*/
import java.util.*;
import java.io.*;
import java.util.function.*;
import static java.lang.System.*;

class Jorge {
	static int[]card;
	static int[]kind;
	static int[]suit;
	public static void main(String...holdem) throws IOException{
		Scanner f = new Scanner(new File("jorge.dat"));
		while(f.hasNext()){
			holdem=f.nextLine().split(" ");
			card=new int[5];
			for(int x=0;x<5;x++)
				card[x]=Integer.parseInt(holdem[x])-1;
			process();
			if(four())
				out.println("FOUR OF A KIND");
			else
			if(full())
				out.println("FULL HOUSE");
			else
			if(flush())
				out.println("FLUSH");
			else
			if(straight())
				out.println("STRAIGHT");
			else
			if(three())
				out.println("THREE OF A KIND");
			else
			if(twoPair())
				out.println("TWO PAIRS");
			else
			if(pair())
				out.println("PAIR");
			else
				out.println("NONE");
		}
		
	}
	static boolean four(){
		for(int c:kind)
			if(c==4)
				return true;
		return false;
		}
	static boolean full(){		
		boolean three=false,two=false;
		for(int c:kind)
			if(c==3)
				three=true;
		for(int c:kind)
			if(c==2)
				two=true;
		return three&&two;
}
	static boolean flush(){		
		for(int c:suit)
			if(c==5)
				return true;
		return false;
}
	static boolean straight(){
		String s="";
		for(int c:kind)
			s+=c;
		return s.indexOf("11111")>=0;
		}
	static boolean three(){
		for(int c:kind)
			if(c==3)
				return true;
		return false;
		}
	static boolean twoPair(){
		boolean pair1=false,pair2=false;
		for(int c:kind)
			if(c==2)
				if(!pair1)
					pair1=true;
				else
					pair2=true;
		return pair1&&pair2;
		}
	static boolean pair(){
		for(int c:kind)
			if(c==2)
				return true;
		return false;}
	
	static void process(){
		Arrays.sort(card);
		kind=new int[13];
		suit=new int[4];
		for(int c:card)
			kind[c%13]++;
		for(int c:card)
			suit[c/13]++;
	}
//	public boolean pair(){
//		
//	}
}

/*
Test data
18 44 7 21 23
18 44 31 22 38
18 44 31 34 21
18 44 31 5 9
32 45 8 22 50
32 46 8 22 50
8 21 36 51 47
28 30 33 36 39
4 17 32 23 36
20 3 17 31 45

Test output
PAIR
THREE OF A KIND
FULL HOUSE
FOUR OF A KIND
PAIR
NONE
THREE OF A KIND
FLUSH
TWO PAIRS
STRAIGHT

*/
/**
Creating letter patterns with a program is one of Veronika's favorite things to do. Lately she has been playing around with a layered patterns,
where she takes any word and makes a "concentric square" with the letters, where the first letter of the word is the outside layer of the square, the second is the next layer, and so on until the last letter is in the middle of the square.
For example, with the word UIL, the square would look like this:

UUUUU
UIIIU
UILIU
UIIIU
UUUUU

or this examle using the word REGION:

RRRRRRRRRRR
REEEEEEEEER
REGGGGGGGER
REGIIIIIGER
REGIOOOIGER
REGIONOIGER
REGIOOOIGER
REGIIIIIGER
REGGGGGGGER
REEEEEEEEER
RRRRRRRRRRR

Input - Several words, all in caps, each on one line, each with a length of at least 2 and no more than 25.

Output - A concentric square for each word, as shown above, each output followed by a blank line.

Sample data:
UIL
REGION

Sample Output:
See above

 */
import java.io.*;
import java.util.*;
import static java.lang.System.*;
public class Veronika {
	public static void main(String [] args) throws FileNotFoundException {
//		Scanner k = new Scanner(in);
		Scanner f = new Scanner(new File("veronika.dat"));
		while(f.hasNext()) {
			String s = f.next();
			int n = s.length()*2-1;
			char[][]g = new char[n][n];
			int x=0;
			while(x<=n)
			{
				for(int r=x;r<n-x;r++)
				  for(int c=x;c<n-x;c++)
				  {
//				  		out.println(r+" "+c+" "+" "+x+" "+s.charAt(x));
				  	  g[r][c]=s.charAt(x);
				  }
				x++;
			}
			for(int r=0;r<g.length;r++)
			{
			  for(int c=0;c<g[r].length;c++)
			  	out.print(g[r][c]);
			  out.println();
			}
			  out.println();
			
		}//end of outside loop
	}
}
/*
Test Data:
UIL
REGION
STATE
JAVA
PROGRAM

Test Output:
UUUUU
UIIIU
UILIU
UIIIU
UUUUU

RRRRRRRRRRR
REEEEEEEEER
REGGGGGGGER
REGIIIIIGER
REGIOOOIGER
REGIONOIGER
REGIOOOIGER
REGIIIIIGER
REGGGGGGGER
REEEEEEEEER
RRRRRRRRRRR

SSSSSSSSS
STTTTTTTS
STAAAAATS
STATTTATS
STATETATS
STATTTATS
STAAAAATS
STTTTTTTS
SSSSSSSSS

JJJJJJJ
JAAAAAJ
JAVVVAJ
JAVAVAJ
JAVVVAJ
JAAAAAJ
JJJJJJJ

PPPPPPPPPPPPP
PRRRRRRRRRRRP
PROOOOOOOOORP
PROGGGGGGGORP
PROGRRRRRGORP
PROGRAAARGORP
PROGRAMARGORP
PROGRAAARGORP
PROGRRRRRGORP
PROGGGGGGGORP
PROOOOOOOOORP
PRRRRRRRRRRRP
PPPPPPPPPPPPP

AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
ABBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBA
ABCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCBA
ABCDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDCBA
ABCDEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEDCBA
ABCDEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEDCBA
ABCDEFGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGFEDCBA
ABCDEFGHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHGFEDCBA
ABCDEFGHIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIHGFEDCBA
ABCDEFGHIJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJIHGFEDCBA
ABCDEFGHIJKKKKKKKKKKKKKKKKKKKKKKKKKKKKKJIHGFEDCBA
ABCDEFGHIJKLLLLLLLLLLLLLLLLLLLLLLLLLLLKJIHGFEDCBA
ABCDEFGHIJKLMMMMMMMMMMMMMMMMMMMMMMMMMLKJIHGFEDCBA
ABCDEFGHIJKLMNNNNNNNNNNNNNNNNNNNNNNNMLKJIHGFEDCBA
ABCDEFGHIJKLMNOOOOOOOOOOOOOOOOOOOOONMLKJIHGFEDCBA
ABCDEFGHIJKLMNOPPPPPPPPPPPPPPPPPPPONMLKJIHGFEDCBA
ABCDEFGHIJKLMNOPQQQQQQQQQQQQQQQQQPONMLKJIHGFEDCBA
ABCDEFGHIJKLMNOPQRRRRRRRRRRRRRRRQPONMLKJIHGFEDCBA
ABCDEFGHIJKLMNOPQRSSSSSSSSSSSSSRQPONMLKJIHGFEDCBA
ABCDEFGHIJKLMNOPQRSTTTTTTTTTTTSRQPONMLKJIHGFEDCBA
ABCDEFGHIJKLMNOPQRSTUUUUUUUUUTSRQPONMLKJIHGFEDCBA
ABCDEFGHIJKLMNOPQRSTUVVVVVVVUTSRQPONMLKJIHGFEDCBA
ABCDEFGHIJKLMNOPQRSTUVWWWWWVUTSRQPONMLKJIHGFEDCBA
ABCDEFGHIJKLMNOPQRSTUVWXXXWVUTSRQPONMLKJIHGFEDCBA
ABCDEFGHIJKLMNOPQRSTUVWXYXWVUTSRQPONMLKJIHGFEDCBA
ABCDEFGHIJKLMNOPQRSTUVWXXXWVUTSRQPONMLKJIHGFEDCBA
ABCDEFGHIJKLMNOPQRSTUVWWWWWVUTSRQPONMLKJIHGFEDCBA
ABCDEFGHIJKLMNOPQRSTUVVVVVVVUTSRQPONMLKJIHGFEDCBA
ABCDEFGHIJKLMNOPQRSTUUUUUUUUUTSRQPONMLKJIHGFEDCBA
ABCDEFGHIJKLMNOPQRSTTTTTTTTTTTSRQPONMLKJIHGFEDCBA
ABCDEFGHIJKLMNOPQRSSSSSSSSSSSSSRQPONMLKJIHGFEDCBA
ABCDEFGHIJKLMNOPQRRRRRRRRRRRRRRRQPONMLKJIHGFEDCBA
ABCDEFGHIJKLMNOPQQQQQQQQQQQQQQQQQPONMLKJIHGFEDCBA
ABCDEFGHIJKLMNOPPPPPPPPPPPPPPPPPPPONMLKJIHGFEDCBA
ABCDEFGHIJKLMNOOOOOOOOOOOOOOOOOOOOONMLKJIHGFEDCBA
ABCDEFGHIJKLMNNNNNNNNNNNNNNNNNNNNNNNMLKJIHGFEDCBA
ABCDEFGHIJKLMMMMMMMMMMMMMMMMMMMMMMMMMLKJIHGFEDCBA
ABCDEFGHIJKLLLLLLLLLLLLLLLLLLLLLLLLLLLKJIHGFEDCBA
ABCDEFGHIJKKKKKKKKKKKKKKKKKKKKKKKKKKKKKJIHGFEDCBA
ABCDEFGHIJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJIHGFEDCBA
ABCDEFGHIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIHGFEDCBA
ABCDEFGHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHGFEDCBA
ABCDEFGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGFEDCBA
ABCDEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEDCBA
ABCDEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEDCBA
ABCDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDCBA
ABCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCBA
ABBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBA
AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA

YYY
YOY
YYY


*/
/*
UIL Invitational B, 2016, Camila - Solution

Last names often are spelled different, but sound alike, like SMITH and SMYTH, OWEN and OWENS, or PHILLIP and PHILIP.  In a large database, there is a way to categorize last names
using a coding process.  The code for each last name is made up of a letter and three digits. The letter is the first one
of the name, and the digits represent the remaining letters, according to the following rules:

In the rest of the name, disregard all instances of the letters A, E, I, O, U, H, W, and Y.
For the letters B, F, P and V, the digit that represents them is 1.
The digit 2 represents the letters C, G, J, K, Q, S, X, and Z.
The digit 3 represents the letters D and T.
L is the digit 4, M and N are indicated by 5, and 6 represents R. 

The first three digits representing the rest of the letters in the name are the code for the name, with zero as a filler for any remaining digit locations.

For example, SMITH has a code of S530: S as the starting letter, 5 for M, I is ignored, T is 3, and H is ignored, with a zero added at the end for the 3rd digit.
SMYTH works out the same way: S, 5 for M, Y is ignored, T is 3, and zero at the end.
CAMILA would be C540, ADAM would be A350, and BARTEK would be B632.
WASHINGTON would be W252, with W, 2 for S, 5 for N, and 2 for G, with the remaining letters ignored.

Some special rules are:
Double letters in any name will be treated as one letter, so ALLEN would be treated as ALEN, and JILLIANNE would be JILIANE.
Any side-by-side different letters with the same digit code will be treated as one letter, 
like PFISTER (P counts, F is ignored, code is P236) or JACKSON (C counts, K is ignored, code is J250).

Input: Several last names, all in uppercase, each on one line. There will be no spaces or symbols in any name.

Output: The 4-digit code for each name, as described and demonstrated above.

Sample input:
SMITH
SMYTH
CAMILA
WASHINGTON
ALLEN
JILLIANNE
PFISTER
JACKSON

Sample output:
S530
S530
C540
W252
A450
J450
P236
J250

*/
import java.util.*;
import java.io.*;
import java.util.function.*;
import static java.lang.System.*;
public class Camila
{
	public static void main(String...cammy) throws IOException
	{
		Scanner f = new Scanner(new File("camila.dat"));
		while(f.hasNext())
		{
			String s = f.next();
			String code = ""+s.charAt(0);
			char dig=digCode(s.charAt(0));
			for(int x=1;x<s.length();x++)
			{
				char d=digCode(s.charAt(x));
				if(d!='_'&&d!=dig)
					code+=d;
				dig=d;
			}
		code+="000";
		out.println(code.substring(0,4));
	}
}
static char digCode(char a){
					switch(a)
				{
					case 'B':
					case 'F':
					case 'P':
					case 'V':return '1';
					case 'C':
					case 'G':
					case 'J':
					case 'K':
					case 'Q':
					case 'S':
					case 'X':
					case 'Z':return '2';
					case 'D':
					case 'T':return '3';
					case 'L':return '4';
					case 'M':
					case 'N':return '5';
					case 'R':return '6';
				}
					return '_';
				}
}
/*
Test data:
SMITH
SMYTH
CAMILA
WASHINGTON
ALLEN
JILLIANNE
PFISTER
JACKSON
ADAM
BARTEK
TYMCZAK
GUTIERREZ
DAIKI
LEE
EUI
FRANCISCO
GRACE
HE
IRINA
JORGE
KALYAN
LIPUN
BAILLEY
BROWN
MOSKOWITZ
MONAHAN
FITZSIMMONS

Test output:
S530
S530
C540
W252
A450
J450
P236
J250
A350
B632
T522
G362
D200
L000
E000
F652
G620
H000
I650
J620
K450
L150
B400
B650
M232
M550
F325
*/
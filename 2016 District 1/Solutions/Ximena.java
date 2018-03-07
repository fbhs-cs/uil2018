import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.*;
/**
 * Solution - Ximena, UIL District 1, 2016
 * @author Owen
 
Like Violeta, Ximena loves palindromes, and especially likes to create her own.  She'll take a sentence
and make a palindrome sentence, taking each word of the sentence, creating a double palindrome for each word.
A double palindrome is created when you take the first half of a word, spell it forwards, and then backwards,
and then the second half of the word, spell it forwards and backwards, and then connect those two into one
long word.
 
An even more fun thing Ximena loves to do is to take words with an odd number of characters, and do the
first half of the word in forwards/backwards order, and then the second part of the word in backwards/forwards order.
The middle letter of an odd length word is only used in the second half of the word.
 
For words of even length, she does the opposite - first half backwards/forwards, last half forwards/backwards. 
 
For example, using her name, XIMENA, she would make a double palindrome that looks like this: MIXXIMENAANE
Using her friend's name, VIOLETA, she would create this: VIOOIVATELLETA
For her other friend, ABE, the result is AAEBBE
 
Input: A list of capitalized names, each at least two letters and no more than 20 in length.

Output: A double palindrome, as described and demonstrated above, each on a separate line, in all caps.

Sample Input:
XIMENA
VIOLETA
ABE

Sample Output:
MIXXIMENAANE
VIOOIVATELLETA
AAEBBE
 
 */
public class Ximena {
	public static void main(String [] args) throws FileNotFoundException {
		Scanner f = new Scanner(new File("ximena.dat"));
		while(f.hasNext()) 
		{
			String s = f.next();
			out.println(s.length()%2==0?even(s):odd(s));
		}
	}
	//forbackbackfor
	static String odd(String s)
	{
		int mid = s.length()/2;
		StringBuilder first = new StringBuilder(s.substring(0,mid)); 
		String First = s.substring(0,mid); 
		StringBuilder sec = new StringBuilder(s.substring(mid)); 
		String Sec = s.substring(mid); 
		return First+new String(first.reverse())+new String(sec.reverse())+Sec;
	}
	//backforforback
	static String even(String s)
	{
		int mid = s.length()/2;
		StringBuilder first = new StringBuilder(s.substring(0,mid)); 
		String First = s.substring(0,mid); 
		StringBuilder sec = new StringBuilder(s.substring(mid)); 
		String Sec = s.substring(mid); 
		return new String(first.reverse())+First+Sec+new String(sec.reverse());
	}
}
/*
Test Data
XIMENA
VIOLETA
ABE
MADISON
WALTER
NICHOLAS
OKSANA
PATRICIO
RISHABH
JO
MADAM
MADDAM
RUMPLESTILTSKIN
WILHAMENADELCO

Test Output
MIXXIMENAANE
VIOOIVATELLETA
AAEBBE
MADDAMNOSIISON
LAWWALTERRET
HCINNICHOLASSALO
SKOOKSANAANA
RTAPPATRICIOOICI
RISSIRHBAHHABH
JJOO
MAAMMADDAM
DAMMADDAMMAD
RUMPLESSELPMURNIKSTLITTILTSKIN
EMAHLIWWILHAMENADELCOOCLEDAN

*/
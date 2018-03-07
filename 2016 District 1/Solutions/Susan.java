import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.*;
/**
 * Solution to Susan, UIL District 1, 2016 - Code Splitter
 * @author Owen
Susan is experimenting with simple encoding techniques to send messages. 
So far, she can only get single words or word fragments, so her codes don't quite make sense, 
but she will persist.
The encoded word or fragment is in the form of a sentence, with the last token of the 
sentence (enclosed in square brackets []) as the code, with an attached adjacent integer 
indicating the position in the resulting array of the encoded word or fragment.

For example, in the sentence:

ONE FLEW EAST, ONE FLEW WEST, ONE FLEW OVER THE CUCKOO'S NEST [ ]10

The output would be "CUCKOO'S" since that word is in position 10 of the resulting split array.

Input: Several sentences, each with a code token and integer at the end.

Output: The resulting word or word fragment for each input sentence and code token.
 
Sample Input:
ONE FLEW EAST, ONE FLEW WEST, ONE FLEW OVER THE CUCKOO'S NEST [ ]10
ONE IF BY LAND, TWO IF BY SEA [AN]3
METHINKS HE DOTH PROTEST TOO MUCH [O+]2

Sample Output:
CUCKOO'S
ND, TWO IF BY S
TEST T

 */
public class Susan {
	
	public static void main(String [] args) throws FileNotFoundException {
		Scanner f = new Scanner(new File("susan.dat"));
			
		while(f.hasNext()) 
		{
			String s = f.nextLine();
			int b1=s.indexOf("[");
			int b2=s.indexOf("]");
			String split = s.substring(b1,b2+1);
			int pos = Integer.parseInt(s.substring(b2+1));
			s=s.substring(0,b1);
			args=s.split(split);
			out.println(args[pos]);
		}
	}
}
/*
Test Input
ONE FLEW EAST, ONE FLEW WEST, ONE FLEW OVER THE CUCKOO'S NEST [ ]10
ONE IF BY LAND, TWO IF BY SEA [AN]3
METHINKS HE DOTH PROTEST TOO MUCH [O+]2
WHOSE WOODS THESE ARE I THINK I KNOW [AEIOU+]4
HIS HOUSE IS IN THE VILLAGE THOUGH [.]0
HIS HOUSE IS IN THE VILLAGE THOUGH [H]3
HIS HOUSE IS IN THE VILLAGE THOUGH [L+]0
HE WILL NOT SEE ME STOPPING HERE [P]2
TO WATCH HIS WOODS FILL UP WITH SNOW [W]3

Output
CUCKOO'S
D, TWO IF BY SE
TEST T
DS TH
HIS HOUSE IS IN THE VILLAGE THOUGH
E VILLAGE T
HIS HOUSE IS IN THE VI
ING HERE
ITH SNO

*/
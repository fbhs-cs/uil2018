/**
Thiago has lots of fun playing with encryption processes, and is experimenting with encoding his friends' names, first counting how many are on the list, then adding up the ASCII values of the capital letters in each person's name, and finally multiplying each person's sum by the number of people on the list to find each person's unique number code.
Help him with this interesting research by writing a program to help him out.

For example, in the data sample below there are three names, the first of which is Magda.  The values for the letters
M, A, G, and D are 77, 65, 71 and 68, for a total sum of 346 for all five letters.  The product of this value and 3 is 1038, the value Thiago assigns as the code number for Magda.

Input - A list of names, each on one line, with no symbols or spaces contained in any of them.

Output - Each capitalized name, followed by a single space, followed by the calculated integer code for that person, as described above.

Sample data:
Magda
Nicole
Oleg

Sample Output:
MAGDA 1038
NICOLE 1326
OLEG 885

 */
import java.io.*;
import java.util.*;
import static java.lang.System.*;
public class Thiago {
	public static void main(String [] args) throws FileNotFoundException {
//		Scanner k = new Scanner(in);
		Scanner f = new Scanner(new File("thiago.dat"));
		int num = 0;
		ArrayList<String>list = new ArrayList();
		while(f.hasNext()) {
			list.add(f.next().toUpperCase());
			num++;
		}//end of outside loop
		for(String s:list)
		{
			int sum=0;
			for(char a:s.toCharArray())
			{
				sum+=a;
				out.println((int)a+" "+sum);
			}
			out.println(s+" "+sum*num);
		}
	}
}
/*
Test Data:
Magda
Nicole
Oleg
Paulina
Quincy
Raj
Sakshi
Thiago
Veronika
Wayne
Yaroslav
Zoe

Test Output:
MAGDA 4152
NICOLE 5304
OLEG 3540
PAULINA 6264
QUINCY 5676
RAJ 2652
SAKSHI 5412
THIAGO 5328
VERONIKA 7284
WAYNE 4656
YAROSLAV 7500
ZOE 2856

*/
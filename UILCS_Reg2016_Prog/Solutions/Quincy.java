import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.*;

/**
Quincy loves floating point numbers, especially the classic irrational values like PI and E, because
they go on forever!  He has found some limited precision representations of these numbers, as well as several others with precision values of over 1000 places, and has decided to do some analysis research on them.
He wants to know how many instances of each digit there are in these values, and then represent those counts in a histogram.
He also wants to know how the frequency changes when the values are halved or doubled.

He starts with some easy values, just to test his process for accuracy, and then tries it on the longer ones.

For example, with the value 123456.7089, it is easy to see one instance of each digit.  
If he halves this value to get 61728.35445, the digit frequencies change a bit, and if
he doubles the value, they change again. 

He decided to output all three versions of the value - the original, half the value, and twice the value,
and then calculate and display the digit frequency for each one.  

Below are several results of his program.

By the number of stars, you can see one zero digit in the original number, but none in the the
half value or double value. The number of 2s, 3s, 6s, 7s, and 8s remains the same, and the remaining digits
change a bit.

123456.7089
61728.35445
246913.4178
0 *||
1 *|*|**
2 *|*|*
3 *|*|*
4 *|**|**
5 *|**|
6 *|*|*
7 *|*|*
8 *|*|*
9 *||*

Then he found a limited precision version of PI, containing 50 digits, and processed that value the same way,
with the following results.

3.141592653589793115997963468544185161590576171875
1.5707963267948965579989817342720925807952880859375
6.283185307179586231995926937088370323181152343750
0 *|****|****
1 *********|**|******
2 *|*****|*****
3 ****|***|*********
4 ****|**|*
5 *********|*******|*****
6 *****|***|***
7 *****|********|*****
8 ****|*******|******
9 *******|*********|*****

After searching some more, he found a version of PI with over 200 digits, and decided to modify the histogram output,
showing up to 25 stars for each count, or just a value followed by "*s" for any counts beyond 25,
so that his output would stay on the screen and not wraparound.  

He also limited the value output to no more than 60 digits for the same reason. Here is the outcome for that more precise value of PI.

3.1415926535897932384626433832795028841971693993751058209749
1.5707963267948966192313216916397514420985846996875529104874
6.2831853071795864769252867665590057683943387987502116419498
0 ********************|*******************|*****************
1 *********************|26*s|*************************
2 *************************|*************************|***********************
3 ********************|******************|****************
4 ************************|27*s|******************
5 **********************|***********************|********************
6 ******************|*******************|29*s
7 *************|*********************|******************
8 27*s|*************|***********************
9 ************************|************************|*************************

Write a program that will show Quincy's process as described above.

Input - several floating point values, each on one line, each containing at least 3 digits (including the .) and no more than 1000 digits.

Output - Three versions of each value - the original value, half the value, and twice the value - showing no more than 50 digits of each, followed by a histogram showing the digit frequency counts as described and shown above.

Sample input:
123456.7089
3.141592653589793115997963468544185161590576171875
3.14159265358979323846264338327950288419716939937510582097494459(...over 200 total digits)

Sample output:
See above. One blank line will follow each output set.

 */
public class Quincy {
	public static void main(String [] args) throws FileNotFoundException {
		Scanner f = new Scanner(new File("quincy.dat"));
		while(f.hasNext()) 
		{
			String st="*****************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************";
			BigDecimal d = new BigDecimal(f.next());
			BigDecimal two = new BigDecimal(2.0);
			BigDecimal dd = d.multiply(two);
			BigDecimal hd = d.divide(two);
			String s = d.toPlainString();
			String ds = dd.toPlainString();
			String hs = hd.toPlainString();
//			out.println(s);
			int limit = 60;
			int limit2 = 25;
			if(s.length()>=limit)
				out.println(s.substring(0,limit));
			else
				out.println(d.toString());
			int[]hist=new int[10];
			for(int x=0;x<s.length();x++)
				if(s.charAt(x)!='.')
				hist[s.charAt(x)-48]++;

			if(hs.length()>=limit)
				out.println(hs.substring(0,limit));
			else
				out.println(hs.toString());
			int[]histHalf=new int[10];
			for(int x=0;x<hs.length();x++)
				if(hs.charAt(x)!='.')
				histHalf[hs.charAt(x)-48]++;
			
			if(ds.length()>=limit)
				out.println(ds.substring(0,limit));
			else
				out.println(ds.toString());
			int[]histDub=new int[10];
			for(int x=0;x<ds.length();x++)
				if(ds.charAt(x)!='.')
				histDub[ds.charAt(x)-48]++;

			
			for(int x=0;x<10;x++)
				
				out.println(x +" "+(hist[x]<=limit2?st.substring(0,hist[x]):hist[x]+"*s")
					          +"|"+(histHalf[x]<=limit2?st.substring(0,histHalf[x]):histHalf[x]+"*s")
					          +"|"+(histDub[x]<=limit2?st.substring(0,histDub[x]):histDub[x]+"*s"));
			out.println();
		}
	}
}


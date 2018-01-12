/*
UIL Invitational B, 2016, Bartek - Solution

ASCII patterns are fun, but sometimes challenging.  Here's a good one for you! Given an
integer N, output a hexagon whose sides are of length N.

How you solve it - brute force or dynamic/elegant - is up to you.

Input: Several integers N (1<N<10), all on one line, separated by single spaces.

Output: A size N hexagon, made up of stars, as shown below, each output aligned on the left edge, and no blank lines between outputs.

Sample input:
2 3 4
Sample output:
 **
*  *
*  *
 **
  ***
 *   *
*     *
*     *
*     *
 *   *
  ***
   ****
  *    *
 *      *
*        *
*        *
*        *
*        *
 *      *
  *    *
   ****


*/
import java.util.*;
import java.io.*;
import java.util.function.*;
import static java.lang.System.*;
public class Bartek
{
	public static void main(String...bart) throws IOException
	{
		Scanner f = new Scanner(new File("bartek.dat"));
		while(f.hasNext())
			{
			int N = f.nextInt();
			out.printf("%"+N+"s","*");
			for(int x=0;x<N-1;x++)out.print("*");
			out.println();
			for(int x=1;x<N;x++)out.printf("%"+(N-x)+"s%"+(2*x+(N-1))+"s\n","*","*");

			for(int x=2;x<N;x++)out.printf("%s%"+(2*N+(N-3))+"s\n","*","*");
			for(int x=N-1;x>0;x--)out.printf("%"+(N-x)+"s%"+(2*x+(N-1))+"s\n","*","*");
			out.printf("%"+N+"s","*");
			for(int x=0;x<N-1;x++)out.print("*");
			out.println();
			
		}
	}
}
/*
Test data
2
3
4
6
8
10
Test output
 **
*  *
*  *
 **
  ***
 *   *
*     *
*     *
*     *
 *   *
  ***
   ****
  *    *
 *      *
*        *
*        *
*        *
*        *
 *      *
  *    *
   ****
     ******
    *      *
   *        *
  *          *
 *            *
*              *
*              *
*              *
*              *
*              *
*              *
 *            *
  *          *
   *        *
    *      *
     ******
       ********
      *        *
     *          *
    *            *
   *              *
  *                *
 *                  *
*                    *
*                    *
*                    *
*                    *
*                    *
*                    *
*                    *
*                    *
 *                  *
  *                *
   *              *
    *            *
     *          *
      *        *
       ********
         **********
        *          *
       *            *
      *              *
     *                *
    *                  *
   *                    *
  *                      *
 *                        *
*                          *
*                          *
*                          *
*                          *
*                          *
*                          *
*                          *
*                          *
*                          *
*                          *
 *                        *
  *                      *
   *                    *
    *                  *
     *                *
      *              *
       *            *
        *          *
         **********

*/
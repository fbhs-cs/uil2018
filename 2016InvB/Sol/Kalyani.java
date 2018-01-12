/*
UIL Invitational B, 2016, Kalyani - Solution

Kalyani loves numbers, and has been experimenting with an exercise with ranges of values.  She uses an overall range of 
real number values from 0.0 to 9.9, using only the one-place precision values, i.e., 0.0, 0.1, 0.2..4.5, 4.6,...9.7, 9.8, 9.9.
Each of those values is then mapped to another decimal value of any precision, for instance 2.365.  
She'll start with all of the values 0.0 through 9.9 mapping to 2.365, but then reassigns various ranges to different values.  
For instance, she could go from 1.3 up to but not including 4.5, where a new value is mapped to each number in that range, 
say 8.340.

A summary of those ranges would look like this:
0.0 1.2 2.365
1.3 4.4 8.340
4.5 9.9 2.365

Another range adjustment, using the values 3.6 7.5 4.23 (which means remap the values 3.6 to 7.4 to the value 4.23),
would yield a new summary:

0.0 1.2 2.365
1.3 3.5 8.340
3.6 7.4 4.23
7.5 9.9 2.365

A third adjustment, using 3.5 5.0 6.87, would be summarized as:

0.0 1.2 2.365
1.3 3.4 8.340
3.5 4.9 6.87
5.0 7.4 4.23
7.5 9.9 2.365

Input: An initial value N, followed by N sets of data.  Each data set starts with a decimal value, followed by
an integer Q.  Q sets of three values follow, all on one line, the first two indicating the range to be remapped, 
and the third the new value mapped to that range. All input values will be non-negative.

Output: The final summary of the value mappings, as shown in the example above and sample output below.

Sample input:
2
2.365
3
1.3 4.5 8.340
3.6 7.5 4.23
3.5 5.0 6.87
8.0
5
0.0 3.4 6.0
0.0 2.5 4.0
5.5 6.5 2.0
7.8 10.0 1.0
7.2 7.4 5.0

Sample output:
0.0 1.2 2.365
1.3 3.4 8.340
3.5 4.9 6.87
5.0 7.4 4.23
7.5 9.9 2.365

0.0 2.4 4.0
2.5 3.3 6.0
3.4 5.4 8.0
5.5 6.4 2.0
6.5 7.1 8.0
7.2 7.3 5.0
7.4 7.7 8.0
7.8 9.9 1.0

*/
import java.util.*;
import java.io.*;
import java.util.function.*;
import static java.lang.System.*;

class Kalyani {
	public static void main(String...kaly) throws IOException{
		Scanner f = new Scanner(new File("kalyani.dat"));
		int N = f.nextInt();
		while(N-->0)
		{
			kaly=new String[101];
			Arrays.fill(kaly,f.next());
			int n = f.nextInt();
			while(n-->0)
			{
				int from=(int)(f.nextDouble()*10);
				int to=(int)(f.nextDouble()*10);
				String fill=f.next();
				Arrays.fill(kaly,from,to,fill);
			}
			for(int x=0;x<100;x++)
			{
				if(x==0)
					out.print((double)x/10.0+" ");
				else
				if(x==99)
					out.println((double)x/10.0+" "+kaly[x]);
				else
				if(kaly[x+1]!=kaly[x])
				{
					out.println((double)x/10.0+" "+kaly[x++]);
					out.print((double)x/10.0+" ");
				}
				else
				if(kaly[x-1]!=kaly[x])
				{
					out.print((double)x/10.0+" ");
				}
			}
			out.println();
		}
	}
}

/*
Test data
4
2.365
3
1.3 4.5 8.340
3.6 7.5 4.23
3.5 5.0 6.87
8.0
5
0.0 3.4 6.0
0.0 2.5 4.0
5.5 6.5 2.0
7.8 10.0 1.0
7.2 7.4 5.0
3.14159265
2
3.4 6.6 2.14
9.0 10.0 0.000
9.999
0

Test output
0.0 1.2 2.365
1.3 3.4 8.340
3.5 4.9 6.87
5.0 7.4 4.23
7.5 9.9 2.365

0.0 2.4 4.0
2.5 3.3 6.0
3.4 5.4 8.0
5.5 6.4 2.0
6.5 7.1 8.0
7.2 7.3 5.0
7.4 7.7 8.0
7.8 9.9 1.0

0.0 3.3 3.14159265
3.4 6.5 2.14
6.6 8.9 3.14159265
9.0 9.9 0.000

0.0 9.9 9.999

*/
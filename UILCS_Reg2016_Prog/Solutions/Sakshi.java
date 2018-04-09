/**
After a recent math class unit on powers Sakshi is experimenting with various bases and exponents to make powers, and needs your help writing a program for her research.
For example, when she uses the base value 10 and exponent 2, she gets the value 100, and for 100 and 0.5, the result is 10, since 0.5 is the exponent when used gives the square root of a value.

Input - Several pairs of non-negative real numbers, each pair on one line, representing the base and exponent of a power P.

Output - The resulting value P, shown with a precision of three decimal places. A tolerance of +- 0.001 will be allowed.

Sample data:
10 2
100 .5
4.5 3
1.1 5

Sample Output:
100.000
10.000
91.125
1.611
 */
import java.io.*;
import java.util.*;
import static java.lang.System.*;
public class Sakshi {
	public static void main(String [] args) throws FileNotFoundException {
//		Scanner k = new Scanner(in);
		Scanner f = new Scanner(new File("sakshi.dat"));
		while(f.hasNext()) {
			double base = f.nextDouble();
			double log = f.nextDouble();
			out.printf("%.3f\n",Math.pow(base,log));
			
		}//end of outside loop
	}
}
/*
Test Data:
10 2
100 .5
4.5 3
1.1 5
13.97 0
100 2.5
12 8.2
99.9 .33
1937.471 3.4
0 4.35

Test Output:
100.000
10.000
91.125
1.611
1.000
100000.000
706783199.459
4.569
150175717806.293
0.000

*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.*;
/**
 * Solution to Jakub, UIL District 2, 2016
 * @author Owen

Jakub is quite the graphic artist and has been experimenting with drawing squares based patterns,
dividing a square into four parts, coloring two diagonal squares, and then dividing the
other two smaller squares into four parts, coloring two, dividing the other two, and so on
until the divided square reach a size smaller than 1 centimeter.

His analytical mind wonders what the area is of the colored squares, and sets out to do 
the math, but has some trouble figuring this out.

Please help Jakup calculate how much are of his repeatedly divided square is colored in.

For example, a 4 cm square divides into four 2X2 squares, each with an area of 4 cm, two 
of which he colors in for a total of 8 square centimeters. The other two are then divided
into four 1 cm squares, adding 4 sq cm to the colored area total, for a total of 12 sq cm,
and the remaining 1 cm square are divided into squares measuring 1/2 by 1/2, adding an
area of 2 more sq cm, for a total of 14 square centimeters of colored in area.

Input: Several integers N, each on one line, each representing the side length of a square.

Output: The total area for each NXN square colored in using the process described above.

Sample input:
4
24
16
10

Sample output:
14.000
558.000
248.000
93.750

 */
public class Jakub {
	public static void main(String [] args) throws FileNotFoundException {
		Scanner f = new Scanner(new File("jakub.dat"));
		while(f.hasNext()) 
		{
			out.printf("%.3f\n",f(f.nextDouble()));
		}
	}
	static double f(double s)
	{
		if(s>=1)
			return 2*f(s/2)+2*Math.pow(s/2,2);
		return 0;
	}
}
/*
Test input:
4
5
24
16
10
20
25
100
55
36
1

Test output:
14.000
21.875
558.000
248.000
93.750
387.500
605.469
9921.875
2977.734
1275.750
0.500

*/
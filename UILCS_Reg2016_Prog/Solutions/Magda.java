/**
Magda knows how to convert between bases with integer values, but has wondered about converting decimal values in different bases.  She found a tutorial that showed her how to do it by hand, and needs your
help writing a program to do this process. The tutorial says to repeatedly multiply a base ten decimal value by 2, taking the whole number value each time, leaving behind the fractional value, until the final answer is 1.0.

For example, to convert .140625 to its floating point equivalent in base 2, which is .001001, base 2, 
you do this:

.140625 * 2 equals 0.28125, which yields 0
.28124  * 2 equals 0.5625, which yields 0
.5625  * 2 equals 1.125, which yields 1
.125  * 2 equals 0.25, which yields 0
.25  * 2 equals 0.5, which yields 0
.5  * 2 equals 1.0, which yields 1

resulting in .001001 as the base two floating point value.

Input - A base ten floating point value.

Output - The first ten digits (or less, if the process terminates before that) of the equivalent base two floating point value. Do not print any digits to the left of the decimal point.

Sample data:
.140625
.111

Sample Output:
.001001
.0001110001

 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static java.lang.System.*;
public class Magda {
	public static void main(String [] args) throws FileNotFoundException {
		Scanner f = new Scanner(new File("magda.dat"));
		while(f.hasNext()) {
			double d = f.nextDouble();
			String s = ".";
			do
			{
				d*=2;
				char a = (""+d).charAt(0);
				s+=a;
				d%=1;
			}while(d%1>0);
			if(s.length()>11)
				out.println(s.substring(0,11));
			else
				out.println(s);
		}
	}
}
/*
Test Data:
.140625
.111
.105
.45
.25
.125
.001

Test Output:
.001001
.0001110001
.0001101011
.0111001100
.01
.001
.0000000001

*/
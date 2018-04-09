/**
Zoe has been practicing hard for a while for the upcoming State UIL programming contest, which she knows is on May 25, 2016 this year.  
She wanted to keep track of the dates that were so many days out from that important date, and needs 
you to write a program that will help her out with that, plus, she needs help with calendar type programs anyway.

She wants the program to calculate and output the date that is a certain number of days before the 
state contest date.  For example 10 days before that day is May 15, 2016, which she wants to be 
in the format mm/dd/yy, and would be 05/15/16.

Input - Several integers N (0<=N<=500), each on a separate line.

Output - The date in mm/dd/yy format that represents the given number of days N before May 25, 2016.

Sample data:
10
1
86

Sample Output:
05/15/16
05/24/16
02/29/16

 */
import java.io.*;
import java.util.*;
import static java.lang.System.*;
public class Zoe {
	public static void main(String [] args) throws FileNotFoundException {
//		Scanner k = new Scanner(in);
		Scanner f = new Scanner(new File("zoe.dat"));
		Calendar cal = Calendar.getInstance();
		cal.set(2016,4,25);
//		out.printf("%tD\n",cal);
		while(f.hasNext()) {
			cal.set(2016,4,25);
			cal.set(Calendar.DAY_OF_YEAR,cal.get(Calendar.DAY_OF_YEAR)-f.nextInt());
			out.printf("%tD\n",cal);
		}

	}
}
/*
Test Data:
10
1
86
30
56
4
1
100
0
200
300
365
500

Test Output:
05/15/16
05/24/16
02/29/16
04/25/16
03/30/16
05/21/16
05/24/16
02/15/16
05/25/16
11/07/15
07/30/15
05/26/15
01/11/15
	
*/
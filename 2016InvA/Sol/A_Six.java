/*
 UIL Invitational A, 2016, Program Six
 BubbaSpice

Bubba Gump's Spice Shop is old school.  Bubba has been keeping track of price changes
on a particular product all year - his secret spice packet called BubbaSpice for boiled shrimp - 
and needs to see a report of all of these changes, in chronological order.  He's been keeping a record 
of all changes on note cards, and is not real sure of the accuracy, but is pretty sure 
if all could be compiled into one report, he would have a true picture of the price changes.

For example, the first price set for period from January 1, 2016 to June 30 of the same year was $5.00.
It shows on the card as 1/1 6/30 5.00. The next card shows "2/1 3/15 5.21", which means that during that time
period, he raised the price to $5.21, but it went back down to 5.00 after that, starting on March 16 to June 30.  
Needless to say, he is very confused and needs your help.

Given the data as shown below, with each data set showing a starting date, ending date, and price, generate
a listing after each card is entered into the mix, of the sequence of price ranges from the first date to the 
last date of record.

The sample output below shows the correct sequence given the sample input data.

Input: Several data sets, each on one line, consisting of two dates in “m/d” format representing the 
starting and ending date of a price, followed by the price for that date range. The starting date will 
always be January 1, 2016, and the ending date will be on or before December 31, 2016.

Output: A complete chronological report AFTER EACH DATA SET of all the different price changes from the 
starting date of the collective dates to the final date in the range, with the word “END” after the final 
date in the range, and a single blank line following each report. The report must be formatted exactly as shown.

Sample Input: 
1/1 6/30 5.00
2/1 3/15 5.21
3/16 6/30 5.75
2/22 3/16 5.16

Sample Output: 
01/01/16 $5.00
06/30/16 END

01/01/16 $5.00
02/01/16 $5.21
03/16/16 $5.00
06/30/16 END

01/01/16 $5.00
02/01/16 $5.21
03/16/16 $5.75
06/30/16 END

01/01/16 $5.00
02/01/16 $5.21
02/22/16 $5.16
03/17/16 $5.75
06/30/16 END

 */
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.*;

public class A_Six {
	public static void main(String...cheese) throws IOException {
		Scanner f = new Scanner(new File("a_six.dat"));
		double[]list=new double[367];
		ArrayList<Calendar> dates = new ArrayList<Calendar>();
		while(f.hasNext())
		{
			Calendar start=Calendar.getInstance(), end=Calendar.getInstance();
			String d = f.nextLine();
			cheese=d.split("[ /]");
			int mon=Integer.parseInt(cheese[0])-1;
			int day=Integer.parseInt(cheese[1]);
			start.set(2016,mon,day);
			dates.add(start);
			mon=Integer.parseInt(cheese[2])-1;
			day=Integer.parseInt(cheese[3]);
			end.set(2016,mon,day);
			double price=Double.parseDouble(cheese[4]);
			int first = Integer.parseInt(String.format("%tj",start));
			int last = Integer.parseInt(String.format("%tj",end));
			Arrays.fill(list,first,last+1,price);
			Collections.sort(dates);
			double currentPrice=0;
			for(int x=0;x<list.length;x++)
			{
				if(list[x]!=currentPrice&&list[x]>0.0)
				{
					currentPrice=list[x];
					day = x;
					Calendar dd = Calendar.getInstance();
					dd.set(Calendar.YEAR,2016);
					dd.set(Calendar.DAY_OF_YEAR,day);
					out.printf("%tD $%.2f\n",dd,list[day]);
				}
				else
				if(x>0&&list[x]==0.0)
				{
					currentPrice=list[x-1];
					day = x-1;
					Calendar dd = Calendar.getInstance();
					dd.set(Calendar.YEAR,2016);
					dd.set(Calendar.DAY_OF_YEAR,day);
					out.printf("%tD END\n",dd);
					break;
				}
			}
			out.println();
		}
	}
}

/*
Test data:
1/1 6/30 3.25
1/1 2/3 3.5
2/15 3/5 3.45
4/20 5/20 3.17
1/1 1/30 3.33
1/15 2/28 3.42
6/2 6/2 3.60
5/12 6/1 3.00
5/13 5/31 3.25
5/20 5/26 3.36
1/5 1/20 3.55
6/15 11/30 5.00
7/1 10/8 10.00

Test Output:
01/01/16 $3.25
06/30/16 END

01/01/16 $3.50
02/04/16 $3.25
06/30/16 END

01/01/16 $3.50
02/04/16 $3.25
02/15/16 $3.45
03/06/16 $3.25
06/30/16 END

01/01/16 $3.50
02/04/16 $3.25
02/15/16 $3.45
03/06/16 $3.25
04/20/16 $3.17
05/21/16 $3.25
06/30/16 END

01/01/16 $3.33
01/31/16 $3.50
02/04/16 $3.25
02/15/16 $3.45
03/06/16 $3.25
04/20/16 $3.17
05/21/16 $3.25
06/30/16 END

01/01/16 $3.33
01/15/16 $3.42
02/29/16 $3.45
03/06/16 $3.25
04/20/16 $3.17
05/21/16 $3.25
06/30/16 END

01/01/16 $3.33
01/15/16 $3.42
02/29/16 $3.45
03/06/16 $3.25
04/20/16 $3.17
05/21/16 $3.25
06/02/16 $3.60
06/03/16 $3.25
06/30/16 END

01/01/16 $3.33
01/15/16 $3.42
02/29/16 $3.45
03/06/16 $3.25
04/20/16 $3.17
05/12/16 $3.00
06/02/16 $3.60
06/03/16 $3.25
06/30/16 END

01/01/16 $3.33
01/15/16 $3.42
02/29/16 $3.45
03/06/16 $3.25
04/20/16 $3.17
05/12/16 $3.00
05/13/16 $3.25
06/01/16 $3.00
06/02/16 $3.60
06/03/16 $3.25
06/30/16 END

01/01/16 $3.33
01/15/16 $3.42
02/29/16 $3.45
03/06/16 $3.25
04/20/16 $3.17
05/12/16 $3.00
05/13/16 $3.25
05/20/16 $3.36
05/27/16 $3.25
06/01/16 $3.00
06/02/16 $3.60
06/03/16 $3.25
06/30/16 END

01/01/16 $3.33
01/05/16 $3.55
01/21/16 $3.42
02/29/16 $3.45
03/06/16 $3.25
04/20/16 $3.17
05/12/16 $3.00
05/13/16 $3.25
05/20/16 $3.36
05/27/16 $3.25
06/01/16 $3.00
06/02/16 $3.60
06/03/16 $3.25
06/30/16 END

01/01/16 $3.33
01/05/16 $3.55
01/21/16 $3.42
02/29/16 $3.45
03/06/16 $3.25
04/20/16 $3.17
05/12/16 $3.00
05/13/16 $3.25
05/20/16 $3.36
05/27/16 $3.25
06/01/16 $3.00
06/02/16 $3.60
06/03/16 $3.25
06/15/16 $5.00
11/30/16 END

01/01/16 $3.33
01/05/16 $3.55
01/21/16 $3.42
02/29/16 $3.45
03/06/16 $3.25
04/20/16 $3.17
05/12/16 $3.00
05/13/16 $3.25
05/20/16 $3.36
05/27/16 $3.25
06/01/16 $3.00
06/02/16 $3.60
06/03/16 $3.25
06/15/16 $5.00
07/01/16 $10.00
10/09/16 $5.00
11/30/16 END

*/
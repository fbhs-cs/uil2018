import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.*;
/**
 * Solution to Ekaterina, UIL District 2, 2016
 * @author Owen

In the classic Jules Verne story Around The World In Eighty Days, the main character 
Phileas Fogg claimed he could do the title task, and made a huge bet with some of his 
friends, and then proceeded to head east, on his journey around the world.

Phileas was a fanatic about time, and was always checking the time and measuring how far he
had come, and what time it was in London, his demarcation point, and ultimate destination.

He would also try and predict what time it was in future destinations.  For example, 
if he was in London, he would be in the zero time zone, otherwise known as Greenwich Mean Time, 
based on the location of the Royal Observatory in Greenwich, a suburb of London. If he wanted 
to know the current time in France, all he would do is add an hour, since France was in the
next time zone to the east.

Currently all of the UK, Portugal, and parts of West Africa, are in the GMT zone. 
As you head East into continental Europe and beyond, you pass into other time zones, 
each one roughly 15 degrees to the East, with 360 degrees representing a full circumnavigation
of the globe.

Each new time zone eastward has a time difference of one hour more than the previous one.  
For example, France, Germany and Italy all are at 1 PM if Big Ben in London strikes noon.  
Beyond that into Eastern European countries, the next zone shows 2 PM, and so on, around 
the world.  

Heading west, the same thing happens, except in reverse.  Each time zone 15 degrees further 
west is another hour earlier. For example, New York City is 4 time zones to the west, 5 
hours earlier, so when it is 7AM in New York, it is already noon in London.

A number line to show this would have zero in the middle, indicating Greenwich time, 15E starting 
the time zone containing Western Europe, 30E starting the Eastern European zone, and so on.
Halfway around, at 180 degrees, is the International Date Line.
                             NY              GMT
IDL 165W 150W 135W....90W 75W 60W 45W 30W 15W 0 15E 30E 45E...135E 150E 165E IDL.

Phileas would have appreciate a computer program to help him keep track of all of this, like
the one you need to write to solve this problem.

Input: Several data sets, each on one line, consisting of four items. The first indicates 
the starting location, with a degree value between 0 and 180, inclusive, followed by the 
letter 'W' or 'E', the second a three letter abbreviation for the current day of the week, 
the third the two digit time of the current location, followed by "AM" of "PM", and the 
fourth the remote time zone, using the same format as the first data item.

Output: The day and time at the remote location, in the format HHXM, with HH meaning the 
two-digit time and the X either the letter 'P' or 'A'.

Sample input:
20E WED 01PM 0E
65W FRI 07AM 5E
4E SAT 06AM 23E
157W MON 07AM 110W
170E SAT 06PM 140W

Sample output:
Wed 12PM
Fri 12PM
Sat 07AM
Mon 10AM
Fri 09PM

 */
public class Ekaterina {
	public static void main(String [] args) throws FileNotFoundException {
		Map<String,Integer> dayNum = new HashMap();
		dayNum.put("MON",2);
		dayNum.put("TUE",3);
		dayNum.put("WED",4);
		dayNum.put("THU",5);
		dayNum.put("FRI",6);
		dayNum.put("SAT",7);
		dayNum.put("SUN",1);
		Scanner f = new Scanner(new File("ekaterina.dat"));
		while(f.hasNext()) 
		{
			Calendar start = Calendar.getInstance();
			Calendar end = Calendar.getInstance();
			args = f.nextLine().split(" ");
			//get start longtitude, positive for East, negative for West
			int last = args[0].length()-1;
			int startLong = Integer.parseInt(args[0].substring(0,last));
			startLong = args[0].charAt(last)=='E'?startLong:-startLong;
			//get end longtitude, positive for East, negative for West
			last = args[3].length()-1;
			int endLong = Integer.parseInt(args[3].substring(0,last));
			endLong = args[3].charAt(last)=='E'?endLong:-endLong;//get start day
			//get startDay
			int startDay = dayNum.get(args[1]);
			start.set(Calendar.DAY_OF_WEEK, startDay);
			end.set(Calendar.DAY_OF_WEEK, startDay);
			//get start time
			int startTime = Integer.parseInt(args[2].substring(0,2));
			startTime = args[2].charAt(2)=='A'?startTime:startTime+12;
			start.set(Calendar.HOUR_OF_DAY,startTime);
			end.set(Calendar.HOUR_OF_DAY,startTime);
			String time = String.format("%tR",start);
			
			int diffHour = endLong>=0&&startLong>=0||endLong<=0&&startLong<=0?
				endLong/15-startLong/15:(endLong-startLong)/15;
			if(endLong<0&&startLong>0)diffHour--;
			if(endLong>0&&startLong<0)diffHour++;
			
			end.set(Calendar.HOUR_OF_DAY,start.get(Calendar.HOUR_OF_DAY)+diffHour);
			String newTime = String.format("%tr",end);
			String endDay = String.format("%ta",end);
			out.printf("%s %s%Tp\n",endDay.toUpperCase(),newTime.substring(0,2),end);
			
		}
	}
}
/*
Test input:
20E WED 01PM 0E
65W FRI 07AM 5E
4E SAT 06AM 23E
157W MON 07AM 110W
170E SAT 06PM 140W
140W SAT 06PM 170E
77W FRI 08PM 149W
5E TUE 09AM 153E
153E WED 09PM 5E
25E MON 08AM 28E
40E MON 09AM 50E
25W TUE 10AM 65W
155W WED 11PM 89W
89W WED 11PM 155W
140E THU 10PM 20E
20E THU 10PM 140E

Test output:
WED 12PM
FRI 12PM
SAT 07AM
MON 10AM
FRI 09PM
SUN 03PM
FRI 04PM
TUE 07PM
WED 11AM
MON 08AM
MON 10AM
TUE 07AM
THU 04AM
WED 06PM
THU 02PM
FRI 06AM

*/
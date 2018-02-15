import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Calendar;

/* 
A + Feb 2016 Packet 1 Neighbor
Jed Wilshire
*/
public class Cheese {
	public void run() throws FileNotFoundException {
		Scanner f = new Scanner(new File("cheese.dat"));
		while (f.hasNext()) {
			long thenInt = f.nextLong();
			long nowInt = f.nextLong();
			// MMDDYYhhmmss
			Calendar then = Calendar.getInstance();
			Calendar now = Calendar.getInstance();
			
			// year, month, day, hour, min, second
			then = setCalendar(then, thenInt);
			now = setCalendar(now, nowInt);
			
			long diff = then.getTimeInMillis() - now.getTimeInMillis();
			
			// dd:hh:mm:ss
			diff /= 1000;
			int dd = (int) (diff / 1000000L);
			diff %= 1000000L;
			int hh = (int) (diff / 10000L);
			diff %= 10000L;
			int mm = (int) (diff / 100L);
			diff %= 100L;
			int ss = (int) (diff);
			System.out.println(dd + ":" + hh + ":" + mm + ":" + ss);
			
		}
		
	}
	
	public Calendar setCalendar(Calendar c, long x) {
		int month = (int) (x / 10000000000L) - 1;
		x %= 10000000000L;
		int day = (int) (x / 100000000L);
		x %= 100000000L;
		int year = (int) (x / 1000000L);
		x %= 1000000L;
		int hour = (int) (x / 10000L);
		x %= 10000L;
		int min = (int) (x / 100L);
		x %= 100L;
		int sec = (int) (x);
		
		// year, month, day, hour, min, second
		c.set(year, month, day, hour, min, sec);
		return c;
	}
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		new Cheese().run();
	}
}
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Calendar;
/* 
A + Feb 2016 Packet 2
Jed Wilshire
*/
public class Kanye {
	public void run() throws FileNotFoundException {
		Scanner f = new Scanner(new File("kanye.dat"));
		int testCases = Integer.parseInt(f.nextLine());
		while (testCases-- > 0) {
			String[] data = f.nextLine().split("[ ,]+");
			// Calendar is an abstract class, but we can 
			// get an instance created by the virtual machine.
			Calendar cal = Calendar.getInstance();
			// cal.set(int year, int month, int date)
			// month is 0 based, 0 = Jan.
			cal.set(Integer.parseInt(data[2]),
						getMonthNumber(data[0]),
							Integer.parseInt(data[1]));
			Calendar kan = Calendar.getInstance();
			kan.set(2020, 10, 3);
			long days = (kan.getTimeInMillis() - cal.getTimeInMillis()) / 1000 / 60 / 60 / 24;
			if (days <= 0) {
				System.out.println("Kanye in the house");
			} else {
				System.out.println( days + " day(s) until Kanye");
			}
		}
		
	}
	
	public int getMonthNumber(String month) {
		String[] months = {"January", "February", "March", "April",
						"May", "June", "July", "August",
						 "September", "October", "November", "December"};
		for (int i = 0; i < months.length; i++) {
			if (months[i].equals(month)) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		new Kanye().run();
	}
}
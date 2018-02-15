import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.Arrays;

public class Kanye {
	public static int findMonth(String month)
	{
		String[] months = {null,"January","February","March","April","May","June","July","August",
				"September","October","November","December"};

		for(int i=1;i<=12;i++)
		{
			if(month.equals(months[i]))
				return i;
		}
		return 0;
	}

	public static void main(String[] args)
	{
		LocalDate electionDay = LocalDate.of(2020, Month.NOVEMBER, 3);
		String data = "3\nNovember 3, 2020\nNovember 2, 2019\nAugust 2, 2018"; // like reading from file

		Scanner in = new Scanner(data);
		int n = in.nextInt();
		in.nextLine(); // throw away the \n!
		while(n-->0)
		{
			String line = in.nextLine().replaceAll(",", "");
			Scanner dateScanner = new Scanner(line);
			String month = dateScanner.next();
			int day = dateScanner.nextInt();
			int year = dateScanner.nextInt();
			int mon = findMonth(month);
			LocalDate date = LocalDate.of(year, mon, day);
			if (date.isAfter(electionDay) || date.isEqual(electionDay))
				System.out.println("Kanye in the house");
			else
				System.out.println(ChronoUnit.DAYS.between(date, electionDay) + " day(s) until Kanye");
		}

	}



}

import java.util.*;
import java.io.*;


public class Librarian {

	
	public static void main(String[] args) throws IOException 
	{
		Scanner in = new Scanner(new File("Librarian.dat"));
		int n = Integer.parseInt(in.nextLine());  // don't have to worry about the \n this way
		
		while(n-->0)
		{
			ArrayList<String> books = new ArrayList<String>();
			for(int i = 0;i<10;i++)
				books.add(new StringBuilder(in.nextLine()).reverse().toString());
			if(in.hasNextLine())
				in.nextLine();
			
			Collections.sort(books);
			ArrayList<String> out = new ArrayList<String>();
			for(String b:books)
				out.add(new StringBuilder(b).reverse().toString());
			
			for(String b:out)
				System.out.println(b);
			System.out.println();
		}
		
	}
	
}

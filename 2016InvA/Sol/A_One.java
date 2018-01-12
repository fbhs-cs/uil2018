/*
UIL Invitational A, 2016, Program A_One - Loopy Lambda

Java 8 has some really cool stuff! Below is a complete program that
creates list of integers and outputs the list in four different ways,
each one a bit simpler than the other. 

The first way is the traditional for loop process, which takes 53 characters to write.
The second way is the newer for each loop, with 29 characters.
The third way is the new Java 8 lambda expression way, with 30 characters.
The fourth way is new Java 8 double colon output technique, with 25 characters.

There is no input required for this program. Just it work as shown, using the four techniques shown:
* a traditional loop using an index value for accessing the List
* a for each loop
* a loop using a lambda expression
* the new shortcut for each loop

The judge will look at your source code to make sure it meets these criteria. You may use the exact code shown,
or produce your own version, as long as they meet the indicated criteria.  Have fun!

*/
import java.util.*;
import static java.lang.System.*;
class A_One
{
	public static void main(String...args)
	{
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		//traditional for loop
		for(int x=0;x<list.size();x++)
			out.print(list.get(x));
		out.println();
		//for each loop
		for(int n:list)
		    out.print(n);
		out.println();
		//lambda version...new with Java 8
		list.forEach(n->out.print(n));
		out.println();
		//new Java 8 double colon println...very cool!
		list.forEach(out::print);
		out.println();
	}
}
/*
1234567
1234567
1234567
1234567

*/
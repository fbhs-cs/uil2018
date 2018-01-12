/*
UIL Invitational B, 2016, Daiki - Solution

Daiki has a collection of weird Japanese toys, each of which has several characteristics.  He is trying to figure
a way to display his collection in some logical order, and has decided on the following process, based on these
characteristics. The characteristics of his weird toys are: dominant color, weight, and overall "weirdness".

He decides to make the primary difference to be their weight (heaviest first), then color (in alpha order), 
then overall weirdness on a scale of 1 to 10, 10 being the weirdest, the weirdest listed first. 
If there is a tie after all three characteristics are considered, the name of the toy is used to break the tie, 
again in alpha order.

Of course, the weirdness factor is totally subjective, but it is Daiki's opinion that matters, regardless of what anyone else thinks.

Some of his toys are: 
	Poop and Pee Plushies, brown, 120 grams, weird factor of 2
	H-Bouya USB Toy, blue, 25, 1
	Face Bank, red, 200, 4
	Virus Plush, yellow, 60, 3
	Road Kill Cat, white, 120 grams, weirdness 5
	
If you think this is all made up, just check it out on the web at:
http://www.tofugu.com/2013/09/19/ten-japanese-toys-you-might-want-to-reconsider-buying-for-your-children/

Input: Several weird toys, each on one line, with toy name, color, weight in grams, and weirdness factor, each part separated by commas, as shown below.

Output: All of the toys in sorted order, according to the criteria listed above.

Sample input:
Poop and Pee Plushies,brown,120,2
H-Bouya USB Toy,blue,25,1
Face Bank,red,200,4
Virus Plush,yellow,60,3
Road Kill Cat,white,120,5

Sample output:
Face Bank (heaviest)
Poop and Pee Flushies 
Road Kill Cat(tied in weight with Poop and Pee Plushies, but loses tie on color)
Virus Plush
H-Bouya USB Toy

*/
import java.util.*;
import java.io.*;
import java.util.function.*;
import static java.lang.System.*;
class Weird implements Comparable<Weird>{
	String name,color;
	int grams,weirdness;
	Weird(String n, String c, int g, int w){
		name=n;
		color=c;
		grams=g;
		weirdness=w;
	}
	public int compareTo(Weird toy)
	{
		if (grams==toy.grams&&color.equals(toy.color)&&weirdness==toy.weirdness)
			return name.compareTo(toy.name);
		if (grams==toy.grams&&color.equals(toy.color))
			if(weirdness>toy.weirdness)
				return -1;
			else
				return 1;
		if (grams==toy.grams)
			return color.compareTo(toy.color);
		return grams>toy.grams?-1:1;
	}
	public String toString()
	{
		return name;
	}
}
public class Daiki
{
	
	public static void main(String...weird) throws IOException
	{
		Scanner f = new Scanner(new File("daiki.dat"));
		ArrayList<Weird> list = new ArrayList();
		while(f.hasNext())
		{
			weird=f.nextLine().split(",");
			list.add(new Weird(weird[0],weird[1],Integer.parseInt(weird[2]),Integer.parseInt(weird[3])));
		}
		Collections.sort(list);
		for(Weird s:list)
			out.println(s);
	}
}
/*
Test data
Poop and Pee Plushies,brown,120,2
H-Bouya USB Toy,blue,25,1
Face Bank,red,200,4
Virus Plush,yellow,60,3
Road Kill Cat,white,120,5
Baby Shave,beige,120,9
Rubber Lips,red,200,5
Russian Roulette Toy Gun,red,200,6
Japanese Pregnant Doll,beige,400,10
Baby Microwave,beige,120,9

Test output
Japanese Pregnant Doll
Russian Roulette Toy Gun
Rubber Lips
Face Bank
Baby Microwave
Baby Shave
Poop and Pee Plushies
Road Kill Cat
Virus Plush
H-Bouya USB Toy
*/
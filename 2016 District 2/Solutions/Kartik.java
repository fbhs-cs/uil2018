import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.*;
/**
 * Solution to Kartik, UIL District 2, 2016
 * @author Owen
Kartik loves to mess around with his friends names, as well as his own, and has come up with several processes to do this.
For example, he may take the leftmost character of his name, delete it, and put a dash on the other end.
He calls this a left shift 1, or LS-1, for short. He would notate this as: LS-1 KARTIK, and would write the
result as KARTIK ==> ARTIK-

Similarly, he would do a Right Shift, followed by a number, and call it RS-N, with N being some integer value, no longer than the name
he is dealing with. He would make sure all of the numbers he chooses don't go beyond the number of letters in the name he is messing with.

He also does a "circulate", either to the right or to the left, with an N value indicating how many times to circulate, but again no greater than the length of the name he is messing with.
His notation for this is either RC-N, or LC-N. For example, if he did RC-2 AIGUO, the result would be: AIGUO ==> UOAIG, where the rightmost two letters of the names are circulated back to the other end of the name.

Another process he uses is Mid Circle, and he uses four items to control this one: S, indicating a starting position in the name, 1 being the first letter of the name,
L being a number that indicates how many letters of the name to be circulated, starting from S, X indicating how many times to circle the letters, and finally 
the character R or L to indicate the direction of the circulate. For example, MC-243R EKATERINA would take "KATE", which is 4 letters starting at position 2, and circulate those letters 3 times to the right,
which would make "ATEK", and thus the full effect would be: EKATERINA ==> EATEKRINA.

The last process he likes to use is a reverse, but not of all of the letters, but just a few somewhere in the name.
For example, if he applied a REV-42 to his friend's name, DAISUKE, he would start with the fourth letter, an S, taking 2 letters from there, SU, and reversing them within the name,
resulting in: DAISUKE ==> DAIUSKE

What he really likes to do is combinations.  For example, RS-2 REV-24 HEATHER, would first produce HHTAEER with the reverse, and then --HHTAE.
Sometimes he goes crazy and puts several combinations with a name, always doing the one closest to the name first, and then working backwards until all have been completed.

Input: Several lines of data, each on one line, each consisting of a process, or series of processes, ending with a name, all in caps.  Single spaces separate each item in the data line.
 
Output: The original name, followed by " ==> ", and then the resulting name after all processes have been completed.


 */
public class Kartik {
	static Scanner k;
	static String dash = "-----------------------";
	public static void main(String [] args) throws FileNotFoundException {
		Scanner f = new Scanner(new File("kartik.dat"));
		while(f.hasNext())
		{
			String s = f.nextLine();
			args=s.split(" ");
			Stack<String> stack = new Stack();
			for(String st:args)
				stack.push(st);
			s = stack.pop();
			out.print(s);
			while(!stack.isEmpty())
			{
				String p = stack.pop();
				String pp=p.substring(0,p.indexOf("-"));
				switch(pp)
				{
					case"LS":s=LS(s,p);break;
					case"RS":s=RS(s,p);break;
					case"LC":s=LC(s,p);break;
					case"RC":s=RC(s,p);break;
					case"MC":s=MC(s,p);break;
					case"REV":s=Rev(s,p);break;
//					case"LS":out.println("Left Shift "+p.substring(p.indexOf("-")+1));break;
//					case"RS":out.println("Right Shift "+p.substring(p.indexOf("-")+1));break;
//					case"LC":out.println("Left Circle "+p.substring(p.indexOf("-")+1));break;
//					case"RC":out.println("Right Circle "+p.substring(p.indexOf("-")+1));break;
//					case"MC":out.println("Mid Circle "+p.substring(p.indexOf("-")+1));break;
//					case"REV":out.println("Reverse "+p.substring(p.indexOf("-")+1));break;
				}
				if(stack.isEmpty())
					out.println(" ==> "+s);
			}
//			out.println();
		}
	}
	static String RS(String s,String p)
	{
		int n = Integer.parseInt(p.substring(p.indexOf("-")+1));
//		out.println("Right Shift-"+n+" on "+s);
		s = dash.substring(0,n)+s.substring(0,s.length()-n);
		return s;
	}
	static String LS(String s,String p)
	{
		int n = Integer.parseInt(p.substring(p.indexOf("-")+1));
//		out.println("Left Shift-"+n+" on "+s);
		s = s.substring(n)+dash.substring(0,n);
		return s;
	}
	static String LC(String s,String p)
	{
		int n = Integer.parseInt(p.substring(p.indexOf("-")+1));
//		out.println("Left Circle-"+n+" on "+s);
		s = s.substring(n)+s.substring(0,n);
		return s;
	}
	static String RC(String s,String p)
	{
		int n = Integer.parseInt(p.substring(p.indexOf("-")+1));
//		out.println("Right Circle-"+n+" on "+s);
		s = s.substring(s.length()-n)+s.substring(0,s.length()-n);
		return s;
	}
	static String MC(String s,String p)
	{
		int S = Integer.parseInt(p.substring(p.indexOf("-")+1,p.indexOf("-")+2))-1;
		int L = Integer.parseInt(p.substring(p.indexOf("-")+2,p.indexOf("-")+3));
		int X = Integer.parseInt(p.substring(p.indexOf("-")+3,p.indexOf("-")+4));
		char dir = p.charAt(p.length()-1);
//		out.println("Mid Circle-"+S+":"+L+":"+X+":"+p.charAt(p.length()-1)+" on "+s);
		if(dir=='L')
			s=s.substring(0,S)+LC(s.substring(S,S+L),"-"+X)+s.substring(S+L);
		else
			s=s.substring(0,S)+RC(s.substring(S,S+L),"-"+X)+s.substring(S+L);
		return s;
	}
	static String Rev(String s,String p)
	{
		int S = Integer.parseInt(p.substring(p.indexOf("-")+1,p.indexOf("-")+2))-1;
		int L = Integer.parseInt(p.substring(p.indexOf("-")+2,p.indexOf("-")+3));
//		out.println("Reverse-"+S+":"+L+" on "+s);
		StringBuilder sb = new StringBuilder(s.substring(S,S+L));
		sb.reverse();
		s= s=s.substring(0,S)+sb+s.substring(S+L);
		return s;
	}
}
/*
LS-1 KARTIK
RC-2 AIGUO
MC-243R EKATERINA
REV-42 DAISUKE
RS-2 REV-24 HEATHER
LS-2 CHIN
RS-1 LC-2 JAKUB
RC-3 MC-342L LAUREN
RC-2 LS-5 FELIPE
LS-1 LC-3 MC-453L SAMURAILAUNDRY
MC-352L MC-452R CHEVYCHASE
MC-342L LC-2 LS-6 REV-35 RS-1 ROSANNAROSANNADANNA

KARTIK ==> ARTIK-
AIGUO ==> UOAIG
EKATERINA ==> EATEKRINA
DAISUKE ==> DAIUSKE
HEATHER ==> --HHTAE
CHIN ==> IN--
JAKUB ==> -KUBJ
LAUREN ==> NURLAE
FELIPE ==> --E---
SAMURAILAUNDRY ==> LURAAUNDRYSAM-
CHEVYCHASE ==> CHAVYEHCSE
ROSANNAROSANNADANNA ==> RONNSAADANN------OA

*/
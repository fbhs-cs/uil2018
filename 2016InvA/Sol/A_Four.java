/*
UIL Invitational A, 2016, Program Four

SimpleCalc

This problem demonstrates a very simple command line calculator using the codes listed below.  Your job is to write
a program to evaluate the results of the commands listed.

The opcodes include:

DEF x y - Assign the y value into the x variable
STO x - Store the current memory value into the variable indicated
REC x - Place the value of x into current memory
ADD x - Add the x value into current memory
SUB x - Subtract x from current memory
MUL x - Multiply current memory by x
DIV x - Integer divide current memory by x
PRN x - Output value contained in variable indicated

Output: Show the results of each PRN command.

Sample Input:
DEF A 1
DEF B 2
DEF C 3
PRN C
REC A
MUL C
STO A
PRN A
DIV B
STO C
PRN C
SUB A
STO B
PRN B
ADD A
PRN A

Sample output:
3
3
1
-2
1
*/
import java.util.*;
import java.io.*;
import static java.lang.System.*;
class A_Four
{
	public static void main(String...theory) throws IOException{
		Scanner k = new Scanner(in);
		Scanner f = new Scanner(new File("a_four.dat"));
		int cm=0;//current memory
		Map<String,Integer> m = new HashMap<String,Integer>();
		while(f.hasNext())
		{
			{
				String s = f.nextLine();
				switch(s.substring(0,3))
				{
					case "DEF": m.put(s.substring(4,5),Integer.parseInt(s.substring(6)));break;
					case "PRN": out.println(m.get(s.substring(4,5)));break;
					case "REC": cm = m.get(s.substring(4,5));break;
					case "STO": m.put(s.substring(4,5),cm);break;
					case "ADD": cm+=m.get(s.substring(4,5));break;
					case "SUB": cm-=m.get(s.substring(4,5));break;
					case "MUL": cm*=m.get(s.substring(4,5));break;
					case "DIV": cm/=m.get(s.substring(4,5));break;
				}
			}
		}
	}
}
/*
DEF A 1
DEF B 2
DEF C 3
PRN C
REC A
MUL C
STO A
PRN A
DIV B
STO C
PRN C
SUB A
STO B
PRN B
ADD A
PRN A
DEF X 4
DEF Y 6
REC X
ADD Y
STO Z
PRN Z
STO X
PRN X
MUL Y
DIV X
STO Z
PRN Z
SUB X
STO Z
PRN Z
DEF W -2
DIV W
STO Z
PRN Z

3
3
1
-2
3
10
10
6
-4
2

*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.*;
/**
 * Solution to Daisuke, UIL District 2, 2016
 * @author Owen

Daisuke loves to create doubly symmetrical character patterns, like the one shown below.  
Your job is to write a program that outputs this exact example of his work.

Input: NONE
 
Expected output:

\""""/
%\''/%
%.\/.%
%./\.%
%/''\%
/""""\

 */
public class Daisuke {
	public static void main(String [] args) throws FileNotFoundException {
		out.println("\\\"\"\"\"/");
		out.println("%\\''/%");
		out.println("%.\\/.%");
		out.println("%./\\.%");
		out.println("%/''\\%");
		out.println("/\"\"\"\"\\");
	}

}
/*
7 2 B C
15 1 A
10 2 B A
130 4 F D E G
20 4 D C B A
40 3 E D A
12 3 D B A
25 2 E A
211 3 G H A
250 3 D H A

6 4
1 8
3 5
120 64
15 8
25 16
11 5
17 10
193 84
137 123

*/
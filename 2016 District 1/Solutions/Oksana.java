import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.*;
/**
 * Solution to Oksana, UIL District 1, 2016 - 
 * @author Owen
Oksana loves to play the Connect Dots game, but gets really tired of drawing out the
dots on paper.  She wants to be able to print them out, but needs your help.

Below is picture of an 8X8 grid of dots. The dots in each row have a space between,
but the rows do not. Write a program to output this exact pattern.

Input: None

Output: The 8X8 grid of dots as shown below.
 
Expected Output:
* * * * * * * *
* * * * * * * *
* * * * * * * *
* * * * * * * *
* * * * * * * *
* * * * * * * *
* * * * * * * *
* * * * * * * *

*

 */
public class Oksana {
	
	public static void main(String [] args) throws FileNotFoundException {
		for(int x=0;x<8;x++)
			out.println("* * * * * * * *");
	}
}
/*
Input
None
Output
* * * * * * * *
* * * * * * * *
* * * * * * * *
* * * * * * * *
* * * * * * * *
* * * * * * * *
* * * * * * * *
* * * * * * * *

*/
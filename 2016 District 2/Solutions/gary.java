import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.*;
/**
 * Solution to Gary, UIL District 2, 2016
 * @author Owen
 
Gary has just encountered boolean postfix expressions in class, and is a bit confused.  
He understands the easy ones, like, "true and false" becomes "true false and", 
and knows how to evaluate them, with "and" giving true only when both operands are "true", 
"or" being "false" only when both operands are "false", xor "true" only when the operand values
are opposite, and "not" just reversing the value from true to false, or vice versa.

It's evaluating the more complex ones in postfix form that give him a bit of trouble.

For example, "true or false and true" is confusing to him.  "What is the postfix version?",
he wonders, "and then what is the answer?"  Well, his teacher helps him out and for now 
and just gives him the postfix version, which is "true false true and or", and then shows 
him how to process it.  

His teacher says, "Take the first two boolean values and see if there is an operator 
immediately after them. If there is, do that operation, and replace the result in 
place of that expression.  If not, ignore the first operand for now, and look at the 
next pair to see if there is an operator following, and evaluate it and replace it with 
an answer."

"In the example, "true false true and or", there is no operator for the first two 
operands, so you ignore the first operand and look at the next two, which have an "and" 
after them.  Well, "false and true" evaluates to "false", so you replace the 
"false true and" with just "false", which now gives you the expression, "true false or", 
which is "true", and is the final value of the expression.

"If you have a "not" in the expression, like this one, "true false or not", the result here
would first be, "true not", since "true false or" becomes "true", and then "false", since 
the "not" operator only needs one operand, and "not true" means "false"."

Input: Several lines of data, each line with a postfix boolean expression made up of the 
words, "true", "false", "not", "and", "or", and "xor", with no parentheses, all separated 
by single spaces.

Output: The final true or false value of the postfix boolean expression.
 
Sample input:
true true or
true false and
true false true and or
true false or not

Sample output:
true
false
true
false

 */
public class Gary {
	public static void main(String [] args) throws FileNotFoundException {
		Scanner f = new Scanner(new File("gary.dat"));
		while(f.hasNext()) 
		{
			String post = f.nextLine();
			out.println(evalPostfix(post));
		}
	}
	public static boolean calc(boolean one, boolean two, String op)
	{
		if(op.equals("or"))
		  return one || two;
		if(op.equals("and"))
		  return one && two;
	    if(op.equals("xor"))
		  return one ^ two;
		if(op.equals("not"))
		  return !one;
		return true;
	}
	public static boolean evalPostfix(String post)
	{
		Stack<Boolean> s = new Stack<>();
		String [] t = post.split("\\s+");
		for(String tok:t)
		{
		  if(tok.equals("not"))
		  {
		  	boolean one = s.pop();
		  	s.push(calc(one,true,tok));
		  }
		  else
		  if(tok.equals("and")||tok.equals("or")||tok.equals("xor"))
		  {
			boolean one = s.pop();
			boolean two = s.pop();
			s.push(calc(two,one,tok));
		  }		
		  else
		    s.push(Boolean.parseBoolean(tok));
		}
		return s.pop();
	}
	private static int precedence(String p)
	{
		if(p.equals("not"))
		  	return 4;
		if(p.equals("and"))
		  	return 3;
		if(p.equals("xor"))
		  	return 2;
		if(p.equals("or"))
		  	return 1;
		 return 0;
	}
}
/*
Test input:
true true or
true false and
true false true and or
true false or not
false not false not or
true false xor
false false and not false true or xor 
true false xor true or 
false true false xor or
true true or true false or xor
false true or false true or not and
false false and false not or
true true or true true or and true not true or xor

Test output:
true
false
true
false
true
true
false
true
true
false
false
true
false

*/
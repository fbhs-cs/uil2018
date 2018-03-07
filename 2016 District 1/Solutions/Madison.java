import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.*;
/**
 * Solution to Tell The Truth - Madison, UIL District 1, 2016
 * @author Owen
 
 Madison always tells the truth, well, sometimes.  She uses the words "and", "or", "not", and "xor" when
 talking about several things at the same time.  For example she would say, "I took out the trash and fed the dog". 
 If indeed she did both things, the she would be telling the truth.  However, if she really did not feed the dog, 
 then she would not be telling the truth.  
 
 Now if she said, "I did NOT take out the trash or I fed the dog.", the situation would be true if she did indeed feed the dog
 or did not take out the trash.  As long as one of the two situations was true, she would be telling the truth.
 
 What's really confusing is when she says, "xor".  This means that she is telling the truth when only one of the two things
 is true.  For example, if she says, "I fed the dog xor I cleaned my room.", she would only be telling the truth if she only did
 one of those two things.  If she did both, it would be a lie, or if she did neither, that would also be false.
 
 We'll represent two or three situations using the letters A, B and C, in some kind of complex expression using NOT(!), AND(*), XOR(^) and OR(+), 
 in that order of priority.  In other words, NOT has top priority, and OR has lowest priority. You'll also know the true or false
 state of each letter.  
 
 For example, for the expression A+B, and the values 11, which means A is 1 and B is 1, the final result will be true, because
 true OR true is true.  
 
 For the expression A*B, and the values 10, the final result would be false, since true AND false is false.
 
 There may be parentheses involved as well, in which case the expression inside would be evaluated first.
 
 There will be no instances of nested parentheses.
 
 Input: Several lines of data, each line with an expression containing no spaces, followed by a two or three digit string of zeros and ones,
 representing the corresponding values of the variables in the expression.
 
 Output: The final true or false value of the expression, given the initial values of each variable.
 
 
 */
public class Madison {
	static boolean A,B,C;
	static Scanner k;
	public static void main(String [] args) throws FileNotFoundException {
		Scanner f = new Scanner(new File("madison.dat"));
//		k = new Scanner(in);
		while(f.hasNext()) 
		{
			args = f.nextLine().split(" ");
			String exp = args[0];
			String boo = args[1];
			
			A = boo.charAt(0)=='1';
			B = boo.charAt(1)=='1';
			C = boo.length()==3&&boo.charAt(2)=='1';
			String post = fromInfixToPostfix(exp);
			out.println(evalPostfix(post));
}
	}
	public static boolean calc(boolean one, boolean two, String op)
	{
		if(op.equals("+"))
		  return one || two;
		if(op.equals("*"))
		  return one && two;
	    if(op.equals("^"))
		  return one ^ two;
		if(op.equals("!"))
		  return !one;
		return true;
	}
	public static boolean evalPostfix(String post)
	{
		Stack<Boolean> s = new Stack<>();
		String [] t = post.split("\\s+");
		for(String tok:t)
		{
		  if(tok.equals("!"))
		  {
		  	boolean one = s.pop();
		  	s.push(calc(one,true,tok));
		  }
		  else
		  if(tok.matches("[+*]")||tok.equals("^"))
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
		if(p.equals("!"))
		  	return 4;
		if(p.equals("*"))
		  	return 3;
		if(p.equals("^"))
		  	return 2;
		if(p.equals("+"))
		  	return 1;
		 return 0;
	}
	public static String fromInfixToPostfix(String in)
	{
		String post = "";
		String exp = "";
		for(int x=0;x<in.length();x++)
			exp+=in.charAt(x)+" ";
		exp = exp.trim();
		String [] t = exp.split(" ");
		Stack <String> s = new Stack<String>();
		for(String token:t)
		{
			if(token.equals("("))
		  	  s.push(token);
			else
			if(token.equals(")"))
			{
			  //pop and append all operators until the "(" is encountered
			  while(!s.empty()&&!s.peek().equals("("))
			       post += s.pop()+" ";
			  //pop the "("
			  s.pop();
			}
			else
			if(token.matches("[+!*]")||token.equals("^"))
			 {
			 	//pop and append each operator that has greater or 
			 	//equal precedence than the current operator
			 	while(!s.empty() && precedence(s.peek())>=precedence(token))
			 		post += s.pop() + " ";
			 	//push the current operator
			 	s.push(token);
			 }
			 else
			 //append the boolean value
			   switch(token)
			   {
			   		case "A":post += A + " "; break;
			   		case "B":post += B + " "; break;
			   		case "C":post += C + " "; break;
			   }
		}
		//pop and append all remaining operators
		while(!s.empty())
		  post += s.pop()+" ";
		
		return post;
	}
}
/*
A+B 11
A*B 10
A+B*C 101
A^B 01
!(A+B) 10
!A+!B 00
(!A*B)^(B+C) 001
A^B+C 101
A+B^C 010
(A+B)^(B+C) 110
(A+B)*!(A+B) 011
A*B+!C 000
(A+B)^(A+C)*(!A+C) 111

true
false
true
true
false
true
true
true
true
false
false
true
false

*/
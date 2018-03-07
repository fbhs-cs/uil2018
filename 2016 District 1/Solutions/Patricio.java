import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * UIL 2016 District 1, Patricio
 * @author sno
 * 
 * Given an expression of the form z = x^3 + 50x + t^2 + x^2y + x^y + xyt 
 * find the values of x, y, and t that yields the highest value for z, with
 * x and y at a grandularity of 0.1 between 0 and the given max (inclusive) 
 * and t with a granularity of 1.0.  
 *
 */
public class Patricio {
	
	public static void main(String [] args) throws FileNotFoundException {
		Scanner f = new Scanner(new File("patricio.dat"));
		int N = f.nextInt();f.nextLine();
		while(N-- > 0) {
			String expression = f.nextLine();
			double xLimit = f.nextDouble();
			double yLimit = f.nextDouble();
			double zLimit = f.nextDouble();
			try {
				f.nextLine();
			} catch (NoSuchElementException e) {
				// do nothing; end of file
			}
			
			String updatedExpression = "";
			
			for(int i = expression.indexOf('=') ; i < expression.length()-1; i++) {
				if((expression.charAt(i) != '^' && expression.charAt(i) != ' ' 
						&& expression.charAt(i) != '(' && expression.charAt(i) != '-'
						&& expression.charAt(i) != '/' && expression.charAt(i) != '*') 
						&& (expression.charAt(i+1) == 'x' || expression.charAt(i+1) == 'y' 
						|| expression.charAt(i+1) == 't')) {
					updatedExpression += "*";
				}
				updatedExpression += expression.charAt(i+1);
			}
			//System.out.println(updatedExpression);
			double max = 0;
			double xSolution = 0;
			double ySolution = 0;
			double tSolution = 0;
			// iterate through all possible soln's
			for(double x = 0; x <= xLimit; x+=0.1) {
				for(double y = 0; y <= yLimit; y+=0.1) {
					for(double t = 0; t <= zLimit; t++) {
						// replace vars in expression with values
						String evalExpression = updatedExpression.replaceAll("x", x+"");
						evalExpression = evalExpression.replaceAll("y", y+"");
						evalExpression = evalExpression.replaceAll("t", t+"");
												
						double val = (new Parser(evalExpression)).parse();
						if(val > max) {
							if(val >= Double.MAX_VALUE){
								// means we divided by 0 somewhere
								continue;
							}
							// this is the highest so record the solution
							xSolution = x;
							ySolution = y;
							tSolution = t;
							max = val;
						}
					}
				}
			}
			System.out.printf("Patricio should launch at x=%.1f and y=%.1f at t=%.0f at a height of %.1f.\n", 
					xSolution, ySolution, tSolution, max);
		}
	}
}
/**
 * Parser for an expression of the form 2^3 - 3 + 1 + 3 * ((4+4*4)/2) / 5 + -5.
 */
class Parser {
    int pos = -1, c;
    String str;
    public Parser(String str) {
    	this.str = str;
    }

    void eatChar() {
        c = (++pos < str.length()) ? str.charAt(pos) : -1;
    }

    void eatSpace() {
        while (Character.isWhitespace(c)) eatChar();
    }

    double parse() {
        eatChar();
        double v = parseExpression();
        if (c != -1) throw new RuntimeException("Unexpected: " + (char)c);
        return v;
    }

    double parseExpression() {
        double v = parseTerm();
        for (;;) {
            eatSpace();
            if (c == '+') { // addition
                eatChar();
                v += parseTerm();
            } else if (c == '-') { // subtraction
                eatChar();
                v -= parseTerm();
            } else {
                return v;
            }
        }
    }

    double parseTerm() {
        double v = parseFactor();
        for (;;) {
            eatSpace();
            if (c == '/') { // division
                eatChar();
                v /= parseFactor();
            } else if (c == '*' || c == '(') { // multiplication
                if (c == '*') eatChar();
                v *= parseFactor();
            } else {
                return v;
            }
        }
    }

    double parseFactor() {
        double v;
        boolean negate = false;
        eatSpace();
        if (c == '+' || c == '-') { // unary plus & minus
            negate = c == '-';
            eatChar();
            eatSpace();
        }
        if (c == '(') { // brackets
            eatChar();
            v = parseExpression();
            if (c == ')') eatChar();
        } else { // numbers
            StringBuilder sb = new StringBuilder();
            while ((c >= '0' && c <= '9') || c == '.') {
                sb.append((char)c);
                eatChar();
            }
            if (sb.length() == 0) throw new RuntimeException("Unexpected: " + (char)c);
            v = Double.parseDouble(sb.toString());
        }
        eatSpace();
        if (c == '^') { // exponentiation
            eatChar();
            v = Math.pow(v, parseFactor());
        }
        if (negate) v = -v; // unary minus is applied after exponentiation; e.g. -3^2=-9
        return v;
    }
}
/*
Test Data
10
z = x^3 + 50x + t^2 + x^2y + x^y + xyt
5.0 5.0 10
z = x^2 + y^2 + t^2
10.0 10.0 100
z = -5x^2 + 4x + -5y^2 + 4y + -5t^2 + 4t
2.0 2.0 10
z = ((x^y)^t)^x
1.0 1.0 10
z = -x - 2y - t
1.0 2.0 5
z = (x + 2) * (-2x + 5) - y^4 + 2y - t^2 + 7t
5.0 1.0 19
z = (x + 2y) * (4t - x) * (7.6y + t)
4.3 0.5 63
z = x + y - t
7.0 0.5 15
z = x/(y/t)
0.5 0.5 10
z = (x + y)^t - t^2 + t
3.0 3.0 25

Test Output
Patricio should launch at x=5.0 and y=5.0 at t=10 at a height of 3975.0.
Patricio should launch at x=10.0 and y=10.0 at t=100 at a height of 10200.0.
Patricio should launch at x=0.4 and y=0.4 at t=0 at a height of 1.6.
Patricio should launch at x=0.0 and y=0.0 at t=0 at a height of 1.0.
Patricio should launch at x=0.0 and y=0.0 at t=0 at a height of 0.0.
Patricio should launch at x=0.2 and y=0.8 at t=3 at a height of 23.3.
Patricio should launch at x=4.2 and y=0.5 at t=63 at a height of 86075.8.
Patricio should launch at x=7.0 and y=0.5 at t=0 at a height of 7.5.
Patricio should launch at x=0.5 and y=0.1 at t=10 at a height of 50.0.
Patricio should launch at x=2.9 and y=2.9 at t=25 at a height of 12181473901262774000.0.
*/
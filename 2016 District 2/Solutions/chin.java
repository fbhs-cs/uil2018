
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 * @author sno
 * 
 * Given some expression, use string manipulation to find the expression representing the derivative of that
 * function and evaluate that at the given floating point.
 * 
 */
public class Chin {
	public static void main(String [ ] args) throws FileNotFoundException {
		Scanner f = new Scanner(new File("chin.dat"));
		
		int N = f.nextInt();f.nextLine();
		
		while(N-- > 0) {
			StringBuffer derivative = new StringBuffer();
			String eqn = f.nextLine() + "      ";
			double evaluatedAt = f.nextDouble();
			try {
				f.nextLine();
			} catch (NoSuchElementException nsee) {
				//do nothing
			}
			String eqn2 = " 0 + " + eqn + " + 0";
			while(eqn2.indexOf("+") >= 0 || eqn2.indexOf("-") >=0) {
				int indexPlus = eqn2.indexOf("+");
				int indexMinus = eqn2.indexOf("-");
				int index = -1;
				if(indexMinus >= 0 && indexPlus >= 0) {
					index = Math.min(indexMinus, indexPlus);
				} else if (indexPlus >= 0){
					index = indexPlus;
				} else {
					index = indexMinus;
				}
				
				int nextIndexPlus = eqn2.indexOf("+", index+1);
				int nextIndexMinus = eqn2.indexOf("-", index+1);
				int nextIndex = -1;
				if(nextIndexPlus >= 0 && nextIndexMinus >= 0) {
					nextIndex = Math.min(nextIndexPlus, nextIndexMinus);
				} else if (nextIndexMinus >= 0) {
					nextIndex = nextIndexMinus;
				} else if (nextIndexPlus >= 0) {
					nextIndex = nextIndexPlus;
				} else {
					nextIndex = eqn2.length()-1;
				}
				String term = eqn2.substring(index, nextIndex);
				if(term.contains("x")) {
					derivative.append(term);
				}
				eqn2 = eqn2.substring(index+1);
			}
			eqn = "0 " + derivative.toString() + "     ";
			derivative = new StringBuffer();
			for(int i = 0; i < eqn.length(); i ++) {
				try {
					if(eqn.substring(i-1, i+1).equals("x^")) {
						// for an exponent, take one down and pass it around;
						derivative.append(eqn.substring(i+1, eqn.indexOf(" ", i+1)) + " * x^" + (Integer.parseInt(eqn.substring(i+1, eqn.indexOf(" ", i+1)))-1) + " ");
						i+=(eqn.indexOf(" ", i+1) - (i-1));
					} else {
						derivative.append(eqn.charAt(i-1));
					}
				} catch (Exception e) {
					//continue
				}
			}
			eqn = derivative.toString() + "     ";
			derivative = new StringBuffer();
			for(int i = 0; i < eqn.length(); i ++) {
				try {
					if(eqn.substring(i-1, i+4).equals(" * x ")) { 
						// only add the coefficient to the string buffer (which has already been added)
						i+=3;
					}
					else if(eqn.substring(i-1, i+3).equals("x * ")) {
						// only add the coefficient to the string buffer (post script)
						i+=3;
					}
					else if(eqn.substring(i-1, i+3).equals("x / ")) {
						// add one over the value as the coefficient
						derivative.append("1 /" + eqn.substring(i+2, i+3));
						i+=3;
					} else if (eqn.substring(i-1,i+2).equals(" x ")){
						derivative.append(" 1");
						i+=2;
					} else {
						derivative.append(eqn.charAt(i-1));
					}
				} catch (Exception e) {
					//continue
				}
			}
			String evaluate = derivative.toString().replaceAll("x", evaluatedAt+"");
			System.out.printf("%.2f\n",(new DerivativeParser(evaluate)).parse());
		}
	}
}
/**
 * Parser for an expression of the form 2^3 - 3 + 1 + 3 * ((4+4*4)/2) / 5 + -5.
 */
class DerivativeParser {
    int pos = -1, c;
    String str;
    public DerivativeParser(String str) {
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
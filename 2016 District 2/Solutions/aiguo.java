import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author sno
 * 
 * Given two strings, use a dynamic programming solution to find the longest common
 * subsequence of the two strings, and use that solution to derive which characters
 * exist in the final string that aren't part of the common subsequence (added) and 
 * which characters are part of the inital and aren't part of the common subsequence 
 * (deleted).
 * 
 */
public class Aiguo {
	public static void main(String [] args) throws FileNotFoundException {
		Scanner f = new Scanner(new File("aiguo.dat"));
		int N = f.nextInt();f.nextLine();
		while(N-- > 0) {
			String initialFile = f.nextLine();
			String finalFile = f.nextLine();
			System.out.println("unchanged: " + lcs("^" + initialFile, "^" + finalFile));
		}
	}

	public static String lcs(String a, String b) {
	    int[][] lengths = new int[a.length()+1][b.length()+1];
	 
	    // row 0 and column 0 are initialized to 0 already
	    for (int i = 0; i < a.length(); i++)
	        for (int j = 0; j < b.length(); j++)
	            if (a.charAt(i) == b.charAt(j))
	                lengths[i+1][j+1] = lengths[i][j] + 1;
	            else
	                lengths[i+1][j+1] =
	                    Math.max(lengths[i+1][j], lengths[i][j+1]);
	 
	    // read the substring out from the matrix
	    StringBuffer same = new StringBuffer();
	    StringBuffer removed = new StringBuffer();
	    StringBuffer added = new StringBuffer();
	    for (int x = a.length(), y = b.length();
	         x != 0 && y != 0; ) {
	        if (lengths[x][y] == lengths[x-1][y]) {
	        	x--;
	        	removed.append(a.charAt(x));
	        }
	        else if (lengths[x][y] == lengths[x][y-1]) {
	        	y--;
	        	added.append(b.charAt(y));
	        }
	        else {
	            assert a.charAt(x-1) == b.charAt(y-1);
	            same.append(a.charAt(x-1));
	            x--;
	            y--;
	        }
	    }
	    
	    System.out.println("removed: " + removed.reverse().toString());
	    System.out.println("added: " + added.reverse().toString());
	    return same.reverse().substring(1).toString();
	}
}

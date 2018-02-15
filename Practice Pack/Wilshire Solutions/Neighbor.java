import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* 
A + Feb 2016 Packet 1 Neighbor
Jed Wilshire
*/
public class Neighbor {
	public void run() throws FileNotFoundException {
		Scanner f = new Scanner(new File("neighbor.dat"));
		while (f.hasNext()) {
			int n1 = f.nextInt();
			int d1 = f.nextInt();
			int n2 = f.nextInt();
			int d2 = f.nextInt();
			int resultn = Math.abs(n1 * d2 - n2 * d1);
			int resultd = d2 * d1;
			int factor = gcd(resultn, resultd);
			resultd /= factor;
			resultn /= factor;
			if (resultn == 1) {
				System.out.println(resultn + "/" + resultd);
			} else {
				System.out.println("NOT NEIGHBORS");
			}
		}
		
	}
	
	public int gcd(int a, int b) {
		if (a % b == 0) { 
			return b;
		} else {
			return gcd(b, a % b); 
		}
	}
	

	
	public static void main(String[] args) throws FileNotFoundException {
		new Neighbor().run();
	}
}
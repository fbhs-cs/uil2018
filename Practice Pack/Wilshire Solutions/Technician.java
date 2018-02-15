import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Arrays;

/* 
A + Oct 2016 Packet 1 The Technician
Jed Wilshire
*/
public class Technician {
	private int[][] adjmat;
	private boolean[] visited;
	private long[] shortestPaths;
	
	public static final long INFINITY = Long.MAX_VALUE;
	
	
	public void run() throws FileNotFoundException {
		Scanner f = new Scanner(new File("Technician.dat"));
		int testCases = Integer.parseInt(f.nextLine());
		while (testCases-- > 0) {
			int distances = Integer.parseInt(f.nextLine());
			String[] list = new String[distances];
			for (int i = 0; i < list.length; i++) {
				list[i] = f.nextLine();
			}
			setUpDiminsions(list);
			fillAdjMat(list);
			visited = new boolean[adjmat.length];
			shortestPaths = new long[adjmat.length];
			for (int i = 0; i < shortestPaths.length; i++) {
				shortestPaths[i] = INFINITY;
			}
			String line = f.nextLine();
			System.out.println(dijkstra((int) line.charAt(0) - 65, (int) line.charAt(2) - 65));
		}	
	}
	
	public long dijkstra(int a, int b) {
		for(int c = 0; c < adjmat[a].length; c++) {
			if (adjmat[a][c] != 0) {
				shortestPaths[c] = adjmat[a][c];
			}
		}
		visited[a] = true;
		while (existsAnUnvistedVertex()) { 
			int current = getNextVertex(a);
			//System.out.println("current:" + current);
			for (int c = 0; c < adjmat[current].length; c++) {
				if (adjmat[current][c] != 0) {
					 shortestPaths[c] = Math.min(shortestPaths[c], shortestPaths[current] + adjmat[current][c]);
				}
			}
			visited[current] = true;
		}
		return shortestPaths[b];
	}
	
	public int getNextVertex(int a) {
		int best = -1;
		long weight = INFINITY; 
		for (int i = 0; i < shortestPaths.length; i++) {
			if (shortestPaths[i] < weight && !visited[i]) {
				best = i;
				weight = shortestPaths[i];
			}
		}
		return best;
	}
	
	public boolean existsAnUnvistedVertex() {
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				return true;
			}
		}
		return false;
	}
	
	public void fillAdjMat(String[] list) {
		for (String line : list) {
			try {
			adjmat[(int) line.charAt(0) - 65][(int) line.charAt(2) - 65] = Integer.parseInt(line.substring(4));
			adjmat[(int) line.charAt(2) - 65][(int) line.charAt(0) - 65] = Integer.parseInt(line.substring(4));
			}
			catch (Exception e) {
				System.out.println(((int) line.charAt(0) - 64) + " " + ((int) line.charAt(2) - 64) );
				System.out.println (adjmat.length + " " + adjmat[0].length);
			}
		}
	}
	
	public void setUpDiminsions(String[] list) {
		int max = (int) list[0].charAt(0) - 65;
		for (String line : list) {
			max = Math.max(max, Math.max((int)line.charAt(0) - 65, (int) line.charAt(2) - 65));
		}
		adjmat = new int[max + 1][max + 1];
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		new Technician().run();
	}
}


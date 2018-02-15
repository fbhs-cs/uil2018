import java.io.*;
import java.util.*;
public class TechnicianJesse {
	public static void main(String[] args) throws IOException {
		new TechnicianJesse().run();
	}
	
	public void run() throws IOException {
		Scanner f = new Scanner(new File("technician.dat"));
		int testCases = Integer.parseInt(f.nextLine());
		while(testCases-- > 0) {
			int distances = Integer.parseInt(f.nextLine());
			int[][] mat = new int[distances][distances];
			int[] from = new int[distances];
			Arrays.fill(from, -1);
			for(int i = 0; i < distances; i++) {
				int a = f.next().charAt(0) - 65;
				int b = f.next().charAt(0) - 65;
				int n = f.nextInt();
				mat[a][b] = n;
				mat[b][a] = n;
			}
			
			f.nextLine();
			int start = f.next().charAt(0) - 65;
			int goal = f.next().charAt(0) - 65;
			System.out.println(goal);
			f.nextLine();
			int steps = 0;
			List<Integer> arr = new ArrayList<Integer>();
			arr.add(start);
			from[start] = start;
			
			while(!arr.contains(goal)) {
				steps++;
				for(int r = 0; r < arr.size(); r++) {
					for(int c = 0; c < mat[r].length; c++) {
						if(mat[arr.get(r)][c] != 0 && mat[arr.get(r)][c] - mat[from[arr.get(r)]][c] <= steps && !arr.contains(c)) {
							arr.add(c);
							from[c] = arr.get(r);
						}
					}
				}
			}
			
			System.out.println(steps);
			
		}
	}
}
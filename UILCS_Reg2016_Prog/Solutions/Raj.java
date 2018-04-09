import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author sno
 * 
 * Given n decimals and the 4 operations, (+, -, *, /) determine
 * the maximum value that could be created by inserting any of the operations.
 *
 */
public class Raj {
	public static void main(String [] args) throws FileNotFoundException {
		Scanner f = new Scanner(new File("raj.dat"));
		int N = f.nextInt(); f.nextLine();
		while(N-- > 0) {
			maxSolution = Double.MIN_VALUE;
			Scanner line = new Scanner(f.nextLine());
			ArrayList<Double> in = new ArrayList<Double>();
			while(line.hasNextDouble()) {
				in.add(line.nextDouble());
			}
			Double[] input = new Double[in.size()];
			for(int i = 0; i < in.size(); i ++) {
				input[i] = in.get(i);
			}
			permute(Arrays.asList(input), 0);
			System.out.printf("%.2f\n", maxSolution);
	
		}		
	}
	public static double maxSolution = Double.MIN_VALUE; 
	public static void permute(List<Double> arr, int k){
        for(int i = k; i < arr.size(); i++){
            Collections.swap(arr, i, k);
            permute(arr, k+1);
            Collections.swap(arr, k, i);
        }
        if (k == arr.size() -1){
        	double[] ret = new double[arr.size()];
        	for(int i = 0; i < arr.size(); i++) {
        		ret[i] = arr.get(i);
        	}
            expand(ret, 0, ret[0]);
        }
    }
	public static void expand(double[] in, int index, double currentValue) {
		if(index >= in.length - 1) {
			if(currentValue > maxSolution) {
				maxSolution = currentValue;
			}
			return;
		}
		expand(in, index + 1, currentValue + in[index + 1]);
		expand(in, index + 1, currentValue - in[index + 1]);
		expand(in, index + 1, currentValue * in[index + 1]);
		expand(in, index + 1, currentValue / in[index + 1]);
	}
}

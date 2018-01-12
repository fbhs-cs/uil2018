
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 * Recognition - UIL 2016, Invitational A, Problem Twelve
 * @author sno
 * 
 * Given a set of images, find the largest common image among all the images of at least size 1 
 * within a tolerance t.

Rodney has been given a bunch of scanned images. He is tasked with determining if these scanned images 
are pictures of the same thing or location. To do this, he has tasked you with writing a program that 
given all of these scanned images, find the largest sub image that appears in each and all of the given 
images. However, there is another hang, Rodney knows that these images aren’t all taken in the exact same 
lighting and position. 

This means that the sub image can be at any location in the given picture, and that 
they will differ by a small amount, which also means that you will need to consider that these sub images could 
appear at any position within the given image. Rodney has further given you a quality compensation. This 
quality compensation determines how good the pictures are. A higher quality compensation means that the 
images are not good and require more leeway in considering them. 

Each of the images Rodney has given you are represented by a square 2D array of integers. These integers are between 0 
and 255 and each represent the red, green, blue values for each pixel in the image. Each group of 3 integers 
in a row represents one addressable pixel. So a 4 pixel image with 2 diagonal black pixels (0 0 0) and 2 diagonal 
white pixels (255 255 255) would be represented by:

0 0 0 255 255 255
255 255 255 0 0 0

To think about the quality compensation consider the following three 2X2 pixel images:

0 0 0 0 0 0
130 130 130 1 1 1 

2 2 2 200 200 2 
1 1 1 3 3 3 

157 88 193 1 1 1
45 190 203 150 40 17

Rodney has given the quality compensation value for this batch of images to be 0.0. This means any sub-image with all pixels 
whose red, green, or blue value are an exact match are considered to be identical. The resulting output is:

(1, 1, 1)

(1, 1, 1)

(1, 1, 1)

which means there is an exact sub-image match of (1, 1, 1) in each image.

In this next example, the quality compensation value is 1.0, and the result is shown, with each subimage within
a QC value of 1.0 of each of the other ones.

0 0 0 5 5 5
130 130 130 1 1 1 

2 2 2 200 200 2 
10 10 10 3 3 3 

157 88 193 1 1 1
45 190 203 150 40 17

Result:
(1, 1, 1)

(2, 2, 2)

(1, 1, 1)

To make it easier on you, Rodney has cropped and scaled all the given images such that all the given images are always 
square and the common sub image is also guaranteed to be square. Help Rodney find the largest sub image that appears in 
all the given images within the quality compensation.

Input: The first integer, i, will be the number of data sets to follow. Each data set will begin with a floating point 
number, t, that represents the quality compensation value given by Rodney. The next integer, q, will be the dimension 
in the image in pixels (representing a qxq image). The next integer, j, will be the number of images that Rodney has 
given you. The next q rows will be an image. Each row will contain q groups of 3 images, representing the red, green, 
and blue values of each pixel. Each image will be followed by a blank line. There will be no more than 4 images considered,
and the maximum square matrix size will be 8X8.

Output: The found largest sub image as it appears in each image. Each pixel in the sub-image should be represented 
with (r, g, b) with parentheses. There should be j sub images output. If no match is found among all of the sub-images 
being considered within the quality compensation given by Rodney, output NONE. Each sub-image output is to be followed 
by a blank line, and each complete output will also be followed by the string "-----".

Sample Input:
3
0.0
2
3
0 0 0 0 0 0
130 130 130 1 1 1 

2 2 2 200 200 2 
1 1 1 3 3 3 

157 88 193 1 1 1
45 190 203 150 40 17

1.0
2
3
0 0 0 5 5 5
130 130 130 1 1 1 

2 2 2 200 200 2 
10 10 10 3 3 3 

157 88 193 1 1 1
45 190 203 150 40 17

2.0
3
3
0 0 0 80 80 80 80 80 80
130 130 130 78 78 78 80 80 80
80 80 80 80 80 80 80 90 90 90

80 80 80 79 79 79 200 200 2 
78 78 78 79 79 79 10 10 10 
80 78 79 78 79 80 0 0 0

157 88 193 1 1 1 150 40 17
45 190 203 78 78 78 78 78 78
0 0 0 80 80 80 79 79 79


Sample Output:
(1, 1, 1)

(1, 1, 1)

(1, 1, 1)

-----
(1, 1, 1)

(2, 2, 2)

(1, 1, 1)

-----
(80, 80, 80) (80, 80, 80)
(78, 78, 78) (80, 80, 80)

(80, 80, 80) (79, 79, 79)
(78, 78, 78) (79, 79, 79)

(78, 78, 78) (78, 78, 78)
(80, 80, 80) (79, 79, 79)

-----

 *
 */
public class A_Twelve {
	public static void main(String [] args) throws FileNotFoundException {
		Scanner f = new Scanner(new File("a_twelve.dat"));
		int numDataSets = f.nextInt(); f.nextLine();
		while(numDataSets --> 0) {
			//processing input
			Color.tolerance = f.nextDouble(); //quality compensation
			int size = f.nextInt();
			int numImages = f.nextInt();f.nextLine();
			Image[] images = new Image[numImages];
			for(int i = 0; i < numImages; i++) {
				Color[][] colorMap = new Color[size][size];
				for(int j = 0; j < size; j++) {
					Scanner chop = new Scanner(f.nextLine());
					for(int k = 0; k < size; k++) {
						colorMap[j][k] = new Color(chop.nextInt(), chop.nextInt(), chop.nextInt());
					}
				}
				images[i] = new Image(colorMap);
				try {
					f.nextLine();
				} catch (Exception e) {
					//last round no newline
				}
			}
			
			ArrayList<Iteration> allSolutions = generateAllSolutions(images, size);
			allSolutions = findSingleSolution(images, allSolutions, size);
			
			Collections.sort(allSolutions, new Comparator<Iteration>() {
				/*
				 * Sorts in descending order by solutions size.
				 */
				@Override
				public int compare(Iteration o1, Iteration o2) {
					return o2.largestTestedSize - o1.largestTestedSize;
				}
			});
			
			if(allSolutions.size() == 0) {
				System.out.println("NONE");
				System.out.println();
			} else if (allSolutions.get(0).largestTestedSize == 0) {
				System.out.println("NONE");
				System.out.println();
			} else {
				Iteration sol = allSolutions.get(0);
				for(int i = 0; i < images.length; i++) {
					System.out.println(images[i].subImage(sol.largestTestedSize, sol.get(i).x, sol.get(i).y));
				}
			}
		System.out.println("-----");	
		}
	}
	/*
	 * Generates all the iterations that are going to be checked. These iterations is the
	 * cross product of all the (x, y) starting values for each image crossed by all the images.
	 * The resulting list of iterations will be of size (image.size*image.size)^(numImages).
	 */
	public static ArrayList<Iteration> generateAllSolutions(Image[] images, int size) {
		//generate all the possible pixel addresses on an image
		ArrayList<Pair> oneIterationGen = new ArrayList<Pair>();
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j ++) {
				oneIterationGen.add(new Pair(i,j));
			}
		}
		//set the intial set
		ArrayList<Iteration> allIterations = new ArrayList<Iteration>();
		for(int i = 0; i < oneIterationGen.size(); i++) {
			Iteration it = new Iteration();
			it.append(oneIterationGen.get(i));
			allIterations.add(it);
		}
		//perform the cross products of the generated set (numImages) times.
		for(int i = 1; i < images.length; i++) {
			ArrayList<Iteration> growingIterations = new ArrayList<Iteration>();
			for(int j = 0; j < allIterations.size(); j++) { 
				for(int k = 0 ; k < oneIterationGen.size(); k++) { 
					Iteration q = new Iteration(allIterations.get(j).coordinates);
					q.append(oneIterationGen.get(k));
					growingIterations.add(q);
				}
			}
			allIterations = growingIterations;
		}
		return allIterations;
	}
	
	/*
	 * Iterates through all the created iterations and determines which are viable solutions.
	 */
	public static ArrayList<Iteration> findSingleSolution(Image[] images, ArrayList<Iteration> allSolutions, int size) {
		for(int i = 1; i < size; i ++) {
			int solutionsOfThisSize = 0; //if we have no solutions of this size, then the prev size is largest solution
			outerIter: for(Iteration j: allSolutions) {
				Image[] subImages = new Image[images.length];
				for(int k = 0; k < images.length; k++) {
					subImages[k] = images[k].subImage(i, j.get(k).x, j.get(k).y);
					// if we can't generate a subImage of this size then its not a solution
					if(subImages[k] == null) {
						j.valid = false;
						continue outerIter;
					}
				}
				if(!superEquals(subImages, i)) {
					j.valid = false;
				} else {
					j.largestTestedSize = i;
					solutionsOfThisSize++;
				}
			}
			// if we found a valid iterations of this size, then we can get rid of all
			// the old iterations because if the subimage is not solution and image 
			// containing the subimage is also not a solution.
			if(solutionsOfThisSize > 0) {
				allSolutions = removeAllInvalidSolutions(allSolutions);
			}
		}
		return allSolutions;
	}
	/*
	 * Removes all iterations marked as invalid.
	 */
	public static ArrayList<Iteration> removeAllInvalidSolutions(ArrayList<Iteration> solutions) {
		ArrayList<Iteration> validSolutions = new ArrayList<Iteration>();
		for(Iteration it: solutions) {
			if(it.valid) {
				validSolutions.add(it);
			}
		}	
		return validSolutions;
	}
	
	/*
	 * Checks that all these image are equal.
	 */
	public static boolean superEquals(Image[] images, int size) {
		return Image.allEquivalent(images, size);
	}
	
	/*
	 * Does a deep copy for Iterations.
	 */
	public static ArrayList<Iteration> deepCopy(ArrayList<Iteration> in) {
		ArrayList<Iteration> out = new ArrayList<Iteration>();
		for(Iteration i: in) {
			out.add(i);
		}
		return out;
	}
	/*
	 * Does a deep copy for Pairs.
	 */
	public static ArrayList<Pair> deepCopyPair(ArrayList<Pair> in) {
		ArrayList<Pair> out = new ArrayList<Pair>();
		for(Pair i: in) {
			out.add(i);
		}
		return out;
	}
}
/**
 * Simple Tuple class for addressing the image.
 */
class Pair {
	public int x;
	public int y;
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
/**
 * Contains a pair for each image to be checked for a matching sub image
 * at a given size. 
 */
class Iteration {
	//all addresses to be checked for each image
	public ArrayList<Pair> coordinates; 
	//is this iteration a valid solution
	public boolean valid = true;
	//what size did this iteration last give a solution with
	public int largestTestedSize = 0;
	public Iteration() {
		coordinates = new ArrayList<Pair>();
	}
	public Iteration(ArrayList<Pair> p) {
		coordinates = A_Twelve.deepCopyPair(p);
	}
	public void append(Pair p) {
		coordinates.add(p);
	}
	public Pair get(int i) {
		return coordinates.get(i);
	}
	//used for debugging
	public String toString() {
		return "{{" + coordinates.toString() + " validity: " + valid +" size: " + largestTestedSize +"}}";
	}
}
/**
 * Color that has an r,g,b value for each pixel address.
 */
class Color { //Pixels
	public int r;
	public int g;
	public int b;
	public static double tolerance = 0.0; //defaults to 0
	public Color(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	/*
	 * Checks that all of these pixels are equivalent with the
	 * specified tolerance.
	 */
	public static boolean equivalentColor(Color[] colors) {
		double maxDifference = 0.0;
		for(int i = 0; i < colors.length; i++) {
			for(int j = 0; j < colors.length; j++) {
				if(i == j) {
					continue;
				}
				double[] diffs = new double [3];
				diffs[0] = Math.abs(colors[i].r - colors[j].r);
				diffs[1] = Math.abs(colors[i].g - colors[j].g);
				diffs[2] = Math.abs(colors[i].b - colors[j].b);
				
				Arrays.sort(diffs);
				if(maxDifference < diffs[2]) {
					maxDifference = diffs[2];
				}
			}
		}
		return maxDifference <= tolerance;
	}
}
/**
 * The 2D array of pixels. 
 */
class Image {
	public Color[][] image;
	public Image(Color [][] image) {
		this.image = image;
	}
	/*
	 * Returns the side length;
	 */
	public int size() {
		return image.length;
	}
	/*
	 * Returns the sub image of the given side length with the top
	 * left corner specified at the x,y position.
	 */
	public Image subImage(int sideLength, int xLoc, int yLoc) {
		Color[][] subsetImage = new Color[sideLength][sideLength];
		if(xLoc + sideLength > this.size() || yLoc + sideLength > this.size()){
			return null;
		}
		for(int i = xLoc; i < xLoc + sideLength; i++) {
			for(int j = yLoc; j < yLoc + sideLength; j++) {
				subsetImage[i - xLoc][j - yLoc] = this.image[i][j];
			}
		}
		return new Image(subsetImage);
	}
	/*
	 * String representation of this image.
	 */
	public String toString() {
		String output = "";
		for(int i = 0; i < this.size(); i++) {
			for(int j = 0; j < this.size(); j++) {
				output += "(" + this.image[i][j].r + ", " + this.image[i][j].g + ", " + this.image[i][j].b + ") ";
			}
			output += "\n";
		}
		return output;
	}
	/*
	 * Checks that all of these images are equivalent by pixels basis.
	 */
	public static boolean allEquivalent(Image[] images, int size) {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				Color[] colors = new Color[images.length];
				for(int k = 0; k < images.length; k++) {
					colors[k] = images[k].image[i][j];
				}
				if(!Color.equivalentColor(colors)) {
					return false;
				}
			}
		}
		return true;
	}
}
/*
Test Input:
6
0.0
2
3
0 0 0 0 0 0
130 130 130 1 1 1 

2 2 2 200 200 2
1 1 1 3 3 3

157 88 193 1 1 1
45 190 203 150 40 17

1.0
2
3
0 0 0 5 5 5
130 130 130 1 1 1

2 2 2 200 200 2
10 10 10 3 3 3

157 88 193 1 1 1
45 190 203 150 40 17

2.0
2
3
0 0 0 5 5 5
130 130 130 1 5 8

3 5 6 200 200 2
10 10 10 3 3 3

157 88 193 1 5 9
45 190 203 150 40 17

2.0
3
3
0 0 0 80 80 80 80 80 80
130 130 130 78 78 78 80 80 80
80 80 80 80 80 80 80 90 90 90

80 80 80 79 79 79 200 200 2
78 78 78 79 79 79 10 10 10
80 78 79 78 79 80 0 0 0

157 88 193 1 1 1 150 40 17
45 190 203 78 78 78 78 78 78
0 0 0 80 80 80 79 79 79

0.0
2
3
0 0 0 0 0 0
1 1 1 1 1 1

2 2 2 2 2 2
3 3 3 3 3 3

4 4 4 1 1 1
5 5 5 5 5 5

10.0
6
4
247 247 247 247 247 247 247 247 247 247 247 247 247 247 247 247 247 247
247 247 247 247 247 247 247 247 247 247 247 247 247 247 247 247 247 247
247 247 247 247 247 247 247 247 247 247 247 247 247 247 247 247 247 247
247 247 247 247 247 247 247 247 247 0 0 0 247 247 247 247 247 247
247 247 247 247 247 247 247 247 247 247 247 247 0 0 0 247 247 247
247 247 247 247 247 247 247 247 247 247 247 247 247 247 247 0 0 0

0 0 0 247 252 252 252 252 252 252 252 252 252 252 252 252 252 252
252 252 252 0 0 0 252 252 252 252 252 252 252 252 252 252 252 252
252 252 252 252 252 252 0 0 0 252 252 252 252 252 252 252 252 252
252 252 252 252 252 252 252 252 252 252 252 252 252 252 252 252 252 252
252 252 252 252 252 252 252 252 252 252 252 252 252 252 252 252 252 252
252 252 252 252 252 252 252 252 252 252 252 252 252 252 252 252 252 255

255 255 255 255 255 255 255 255 255 255 255 255 255 255 255 255 255 255
255 255 255 255 255 255 255 255 255 255 255 255 255 255 255 255 255 255
255 255 255 255 255 255 0 0 0 255 255 255 255 255 255 255 255 255
255 255 255 255 255 255 255 255 255 0 0 0 255 255 255 255 255 255
255 255 255 255 255 255 255 255 255 255 255 255 0 0 0 255 255 255
255 255 255 255 255 255 255 255 255 255 255 255 255 255 255 255 255 255

150 150 150 0 0 0 255 255 255 255 255 255 150 150 150 150 150 150
150 150 150 255 255 255 0 0 0 255 255 255 150 150 150 150 150 150
150 150 150 255 255 255 255 255 255 0 0 0 150 150 150 150 150 150
150 150 150 150 150 150 150 150 150 150 150 150 150 150 150 150 150 150
150 150 150 150 150 150 150 150 150 150 150 150 150 150 150 150 150 150
150 150 150 150 150 150 150 150 150 150 150 150 150 150 150 150 150 150


Test Output:
(1, 1, 1)

(1, 1, 1)

(1, 1, 1)

-----
(1, 1, 1)

(2, 2, 2)

(1, 1, 1)

-----
NONE

-----
(80, 80, 80) (80, 80, 80)
(78, 78, 78) (80, 80, 80)

(80, 80, 80) (79, 79, 79)
(78, 78, 78) (79, 79, 79)

(78, 78, 78) (78, 78, 78)
(80, 80, 80) (79, 79, 79)

-----
NONE

-----
(0, 0, 0) (247, 247, 247) (247, 247, 247)
(247, 247, 247) (0, 0, 0) (247, 247, 247)
(247, 247, 247) (247, 247, 247) (0, 0, 0)

(0, 0, 0) (247, 252, 252) (252, 252, 252)
(252, 252, 252) (0, 0, 0) (252, 252, 252)
(252, 252, 252) (252, 252, 252) (0, 0, 0)

(0, 0, 0) (255, 255, 255) (255, 255, 255)
(255, 255, 255) (0, 0, 0) (255, 255, 255)
(255, 255, 255) (255, 255, 255) (0, 0, 0)

(0, 0, 0) (255, 255, 255) (255, 255, 255)
(255, 255, 255) (0, 0, 0) (255, 255, 255)
(255, 255, 255) (255, 255, 255) (0, 0, 0)

-----
*/
/**
In her Scouting Venture Crew, Paulina has just learned about orienteering, but still needs a little bit of help.

Instead of the traditional value of zero being north, zero will be east.  The direction 360 is also east, as is -360.
Due west is positive or negative 180. Due north is either 90 or -270. To make it easier, the orienteering course only dealt with directions that were multiples of 30 or 45,
which made it easy to use the special 45-45-90 and 30-60-90 triangle formulas she learned in algebra.

The purpose of the course was to predict an ending position on the coordinate grid, with (0,0) being the home base location, and all other positions relative to home base.
The instructions given were in numeric pairs representing a vector, the first one indicating the distance traveled, and the second the direction traveled, and the task was to predict the ending location of the course.

Several vectors could be given, representing several different movements in one course.  For example, the vector (5,45) means to go 5 miles in a north-east direction, which would end up at position (3.5355, 3.5355), relative to home.
An additional vector of (4, -30) in the same course would start from (3.5355, 3.5355), go 4 miles in the direction 30 degrees below east, ending up at (6.9996, 1.5355).

Input - Several sets of data, each consisting of an initial value N, followed by N vector integer pairs, each pair consisting of a distance in miles, and a positive or negative direction (-360 <= direction <= 360) relative to East, as described above. Each direction is guaranteed to be a positive or negative multiple of 30 or of 45.

Output - An ordered pair representing the final position upon completion of the course as designated by the data set, enclosed within parentheses, output to a precision of 4 decimal places.  A tolerance of +-0.0001 will be accepted for either value.

Sample data:
2 5 45 4 -30
4 2 90 2 180 2 270 2 0
3 2 120 2 -330 2 60

Sample Output:
(6.9996, 1.5355)
(0.0000, 0.0000)
(1.7321, 4.4641)

 */
import java.io.*;
import java.util.*;
import static java.lang.System.*;
public class Paulina {
	public static void main(String [] args) throws FileNotFoundException {
//		Scanner k = new Scanner(in);
		Scanner f = new Scanner(new File("paulina.dat"));
		while(f.hasNext()) {
			int N = f.nextInt();
			double x=0,y=0;
			while(N-->0){
				int dist = f.nextInt();
				int dir = f.nextInt();
				//if east
				if(dir==0||dir==360||dir==-360)
					x+=dist;
				else
				//if west
				if(dir==180||dir==-180)
					x-=dist;
				else
				//if north
				if(dir==90||dir==-270)
					y+=dist;
				else
				//if south
				if(dir==-90||dir==270)
					y-=dist;
				else
				//if dir is 30 or -330
				if(dir==30||dir == -330)
				{
					x+=dist/2.0*Math.sqrt(3);
					y+=dist/2.0;
				}
				else
				//if dir is -30 or 330
				if(dir==-30||dir == 330)
				{
					x+=dist/2.0*Math.sqrt(3);
					y-=dist/2.0;
				}
				else
				//if dir is 150 or -210
				if(dir==150||dir == -210)
				{
					x-=dist/2.0*Math.sqrt(3);
					y+=dist/2.0;
				}
				else
				//if dir is -150 or 210
				if(dir==-150||dir == 210)
				{
					x-=dist/2.0*Math.sqrt(3);
					y-=dist/2.0;
				}
				else
				//if dir is 60 or -300
				if(dir==60 || dir == -300)
				{
					y+=dist/2.0*Math.sqrt(3);
					x+=dist/2.0;
				}
				else
				//if dir is -60
				if(dir==-60 || dir == 300)
				{
					y-=dist/2.0*Math.sqrt(3);
					x+=dist/2.0;
				}
				else
				//if dir is 120
				if(dir==120 || dir == -240)
				{
					y+=dist/2.0*Math.sqrt(3);
					x-=dist/2.0;
				}
				else
				//if dir is -120
				if(dir==-120 || dir == 240)
				{
					y-=dist/2.0*Math.sqrt(3);
					x-=dist/2.0;
				}
				else
				//if dir is 45
				if(dir==45 || dir == -315)
				{
					double delta = dist/Math.sqrt(2);
					x+=delta;
					y+=delta;
				}
				else
				//if dir is -45
				if(dir==-45 || dir == 315)				
				{
					double delta = dist/Math.sqrt(2);
					x+=delta;
					y-=delta;
				}
				else
				//if dir is 135
				if(dir==135 || dir == -225)				
				{
					double delta = dist/Math.sqrt(2);
					x-=delta;
					y+=delta;
				}
				else
				//if dir is -135
				if(dir==-135 || dir == 225)								
				{
					double delta = dist/Math.sqrt(2);
					x-=delta;
					y-=delta;
				}
//				out.printf("%d %d___%.5f %.5f\n",dist,dir,x,y);
				
			}//end of inside loop
		out.printf("(%.4f, %.4f)\n",x,y);
		}//end of outside loop
	}
}
/*
Test Data:
2 5 45 4 -30
4 2 90 2 180 2 270 2 0
3 2 120 2 -330 2 60
3 2 -45 2 -300 2 -60
3 2 240 2 150 2 200
3 2 -90 2 -180 2 -270
3 2 30 2 330 2 360
4 2 315 2 300 2 -210 2 -150
4 2 -360 2 -240 2 135 2 225
4 2 -45 2 -135 2 -225 2 -315
4 2 30 2 30 2 -120 2 -180
5 2 0 2 90 2 -90 2 -270 2 -180

Test Output:
(6.9996, 1.5355)
(0.0000, 0.0000)
(1.7321, 4.4641)
(3.4142, -1.4142)
(-2.7321, -0.7321)
(-2.0000, 0.0000)
(5.4641, 0.0000)
(-1.0499, -3.1463)
(-1.8284, 1.7321)
(0.0000, 0.0000)
(0.4641, 0.2679)
(0.0000, 2.0000)
*/
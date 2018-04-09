
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * 
 * @author sno
 *
 * Given the position, intial velocity, equations of gravity, and kinematics, determine 
 * yaroslav's location and velocity in x seconds. 
 */
public class Yaroslav {
	public static void main(String [] args) throws FileNotFoundException {
		Scanner f = new Scanner(new File("yaroslav.dat"));
		int N = f.nextInt(); f.nextLine();
		while(N-- > 0) {
			Yaro yaro = new Yaro();
			yaro.mass = 160000; //kg
			yaro.location = new Coordinate(f.nextDouble(), f.nextDouble(), f.nextDouble());
			yaro.velocity = new Coordinate(f.nextDouble(), f.nextDouble(), f.nextDouble());
			
			int seconds = f.nextInt();
			int numPlanets = f.nextInt();
			Planet [] planets = new Planet[numPlanets];
			for(int i = 0; i < numPlanets; i++) {
				Planet x = new Planet();
				x.mass = f.nextDouble();
				x.location = new Coordinate(f.nextDouble(), f.nextDouble(), f.nextDouble());
				planets[i] = x;
			}
			
			for(int i = 0; i < seconds*TIME_STEP; i++) {
				//System.out.println(yaro.location);
				updatePosition(planets, yaro);
			}
			System.out.println("YAROSLAV IS AT POSITION " + yaro.location + ".");
		}
	}
	public static double G = 0.0000000006674; 
	public static double TIME_STEP = 1000;
	public static Coordinate forces(Planet[] planets, Yaro yaro) {
		//F = gMm/r^2
		double force = 0.0;
		Coordinate dirVector = new Coordinate(0,0,0);
		for(Planet p: planets) {
			force += yaro.mass * p.mass * G / (Math.pow(yaro.location.distance(p.location), 2));
			dirVector.add(yaro.location.directionVector(p.location));
			dirVector.normalize();
		}
		return new Coordinate(force * dirVector.x, force * dirVector.y, force * dirVector.z);
	}
	public static void updatePosition(Planet[] planets, Yaro yaro) {
		Coordinate force = forces(planets, yaro);
	//	System.out.println("force: " + force);
		// a = F/m
		Coordinate acceleration = new Coordinate(force.x/yaro.mass, force.y/yaro.mass, force.z/yaro.mass);
		// v = a * t + v0
		Coordinate velocity = new Coordinate(acceleration.x/TIME_STEP + yaro.velocity.x, acceleration.y/TIME_STEP + yaro.velocity.y, acceleration.z/TIME_STEP + yaro.velocity.z);
		// x = v * t + x0
		yaro.velocity = velocity;
		Coordinate position = new Coordinate(velocity.x/TIME_STEP + yaro.location.x, velocity.y/TIME_STEP + yaro.location.y, velocity.z/TIME_STEP + yaro.location.z);
		yaro.location = position;
	}
}
class Coordinate {
	public double x;
	public double y;
	public double z;
	public Coordinate() {};
	public Coordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double distance(Coordinate c){
		return Math.sqrt(Math.pow(c.x - this.x, 2) + Math.pow(c.y - this.y, 2) + Math.pow(c.z - this.z, 2));
	}
	public Coordinate directionVector(Coordinate c) {
		double dist = this.distance(c);
		return new Coordinate((this.x - c.x)/dist, (this.y - c.y)/dist, (this.z-c.z)/dist);	
	}
	public void normalize() {
		double size = Math.sqrt(x*x + y*y + z*z);
		if(size == 0) {
			x = 0;
			y = 0;
			z = 0;
			return;
		}
		x/=size;
		y/=size;
		z/=size;
	}
	public double size() {
		return Math.sqrt(x*x + y*y + z*z);
	}
	public void add(Coordinate c) {
		this.x += c.x;
		this.y += c.y;
		this.z += c.z;
	}
	public String toString() {
		return String.format("(%.2f, %.2f, %.2f)",x,y,z);
	}
}
class Planet {
	public Coordinate location;
	public double mass;
}
class Yaro {
	public double mass;
	public Coordinate location;
	public Coordinate velocity;
}


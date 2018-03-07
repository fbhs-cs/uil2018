
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author sno - Zhenya - UIL District 1 - 2016
 *
 * Given n boxes, return true if all the boxes are overlapping with each other at 
 * at least one point. If there is one or more boxes that are not overlappoing 
 * each other, then return false;
 *
 */
public class Zhenya {
	public static void main(String [] args) throws FileNotFoundException {
		Scanner f = new Scanner(new File("zhenya.dat"));
		int N = f.nextInt();f.nextLine();
		while(N-- > 0) {
			String rectstr = f.nextLine();
			Scanner chop = new Scanner(rectstr);
			ArrayList<Rectangle> rects = new ArrayList<Rectangle>();
			while(chop.hasNextInt()) {
				rects.add(new Rectangle(chop.nextInt(), chop.nextInt(), chop.nextInt(), chop.nextInt()));
			}
			
			boolean intersects = true;
			for(int i = 0; i < rects.size(); i++) {
				Rectangle r = rects.get(i);
				for(int j = 0; j < rects.size(); j ++) {
					Rectangle s = rects.get(j);
					if(!r.intersects(s) && !s.intersects(r)) {
						intersects = false;
						break;
					}
				}
			}
			
			if(intersects) {
				System.out.println("ALL STACKED");
			} else {
				System.out.println("NOT STACKED");
			}
		}
	}

}
class Rectangle {
	public Point bl, br, tl, tr;
	public Rectangle(int x, int y, int l, int w) {
		int x1 = x;
		int y1 = y;
		int x2 = x + w;
		int y2 = y;
		int x3 = x;
		int y3 = y + l;
		int x4 = x + w;
		int y4 = y + l;
		
		this.bl = new Point(x1, y1);
		this.br = new Point(x2, y2);
		this.tl = new Point(x3, y3);
		this.tr = new Point(x4, y4);
		
		//System.out.println(bl + " " + br + " " + tl + " " + tr);
	}
	
	public boolean coordinateIsRectangle(Point p) {
		return (p.x <= br.x && p.x >= bl.x && p.y >= bl.y && p.y <= tl.y);
	}
	
	public boolean horizontalEdgeGoesThroughRectangle(Point a, Point b) {
		if(a.y != b.y) {
			System.out.println("NOT A HORIZONTAL LINE");
			return false;
		}
		if(b.x >= br.x && a.x <= br.x && a.y >= br.y && a.y <= tr.y) {
			return true;
		} 
		
		if(a.x <= br.x && b.x >= br.x && a.y >= br.y && a.y <= tr.y) {
			return true;
		}
		return false;
	}
	
	public boolean verticalEdgeGoesThroughRectangle(Point a, Point b) {
		if(a.x != b.x) {
			System.out.println("NOT A VERTICAL LINE");
			return false;
		}
		if(b.y >= tr.y && a.y <= tr.y && a.x >= bl.x && a.x <= br.x) {
			return true;
		} 
		
		if(a.y <= br.y && b.y >= br.y && a.x >= bl.x && a.x <= br.x) {
			return true;
		}
		return false;
	}
	
	public boolean intersects(Rectangle r) {
		if(this.coordinateIsRectangle(r.bl) || this.coordinateIsRectangle(r.br) 
				|| this.coordinateIsRectangle(r.tr) || this.coordinateIsRectangle(r.tl)) {
			return true;
		}
		
		if(this.verticalEdgeGoesThroughRectangle(r.br, r.tr) || 
				this.verticalEdgeGoesThroughRectangle(r.bl, r.tl)) {
			return true;
		}
		
		
		if(this.horizontalEdgeGoesThroughRectangle(r.bl, r.br) || 
				this.horizontalEdgeGoesThroughRectangle(r.tl, r.tr)) {
			return true;
		}
		
		return false;
	}
}
class Point {
	int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
/*
10
0 0 2 2 1 1 2 2 -1 -1 3 3
1 1 300 0 0 0 1 3 10 10 14 44829
0 0 10 10 2 2 5 5 4 4 1 1
0 0 1 1 2 2 1 1 4 4 1 1 6 6 1 1 8 8 1 1 10 10 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 10 10 1 1
0 0 10 10 2 2 5 5 4 4 1 1
-1000000 -1000000 100000 100000000 -10000 1000000 1000 100000
0 0 1 1 1 1 0 0
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 


ALL STACKED
NOT STACKED
ALL STACKED
NOT STACKED
ALL STACKED
NOT STACKED
ALL STACKED
NOT STACKED
ALL STACKED
ALL STACKED
*/
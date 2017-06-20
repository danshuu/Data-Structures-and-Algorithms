import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Driver {

	
	
	public static void main(String[] args){
		Point[] pp = new Point[] {new Point(0,0), new Point(0,2), new Point(3,0)};
		Point[] po = new Point[] {new Point(0,0), new Point(0,2), new Point(3,0)};
		ConvexPolygon pep = new ConvexPolygon(pp, Color.RED, true);
		ConvexPolygon pop = new ConvexPolygon(po, Color.RED, true);
		Triangle tri = new Triangle(new Point(0,0), new Point(2,0), new Point(0,2), Color.RED, true);
		Rectangle rect = new Rectangle(2,2,new Point(0,0),Color.RED, true);
		WorkSpace working = new WorkSpace();
		working.add(pep);
		working.add(pop);
		working.add(tri);
		working.add(rect);
	
		
		Point[] points = new Point[4];
	      points[0] = new Point(0,0);
	      points[1] = new Point(1,0);
	      points[2] = new Point(1,1);
	      points[3] = new Point(0,1);
	      ConvexPolygon cp = new ConvexPolygon(points, Color.BLACK, false);
		System.out.println(cp.getArea());
		
	}
}
	
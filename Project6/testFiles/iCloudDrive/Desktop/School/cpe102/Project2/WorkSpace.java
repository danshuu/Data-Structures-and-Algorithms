import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class WorkSpace { //not implementing the interface?

	private ArrayList<Shape> shapes;

	public WorkSpace() {
		shapes = new ArrayList<Shape>();
	}

	//Adds objects which implement the Shape interface to the end of the
	//WorkSpace's ArrayList instance variable.
	public void add(Shape shape) {
		shapes.add(shape);
	}

	public Shape remove(int index) {
		Shape x = shapes.get(index);
		shapes.remove(index);
		return x;
	}

	public Shape get(int index) {
		//returns the ith shape object from workspace
		return shapes.get(index);
	}

	public int size() {
		//returns the number of shapes contained by the workspace
		return shapes.size();
	}

	public ArrayList<Circle> getCircles() {
		//returns an arraylist of all of the circle objects contained in the workspace
		ArrayList<Circle> circleList = new ArrayList<Circle>();
		for (int i = 0; i < shapes.size(); i++) {
			if (shapes.get(i) instanceof Circle) {
				circleList.add((Circle)(shapes.get(i)));
			} // end of if
		} // end of for loop
		return circleList;
	}

	public ArrayList<Rectangle> getRectangles() {
    	//returns an arraylist of all of rectangle objects contained in workspace
        ArrayList<Rectangle> rectangleList = new ArrayList<Rectangle>();
        for(int i = 0; i < shapes.size(); i++) {
            if(shapes.get(i) instanceof Rectangle) {
                rectangleList.add((Rectangle)(shapes.get(i)));
            } // end of if
        } // end of for loop
        return rectangleList;
    }

	public ArrayList<Triangle> getTriangles() {
		//returns an arraylist of all of the triangle objects contained in the workspace
		ArrayList<Triangle> triangleList = new ArrayList<Triangle>();
		for (int i = 0; i < shapes.size(); i++) {
			if (shapes.get(i) instanceof Triangle) {
				triangleList.add((Triangle)(shapes.get(i)));
			} // end of if
		} // end of for loop
		return triangleList;
	}

	public ArrayList<ConvexPolygon> getConvexPolygons() {
		//returns an arraylist of all of the convexpolygon objects contained in the workspace
		ArrayList<ConvexPolygon> convexList = new ArrayList<ConvexPolygon>();
		for (int i = 0; i < shapes.size(); i++) {
			if (shapes.get(i) instanceof ConvexPolygon) {
				convexList.add((ConvexPolygon)(shapes.get(i)));
			} // end of if
		} // end of for loop
		return convexList;
	}

	public ArrayList<Shape> getShapesByColor(Color color) {
		//returns an arraylist of all of the shape objects contained
		//in the workspace that specify color
		ArrayList<Shape> colorList = new ArrayList<Shape>();
		for (int i = 0; i < shapes.size(); i++) {
			if (((shapes.get(i)).getColor()).equals(color)) {
				colorList.add((Shape)shapes.get(i));
			} // end of if
		} // end of for loop
		return colorList;
	}

	public double getAreaOfAllShapes() {
		//returns the sum of the area of all shape objects in workspace
		double totalArea = 0.0;
		for (int i = 0; i < shapes.size(); i++) {
			totalArea += (shapes.get(i)).getArea();
		}
		return totalArea;
	}
}	

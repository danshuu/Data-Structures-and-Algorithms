import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
 
public class WorkSpace1 {
 
    private ArrayList<Shape> shapes;
     
    public WorkSpace1()
    {
        shapes = new ArrayList<Shape>();
    }
    public void add(Shape shape)
    {
        shapes.add(shape);
    }
    public Shape remove(int index)
    {
        return shapes.remove(index);
    }
    public Shape get(int index)
    {
        return shapes.get(index);
    }
    public int size()
    {
        return shapes.size();
    }
    public java.util.ArrayList<Circle> getCircles()
    {
        ArrayList<Circle> circles = new ArrayList<Circle>();
        for(int i = 0; i<shapes.size(); i++)
        {
            if(shapes.get(i) instanceof Circle)
            {
                circles.add((Circle)(shapes.get(i)));
            }
        }
        return circles;
    }
    public java.util.ArrayList<Rectangle> getRectangles()
    {
        ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();
        for(int i = 0; i<shapes.size(); i++)
        {
            if(shapes.get(i) instanceof Rectangle)
            {
                rectangles.add((Rectangle)(shapes.get(i)));
            }
        }
        return rectangles;
    }
    public java.util.ArrayList<Triangle> getTriangles()
    {
        ArrayList<Triangle> triangles = new ArrayList<Triangle>();
        for(int i = 0; i<shapes.size(); i++)
        {
            if(shapes.get(i) instanceof Triangle)
            {
                triangles.add((Triangle)(shapes.get(i)));
            }
        }
        return triangles;
    }
    public java.util.ArrayList<ConvexPolygon> getConvexPolygons()
    {
        ArrayList<ConvexPolygon> convexPolygons = new ArrayList<ConvexPolygon>();
        for(int i = 0; i<shapes.size(); i++)
        {
            if(shapes.get(i) instanceof ConvexPolygon)
            {
                convexPolygons.add((ConvexPolygon)(shapes.get(i)));
            }
        }
        return convexPolygons;
    }
    public java.util.ArrayList<Shape> getShapesByColor(java.awt.Color color)
    {
        ArrayList<Shape> colorShapes = new ArrayList<Shape>();
        for(int i = 0; i<shapes.size(); i++)
        {
            if((shapes.get(i)).getColor().equals(color))
            {
                colorShapes.add(shapes.get(i));
            }
        }
         
        return colorShapes;
    }
    public double getAreaOfAllShapes()
    {
        double sum = 0;
        for(int i = 0; i<shapes.size(); i++)
        {
            sum +=(shapes.get(i)).getArea();
        }
        return sum;
    }
}
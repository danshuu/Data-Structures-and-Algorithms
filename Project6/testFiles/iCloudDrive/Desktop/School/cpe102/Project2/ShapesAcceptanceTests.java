/**
 * JUnit tests for CPE 102 Project 2
 *
 * @author Julie Workman and Christopher Siu
 * @version 4/16/2016 (Written to JUnit-4.12)
 */

import static org.junit.Assert.*;
import org.junit.*;
import java.lang.reflect.*;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class ShapesAcceptanceTests
{
   @Test (timeout = 5000)
   public void circleArchitectureTest()
   {
      Circle circle = new Circle(5.6789, new Point(-99, 66), Color.cyan, 
                                 false);

      Class cl = circle.getClass();
      assertEquals(1, cl.getConstructors().length);
      assertEquals(1, cl.getInterfaces().length);
      assertEquals("Shape", cl.getInterfaces()[0].getName());

      int cnt = countModifiers(cl.getDeclaredMethods(), Modifier.PUBLIC);
      assertEquals(10, cnt);

      cnt = cl.getFields().length;
      assertEquals(0, cnt);

      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED);
      assertEquals(0, cnt);

      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE);
      assertEquals(4, cnt);

      cnt = cl.getDeclaredFields().length 
            - countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE) 
            - countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED) 
            - countModifiers(cl.getDeclaredFields(), Modifier.PUBLIC);
      assertEquals(0, cnt);
   }

   @Test (timeout = 5000)
   public void rectangleArchitectureTest()
   {        
      Rectangle rect = new Rectangle(4.3, 5.6, new Point(-99, 66), 
                                     Color.cyan, false);
      
      Class cl = rect.getClass();

      assertEquals(1, cl.getConstructors().length);
      assertEquals(1, cl.getInterfaces().length);
      assertEquals("Shape", cl.getInterfaces()[0].getName());
      
      int cnt = countModifiers(cl.getDeclaredMethods(), Modifier.PUBLIC);
      assertEquals(12, cnt);

      cnt = cl.getFields().length;
      assertEquals(0, cnt);

      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED);
      assertEquals(0, cnt);

      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE);
      assertEquals(5, cnt);

      cnt = cl.getDeclaredFields().length 
            - countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE) 
            - countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED) 
            - countModifiers(cl.getDeclaredFields(), Modifier.PUBLIC);
      assertEquals(0, cnt);
   }

   @Test (timeout = 5000)
   public void triangleArchitectureTest()
   { 
      Point a = new Point(0, 0);
      Point b = new Point(3, 0);
      Point c = new Point(0, 4);    
      Triangle tri = new Triangle(a, b, c, Color.cyan, false);
      
      Class cl = tri.getClass();

      assertEquals(1, cl.getConstructors().length);
      assertEquals(1, cl.getInterfaces().length);
      assertEquals("Shape", cl.getInterfaces()[0].getName());
      
      int cnt = countModifiers(cl.getDeclaredMethods(), Modifier.PUBLIC);
      assertEquals(13, cnt);

      cnt = cl.getFields().length;
      assertEquals(0, cnt);

      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED);
      assertEquals(0, cnt);

      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE);
      assertEquals(5, cnt);

      cnt = cl.getDeclaredFields().length 
            - countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE) 
            - countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED) 
            - countModifiers(cl.getDeclaredFields(), Modifier.PUBLIC);
      assertEquals(0, cnt);
   }

   @Test (timeout = 5000)
   public void convexPolygonArchitectureTest()
   {
      Point a = new Point(7, 7);
      Point b = new Point(0, 9);
      Point c = new Point(-3, -5);
      Point d = new Point(2, -6);
      Point e = new Point(12, 0);
      Point[] vertices = new Point[5];
      vertices[0] = new Point(a);
      vertices[1] = new Point(b);
      vertices[2] = new Point(c);
      vertices[3] = new Point(d);
      vertices[4] = new Point(e);
      ConvexPolygon poly = new ConvexPolygon(vertices, Color.cyan, false);

      Class cl = poly.getClass();

      assertEquals(1, cl.getConstructors().length);
      assertEquals(1, cl.getInterfaces().length);
      assertEquals("Shape", cl.getInterfaces()[0].getName());
      
      int cnt = countModifiers(cl.getDeclaredMethods(), Modifier.PUBLIC);
      assertEquals(9, cnt);

      cnt = cl.getFields().length;
      assertEquals(0, cnt);

      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED);
      assertEquals(0, cnt);

      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE);
      assertEquals(3, cnt);

      cnt = cl.getDeclaredFields().length 
            - countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE) 
            - countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED) 
            - countModifiers(cl.getDeclaredFields(), Modifier.PUBLIC);
      assertEquals(0, cnt);
   }

   @Test (timeout = 5000)
   public void workSpaceArchitectureTest()
   {
      WorkSpace ws = new WorkSpace();
      Class cl = ws.getClass();

      assertEquals(1, cl.getConstructors().length);
      
      int cnt = countModifiers(cl.getDeclaredMethods(), Modifier.PUBLIC);
      assertEquals(10, cnt);

      cnt = cl.getFields().length;
      assertEquals(0, cnt);

      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED);
      assertEquals(0, cnt);

      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE);
      assertEquals(1, cnt);

      cnt = cl.getDeclaredFields().length 
            - countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE) 
            - countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED) 
            - countModifiers(cl.getDeclaredFields(), Modifier.PUBLIC);
      assertEquals(0, cnt);
   }

   @Test (timeout = 5000)
   public void circleTest()
   {
      Circle circle = new Circle(5.6789, new Point(-99, 66), Color.cyan, 
                                 false);

      assertEquals(Math.PI*5.6789*5.6789, circle.getArea(), 0.000001);
      assertEquals(Color.cyan, circle.getColor());

      circle.setColor(Color.black);
      assertEquals(Color.black, circle.getColor());
      assertFalse(circle.getFilled());
      
      circle.setFilled(true);
      assertTrue(circle.getFilled());
      assertEquals(5.6789, circle.getRadius(), 0.000001);

      circle.setRadius(4.321);
      assertEquals(4.321, circle.getRadius(), 0.000001);
      assertEquals(Math.PI*4.321*4.321, circle.getArea(), 0.000001);
      assertEquals(new Point(-99, 66), circle.getPosition());
      
      circle.move(new Point(-5, -7)); 
      assertEquals(new Point(-104, 59), circle.getPosition());

      Circle circle2 = new Circle(4.321, new Point(-104, 59), Color.black, 
                                  true);
      assertTrue(circle.equals(circle2));
      
      Circle circle3 = new Circle(4.3219, new Point(-104, 59), Color.black, 
                                  false);
      assertFalse(circle2.equals(circle3));

      circle3 = new Circle(4.321, new Point(-104, 59), Color.red, false);
      assertFalse(circle2.equals(circle3));
 
      circle3 = new Circle(4.321, new Point(104, 59), Color.black, false); 
      assertFalse(circle2.equals(circle3));
      
      assertFalse(circle2.equals(null));
      assertFalse(circle2.equals(new String("Whatever")));
   }

   @Test (timeout = 5000)
   public void rectangleTest()
   {
      Rectangle rect = new Rectangle(4.3, 5.6, new Point(-99, 66), Color.cyan, 
                                     false);

      assertEquals(4.3 * 5.6, rect.getArea(), 0.000001);
      assertEquals(Color.cyan, rect.getColor());
      
      rect.setColor(Color.black);
      assertEquals(Color.black, rect.getColor());
      assertFalse(rect.getFilled());
      
      rect.setFilled(true);
      assertTrue(rect.getFilled());
      assertEquals(4.3, rect.getWidth(), 0.000001);
      assertEquals(5.6, rect.getHeight(), 0.000001);
      
      rect.setWidth(4.321);
      assertEquals(4.321, rect.getWidth(), 0.000001);
      
      rect.setHeight(89.21);
      assertEquals(89.21, rect.getHeight(), 0.000001);
      assertEquals(4.321 * 89.21, rect.getArea(), 0.000001);
      assertEquals(new Point(-99, 66), rect.getPosition());
      
      rect.move(new Point(-5, -7));
      assertEquals(new Point(-104, 59), rect.getPosition());

      Rectangle rect2 = new Rectangle(4.321, 89.21, new Point(-104, 59), 
                                      Color.black, true);
      assertTrue(rect.equals(rect2));

      Rectangle rect3 = new Rectangle(4.3219, 89.21, new Point(-104, 59), 
                                      Color.black, false);
      assertFalse(rect2.equals(rect3));

      rect3 = new Rectangle(4.321, 89.219, new Point(-104, 59), Color.black, 
                            false);
      assertFalse(rect2.equals(rect3));

      rect3 = new Rectangle(4.321, 89.21, new Point(-104, 59), Color.red, 
                            false);
      assertFalse(rect2.equals(rect3));
      
      rect3 = new Rectangle(4.321, 89.21, new Point(104, 59), Color.black, 
                            false);
      assertFalse(rect2.equals(rect3));
      
      assertFalse(rect2.equals(null));
      assertFalse(rect2.equals(new String("Whatever")));       
   }

   @Test (timeout = 5000)
   public void triangleTest()
   {
      Point a = new Point(4, 0);
      Point b = new Point(-2, -1);
      Point c = new Point(1, 4);
      Triangle tri = new Triangle(a, b, c, Color.cyan, false);

      assertEquals(13.5, tri.getArea(), 0.000001);
      assertEquals(Color.cyan, tri.getColor());

      tri.setColor(Color.black);
      assertEquals(Color.black, tri.getColor());
      assertFalse(tri.getFilled());
      
      tri.setFilled(true);
      assertTrue(tri.getFilled());
      assertEquals(new Point(4, 0), tri.getVertexA());
      assertEquals(new Point(-2, -1), tri.getVertexB());
      assertEquals(new Point(1, 4), tri.getVertexC());
      
      a = new Point(7, -3);
      tri.setVertexA(a);
      assertEquals(new Point(7, -3), tri.getVertexA());
      
      b = new Point(13, 56);
      tri.setVertexB(b);
      assertEquals(new Point(13, 56), tri.getVertexB());
      
      c = new Point(-3, 23);
      tri.setVertexC(c);
      assertEquals(new Point(-3, 23), tri.getVertexC());

      assertEquals(373.0, tri.getArea(), 0.000001);
      
      tri.move(new Point(-5, -7));
      assertEquals(new Point(2, -10), tri.getVertexA());
      assertEquals(new Point(8, 49), tri.getVertexB());
      assertEquals(new Point(-8, 16), tri.getVertexC());
      
      a = new Point(2, -10);
      b = new Point(8, 49);
      c = new Point(-8, 16);
      
      Triangle tri2 = new Triangle(a, b, c, Color.black, true);
      assertTrue(tri.equals(tri2));

      Triangle tri3 = new Triangle(new Point(3, -9), b, c, Color.black, false);
      assertFalse(tri2.equals(tri3));

      tri3 = new Triangle(a, new Point(7, 48), c, Color.black, false);
      assertFalse(tri2.equals(tri3));

      tri3 = new Triangle(a, b, new Point(-7, 17), Color.black, false);
      assertFalse(tri2.equals(tri3));

      tri3 = new Triangle(a, b, c, Color.red, false);
      assertFalse(tri2.equals(tri3));

      assertFalse(tri2.equals(null));
      assertFalse(tri2.equals(new String("Whatever")));
   }

   @Test (timeout = 5000)
   public void convexPolygonTest()
   {
      Point a = new Point(7, 7);
      Point b = new Point(0, 9);
      Point c = new Point(-3, -5);
      Point d = new Point(2, -6);
      Point e = new Point(12, 0);
      Point[] vertices = new Point[5];
      vertices[0] = new Point(a);
      vertices[1] = new Point(b);
      vertices[2] = new Point(c);
      vertices[3] = new Point(d);
      vertices[4] = new Point(e);
   
      ConvexPolygon poly = new ConvexPolygon(deepCopy(vertices), Color.cyan, 
                                             false);

      assertEquals(137.0, poly.getArea(), 0.000001);
      assertEquals(Color.cyan, poly.getColor());
     
      poly.setColor(Color.black);
      assertEquals(Color.black, poly.getColor());
      assertFalse(poly.getFilled());
     
      poly.setFilled(true);
      assertTrue(poly.getFilled());

      assertEquals(a, poly.getVertex(0));
      assertEquals(b, poly.getVertex(1));
      assertEquals(c, poly.getVertex(2));
      assertEquals(d, poly.getVertex(3));
      assertEquals(e, poly.getVertex(4));

      poly.setVertex(0, new Point(8, 9));
      assertEquals(new Point(8, 9), poly.getVertex(0));

      poly.setVertex(1, new Point(1, 11));
      assertEquals(new Point(1, 11), poly.getVertex(1));
      
      poly.setVertex(2, new Point(-2, -3));
      assertEquals(new Point(-2, -3), poly.getVertex(2));

      poly.setVertex(3, new Point(3, -4));
      assertEquals(new Point(3, -4), poly.getVertex(3));

      poly.setVertex(4, new Point(13, 2));
      assertEquals(new Point(13, 2), poly.getVertex(4));

      poly.move(new Point(-1, -2));
      assertEquals(new Point(7, 7), poly.getVertex(0));
      assertEquals(new Point(0, 9), poly.getVertex(1));
      assertEquals(new Point(-3, -5), poly.getVertex(2));
      assertEquals(new Point(2, -6), poly.getVertex(3));
      assertEquals(new Point(12, 0), poly.getVertex(4));

      ConvexPolygon poly2 = new ConvexPolygon(deepCopy(vertices), Color.black,
                                              false);
      
      assertFalse(poly.equals(poly2));
      
      poly2.setFilled(true);
      assertTrue(poly.equals(poly2));
      
      ConvexPolygon poly3 = new ConvexPolygon(deepCopy(vertices), Color.black, 
                                              false);
      poly3.setFilled(true);
      poly3.setVertex(0, new Point(7, 8));
      assertFalse(poly2.equals(poly3));
     
      poly3 = new ConvexPolygon(deepCopy(vertices), Color.black, false);
      poly3.setVertex(1, new Point(1, 9));
      assertFalse(poly2.equals(poly3));

      poly3 = new ConvexPolygon(deepCopy(vertices), Color.black, false);
      poly3.setVertex(4, new Point(13, 1));
      assertFalse(poly2.equals(poly3));

      poly3 = new ConvexPolygon(deepCopy(vertices), Color.red, false);
      assertFalse(poly2.equals(poly3));
      assertFalse(poly2.equals(null));
      assertFalse(poly2.equals(new String("Whatever")));
   }

   @Test (timeout = 5000)
   public void workSpaceTest()
   {
      double area;
      WorkSpace ws = new WorkSpace();
      Circle[] circles = new Circle[3];
      Rectangle[] rects = new Rectangle[3];
      Triangle[] tris = new Triangle[3];
      ConvexPolygon[] polys = new ConvexPolygon[3];
      ArrayList<Circle> circleList;
      ArrayList<Rectangle> rectList;
      ArrayList<Triangle> triList;
      ArrayList<ConvexPolygon> polyList;
      ArrayList<Shape> shapeList;
      
      circles[0] = new Circle(1.1, new Point(1, 2), Color.cyan, false);
      circles[1] = new Circle(2.2, new Point(2, 3), Color.red, false);   
      circles[2] = new Circle(3.3, new Point(3, 4), Color.black, false);
      
      rects[0] = new Rectangle(1.1, 1.11, new Point(1, 2), Color.cyan, false);
      rects[1] = new Rectangle(2.2, 2.22, new Point(2, 3), Color.red, false);
      rects[2] = new Rectangle(3.3, 3.33, new Point(3, 4), Color.black, false);
      
      Point a = new Point(1, 1);
      Point b = new Point(0, 2);
      Point c = new Point(0, 0);
      
      Point aa = new Point( 2, 2);
      Point bb = new Point(1, 3);
      Point cc = new Point(1, 1);
      
      Point aaa = new Point(3, 3);
      Point bbb = new Point(2, 4);
      Point ccc = new Point(2, 2);

      tris[0] = new Triangle(a, b, c, Color.cyan, false);
      tris[1] = new Triangle(aa, bb, cc, Color.red, false);
      tris[2] = new Triangle(aaa, bbb, ccc, Color.black, false);
      
      Point[] aVertices = new Point[5];
      Point[] bVertices = new Point[5];
      Point[] cVertices = new Point[5];
      
      aVertices[0] = new Point(4, 0);
      aVertices[1] = new Point(2, 2);
      aVertices[2] = new Point(-2, -2);
      aVertices[3] = new Point(-4, 0);
      aVertices[4] = new Point(0, -2);

      bVertices[0] = new Point(4, 1);
      bVertices[1] = new Point(2, 3);
      bVertices[2] = new Point(-2, -1);
      bVertices[3] = new Point(-4, 1);
      bVertices[4] = new Point(0, -1);

      cVertices[0] = new Point(4, -1);
      cVertices[1] = new Point(2, 1);
      cVertices[2] = new Point(-2, -3);
      cVertices[3] = new Point(-4, -1);
      cVertices[4] = new Point(0, -3);
     
      polys[0] = new ConvexPolygon(aVertices, Color.cyan, false);
      polys[1] = new ConvexPolygon(bVertices, Color.red, false);
      polys[2] = new ConvexPolygon(cVertices, Color.black, false);
      
      // Test an empty WorkSpace...
      assertEquals(0, ws.size());
      assertEquals(0, ws.getCircles().size());
      assertEquals(0, ws.getRectangles().size());
      assertEquals(0, ws.getTriangles().size());
      assertEquals(0, ws.getConvexPolygons().size());
      assertEquals(0, ws.getShapesByColor(Color.cyan).size());
      assertEquals(0.0, ws.getAreaOfAllShapes(), 0.000001);
      
      // Add a shape and test a WorkSpace with one shape in it...
      ws.add(circles[0]);

      assertEquals(1, ws.size());
      assertEquals(1, ws.getCircles().size());
      assertEquals(0, ws.getRectangles().size());
      assertEquals(0, ws.getTriangles().size());
      assertEquals(0, ws.getConvexPolygons().size());
      assertEquals(0, ws.getShapesByColor(Color.black).size());
      assertEquals(1, ws.getShapesByColor(Color.cyan).size());
      assertTrue(ws.getCircles().get(0).equals(circles[0]));
      assertTrue(ws.getShapesByColor(Color.cyan).get(0).equals(circles[0]));
      assertTrue(ws.get(0).equals(circles[0]));
      assertEquals(circles[0].getArea(), ws.getAreaOfAllShapes(), 0.000001);
      
      // Remove a shape and test an empty WorkSpace...
      assertTrue(ws.remove(0).equals(circles[0]));
      assertEquals(0, ws.size());
      assertEquals(0, ws.getCircles().size());
      assertEquals(0, ws.getRectangles().size());
      assertEquals(0, ws.getTriangles().size());
      assertEquals(0, ws.getConvexPolygons().size());
      assertEquals(0, ws.getShapesByColor(Color.cyan).size());
      assertEquals(0.0, ws.getAreaOfAllShapes(), 0.000001);
      
      // Add one of each shape and test...
      ws.add(circles[0]);
      ws.add(rects[0]);
      ws.add(tris[0]);
      ws.add(polys[0]);
      
      assertEquals(4, ws.size());
      assertEquals(1, ws.getCircles().size());
      assertEquals(1, ws.getRectangles().size());
      assertEquals(1, ws.getTriangles().size());
      assertEquals(1, ws.getConvexPolygons().size());
      assertEquals(0, ws.getShapesByColor(Color.black).size());
      assertEquals(4, ws.getShapesByColor(Color.cyan).size());
      assertTrue(ws.getCircles().get(0).equals(circles[0]));
      assertTrue(ws.getRectangles().get(0).equals(rects[0]));
      assertTrue(ws.getTriangles().get(0).equals(tris[0]));
      assertTrue(ws.getConvexPolygons().get(0).equals(polys[0]));
      
      area = circles[0].getArea() + rects[0].getArea() + tris[0].getArea()
             + polys[0].getArea();
      assertEquals(area, ws.getAreaOfAllShapes(), 0.000001);

      // Remove a shape and test again...
      ws.remove(2);

      assertEquals(3, ws.size());
      assertEquals(1, ws.getCircles().size());
      assertEquals(1, ws.getRectangles().size());
      assertEquals(0, ws.getTriangles().size());
      assertEquals(1, ws.getConvexPolygons().size());
      assertEquals(0, ws.getShapesByColor(Color.black).size());
      assertEquals(3, ws.getShapesByColor(Color.cyan).size());
      assertTrue(ws.getCircles().get(0).equals(circles[0]));
      assertTrue(ws.getRectangles().get(0).equals(rects[0]));
      assertTrue(ws.getConvexPolygons().get(0).equals(polys[0]));
      
      area -= tris[0].getArea();
      assertEquals(area, ws.getAreaOfAllShapes(), 0.000001);

      // Add more shapes and test again...
      ws.add(tris[0]);
      area += tris[0].getArea();
            
      for(int i = 1; i < 3; i++)
      {
         ws.add(circles[i]);
         ws.add(rects[i]);
         ws.add(tris[i]);
         ws.add(polys[i]);
         
         area += circles[i].getArea() + rects[i].getArea() + tris[i].getArea()
                 + polys[i].getArea();      
      }

      assertEquals(12, ws.size());
      assertEquals(3, ws.getCircles().size());
      assertEquals(3, ws.getRectangles().size());
      assertEquals(3, ws.getTriangles().size());
      assertEquals(3, ws.getConvexPolygons().size());
      assertEquals(4, ws.getShapesByColor(Color.black).size());
      assertEquals(4, ws.getShapesByColor(Color.cyan).size());
      assertEquals(0, ws.getShapesByColor(Color.white).size());
      assertTrue(ws.get(8).equals(circles[2]));
      assertTrue(ws.get(9).equals(rects[2]));
      assertTrue(ws.get(10).equals(tris[2]));
      assertTrue(ws.get(11).equals(polys[2]));
      assertEquals(area, ws.getAreaOfAllShapes(), 0.000001);

      // Remove a couple of shapes and test again...
      assertTrue(ws.remove(0).equals(circles[0]));
      assertTrue(ws.remove(10).equals(polys[2]));
      assertTrue(ws.remove(7).equals(circles[2]));

      assertEquals(9, ws.size());
      assertEquals(1, ws.getCircles().size());
      assertEquals(3, ws.getRectangles().size());
      assertEquals(3, ws.getTriangles().size());
      assertEquals(2, ws.getConvexPolygons().size());
      assertEquals(2, ws.getShapesByColor(Color.black).size());
      assertEquals(3, ws.getShapesByColor(Color.cyan).size());
      assertEquals(0, ws.getShapesByColor(Color.white).size());
      
      area -= circles[0].getArea();
      area -= polys[2].getArea();
      area -= circles[2].getArea();
      assertEquals(area, ws.getAreaOfAllShapes(), 0.000001);
   }

   private int countModifiers(Field[] fields, int modifier)
   {
      int count = 0;
      
      for (Field f : fields)
      {
         if (f.getModifiers() == modifier)
            count++;
      }
      
      return count;
   }
   
   private int countModifiers(Method[] methods, int modifier)
   {
      int count = 0;
      
      for (Method m : methods)
      {
         if (m.getModifiers() == modifier)
            count++;
      }
      
      return count;
   }

   private Point[] deepCopy(Point[] a)
   {
      int i = 0;
      Point[] ret = new Point[a.length];
      
      for(Point p : a)
         ret[i++] = p == null ? null : new Point(p);
      
      return ret;
   }
}
package cpe102project2;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Triangle implements Shape {
	//instance variables 
	private Point a;
	private Point b;
	private Point c;
	private Color color;
	private boolean filled;

	//constructor
	public Triangle(Point a, Point b, Point c, Color color, boolean filled) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.color = color;
		this.filled = filled;
	}

	//methods
	//getvertexa() returns the specific vertex of the triangle
	public Point getVertexA() {
		return a;
	}

	//setvertexa() sets a specific vertex of the triangle
	public void setVertexA(Point point) {
		this.a = point;
	}

	//getvertexb() returns the specific vertex of the triangle
	public Point getVertexB() {
		return b;
	}

	//setvertexb() sets a specific vertex of the triangle
	public void setVertexB(Point point) {
		this.b = point;
	}

	//getvertexc() returns the specific vertex of the triangle
	public Point getVertexC() {
		return c;
	}

	//setvertexc() sets a specific vertex of the triangle
	public void setVertexC(Point point) {
		this.c = point;
	}

	public double getArea() {
        double distanceAB;
        double distanceBC;
        double distanceCA;
        double semiperimeter;
        distanceCA = Math.sqrt((a.getX() - c.getX())*(a.getX() - c.getX()) + (a.getY() - c.getY())*(a.getY() - c.getY()));
        distanceAB = Math.sqrt((b.getX() - a.getX())*(b.getX() - a.getX()) + (b.getY() - a.getY())*(b.getY() - a.getY()));
        distanceBC = Math.sqrt((c.getX() - b.getX())*(c.getX() - b.getX()) + (c.getY() - b.getY())*(c.getY() - b.getY()));
        semiperimeter = (distanceAB + distanceBC + distanceCA)/2;
         
        return Math.sqrt(semiperimeter*(semiperimeter-distanceAB)*(semiperimeter-distanceBC)*(semiperimeter-distanceCA)); 
   
	}

	//override the equals method so that it returns true for 2 Triangle objects that are logically equivalent based on state of all instance variables
    public Color getColor() {
    	return color;
    }

    public void setColor(Color color) {
    	this.color = color;
    }

    public boolean getFilled() {
    	if (filled == true) {
    		return true;
    	} else {
    		return false;
    	}
    }// end of method

    public void setFilled(boolean filled) {
    	// sets the filled state of object
    	this.filled = filled;
    }

    public void move(Point point) {
    	a.translate((int) point.getX(), (int) point.getY());
    	b.translate((int) point.getX(), (int) point.getY());
    	c.translate((int) point.getX(), (int) point.getY());
    }
    

    public boolean equals(Object obj) {
        if (obj == null) {
        	//if nothing in object
            return false;
        } else if(!(this.getClass().equals(obj.getClass()))) {
        	//if object's class isnt even in the same class
            return false;
        }
        Triangle o1 = (Triangle)obj;

        
        //return true if all vertices are equal and colors/filled are all the same
        return this.a.equals(o1.getVertexA()) && this.b.equals(o1.getVertexB()) && this.c.equals(o1.getVertexC()) && this.color.equals(o1.getColor()) && this.filled == o1.getFilled();
    }
    
}

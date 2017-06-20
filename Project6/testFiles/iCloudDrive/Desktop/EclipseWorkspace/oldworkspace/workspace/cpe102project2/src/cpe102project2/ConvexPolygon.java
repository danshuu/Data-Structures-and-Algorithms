package cpe102project2;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;


public class ConvexPolygon implements Shape {
	//instance variables
	private Point[] vertices;
	private Color color;
	private boolean filled;

	// int[] myIntegers = {1,2,3,4};
	// myIntegers[3]
	// Point[] myPoints = {new Point(1,2), new Point(5,6)};

	//Constructor
	//vertices must be specified in counterclockwise order
	//assume that the array passed to the constructor is in counterclockwise order
	//boolean indicates if the shape is filled with color or wireframe
	public ConvexPolygon(Point[] vertices, Color color, boolean filled) {
		this.vertices = new Point[vertices.length];
		for (int i = 0; i < vertices.length; i++) {
			this.vertices[i] = vertices[i];		
		}
		//this.vertices = vertices;
		this.color = color;
		this.filled = filled;
	}

	public Point getVertex(int index) {
		return vertices[index];
	}

	public void setVertex(int index, Point point) {
		this.vertices[index] = point;
	}

    public double getArea() {
        double sum1,sum2;
        sum1 = 0;
        sum2 = 0;
        for (int i=0; i<vertices.length; i++) {
            int a = i%vertices.length;
            int b = (a+1)%vertices.length;
            sum1 += (vertices[a].getX() * vertices[b].getY());
            sum2 += (vertices[a].getY() * vertices[b].getX());
        } // end of loop
        return 1/2.0*(sum1 - sum2);
    } // end of method

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
        for(int i = 0; i<vertices.length; i++) {
        	/* translate will move the points x and y by the given 
        	x and y of the other point */
            vertices[i].translate((int) point.getX(), (int) point.getY());
        }
    }

    public boolean equals(Object obj)
    {
        if (obj == null) {
        	//if nothing in object
            return false;
        } else if(!(this.getClass().equals(obj.getClass()))) {
        	//if object's class isnt even in the same class
            return false;
        }
        ConvexPolygon o1 = (ConvexPolygon)obj;
        //initial status as false
        boolean check = false;
        for (int i = 0; i<vertices.length; i++) {
            if(!(this.vertices[i].equals(o1.getVertex(i)))) {
            	/* if one vertice doesnt equal another, false then break
            	 the loop */
                check = false;
                break;

            } else {
            	//vertice is equal to one vertice
                check = true;
            }
        }
        //return true if all vertices are equal and colors/filled are all the same
        return check && this.color.equals(o1.getColor()) && this.filled == o1.getFilled();
    }
    
}

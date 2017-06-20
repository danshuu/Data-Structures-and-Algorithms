import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;


public class Rectangle implements Shape {
	//instance variables
	private double width;
	private double height;
	private Point position;
	private Color color;
	private boolean filled;
	//Constructor for Rectangle
	//Point specifies the location of the lower-left corner of the rectangle
	//boolean indicates if shape is filled with color or wire-frame
	public Rectangle(double width, double height, Point position, Color color, boolean filled) {
		this.width = width;
		this.height = height;
		this.position = position;
		this.color = color;
		this.filled = filled;
	}

	//methods
	//getwidth() returns width of rectangle object
	public double getWidth() {
		return width;
	}

	//setwidth() sets the width of the rectangle object
	public void setWidth(double width) {
		this.width = width;
	}

	//getheight() returns height of rectangle object
	public double getHeight() {
		return height;
	}

	//setheight() sets height of rectangle object
	public void setHeight(double height) {
		this.height = height;
	}

	//getposition() returns position of rectangle object
	public Point getPosition() {
		return position;
	}

	public double getArea() {
		// get & return area of a circle
		return (width * height);
	}	

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
    	position.translate((int) point.getX(), (int) point.getY());
    }
    

    public boolean equals(Object obj) {
        if (obj == null) {
        	//if nothing in object
            return false;
        } else if(!(this.getClass().equals(obj.getClass()))) {
        	//if object's class isnt even in the same class
            return false;
        }
        Rectangle o1 = (Rectangle)obj;
        
        //return true if all vertices are equal and colors/filled are all the same
        return this.width == (o1.getWidth()) && this.height == (o1.getHeight()) && this.position.equals(o1.getPosition()) && this.color.equals(o1.getColor()) && this.filled == o1.getFilled();
    }

	//override the equals method so that it returns true for 2 rectangle objects that are logically equivalent based on state of all instance variables
}

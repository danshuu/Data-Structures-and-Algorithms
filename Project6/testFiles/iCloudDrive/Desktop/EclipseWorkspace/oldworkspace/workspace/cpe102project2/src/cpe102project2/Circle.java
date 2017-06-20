package cpe102project2;

import java.awt.Point;
import java.awt.Color;
import java.util.ArrayList;

public class Circle {
	//instance variables
	double radius;
	Point position;
	Color color;
	boolean filled;

	//Constructor
	public Circle(double radius, Point position, Color color, boolean filled) {
		this.radius = radius;
		this.position = position;
		this.color = color;
		this.filled = filled;
	}

	public double getRadius() {
		//returns radius of the circle object
		return radius;
	}

	public void setRadius(double radius) {
		//sets the radius of the circle object
		this.radius = radius;
	}

	public Point getPosition() {
		//return position of the circle object
		return position;
	}

	//methods
	public double getArea() {
		return Math.PI * radius * radius;
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
		} // end of if
	} // end of method

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public void move(Point point) {
		position.translate((int)point.getX(), (int)point.getY());
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (this.getClass().equals(obj.getClass())) {
			return false;
		} 

		//create a new circle object from the object class
		//so you can check if the two circles are equal by calling the circles methods

		Circle o1 = (Circle)obj;

		return (this.radius == o1.getRadius() && this.position.equals(o1.getPosition()) && this.color.equals(o1.getColor()) && this.filled == (o1.getFilled()));
	} // end of method

}
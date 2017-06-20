import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
 
public interface Shape {
	double getArea(); // Calculates and returns the area of the object
	Color getColor(); // Returns the Color of the object
	void setColor(Color color); // Sets the color of the object
	boolean getFilled(); // Returns true if the object is filled with color, otherwise false
	void setFilled(boolean filled); // Sets the filled state of the object
	void move(Point point); // Moves the shape by the x and y amounts specified in the Point
}

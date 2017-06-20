//class implementation here
public class CartesianPoint implements Point {

	//instance variables
	private double x;
	private double y;

	//implementing of methods

	//returns the xcoordinate

	public double xCoordinate() {
		return x;
	}

	//returns the ycoordinate

	public double yCoordinate() {
		return y;
	}

	//returns the radius which is sqrt of x square + y square
	
	public double radius() {
		return Math.sqrt(x * x + y * y);
	}

	//returns the angle which is arctan(y/x)

	public double angle() {
		return Math.atan(y/x);
	}
	
	/*this method returns the distance of the object declared and another object.
	The other object will be declared and used in the parameter of the object using the method.
	example: x.distanceFrom(x2) will return the distance from x and x2.
	*/
	
	public double distanceFrom(Point other) {
		return Math.sqrt((x - other.xCoordinate()) * (x - other.xCoordinate()) + (y - other.yCoordinate()) * (y-other.yCoordinate()));
	}

	//this method will rotate the point by 90 degrees by flipping the y and the x and making the y negative.

	public Point rotate90(){
		return new CartesianPoint(-y , x);
	}

	//constructor
	//this constructor initializes the object and declares the instance variable of each object

	public CartesianPoint(double xCoord, double yCoord) {
		this.x = xCoord;
		this.y = yCoord;
	}

}

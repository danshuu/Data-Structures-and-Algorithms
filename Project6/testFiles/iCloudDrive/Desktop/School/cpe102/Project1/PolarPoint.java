//class implementation here
public class PolarPoint implements Point {

	//variable initialization
	
	private double radius;
	private double angle;

	//implementing of methods

	//this method returns the x coordinate, by using the radius and angle known
	
	public double xCoordinate() {
		return radius * Math.cos(angle);
	}

	//this method returns the y coordinate, by using the radius and angle known

	public double yCoordinate() {
		return radius * Math.sin(angle);
	}

	//this method returns the radius known

	public double radius() {
		return radius;
	}

	//this method returns the angle known

	public double angle() {
		return angle;
	}

	/*this method returns the distance of the object declared and another object.
	The other object will be declared and used in the parameter of the object using the method.
	example: x.distanceFrom(x2) will return the distance from x and x2.
	*/

	public double distanceFrom(Point other) {
		return Math.sqrt((radius * radius) + (other.radius() * other.radius()) - (2 * radius * other.radius() * Math.cos(other.angle() - angle)));
	}

	//this method will add pi/2 to the already declared point's angle in radians.

	public Point rotate90() {
		return new PolarPoint(radius , angle + Math.PI/2.0);
	}

	//constructor
	//this constructor initializes the object and declares the instance variable of each object
	public PolarPoint(double radiusOf, double angleOf) {
		this.radius = radiusOf;
		this.angle = angleOf;
	}

}

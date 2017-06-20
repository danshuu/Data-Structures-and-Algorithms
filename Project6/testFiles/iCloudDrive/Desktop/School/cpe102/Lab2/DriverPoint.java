public class DriverPoint {
	public static void main(String[] args) {
		CartesianPoint cp = new CartesianPoint(0.0, 8.0);
		CartesianPoint cp2 = new CartesianPoint(0.0, 3.0);
  		System.out.println("The Cartesian distance between point " + cp.xCoordinate() + ", " + cp.yCoordinate() + " and point " + cp.xCoordinate() + ", " + cp.yCoordinate() + " is " + cp.distanceFrom(cp2));

	}
}



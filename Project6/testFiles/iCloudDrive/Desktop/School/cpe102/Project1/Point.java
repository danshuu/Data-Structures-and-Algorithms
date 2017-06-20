public interface Point 
{
	double xCoordinate();
	double yCoordinate();
	double radius();
	double angle();
	double distanceFrom(Point other);
	Point rotate90();
}
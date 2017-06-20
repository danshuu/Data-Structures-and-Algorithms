/**
* HashMetrics is an interface
* 
* @author Daniel Shu
* @version Project 5 CPE103
*/

public interface HashMetrics<T> {

	long collisions(); //returns the total number of collisions that have occurred during all calls to add in this table

	int maxCollisions(); //returns the maximum number of collisions that have occurred during a single call to add in this table

}

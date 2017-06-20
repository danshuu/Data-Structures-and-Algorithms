/**
 * An abstract class for Occupants of the maze
 *
 * @author Bradley Ting, Daniel Shu
 * @version 11/4/2016
 */
public abstract class Occupant {
	//instance variables
	private Square location;
	
	//constructors
	public Occupant(){}
	public Occupant(Square start){
		this.location = start;
	}
	
	//methods
	public Square location(){
		return this.location;
	}
	public void moveTo(Square newLoc){
		this.location = newLoc;
	}
}
	
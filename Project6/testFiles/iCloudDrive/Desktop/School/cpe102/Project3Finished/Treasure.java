/**
 * A class that creates the Treasure object which can be found by the explorer
 *
 * @author Bradley Ting, Daniel Shu
 * @version 11/4/2016
 */
public class Treasure extends RandomOccupant {

	//instance variable
	private boolean found;
	
	//constructors
	public Treasure(Maze maze){
		super(maze);
		this.found = false; //In the constructor, the object must also send itself (using this) to the setTreasure method
		super.location().setTreasure(this);					//of the Square it resides in. 
	}
	public Treasure(Maze maze, long seed){
		super(maze, seed);
		this.found = false;
		super.location().setTreasure(this);
	}
	public Treasure(Maze maze, Square location){
		super(maze, location);
		this.found = false;
		super.location().setTreasure(this);
	}
	
	//methods
	public boolean found(){return found;}
	public void setFound(){this.found = true;}
	public void move(){}
}

/**
 * A class that creates the Monster class, which extends a RandomOccupant 
 *
 * @author Bradley Ting, Daniel Shu
 * @version 11/17/2016
 */
import java.util.Random;

public class Monster extends RandomOccupant{
	
	//constructors
	public Monster(Maze maze){
		super(maze);
	}
	public Monster(Maze maze, long seed){
		super(maze, seed);
	}
	public Monster(Maze maze, Square location){
		super(maze, location);
	}
	
}

import java.util.*;
/**
 * An abstract class for specifying random moves for the Treasure and Monster classes
 *
 * @author Bradley Ting, Daniel Shu
 * @version 11/4/2016
 */
public abstract class RandomOccupant extends Occupant {
	//instance variables
	private Random randy;
	private Maze maze;
	
	//constructor
	public RandomOccupant(Maze maze){
		this.maze = maze;
		randy = new Random();
		int r = randy.nextInt(maze.rows());
		int c = randy.nextInt(maze.cols());
		super.moveTo(maze.getSquare(r, c));
	}
	public RandomOccupant(Maze maze, long seed){
		this.maze = maze;
		randy = new Random(seed);
		int r = randy.nextInt(maze.rows());
		int c = randy.nextInt(maze.cols());
		super.moveTo(maze.getSquare(r, c));
	}
	public RandomOccupant(Maze maze, Square location){
		this.maze = maze;
		randy = new Random();
		super.moveTo(location);
	}
	
	//methods
	public void move(){
		int row = super.location().row();
		int col = super.location().col();
		
		int randDirection = randy.nextInt(4);
		while(super.location().wall(randDirection) == true){
			randDirection = randy.nextInt(4);
		}
		//move in whichever direction
		if(randDirection == super.location().UP) //up
			super.moveTo(this.maze.getSquare(row - 1, col));	
		else if(randDirection == super.location().RIGHT) //right
			super.moveTo(this.maze.getSquare(row, col + 1));
		else if(randDirection == super.location().DOWN) //down		
			super.moveTo(this.maze.getSquare(row + 1, col));
		else if(randDirection == super.location().LEFT) //left
			super.moveTo(this.maze.getSquare(row, col - 1));
	
		
		 
	}
	
}

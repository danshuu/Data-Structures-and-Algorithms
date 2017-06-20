import java.awt.event.KeyEvent;
/**
 * A class to create the explorer character for the maze
 *
 * @author Bradley Ting, Daniel Shu
 * @version 11/4/2016
 */
public class Explorer extends Occupant{
	//instance variables
	private String name;
	private Maze maze;
	
	//constructors
	public Explorer(Square location, Maze maze, String name){
		super(location);
		this.maze = maze;
		this.name = name;
		maze.lookAround(location);
	}
	
	//methods	
	public String name(){return this.name;}
	
	public void move(int key){
		int row = super.location().row();
		int col = super.location().col();
		Square current = super.location();
	
		//ASSUMES that walls are around all sides of the maze!
		switch(key){
		case KeyEvent.VK_UP:
		case KeyEvent.VK_KP_UP: if(!current.wall(current.UP)) {this.moveTo(this.maze.getSquare(row - 1, col));} break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_KP_RIGHT: if(!current.wall(current.RIGHT)) {this.moveTo(this.maze.getSquare(row, col + 1));} break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_KP_DOWN: if(!current.wall(current.DOWN)) {this.moveTo(this.maze.getSquare(row + 1, col));} break;
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_KP_LEFT: if(!current.wall(current.LEFT)) {this.moveTo(this.maze.getSquare(row, col - 1));} break;

		}
			
	}
	
	public void moveTo(Square s){
		super.moveTo(s);
		super.location().enter();
		maze.lookAround(s);
	}
	
	
	
}

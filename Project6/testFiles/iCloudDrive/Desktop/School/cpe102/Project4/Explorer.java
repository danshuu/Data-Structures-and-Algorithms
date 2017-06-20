import java.awt.event.KeyEvent;
import java.util.*;

public class Explorer extends Occupant {
	//Fields(instance variables)
	private String name;
	private Maze maze;

	//Constructors
	//Constructor that only takes Maze as a parameter
	public Explorer(Maze maze) {
		this.maze = maze;
	}
	public Explorer (Square location, Maze maze, String name) {
		//initialize all instance variables
		super(location); 
		this.name = name;
		this.maze = maze;
		maze.lookAround(location);
	}

	//Methods
	public String name() {
		return name;
	}

	public void move(int key) {
		//if key is up in numeric or non-numeral keypad
		Square current = super.location();
		int row = current.row();
		int col = current.col();
		if (key == KeyEvent.VK_UP || key == KeyEvent.VK_KP_UP) {
			//if the square's chosen direction has no wall, then adjust row/column accordingly
			if (current.wall(Square.UP) == false) {
				if (row - 1 >= 0) {
					// row -= 1;
					super.moveTo(maze.getSquare(row-1, col));
					//move to the square of the maze by getting the location of
					//the occupant's adjusted square location
				}
			}
		}
		//if key is right in numeric or non-numeral keypad
		if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_KP_RIGHT) {
			//if the square's chosen direction has no wall, then adjust row/column accordingly
			if (current.wall(Square.RIGHT) == false) {
				if (col + 1 <= maze.cols()) { //max of columns
					// column += 1;
					super.moveTo(maze.getSquare(row, col + 1));
				}
			}
		}
		//if key is down in numeric or non-numeral keypad
		if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_KP_DOWN) {
			//if the square's chosen direction has no wall, then adjust row/column accordingly
			if (current.wall(Square.DOWN) == false) { //max of rows
				if (row + 1 <= maze.rows()) {
					// row += 1;
					super.moveTo(maze.getSquare(row+1, col));
				}
			}
		}
		//if key is left in numeric or non-numeral keypad
		if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_KP_LEFT) {
			//if the square's chosen direction has no wall, then adjust row/column accordingly
			if (current.wall(Square.LEFT) == false) {
				if (current.col() - 1 >= 0) {
					// column -= 1;
					super.moveTo(maze.getSquare(row, col - 1));
				}
			}
		}
	} // end of move() method

	public void moveTo(Square s) {
		//move to another Square in the Maze
		super.moveTo(s); 
		super.location().enter();
		maze.lookAround(s);
	}

	public String toText(char delimiter) {
		String out = "";
		out += super.toText(delimiter);
		out += delimiter + name();
		return out;
	}

	public void toObject(Scanner input) {
		int row = input.nextInt();
		// System.out.println(row);
		int col = input.nextInt();
		// System.out.println(col);
		moveTo(maze.getSquare(row,col));
		this.name = input.next();
	}
}
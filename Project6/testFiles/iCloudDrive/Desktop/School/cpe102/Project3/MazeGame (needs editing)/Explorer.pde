import java.awt.event.KeyEvent;

public class Explorer extends Occupant {
	//Fields(instance variables)
	private String name;
	private Maze maze;

	//Constructors
	public Explorer (Square location, Maze maze, String name) {
		//initialize all instance variables
		super(location); //need super(location) here? how does it it know to use location, 
								//what if there were 2 parameters in Occupant?
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
		int row = super.location().row();
		int col = super.location().col();
		Square current = super.location();
		if (key == KeyEvent.VK_UP || key == KeyEvent.VK_KP_UP) {
			//if the square's chosen direction has no wall, then adjust row/column accordingly
			if (current.wall(Square.UP) == false) {
				if (row - 1 >= 0) {
					// row -= 1;
					super.moveTo(this.maze.getSquare(row - 1, col));
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
					super.moveTo(this.maze.getSquare(row, col + 1));
				}
			}
		}
		//if key is down in numeric or non-numeral keypad
		if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_KP_DOWN) {
			//if the square's chosen direction has no wall, then adjust row/column accordingly
			if (current.wall(Square.DOWN) == false) { //max of rows
				if (row + 1 <= maze.rows()) {
					// row += 1;
					super.moveTo(this.maze.getSquare(row + 1, col));
				}
			}
		}
		//if key is left in numeric or non-numeral keypad
		if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_KP_LEFT) {
			//if the square's chosen direction has no wall, then adjust row/column accordingly
			if (current.wall(Square.LEFT) == false) {
				if (current.col() - 1 >= 0) {
					// column -= 1;
					super.moveTo(this.maze.getSquare(row, col - 1));
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


}
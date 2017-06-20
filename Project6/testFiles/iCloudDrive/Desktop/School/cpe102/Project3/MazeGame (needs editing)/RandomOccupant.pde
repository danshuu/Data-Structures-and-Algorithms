import java.util.Random;

public abstract class RandomOccupant extends Occupant {
	//know how to generate a random Square as its initial location and know how to 
	//move randomly around the Maze
	//Fields(instance variables)
	private Random rdm;
	private Maze maze;

	//Constructors
	public RandomOccupant(Maze maze) {
		// super(); //super the default constructor
		this.maze = maze;
		rdm = new Random();
		int randomRow, randomCol;
		randomRow = rdm.nextInt(maze.rows());
		randomCol = rdm.nextInt(maze.cols());
		super.moveTo(maze.getSquare(randomRow, randomCol));
	}

	public RandomOccupant(Maze maze, long seed) {
		// super(); //super the default constructor
		this.maze = maze;
		rdm = new Random(seed);
		int randomRow, randomCol;
		randomRow = rdm.nextInt(maze.rows());
		randomCol = rdm.nextInt(maze.cols());
		//why do we have to initialize them first? isnt it the same?
		super.moveTo(maze.getSquare(randomRow, randomCol));
	}

	public RandomOccupant(Maze maze, Square location) {
		// super(location);
		this.maze = maze;
		super.moveTo(location);
		rdm = new Random(); //still need random variable in order to move randomly later
	}

	public void move() {
		//responsible for moving the RandomOccupant in a random fashion
		//cannot move through any walls in current location
		int rdmInt = rdm.nextInt(4);
		while (super.location().wall(rdmInt)) {
			rdmInt = rdm.nextInt(4);
		} //regenerates a random integer until the direction doesn't hold a wall
		if (rdmInt == super.location().UP) {
			if (super.location().row() - 1 >= 0) {
				// row -= 1;
				super.moveTo(maze.getSquare(super.location().row()-1, super.location().col()));
				//move to the square of the maze by getting the location of
				//the occupant's adjusted square location
			}
		}
		//if key is right in numeric or non-numeral keypad
		if (rdmInt == super.location().RIGHT) {
			if (super.location().col() + 1 <= maze.cols()) { //max of columns
				// column += 1;
				super.moveTo(maze.getSquare(super.location().row(), super.location().col() + 1));
			}
		}
		//if key is down in numeric or non-numeral keypad
		if (rdmInt == super.location().DOWN) {
			if (super.location().row() + 1 <= maze.rows()) {
				// row += 1;
				super.moveTo(maze.getSquare(super.location().row()+1, super.location().col()));
			}
		}
		//if key is left in numeric or non-numeral keypad
		if (rdmInt == super.location().LEFT) {
			if (super.location().col() - 1 >= 0) {
				// column -= 1;
				super.moveTo(maze.getSquare(super.location().row(), super.location().col() - 1));
			}
		}
	}
}
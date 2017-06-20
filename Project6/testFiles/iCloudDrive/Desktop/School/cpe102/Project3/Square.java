public class Square {
	//Named Constants
	public static final int SQUARE_SIZE = 50;
	public static final int UP = 0;
	public static final int RIGHT = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;

	//Fields (instance variables)
	private boolean[] squareWall = new boolean[4]; //does the square have a wall in that direction
	private boolean seen = false; //whether Square has been seen
	private boolean inView = false; //whether Square is currently in view
	private int row; //row of square
	private int column; //column of square
	private Treasure treasure = null; //keep track of treasure in Square

	//Constructors
	public Square(boolean up, boolean right, boolean down, boolean left, int row, int col) {
		//initializes the walls array and row and column
		//booleans to keep track of "seen" and "inView" should be defaulted to false
		//Treasure reference starts out null
		squareWall[UP] = up;
		squareWall[RIGHT] = right;
		squareWall[DOWN] = down;
		squareWall[LEFT] = left;
		this.row = row;
		this.column = col;
	}
	//when do you set up,down,right,left equal to true/false? ***************

	//Methods
	public boolean wall(int direction) {
		return squareWall[direction];
	}

	public boolean seen() {
		return seen;
	}

	public boolean inView() {
		return inView;
	}

	public int row() {
		return row;
	}

	public int col() {
		return column;
	}

	public Treasure treasure() {
		return treasure;
	}

	public int x() {
		//query for the x-value of upper left corner of square
		return column * SQUARE_SIZE;
	}

	public int y() {
		return row * SQUARE_SIZE;
	}

	public void setInView(boolean inView) {
		//tell the Square if it is currently in view of the Explorer
		this.inView = inView;
		if (inView == true) {
			seen = true;
		} //end of if
	} //end of method

	public void setTreasure(Treasure t) {
		//sets the treasure reference to the parameter t
		this.treasure = t;
	}

	public void enter() {
		//tells the Square that the Explorer has entered it
		//invoke treasure's setFound() only if treasure is within Square
		if (treasure != null) {
			treasure.setFound();
		}
	}

}
public class Treasure extends RandomOccupant {
	//treasure begin the game in a random location
	//treasures may not move about the maze
	//explorers must collect all treasures in the maze before
	//encountering a monster to win the game

	//Fields
	private boolean found;

	//Constructors
	public Treasure(Maze maze) {
		super(maze);
		super.location().setTreasure(this);
		found = false;
	}

	public Treasure(Maze maze, long seed) {
		super(maze, seed);
		super.location().setTreasure(this);
		found = false;
	}

	public Treasure(Maze maze, Square location) {
		super(maze, location);
		super.location().setTreasure(this);
		found = false;
	}

	public boolean found() {
		return found;
	}

	public void setFound() {
		found = true;
	}

	public void move() {
		//override the move method of RandomOccupant
	}
}
}}
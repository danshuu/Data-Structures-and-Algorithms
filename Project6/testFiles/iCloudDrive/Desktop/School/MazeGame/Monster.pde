public class Monster extends RandomOccupant {
	/*usually monsters begin the game in a random location
	but can also be placed in a constructor with a specific location in the maze
	mosters move randomly about the maze and if they run into the explorer, the
	explorer dies and the game is over */
	//Constructors
	public Monster(Maze maze) {
		super(maze);
	}

	public Monster(Maze maze, long seed) {
		super(maze, seed);
	}

	public Monster(Maze maze, Square location) {
		super(maze, location);
	}
}
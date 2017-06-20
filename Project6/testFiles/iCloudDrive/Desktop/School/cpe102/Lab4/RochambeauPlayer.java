import java.util.Random;

public class RochambeauPlayer {
	//Instance Variables
	private String name;
	private int winTotal;
	private int seed;
	private String lastThrow;
	private int throwMade;
	//instantiate the random variable to use the methods installed in random library
	private Random rdm;
	//Constructors
	public RochambeauPlayer(String name) {
		this.name = name;
		rdm = new Random();
		winTotal = 0;
	}

	public RochambeauPlayer(String name, int seed) {
		this.name = name;
		rdm = new Random(seed);
		winTotal = 0;
	}
	//methods 

	//gets the player's name
	public String getName() {
		return name;
	}

	//gets the player's win total
	public int getWins() {
		return winTotal;
	}

	//gets the last throw in String format
	//returns "No throw" only if the player hasn't made a throw yet
	public String lastThrow() {
		if (lastThrow == null) {
			return "No Throw";
		} else {
			return lastThrow;			
		}
	}

	//get player as String. Format is either: (name) has 1 win. or (name) has (#wins) wins.
	public String toString() {
		return name + " has " + winTotal + " wins.";
	}

	//increment the number of wins of the player
	public void incrementWins() {
		winTotal++;
	}

	//player decides randomly which throw to make.
	//either Rochambeau.ROCK, Rochambeau.PAPER, or Rochambeau.SCISSORS
	public int makeThrow() {
		int x = rdm.nextInt(3);
		if (x == 0) {
			lastThrow = "Rock";
		} else if (x == 1) {
			lastThrow = "Paper";
		} else if (x == 2) {
			lastThrow = "Scissors";
		} else {
			lastThrow = "No Throw";
		}
		return x;
	}

	//not random; instructs the player which throw to make
	public int makeThrow(int throwType) {
		int x = throwType;
		if (x == 0) {
			lastThrow = "Rock";
		} else if (x == 1) {
			lastThrow = "Paper";
		} else if (x == 2) {
			lastThrow = "Scissors";
		} else {
			lastThrow = "No Throw";
		}
		return x;
	}
} 
/**
 * A class that creates the Monster class, which extends a RandomOccupant 
 *
 * @author Bradley Ting, Daniel Shu
 * @version 11/4/2016
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
	
	public static void main(String[] args){
		  Square[][] mazeSquares = new Square[3][3];
	      Maze maze = new Maze(mazeSquares, 3, 3);
	      Explorer ex;
	      
	      mazeSquares[0][0] = new Square(true, false, true, true, 0, 0);
	      mazeSquares[0][1] = new Square(true, true, false, false, 0, 1);
	      mazeSquares[0][2] = new Square(true, true, false, true, 0, 2);
	      mazeSquares[1][0] = new Square(true, true, false, true, 1, 0);
	      mazeSquares[1][1] = new Square(false, false, false, true, 1, 1);
	      mazeSquares[1][2] = new Square(false, true, false, false, 1, 2);
	      mazeSquares[2][0] = new Square(false, false, true, true, 2, 0);
	      mazeSquares[2][1] = new Square(false, true, true, false, 2, 1);
	      mazeSquares[2][2] = new Square(false, true, true, true, 2, 2);
	      
	      
	      ex = new Explorer(mazeSquares[0][1], maze, "Super Chris");
	      Monster m = new Monster(maze, mazeSquares[1][1]);
	      Treasure t = new Treasure(maze, mazeSquares[2][2]);
	      maze.addRandomOccupant(m);
	      maze.addRandomOccupant(t);
	      maze.setExplorer(ex);
	      
	      System.out.println("MONSTER NULL?: " + (m == null));
	      
	      System.out.println("Monster location: " + m.location().row() + " " + m.location().col());
	      System.out.println("Explorer location: " + ex.location().row() + " " + ex.location().col());
	      System.out.println(maze.gameStatus());
	      ex.moveTo(mazeSquares[1][1]);
	      
	      System.out.println("Monster location: " + m.location().row() + " " + m.location().col());
	      System.out.println("Explorer location: " + ex.location().row() + " " + ex.location().col());
	      System.out.println(maze.gameStatus());

	      //System.out.println(mazeSquares[2][2].inView());
	}
}

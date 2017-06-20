/**
 * A class that allows the Treasure class to be drawn
 *
 * @author Bradley Ting, Daniel Shu
 * @version 11/4/2016
 */
public class DrawableTreasure extends Treasure implements Drawable{
	public DrawableTreasure(Maze maze){
		super(maze);
	}
	public DrawableTreasure(Maze maze, long seed){
		super(maze, seed);
	}
	public DrawableTreasure(Maze maze, Square location){
		super(maze, location);
	}
	public void draw(){}
}
	
/**
 * A class that allows the Monster class to be drawn
 *
 * @author Bradley Ting, Daniel Shu
 * @version 11/4/2016
 */
public class DrawableMonster extends Monster implements Drawable {
	public DrawableMonster(Maze maze){
		super(maze);
	}
	public DrawableMonster(Maze maze, long seed){
		super(maze, seed);
	}
	public DrawableMonster(Maze maze, Square location){
		super(maze, location);
	}
	public void draw(){}
}

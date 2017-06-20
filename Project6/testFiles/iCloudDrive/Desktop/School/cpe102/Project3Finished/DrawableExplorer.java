/**
 * A class that allows the Maze class to be drawn
 *
 * @author Bradley Ting, Daniel Shu
 * @version 11/4/2016
 */
public class DrawableExplorer extends Explorer implements Drawable{
	public DrawableExplorer(Square location, Maze maze, String name){
		super(location, maze, name);
	}
	public void draw(){}
}

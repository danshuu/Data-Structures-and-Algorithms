/**
 * A class that allows the maze class to be drawn
 *
 * @author Bradley Ting, Daniel Shu
 * @version 11/4/2016
 */
public class DrawableMaze extends Maze implements Drawable{
	public DrawableMaze(DrawableSquare[][] squares, int rows, int cols){
		super(squares, rows, cols);
	}
	public void draw(){}
}

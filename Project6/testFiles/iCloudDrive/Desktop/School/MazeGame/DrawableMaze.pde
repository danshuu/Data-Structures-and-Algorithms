/**
 * A class that allows the maze class to be drawn
 *
 * @author Bradley Ting, Daniel Shu
 * @version 11/4/2016
 */
public class DrawableMaze extends Maze implements Drawable{
	public DrawableMaze(DrawableSquare[][] squares, int rows, int cols) {
		super(squares, rows, cols);
	}
  public void draw(){
    background(150,255,200);
    for (int i = 0; i < super.rows; i++) {
      for (int j = 0; i < super.cols; j++) {
        ((Drawable)getSquare(i,j)).draw();
    }
  }
  
  //for (int i = 0; i < getNumRandOccupants(); i++) {
  //  ((Drawable)getRandomOccupant(i)).draw();
  //}
  
  ((Drawable)getExplorer()).draw();
  
  }
}
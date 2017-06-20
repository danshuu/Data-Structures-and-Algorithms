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

 public void draw()
  {
    background(#00685A);
    for(int i = 0; i < rows(); i++)
    {
      for(int j = 0; j < cols(); j++)
      {
        ((Drawable)getSquare(i,j)).draw();
        //DrawableSquare x = new DrawableSquare(getSquare(i,j).wall(Square.UP),getSquare(i,j).wall(Square.RIGHT),getSquare(i,j).wall(Square.DOWN),getSquare(i,j).wall(Square.LEFT),rows(), cols()); 
      }
    }
    
    for(int i = 0; i < getNumRandOccupants(); i++)
    {
      ((Drawable)getRandomOccupant(i)).draw();
    }
    
    ((Drawable)getExplorer()).draw();
    
  }
  //public void draw(){
  //  background(150,255,200);
  //  for (int i = 0; i < rows(); i++) {
  //    for (int j = 0; i < cols(); j++) {
  //      ((Drawable)getSquare(i,j)).draw();
  //  }
  //}
  
  //for (int i = 0; i < getNumRandOccupants(); i++) {
  //  ((Drawable)getRandomOccupant(i)).draw();
  //}
  
  //((Drawable)getExplorer()).draw();
  
  //}
}
//DrawableMaze.java: Class for drawing maze that implements Drawable interface.


public class DrawableMaze extends Maze implements Drawable {

  public DrawableMaze(Square[][] maze, int rows, int cols)
  {
    super(maze, rows, cols);
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
}
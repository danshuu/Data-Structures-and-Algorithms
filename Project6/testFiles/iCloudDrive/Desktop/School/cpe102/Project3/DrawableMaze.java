public class DrawableMaze extends Maze implements Drawable {

	public DrawableMaze(DrawableSquare[][] maze, int rows, int cols) {
		super(maze, rows, cols);
	}

  public void draw(){
    background(150,255,200);
    for (int i = 0; i < rows(); i++) {
      for (int j = 0; i < cols(); j++) {
        ((Drawable)getSquare(i,j)).draw();
    }
  }
  
  for (int i = 0; i < getNumRandOccupants(); i++) {
    ((Drawable)getRandomOccupant(i)).draw();
  }
  
  ((Drawable)getExplorer()).draw();
  
  }
}
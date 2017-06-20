import java.awt.*;
import javax.swing.*;

/**
 * A class that allows the Square class to be drawn
 *
 * @author Bradley Ting, Daniel Shu
 * @version 11/4/2016
 */

public class DrawableSquare extends Square implements Drawable{
	public DrawableSquare(boolean up, boolean right, boolean down, boolean left, int row, int col){
		super(up, right, down, left, row, col);
	}
	
	public void draw(){
  
  pushMatrix();
  noStroke();
  
  if (super.inView() == true) {
    //draw the area around it, and squares adjacent if inview is true
    //background square SEEN
    fill(255);
    rect(0,0,50,50);
    //walls
    if (wall(Square.UP)==true) {
      fill(100,100,100);
      rect(0,0,50,5);
    }
    if (wall(Square.RIGHT)==true) {
      fill(100,100,100);
      rect(50,0,5,50);
    }
    if (wall(Square.DOWN)==true) {
      fill(100,100,100);
      rect(0,50,50,5);
    }
    if (wall(Square.LEFT)==true) {
      fill(100,100,100);
      rect(0,0,5,50);
    } //end of if
  } // end of first if
  else {
    fill(0);
    rect(0,0,50,50);
  }
  popMatrix();
} //end of method
	
}//end of class
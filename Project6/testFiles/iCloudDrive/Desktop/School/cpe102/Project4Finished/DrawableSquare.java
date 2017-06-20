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
	
	public void draw(){}
	
}

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

	public void draw(){
    pushMatrix();
    noStroke();
    //happy face
    fill(255);
    ellipse(25,25,25,25);
    //eyes
    fill(0);
    ellipse(20,20,2,2);
    ellipse(30,20,2,2);
    //mouth
    fill(255,0,100);
    ellipse(25,32.5,5,5);
    popMatrix();
  }  
}
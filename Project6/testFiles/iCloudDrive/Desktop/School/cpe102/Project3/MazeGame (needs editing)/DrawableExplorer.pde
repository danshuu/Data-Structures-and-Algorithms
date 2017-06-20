import java.awt.*;
import javax.swing.*;
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

  public void draw()
  {
    int xCoord = location().x()+25;
    int yCoord = location().y()+25;
    pushMatrix();
    translate(xCoord, yCoord);
    noStroke();
    
    //PLANKTON
    //body
    fill(#015C65);
    noStroke();
    ellipse(0,0, 15,30);
    stroke(0);
    //antenna
    line(-2, -14,-3, -19);
    line(2, -14,3, -19);
    //arms
    stroke(#015C65);
    line(-8,0, -9, 4);
    line(8, 0, 9, 4);
    
    //legs
    line(-3,14, -3, 19);
    line(3,14, 3, 19);
    
    //eye
    noStroke();    
    fill(#FFF173);
    ellipse(0,-5,8,8);
    fill(#FF0000);
    ellipse(0,-5,3,3);
    
    //smile
    stroke(255);
    noFill();
    arc(0,0,10,5,PI/4, 3*PI/4);
    arc(0,-5,9,20,PI/4, 3*PI/4);
    
    popMatrix();

  }
	//public void draw(){
 //   pushMatrix();
 //   noStroke();
 //   //happy face
 //   fill(255);
 //   ellipse(25,25,25,25);
 //   //eyes
 //   fill(0);
 //   ellipse(20,20,2,2);
 //   ellipse(30,20,2,2);
 //   //mouth
 //   fill(255,0,100);
 //   ellipse(25,32.5,5,5);
 //   popMatrix();
 // }  
}
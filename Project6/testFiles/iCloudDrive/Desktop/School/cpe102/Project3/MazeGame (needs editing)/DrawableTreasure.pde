import java.awt.*;
import javax.swing.*;
/**
 * A class that allows the Treasure class to be drawn
 *
 * @author Bradley Ting, Daniel Shu
 * @version 11/4/2016
 */
public class DrawableTreasure extends Treasure implements Drawable{
	public DrawableTreasure(Maze maze){
		super(maze);
	}
	public DrawableTreasure(Maze maze, long seed){
		super(maze, seed);
	}
	public DrawableTreasure(Maze maze, Square location){
		super(maze, location);
	}

 public void draw()
  {
    
    int xCoord = location().x()+25;
    int yCoord = location().y()+25;
    pushMatrix();
    translate(xCoord, yCoord);
    noStroke();
    if(!found() && location().inView())
    {
      //KRABBY PATTY
      fill(#FF9700);
      noStroke();
      //bread
      arc(0, -5, 25,20,PI, 2*PI, CHORD);
      arc(0, 5, 25,15,0, PI, CHORD);
      fill(255);
      ellipse(-3,-7,2,1);
      ellipse(-7,-11,2,1);
      ellipse(5,-11,2,1);
      ellipse(9,-8,2,1);
      ellipse(0,-12,2,1);
      
      //cheese
      fill(#FFC600);
      rect(-12,-5,24,2);
      //pattys
      fill(#A64500);
      ellipse(0,-2,24,4);
      ellipse(0,5,24,4);
      //lettuce
      fill(#287751);
      ellipse(0,3,24,4);
      //tomato
      fill(#FF0000);
      ellipse(0,1,24,3);
    }
    
    if(found()) {
      //KRABBY PATTY FOUND
      fill(#FF9700);
      noStroke();
      //bread
      arc(0, -5, 25,20,PI, 2*PI, CHORD);
      arc(0, 5, 25,15,0, PI, CHORD);
      fill(255);
      ellipse(-3,-7,2,1);
      ellipse(-7,-11,2,1);
      ellipse(5,-11,2,1);
      ellipse(9,-8,2,1);
      ellipse(0,-12,2,1);
      
      //cheese
      fill(#FFC600);
      rect(-12,-5,24,2);
      //pattys
      fill(#A64500);
      ellipse(0,-2,24,4);
      ellipse(0,5,24,4);
      //lettuce
      fill(#287751);
      ellipse(0,3,24,4);
      //tomato
      fill(#FF0000);
      ellipse(0,1,24,3);
      
      fill(#5DD0C0);
      ellipse(8,-3, 10,8);
      ellipse(10,-10, 10,8);
      ellipse(7,1, 10,8);
      ellipse(9,8, 10,8);
    }
    
      
    popMatrix();
  }
	//public void draw(){
 //   //if treasure is in view and hasnt been found, it will be unopened
 //   if (found() == false && location().inView()) { 
 //     fill(255,204,0);
 //     rect(15,15,25,25);
 //   } //open treasure chest
 //   else if (found() == true) {
 //       fill(255,204,0);
 //       rect(15,15,25,25);
 //       stroke(0);
 //       strokeWeight(2);
 //       line(15,25,39,25);
 //       fill(0);
 //       ellipse(27.5,25,5,5);
 //   }
    
 // }
}
	
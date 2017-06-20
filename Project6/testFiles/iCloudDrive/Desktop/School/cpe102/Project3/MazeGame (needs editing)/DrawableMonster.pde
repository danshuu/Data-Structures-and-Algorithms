import java.awt.*;
import javax.swing.*;
/**
 * A class that allows the Monster class to be drawn
 *
 * @author Bradley Ting, Daniel Shu
 * @version 11/4/2016
 */
public class DrawableMonster extends Monster implements Drawable {
	public DrawableMonster(Maze maze){
		super(maze);
	}
	public DrawableMonster(Maze maze, long seed){
		super(maze, seed);
	}
	public DrawableMonster(Maze maze, Square location){
		super(maze, location);
	}

 public void draw()
  {
  if(location().inView()){  
    int xCoord = location().x()+25;
    int yCoord = location().y()+25;
    pushMatrix();
    translate(xCoord, yCoord);
    noStroke();
    //if(location().inView()){
    //SPONGEBOB MONSTER
    // body
    fill(#FFDA00);
    rect(-11, -20, 22, 28);  
    
    // eyes
    fill(255);
    ellipse(5, -10, 7, 7);  
    ellipse(-5, -10, 7, 7);  
    fill(#FF0000);
    ellipse(5, -10, 2, 2);
    ellipse(-5, -10, 2, 2);
    // smile
    noFill();
    stroke(0);
    arc(0,-9,20,10,PI/3, 2*PI/3);

    // shirt
    noStroke();
    fill(255);
    rect(-11,-2,22,5);
    stroke(0);
    //collar
    triangle(-5,-2,0,-2, -3,0); 
    triangle(5,-2,0,-2, 3,0);
    //tie
    noStroke();
    fill(#FF0000);
    quad(0,-2,-2,1,0,3,2,1);
    
    //pants
    fill(#A65E00);
    rect(-11,3,22,5);
    rect(-8, 8,6,3);
    rect(3,8,6,3);
    
    //sleeves
    fill(255);
    arc(-11, -3, 5, 5, PI, 3*PI/2, PIE);
    arc(11,-3,5,5,3*PI/2, 2*PI, PIE);
    //arms   
    stroke(#FFDA00);
    fill(#FFDA00);
    line(-13, -3, -15, 2);
    line(12,-3, 14, 2);
    //legs
    line(-5, 11, -5, 12);   
    line(6, 11, 6, 12);   
    //socks
    stroke(255);
    line(-5,13,-5,14);
    line(6,13,6,14);
    stroke(#FF0000);
    line(6,15,6,15);
    line(-5,15,-5,15);   
    stroke(255);
    line(-5,16,-5,17);
    line(6,16,6,17);   
    
    //shoes
    stroke(0);
    fill(0);
    rect(-6,18, 2,2);
    rect(5,18,2,2);
    //}  
    popMatrix();
  
  }
  }
	//public void draw(){
 //   if(location().inView()) {
 //     pushMatrix();
 //     noStroke();
 //     //dark minion
 //     //head
 //     fill(120,100,206);
 //     ellipse(27.5,27.5,25,35);
 //     //eyes
 //     fill(0);
 //     ellipse(22.5,20,8,12);
 //     fill(0);
 //     ellipse(32.5,20,8,12);
 //     //pupils
 //     fill(255);
 //     ellipse(22.5,20,3,5);
 //     fill(255);
 //     ellipse(32.5,20,3,5);
        
 //     //mouth
 //     fill(0);
 //     ellipse(27.5,32.5,7.5,15);
        
 //     //teeth
 //     fill(255);
 //     triangle(24,30,27,24,26,30);
 //     triangle(30.5,30,28.5,24,28,30);    
 //     popMatrix();
 //   }
}
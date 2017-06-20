//DrawableSquare.java: Class for drawing square that implements Drawable interface.

public class DrawableSquare extends Square implements Drawable {

  public DrawableSquare(boolean up, boolean right, boolean down, boolean left, int row, int col)
  {
    super(up, right, down, left, row, col);
  }
  
  public void draw()
  {
      int xCoord = x()+25;
      int yCoord = y()+25;
      pushMatrix();
      noStroke();
      translate(xCoord, yCoord);
    
    if(super.inView() == true)
    {
      //draw
      
      //sqaure background SEEN
      fill(#5DD0C0);
      rect(-25,-25,50,50);
      fill(#33CCCC);
      ellipse(-15,-10, 7,8);
      ellipse(-2, -7, 6,6);
      ellipse(5, 8, 7,8);
      ellipse(13, -9, 6,6);
      ellipse(-11,10,5,5);
      ellipse(15, 15, 4,4);
      fill(255);
      ellipse(-15,-10, 2,3);
      ellipse(-2, -7, 2,2);
      ellipse(5, 8, 2,3);
      ellipse(13, -9, 2,2);
      ellipse(-11,10,2,2);
      ellipse(15, 15, 2,2);
      
      
      //walls
      if(wall(Square.UP))
      {
        //seaweed N
        fill(#14D100);
        rect(-25,-25,50,5);
        ellipse(-20,-21,10,5);
        ellipse(-10,-21,10,5);
        ellipse(0,-21,10,5);
        ellipse(10,-21,10,5);
        ellipse(20,-21,10,5);
        noFill();
        stroke(0);
        arc(-20,-36,25,25,radians(70), radians(110));
        arc(0,-36,25,25,radians(70), radians(110));
        arc(20,-36,25,25,radians(70), radians(110));
        fill(#007733);
        noStroke();
        ellipse(-20,-22,3,3);
        ellipse(-10,-22,3,3);
        ellipse(0,-22,3,3);
        ellipse(10,-22,3,3);
        ellipse(20,-22,3,3);    
      }
      if(wall(Square.RIGHT))
      {
        //seaweed E
        fill(#14D100);
        rect(22,-20,3,40);
        ellipse(22,-20,5,10);
        ellipse(22,-10,5,10);
        ellipse(22,0,5,10);
        ellipse(22,10,5,10);
        ellipse(22,20,5,10);
        noFill();
        stroke(0);
        arc(33,-10 ,20,20,radians(180), radians(210));
        arc(33,5,20,20,radians(180), radians(210));
        arc(33,20,20,20,radians(180), radians(210));
        fill(#007733);
        noStroke();
        ellipse(23,-20,3,3);
        ellipse(23,-10,3,3);
        ellipse(23,0,3,3);
        ellipse(23,10,3,3);
        ellipse(23,20,3,3);
      }
      if(wall(Square.DOWN))
      {
        //seaweed S
        fill(#14D100);
        rect(-25,20,50,5);
        ellipse(-20,21,10,5);
        ellipse(-10,21,10,5);
        ellipse(0,21,10,5);
        ellipse(10,21,10,5);
        ellipse(20,21,10,5);
        noFill();
        stroke(0);
        arc(-10,36,25,25,radians(250), radians(290));
        arc(10,36,25,25,radians(250), radians(290));
        fill(#007733);
        noStroke();
        ellipse(-20,22,3,3);
        ellipse(-10,22,3,3);
        ellipse(0,22,3,3);
        ellipse(10,22,3,3);
        ellipse(20,22,3,3); 
      }
      if(wall(Square.LEFT))
      {
        //seaweed W
        fill(#14D100);
        rect(-25,-20,3,40);
        ellipse(-22,-20,5,10);
        ellipse(-22,-10,5,10);
        ellipse(-22,0,5,10);
        ellipse(-22,10,5,10);
        ellipse(-22,20,5,10);
        noFill();
        stroke(0);
        arc(-33,-15 ,20,20,radians(0), radians(30));
        arc(-33,0,20,20,radians(0), radians(30));
        arc(-33,15,20,20,radians(0), radians(30));
        fill(#007733);
        noStroke();
        ellipse(-23,-20,3,3);
        ellipse(-23,-10,3,3);
        ellipse(-23,0,3,3);
        ellipse(-23,10,3,3);
        ellipse(-23,20,3,3);  
      }
    }
    else if(super.seen() == true)
    {

      
      //sqaure background 2
      fill(#00685A);
      rect(-25,-25,50,50);
      fill(#33CCCC);
      ellipse(-15,-10, 7,8);
      ellipse(-2, -7, 6,6);
      ellipse(5, 8, 7,8);
      ellipse(13, -9, 6,6);
      ellipse(-11,10,5,5);
      ellipse(15, 15, 4,4);
      fill(255);
      ellipse(-15,-10, 2,3);
      ellipse(-2, -7, 2,2);
      ellipse(5, 8, 2,3);
      ellipse(13, -9, 2,2);
      ellipse(-11,10,2,2);
      ellipse(15, 15, 2,2);
      
      
      //walls
      if(wall(Square.UP))
      {
        //seaweed N
        fill(#14D100);
        rect(-25,-25,50,5);
        ellipse(-20,-21,10,5);
        ellipse(-10,-21,10,5);
        ellipse(0,-21,10,5);
        ellipse(10,-21,10,5);
        ellipse(20,-21,10,5);
        noFill();
        stroke(0);
        arc(-20,-36,25,25,radians(70), radians(110));
        arc(0,-36,25,25,radians(70), radians(110));
        arc(20,-36,25,25,radians(70), radians(110));
        fill(#007733);
        noStroke();
        ellipse(-20,-22,3,3);
        ellipse(-10,-22,3,3);
        ellipse(0,-22,3,3);
        ellipse(10,-22,3,3);
        ellipse(20,-22,3,3);    
      }
      if(wall(Square.RIGHT))
      {
        //seaweed E
        fill(#14D100);
        rect(22,-20,3,40);
        ellipse(22,-20,5,10);
        ellipse(22,-10,5,10);
        ellipse(22,0,5,10);
        ellipse(22,10,5,10);
        ellipse(22,20,5,10);
        noFill();
        stroke(0);
        arc(33,-10 ,20,20,radians(180), radians(210));
        arc(33,5,20,20,radians(180), radians(210));
        arc(33,20,20,20,radians(180), radians(210));
        fill(#007733);
        noStroke();
        ellipse(23,-20,3,3);
        ellipse(23,-10,3,3);
        ellipse(23,0,3,3);
        ellipse(23,10,3,3);
        ellipse(23,20,3,3);
      }
      if(wall(Square.DOWN))
      {
        //seaweed S
        fill(#14D100);
        rect(-25,20,50,5);
        ellipse(-20,21,10,5);
        ellipse(-10,21,10,5);
        ellipse(0,21,10,5);
        ellipse(10,21,10,5);
        ellipse(20,21,10,5);
        noFill();
        stroke(0);
        arc(-10,36,25,25,radians(250), radians(290));
        arc(10,36,25,25,radians(250), radians(290));
        fill(#007733);
        noStroke();
        ellipse(-20,22,3,3);
        ellipse(-10,22,3,3);
        ellipse(0,22,3,3);
        ellipse(10,22,3,3);
        ellipse(20,22,3,3); 
      }
      if(wall(Square.LEFT))
      {
        //seaweed W
        fill(#14D100);
        rect(-25,-20,3,40);
        ellipse(-22,-20,5,10);
        ellipse(-22,-10,5,10);
        ellipse(-22,0,5,10);
        ellipse(-22,10,5,10);
        ellipse(-22,20,5,10);
        noFill();
        stroke(0);
        arc(-33,-15 ,20,20,radians(0), radians(30));
        arc(-33,0,20,20,radians(0), radians(30));
        arc(-33,15,20,20,radians(0), radians(30));
        fill(#007733);
        noStroke();
        ellipse(-23,-20,3,3);
        ellipse(-23,-10,3,3);
        ellipse(-23,0,3,3);
        ellipse(-23,10,3,3);
        ellipse(-23,20,3,3);  
      }

    
    }
      popMatrix();
  }
}
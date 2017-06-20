

class Monster{
  //instance vars
  private PVector direction;
  private double x;
  private double y;
  //constructor
  public Monster(double x, double y){
  this.x = x;
  this.y = y;
  this.direction = new PVector(0,0);
  }

    public void draw(){
 pushMatrix();
 translate((int)x, (int)y);

 noStroke();

 // head
 fill(119, 87, 87);
 ellipse(0, -10, 25, 25);

 
 //bottom face
 fill(185,0,0);
 ellipse(0, -10, 20, 18);
 
 //top face
 fill(4,0,0);
 ellipse(0, -17, 20, 10);
 
 //EYES
 fill(0);
 ellipse(-2, -10, 2, 2);
 ellipse(2, -10, 2, 2);

 // muzzle / jowels/ bottom face
 fill(119,87,87);
 ellipse(0, -3, 22, 10);
 fill(119, 87, 87);
 rect(-7, 0, 14, 13);
 ellipse(0, 10, 20, 10);
 fill(119, 87, 87);
 ellipse(-10, 5, 7, 15);
 ellipse(10, 5, 7, 15);

 // nose
 fill(0);
 ellipse(0, -6, 8, 5);



 // ears
 fill(86.7,0,0);
 ellipse(-10, -20, 6, -10);
 ellipse(10, -20, 6, -10);
 
 triangle(-7,-18,-13,-18,-10,-30);
 triangle(7,-18,13,-18,10,-30);
 popMatrix();
  }
  public double getX(){return this.x;}
  public double getY(){return this.y;}
  public void move(){
    this.x += direction.x;
    this.y += direction.y;
  }
  public void setVector(PVector direction){
    this.direction = direction;
  }



}//class
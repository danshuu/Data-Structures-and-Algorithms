public class Monster {
  private PVector direction;
  private double x;
  private double y;
  
  public Monster(double x, double y) {
    this.x = x;
    this.y = y;
    this.direction = new PVector(0,0);
  }


  public void draw() {           
    pushMatrix();
    translate((int)x, (int)y);
    
    noStroke();           
    
    // head        
    fill(120);        
    ellipse(0, -10, 25, 25);                 
    // eyes        
    fill(255);        
    ellipse(0, -10, 20, 18);        
    fill(120);        
    ellipse(0, -17, 20, 10);        
    fill(0);        
    ellipse(-2, -10, 2, 2);        
    ellipse(2, -10, 2, 2); 
    
    // muzzle / jowels        
    fill(180);        
    ellipse(0, -3, 22, 10);        
    fill(120);        
    rect(-7, 0, 14, 13);        
    ellipse(0, 10, 20, 10);        
    fill(180);        
    ellipse(-10, 5, 7, 15);        
    ellipse(10, 5, 7, 15);    
    
    // nose        
    fill(0);        
    ellipse(0, -6, 8, 5);  
    
    // teeth        
    fill(255);        
    triangle(-7, 0, -5, -5, -3, 0);        
    triangle(7, 0, 5, -5, 3, 0); 
    
    // ears        
    fill(120);        
    ellipse(-10, -20, 6, 3);        
    ellipse(10, -20, 6, 3);                 
    popMatrix();    
  }
  
  public double getX() {
    return x;
  }
  
  public double getY() {
    return y;
  }
  
  public void move() {
    x = x + direction.mag()*cos(direction.heading());
    y = y + direction.mag()*sin(direction.heading());
  }
  
  //setDirection
  public void setVector(PVector direction) {
    this.direction = direction;
  }
    
}
public class DrawableMonster extends Monster implements Drawable {
	
	public DrawableMonster(Maze maze) {
		super(maze);
	}

	public DrawableMonster(Maze maze, long seed) {
		super(maze,seed);
	}

	public DrawableMonster(Maze maze, Square location) {
		super(maze,location);
	}

	public void draw(){
    // if(location().inView()) {
    //   pushMatrix();
    //   noStroke();
    //   //dark minion
    //   //head
    //   fill(120,100,206);
    //   ellipse(27.5,27.5,25,35);
    //   //eyes
    //   fill(0);
    //   ellipse(22.5,20,8,12);
    //   fill(0);
    //   ellipse(32.5,20,8,12);
    //   //pupils
    //   fill(255);
    //   ellipse(22.5,20,3,5);
    //   fill(255);
    //   ellipse(32.5,20,3,5);
        
    //   //mouth
    //   fill(0);
    //   ellipse(27.5,32.5,7.5,15);
        
    //   //teeth
    //   fill(255);
    //   triangle(24,30,27,24,26,30);
    //   triangle(30.5,30,28.5,24,28,30);    
    //   popMatrix();
    }
}
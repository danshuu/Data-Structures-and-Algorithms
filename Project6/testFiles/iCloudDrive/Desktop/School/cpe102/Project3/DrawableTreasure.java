public class DrawableTreasure extends Treasure implements Drawable {
	
	public DrawableTreasure(Maze maze) {
		super(maze);
	}

	public DrawableTreasure(Maze maze, long seed) {
		super(maze, seed);
	}

	public DrawableTreasure(Maze maze, Square location) {
		super(maze, location);
	}

	public void draw(){
    //if treasure is in view and hasnt been found, it will be unopened
    if (found() == false && location().inView()) { 
      fill(255,204,0);
      rect(15,15,25,25);
    } //open treasure chest
    else if (found() == true) {
        fill(255,204,0);
        rect(15,15,25,25);
        stroke(0);
        strokeWeight(2);
        line(15,25,39,25);
        fill(0);
        ellipse(27.5,25,5,5);
    } else {
    	fill(0);
		rect(0,0,50,50);
	}
    
    
  }
}
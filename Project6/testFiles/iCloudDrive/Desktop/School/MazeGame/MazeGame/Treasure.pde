// Treasure.java: Class for controlling the treasures inside of the maze. 


public class Treasure extends RandomOccupant {

  private boolean found = false;
  
  public Treasure(Maze maze)
  {
    super(maze);
    super.location().setTreasure(this);
  }
  public Treasure(Maze maze, long seed)
  {
    super(maze, seed);
    super.location().setTreasure(this);
  }
  public Treasure(Maze maze, Square location)
  {
    super(maze, location);
    super.location().setTreasure(this);
  } 
  public boolean found()
  {
    return found;
  }
  public void setFound()
  {
    found = true;
  }
  public void move()
  {
    
  }
}
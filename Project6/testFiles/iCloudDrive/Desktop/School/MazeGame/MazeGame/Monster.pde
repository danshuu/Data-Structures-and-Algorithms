//Monster.java: Class for controlling monsters inside of the maze. 


public class Monster extends RandomOccupant {
  
  public Monster(Maze maze)
  {
    super(maze);
  }
  
  public Monster(Maze maze, long seed)
  {
    super(maze, seed);
    
  }
  public Monster(Maze maze, Square location)
  {
    super(maze, location);
  }
  
  
  
}
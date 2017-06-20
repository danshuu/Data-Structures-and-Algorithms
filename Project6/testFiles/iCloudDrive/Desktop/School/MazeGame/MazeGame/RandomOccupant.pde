// RandomOccupant: Class for controlling the randomly operated Occupants (monster, treasure).


import java.util.Random;

public abstract class RandomOccupant extends Occupant {

  private Random r;
  private Maze maze;
  
  public RandomOccupant(Maze maze)
  {
    super();
    r = new Random();
    super.moveTo(maze.getSquare(r.nextInt(maze.rows()),r.nextInt(maze.cols())));
    //super(maze.getSquare(r.nextInt(maze.rows()),r.nextInt(maze.cols())));
    this.maze = maze;
  }
  public RandomOccupant(Maze maze, long seed)
  {
    super();
    r = new Random(seed);
    int x, y;
    x = r.nextInt(maze.rows());
    y = r.nextInt(maze.cols());
    //System.out.println("x: " + x + ", y: " + y);
    super.moveTo(maze.getSquare(x,y));
    this.maze = maze;
  }
  public RandomOccupant(Maze maze, Square location)
  {
    super(location);
    r = new Random();  
    this.maze = maze;
  }
  
  public void move()
  {
    int x = r.nextInt(4);
    while(super.location().wall(x)) {
      x = r.nextInt(4);
    }
    //System.out.println("rolled direction: " + x);
    if (x == Square.UP)
    {
      if(super.location().row()-1 >= 0)
      {  
        super.moveTo(maze.getSquare(super.location().row()-1, super.location().col()));
      }
    }
    if (x == Square.RIGHT)
    {
      if(super.location().col()+1 <= maze.cols())
      {
        super.moveTo(maze.getSquare(super.location().row(), super.location().col()+1));
      }
    }
    if (x == Square.DOWN)
    {
      if(super.location().row()+1 <= maze.rows())
      {
        super.moveTo(maze.getSquare(super.location().row()+1, super.location().col()));
      }
    }
    if (x == Square.LEFT)
    {
      if(super.location().col()-1 >= 0) 
      {
        super.moveTo(maze.getSquare(super.location().row(), super.location().col()-1));
      }
    }
      
    

  }
  
}
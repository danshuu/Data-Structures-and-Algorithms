//Explorer.java: Class for controlling the Explorer.


import java.awt.event.KeyEvent;

public class Explorer extends Occupant {
  
  private String name;
  private Maze maze;
  
  public Explorer(Square location, Maze maze, String name)
  {
    super(location);
    this.name = name;
    this.maze = maze;
    maze.lookAround(location);
  }
  public String name()
  {
    return name;
  }
  public void move(int key)
  {
    //maze.getSquare(super.location().getRow(), super.location().getColumn());

    if(KeyEvent.VK_UP == key || KeyEvent.VK_KP_UP == key)
    {
      if(!super.location().wall(Square.UP))
      {
        if(super.location().row()-1 >= 0)
        {
          moveTo(maze.getSquare(super.location().row()-1, super.location().col()));
        }
      }
    }
    if(KeyEvent.VK_RIGHT == key || KeyEvent.VK_KP_RIGHT == key)
    {
      if(!super.location().wall(Square.RIGHT))
      {
        if(super.location().col()+1 <= maze.cols())
        {
          moveTo(maze.getSquare(super.location().row(), super.location().col()+1));
        }
      }
    }
    if(KeyEvent.VK_DOWN == key || KeyEvent.VK_KP_DOWN == key)
    {
      if(!super.location().wall(Square.DOWN))
      {
        if(super.location().row()+1 <= maze.rows())
        {
          moveTo(maze.getSquare(super.location().row()+1, super.location().col()));
        }
      }
    }
    if(KeyEvent.VK_LEFT == key || KeyEvent.VK_KP_LEFT == key)
    {
      if(!super.location().wall(Square.LEFT))
      {
        if(super.location().col()-1 >= 0)
        {
          moveTo(maze.getSquare(super.location().row(), super.location().col()-1));
        }
      }
    }
    
    
    
  }
  public void moveTo(Square s) 
  {
    super.moveTo(s);
    s.enter();
    maze.lookAround(s);
  }

}
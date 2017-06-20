//Maze.java: Class for controlling the maze, including objects inside the maze as well as the status.


import java.util.*;
/**
 * Class that contains all the logic to model a Maze with Treasures, Monsters, and an Explorer.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Maze
{
   // named constants
   public static final int ACTIVE = 0;
   public static final int EXPLORER_WIN = 1;
   public static final int MONSTER_WIN = 2;
    
    // instance variables
   private Square[][] maze;
   private ArrayList<RandomOccupant> randOccupants;
   private Explorer explorer;
   private int rows;
   private int cols;

   /**
    * Constructor for objects of class Maze
    */
   public Maze(Square[][] maze, int rows, int cols)
   {
      // doneCHANGE - initialize the maze, rows, and cols instance variables
     this.maze = maze;
     this.rows = rows;
     this.cols = cols;
      // doneCHANGE - create the empty ArrayList of RandomOccupants
     randOccupants = new ArrayList<RandomOccupant>();
   }
  
   // QUERIES
   public Square getSquare(int row, int col) { return maze[row][col]; }
   public int rows() {return rows;}
   public int cols() {return cols;}
   public String explorerName() {return explorer.name();}
   public Explorer getExplorer() {return explorer;}
    
   // done?CHANGE - Implement the following two methods.  I have them stubbed to return dummy values just so it will compile.
   //          Your getRandomOccupant should return the occupant from the ArrayList at the specified index.
   public RandomOccupant getRandomOccupant(int index) 
   {
     return randOccupants.get(index);
   }
   public int getNumRandOccupants() 
   {
     return randOccupants.size();
   }
  
   // COMMANDS
   // doneCHANGE - implement the following method
   public void addRandomOccupant(RandomOccupant ro) {randOccupants.add(ro);}
    
   public void setExplorer(Explorer e) {explorer = e;}
  
   public void explorerMove(int key)
   {
      explorer.move(key);
   }
  
   public void randMove()
   {
     // doneCHANGE - instruct each object in the RandomOccupant to move
     for(int i = 0; i < randOccupants.size(); i++)
      {
        randOccupants.get(i).move();
      }
   }
  
   /**
    * Returns the status of the game.
    *
    * If all treasures have been found, return EXPLORER_WIN.
    * If not, check each maze occupant, if it is a Monster and
    *   it is in the same location as the Explorer, return
    *   MONSTER_WIN.  Note that you can use == to check locations, do you know why?
    * Otherwise, return ACTIVE.
    */
   public int gameStatus()
   {
      int status = ACTIVE;
        
      if(foundAllTreasures())
      {
        status = EXPLORER_WIN;
      }
      
      for(int i = 0; i < randOccupants.size(); i++) 
      {
        if(((Occupant)explorer).location() == randOccupants.get(i).location() && randOccupants.get(i) instanceof Monster)
        {
          status = MONSTER_WIN;
        }
      }
      
      return status;
   }
  
   private boolean foundAllTreasures()
   {
      boolean foundAll = true;
        
      // doneCHANGE - search through all the occupants to see if the Treasures have been found.  Return false if
      //        - there is a Treasure that hasn't been found.
      
      for(int i = 0; i < randOccupants.size(); i++)
      {
        if(randOccupants.get(i) instanceof Treasure)
        {
          if(((Treasure)randOccupants.get(i)).found() == false)
          {
            return false;
          }
        }
      }
      
      return foundAll;
   }
    
   public void lookAround(Square s)
   {
      int row = s.row();
      int col = s.col();
        
      // Clear what was previously in view
      resetInView();
        
      // Set the current square so that we are viewing it (obviously)
      s.setInView(true);
        
      // doneCHANGE - Check the adjacent squares.  If there isn't a wall in the way, set their inview to true.
      //        - Check the diagonal squares.  If there isn't a wall in the way, set their inview to true.
      if(!s.wall(Square.UP))
      {
        //System.out.println("About to SetInView(true)");
        
        getSquare(row-1, col).setInView(true);
        if(!getSquare(row-1, col).wall(Square.RIGHT))
        {
          getSquare(row-1,col+1).setInView(true);
        }
        if(!getSquare(row-1, col).wall(Square.LEFT))
        {
          getSquare(row-1,col-1).setInView(true);
        }
      }
      if(!s.wall(Square.RIGHT))
      {
        //System.out.println("About to SetInView(true)");
        getSquare(row, col+1).setInView(true);
        if(!getSquare(row, col+1).wall(Square.UP))
        {
          getSquare(row-1,col+1).setInView(true);
        }
        if(!getSquare(row, col+1).wall(Square.DOWN))
        {
          getSquare(row+1,col+1).setInView(true);
        }
  
      }
      if(!s.wall(Square.DOWN))
      {
        //System.out.println("About to SetInView(true)");
        getSquare(row+1, col).setInView(true);
        if(!getSquare(row+1, col).wall(Square.RIGHT))
        {
          getSquare(row+1,col+1).setInView(true);
        }
        if(!getSquare(row+1, col).wall(Square.LEFT))
        {
          getSquare(row+1,col-1).setInView(true);
        }
      }
      if(!s.wall(Square.LEFT))
      {
        //System.out.println("About to SetInView(true)");
        getSquare(row, col-1).setInView(true);
        if(!getSquare(row, col-1).wall(Square.UP))
        {
          getSquare(row-1,col-1).setInView(true);
        }
        if(!getSquare(row, col-1).wall(Square.DOWN))
        {
          getSquare(row+1,col-1).setInView(true);
        }
      }
      

   }
    
   private void resetInView()
   {
      for (int i = 0; i<rows; i++) {
         for (int j = 0; j<cols; j++) {
            maze[i][j].setInView(false);
         }
      }
   }
}
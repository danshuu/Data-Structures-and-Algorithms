import java.util.*;
/**
 * Class that contains all the logic to model a Maze with Treasures, Monsters, and an Explorer.
 *
 * @author Jesse Bao
 * @author CPE102-13
 * @version 4-29-16
 */
public class Maze
{
   // named constants
   public static final int ACTIVE = 0;
   public static final int EXPLORER_WIN = 1;
   public static final int MONSTER_WIN = 2;

    // instance variables
   private Square[][] squares;
   private ArrayList<RandomOccupant> randOccupants;
   private Explorer explorer;
   private int rows;
   private int cols;

   /**
    * Constructor for objects of class Maze
    */
   public Maze(Square[][] squares, int rows, int cols)
   {
     this.squares = squares;
     this.rows = rows;
     this.cols = cols;
     randOccupants = new ArrayList<RandomOccupant>();
      // initialize the squares, rows, and cols instance variables to
      //          what is passed in to the constructor

      // create the empty ArrayList of RandomOccupants
   }

   // QUERIES
   public Square getSquare(int row, int col) { return squares[row][col]; }
   public int rows() {return rows;}
   public int cols() {return cols;}
   public String explorerName() {return explorer.name();}
   public Explorer getExplorer() {return explorer;}

   // Implement the following two methods.  I have them stubbed to return dummy values just so it will compile.
   //          Your getRandomOccupant should return the occupant from the ArrayList at the specified index.
   public RandomOccupant getRandomOccupant(int index) {
      return randOccupants.get(index);
   }
   public int getNumRandOccupants() {
      return randOccupants.size();
   }

   // COMMANDS
   // implement the following method
   public void addRandomOccupant(RandomOccupant ro) {
      randOccupants.add(ro);
   }

   public void setExplorer(Explorer e) {explorer = e;}

   public void explorerMove(int key)
   {
      explorer.move(key);
   }

   public void randMove()
   {
     for(RandomOccupant r : randOccupants) {
       r.move();
     }
      //instruct each object in the RandomOccupant to move
   }

   /**
    * Returns the status of the game.
    *
    * If all treasures have been found, return EXPLORER_WIN.
    * If not, check each maze occupant, if it is a Monster and
    *    it is in the same location as the Explorer, return
    *    MONSTER_WIN.  Note that you can use == to check locations, do you know why?
    * Otherwise, return ACTIVE.
    */
   public int gameStatus()
   {
      int status = ACTIVE;
      if(foundAllTreasures()) {
        status = EXPLORER_WIN;
      }
      for(RandomOccupant r : randOccupants) {
        if (r instanceof Monster && r.location() == explorer.location()) {
          status = MONSTER_WIN;
        }
      }
      return status;
   }

   private boolean foundAllTreasures()
   {
      boolean foundAll = true;
      for(RandomOccupant r : randOccupants) {
        if(r instanceof Treasure && !((Treasure)r).found()) {
          foundAll = false;
        }
      }

      // search through all the occupants to see if the Treasures have been found.  Return false if
      //        - there is a Treasure that hasn't been found.

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
      if(!s.wall(Square.UP)) {
        squares[row-1][col].setInView(true);
      }
      if(!s.wall(Square.RIGHT)) {
        squares[row][col+1].setInView(true);
      }
      if(!s.wall(Square.DOWN)) {
        squares[row+1][col].setInView(true);
      }
      if(!s.wall(Square.LEFT)) {
        squares[row][col-1].setInView(true);
      }
      //TOP RIGHT
      if((!s.wall(Square.UP) && !squares[row-1][col].wall(Square.RIGHT))
          || (!s.wall(Square.RIGHT) && !squares[row][col+1].wall(Square.UP))) {
        squares[row-1][col+1].setInView(true);
      }
      //TOP LEFT
      if((!s.wall(Square.UP) && !squares[row-1][col].wall(Square.LEFT))
          || (!s.wall(Square.LEFT) && !squares[row][col-1].wall(Square.UP))) {
        squares[row-1][col-1].setInView(true);
      }
      //BOTTOM RIGHT
      if((!s.wall(Square.DOWN) && !squares[row+1][col].wall(Square.RIGHT))
          || (!s.wall(Square.RIGHT) && !squares[row][col+1].wall(Square.DOWN))) {
        squares[row+1][col+1].setInView(true);
      }
      //BOTTOM LEFT
      if((!s.wall(Square.DOWN) && !squares[row+1][col].wall(Square.LEFT))
          || (!s.wall(Square.LEFT) && !squares[row][col-1].wall(Square.DOWN))) {
        squares[row+1][col-1].setInView(true);
      }
   }

   private void resetInView()
   {
      for (int i = 0; i<rows; i++) {
         for (int j = 0; j<cols; j++) {
            squares[i][j].setInView(false);
         }
      }
   }
}
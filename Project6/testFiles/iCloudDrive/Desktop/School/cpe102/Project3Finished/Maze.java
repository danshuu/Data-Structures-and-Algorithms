import java.util.*;
/**
 * Class that contains all the logic to model a Maze with Treasures, Monsters, and an Explorer.
 * 
 * @author Bradley Ting, Daniel Shu
 * @version 11/4/2016
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
		
   }
	
   // QUERIES
   public Square getSquare(int row, int col) { return squares[row][col]; }
   public int rows() {return rows;}
   public int cols() {return cols;}
   public String explorerName() {return explorer.name();}
   public Explorer getExplorer() {return explorer;}
    
   //
   //Your getRandomOccupant should return the occupant from the ArrayList at the specified index.
   public RandomOccupant getRandomOccupant(int index) {return randOccupants.get(index);}
   public int getNumRandOccupants() {return randOccupants.size();}
	
   // COMMANDS
   //implement the following method
   public void addRandomOccupant(RandomOccupant ro) {randOccupants.add(ro);}
	
   public void setExplorer(Explorer e) {explorer = e;}
	
   public void explorerMove(int key)
   {
      explorer.move(key);
   }
	
   public void randMove()
   {
      for(RandomOccupant r: randOccupants){
    	  r.move();
      }
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
      if(foundAllTreasures()){
    	  status = EXPLORER_WIN;
      }
      for(RandomOccupant r: randOccupants){
    	  if(r instanceof Monster){
    		  if(r.location() == explorer.location()){
    			  status = MONSTER_WIN;
    			  break;
    		  }
    			  
    	  }
      }
      
        
      return status;
   }
	
   private boolean foundAllTreasures()
   {
      boolean foundAll = true;
        
      //search through all the occupants to see if the Treasures have been found.  Return false if
      //there is a Treasure that hasn't been found.
      ArrayList<Treasure> treasures = new ArrayList<Treasure>();
      
      for(RandomOccupant r: randOccupants){
    	  if(r instanceof Treasure)
			treasures.add((Treasure) r);
    	  
      for(Treasure t: treasures){
    	  if(!t.found())
    		  foundAll = false;
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
        
      
      //Check the adjacent squares.  If there isn't a wall in the way, set their inview to true.
     
		if(!s.wall(s.UP)) {getSquare(row - 1, col).setInView(true);}
		if(!s.wall(s.RIGHT)) {getSquare(row, col + 1).setInView(true);}
		if(!s.wall(s.DOWN)) {getSquare(row + 1, col).setInView(true);}
		if(!s.wall(s.LEFT)) {getSquare(row, col - 1).setInView(true);}
		
	  //check diagonal squares
        if(row > 0 && col > 0){
        	Square up_left = getSquare(row - 1, col - 1);
        	if((!up_left.wall(up_left.RIGHT) && !s.wall(s.UP)) || (!up_left.wall(up_left.DOWN) && !s.wall(s.LEFT))) {up_left.setInView(true);}
        }
        if(row > 0 && col < (this.cols-1)){
        	Square up_right = getSquare(row - 1, col + 1);
        	if((!up_right.wall(up_right.LEFT) && !s.wall(s.UP)) || (!up_right.wall(up_right.DOWN) && !s.wall(s.RIGHT))) {up_right.setInView(true);}
        }
        if(row < (this.rows-1) && col > 0){
        	Square down_left = getSquare(row + 1, col - 1);
        	if((!down_left.wall(down_left.RIGHT) && !s.wall(s.DOWN)) || (!down_left.wall(down_left.UP) && !s.wall(s.LEFT))) {down_left.setInView(true);}
        }
        if(row < (this.rows-1) && col < (this.cols-1)){
        	Square down_right = getSquare(row + 1, col + 1);
        	if((!down_right.wall(down_right.LEFT) && !s.wall(s.DOWN)) || (!down_right.wall(down_right.UP) && !s.wall(s.RIGHT))) {down_right.setInView(true);}
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

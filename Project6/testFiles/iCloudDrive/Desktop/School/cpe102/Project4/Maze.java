import java.util.*;
import java.io.*;
/**
 * Class that contains all the logic to model a Maze with Treasures, Monsters, and an Explorer.
 * 
 * Project 4 - modification of Project 3
 * @author Daniel Shu
 * @version 11/4/16
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
   //default constructor
   public Maze() {
   	randOccupants = new ArrayList<RandomOccupant>();
   }
   
   public Maze(Square[][] squares, int rows, int cols)
   {
      // initialize the squares, rows, and cols instance variables to
      // what is passed in to the constructor
    this.squares = squares;
    this.rows = rows;
    this.cols = cols;
      // create the empty ArrayList of RandomOccupants
    randOccupants = new ArrayList<RandomOccupant>();
   }
	
   // QUERIES
   public Square getSquare(int row, int col) { return squares[row][col]; }
   public int rows() {return rows;}
   public int cols() {return cols;}
   public String explorerName() {return explorer.name();}
   public Explorer getExplorer() {return explorer;}
    
   // Implement the following two methods.  I have them stubbed to return dummy values just so it will compile.
   // Your getRandomOccupant should return the occupant from the ArrayList at the specified index.
   public RandomOccupant getRandomOccupant(int index) {return randOccupants.get(index);}
   public int getNumRandOccupants() {return randOccupants.size();}
	
   // COMMANDS
   public void addRandomOccupant(RandomOccupant ro) {randOccupants.add(ro);}
	
   public void setExplorer(Explorer e) {explorer = e;}
	
   public void explorerMove(int key)
   {
      explorer.move(key);
   }
	
   public void randMove()
   {
      // instruct each object in the RandomOccupant to move
    for (int i = 0; i < randOccupants.size(); i++) {
      randOccupants.get(i).move();
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
      if (foundAllTreasures()) {
        status = EXPLORER_WIN;
      } 

      for (int i = 0; i < randOccupants.size(); i++) {
        if (explorer.location() == randOccupants.get(i).location()) {
          status = MONSTER_WIN;
          break;
        }
      }
      return status;
   }
	
   private boolean foundAllTreasures()
   {
      boolean foundAll = true;

      ArrayList<Treasure> treasures = new ArrayList<Treasure>();
        
      // search through all the occupants to see if the Treasures have been found.  Return false if
      // there is a Treasure that hasn't been found.
      for (RandomOccupant r: randOccupants) {
        if (r instanceof Treasure) {
          treasures.add((Treasure) r);
        }

      for (Treasure t: treasures) {
          if (t.found() == false) {
            foundAll = false;
          }
        }
      }
      return foundAll;
   }
    
   public void lookAround(Square s)
   {
    //s is a square
      int row = s.row();
      int col = s.col();
        
      // Clear what was previously in view
      resetInView();
        
      // Set the current square so that we are viewing it (obviously)
      s.setInView(true);
        
      // Check the adjacent squares. If there isn't a wall in the way, set their inview to true.
      //check diagonal squares. If there isn't a wall in the way, set their inview to true.

      if(s.wall(s.UP) == false)
      {
       //System.out.println("About to SetInView(true)");
       
       getSquare(row-1, col).setInView(true);
       if(!getSquare(row-1, col).wall(s.RIGHT)) //top right
       {
        getSquare(row-1,col+1).setInView(true);
       }
       if(!getSquare(row-1, col).wall(s.LEFT)) //top left
       {
        getSquare(row-1,col-1).setInView(true);
       }
      }
      if(s.wall(s.RIGHT) == false)
      {
       //System.out.println("About to SetInView(true)");
       getSquare(row, col+1).setInView(true);
       if(!getSquare(row, col+1).wall(s.UP)) //top right
       {
        getSquare(row-1,col+1).setInView(true);
       }
       if(!getSquare(row, col+1).wall(s.DOWN)) //bottom right
       {
        getSquare(row+1,col+1).setInView(true);
       }
  
      }
      if(s.wall(s.DOWN) == false)
      {
       getSquare(row+1, col).setInView(true);
       if(!getSquare(row+1, col).wall(s.RIGHT)) //bottom right
       {
        getSquare(row+1,col+1).setInView(true);
       }
       if(!getSquare(row+1, col).wall(s.LEFT)) //bottom left
       {
        getSquare(row+1,col-1).setInView(true);
       }
      }
      if(s.wall(s.LEFT) == false)
      {
       //System.out.println("About to SetInView(true)");
       getSquare(row, col-1).setInView(true);
       if(!getSquare(row, col-1).wall(s.UP)) //top left
       {
        getSquare(row-1,col-1).setInView(true); //top left
       }
       if(!getSquare(row, col-1).wall(s.DOWN)) //bottom left
       {
        getSquare(row+1,col-1).setInView(true); //bottom left
       }
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

   public void writeMazeToFile(String fileName) throws IOException {
   		PrintWriter writer = new PrintWriter(fileName);
   		writer.println(rows + "," + cols);
   		for (int i = 0; i < rows; i++) {
    		for (int j = 0; j < cols; j++) {
       			writer.println(squares[i][j].toText(','));
        // System.out.println(maze[i][j].toText(','));
      } //end of first loop
    } //end of second loop
    
    writer.println(explorer.toText(','));
    // System.out.println(explorer.toText(','));
    for (int i = 0; i < randOccupants.size(); i++) {
      writer.println(randOccupants.get(i).toText(','));
      // System.out.println(randOccupants.get(i).toText(','));
    }
  }
  
  public void readMazeFromFile(String fileName) throws IOException, FileNotFoundException, MazeReadException {
    Scanner s1 = new Scanner(new File(fileName));
    String line = s1.nextLine(); // give you 5,5 FIRST LINE
    Scanner s2 = new Scanner(line);
    s2.useDelimiter(",");
    int counter = 1;

    if (s2.hasNextInt()) {
      rows = s2.nextInt();
      cols = s2.nextInt();
      squares = new Square[rows][cols];
    } else {
      throw new MazeReadException("Rows and columns not specified.",
          s2.nextLine(), counter);
    }

    while (s1.hasNextLine()) {
      line = s1.nextLine();
      s2 = new Scanner(line);
      s2.useDelimiter(",");
      counter++;
      if(s2.hasNext()){
        String type = s2.next();
        if (type.equals("Square")) {
          int inputRow = s2.nextInt();
          int inputCol = s2.nextInt();
  
          if (squares[inputRow][inputCol] == null) {
            squares[inputRow][inputCol] = new Square(inputRow, inputCol);
          } else {
            throw new MazeReadException("Duplicate square.", line, counter);
          }
          try {
            squares[inputRow][inputCol].toObject(s2);
          } catch (InputMismatchException e) {
            throw new MazeReadException("Line format or other error.", line,
                counter);
          }
        } else if (type.equals("Treasure")) {
          Treasure t = new Treasure(this);
          try {
            t.toObject(s2);
          } catch (InputMismatchException e) {
            throw new MazeReadException("Line format or other error.", line,
                counter);
          }
          randOccupants.add(t);
        } else if (type.equals("Explorer")) {
          explorer = new Explorer(this);
          try { 
            explorer.toObject(s2);
          }
          catch (InputMismatchException e) {
            throw new MazeReadException("Line format or other error.", line, counter);
          }
        } else if (type.equals("Monster")) {
          Monster m = new Monster(this);
          try {
            m.toObject(s2);
          }
          catch (InputMismatchException e) { 
            throw new MazeReadException("Line format or other error.", line, counter);
          }
          randOccupants.add(m);
  
        } else {
          throw new MazeReadException("Unknown type.", line, counter);
        }

      }
      else {
        throw new MazeReadException("Line format or other error.", line, counter);
      }
    }
  }
}






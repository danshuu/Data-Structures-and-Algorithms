import java.awt.event.KeyEvent.*;
import java.util.Random;

GameGUI gui;
final int ROWS = 10;
final int COLS = 10;
final int NUM_MONSTERS = 3;
final int NUM_TREASURES = 2;
int counter;
PFont f;

void setup()
{
   // CHANGE the name of the Explorer passed to the gui constructor.
   gui = new GameGUI(ROWS, COLS, NUM_MONSTERS, NUM_TREASURES, "Virus");

   colorMode(RGB, 255, 255, 255, 100);
   size(500, 500);
   counter = 0;

   // setup for final scene
   f = loadFont("AmericanTypewriter-CondensedBold-48.vlw");
}

void draw()
{
   gui.draw();
   if (!gui.isGameOver())
   {
      // move the monsters once per second
      counter++;
      if (counter % 60 == 0)
      {
         gui.monsterMove();
      }
   }
}

void keyPressed()
{
  if (!gui.isGameOver())
  {
     if (key == CODED)
     switch (keyCode)
     {
        case DOWN:
           gui.move(KeyEvent.VK_DOWN);
           break;
        case UP:
           gui.move(KeyEvent.VK_UP);
           break;
        case LEFT:
           gui.move(KeyEvent.VK_LEFT);
           break;
        case RIGHT:
           gui.move(KeyEvent.VK_RIGHT);
           break;
     }
  }
}

/**
 * Class GameGUI - Class to run the GUI for the maze game
 *
 * @author Julie Workman
 * @version April 25, 2013
 */
public class GameGUI
{
    private int rows;
    private int cols;
    private int numMonsters;
    private int numTreasures;

    private DrawableMaze maze;
    private boolean gameover = false;

    // for random maze generation
    int[][] cell= new int[200][100];
    int xdim = 5;
    int ydim = 5;

    public GameGUI(int r, int c, int m, int t, String name)
    {
        rows = r;
        cols = c;
        numMonsters = m;
        numTreasures = t;
        init(name);
    }

    public boolean isGameOver() {return gameover;}

    private void init(String name)
    {
        DrawableSquare[][] squares = new DrawableSquare[rows][cols];
        int[][] randMaze;
        int N = MazeGenerator.N; //1
        int E = MazeGenerator.E; //2
        int S = MazeGenerator.S; //3
        int W = MazeGenerator.W; //4

        MazeGenerator mg = new MazeGenerator(); //maze constructor
        boolean up, right, down, left;

        // generate a maze stored as integer values (bitwise & of 1,2,4,8)
        randMaze = mg.generate_maze(rows, cols); //create the maze

        // remove some walls to make it easier - loops and rooms
        for (int i=0; i<ROWS+COLS; i++)
        {
            int row = (int)random(rows-2)+1;
            int col = (int)random(cols-2)+1;

            switch (i%4)
            {
               case 0:
                   randMaze[row][col] &= N+E+S;
                   randMaze[row][col-1] &= N+W+S;
                   break;
               case 1:
                   randMaze[row][col] &= E+S+W;
                   randMaze[row-1][col] &= E+N+W;
                   break;
               case 2:
                   randMaze[row][col] &= N+S+W;
                   randMaze[row][col+1] &= N+S+E;
                   break;
               default:
                   randMaze[row][col] &= N+E+W;
                   randMaze[row+1][col] &= S+E+W;
                   break;
            }
        }

        // construct the maze squares with values from the randMaze
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                up = ((randMaze[i][j] & N) == N);
                right = ((randMaze[i][j] & E) == E);
                down = ((randMaze[i][j] & S) == S);
                left = ((randMaze[i][j] & W) == W);

                squares[i][j] = new DrawableSquare(up, right, down, left, i, j);
            }
        }

        // construct the maze
        maze = new DrawableMaze(squares, rows, cols);

        // add monsters and treasures
        for (int i=0; i<numMonsters; i++)
           maze.addRandomOccupant(new DrawableMonster(maze));

        for (int i=0; i<numTreasures; i++)
           maze.addRandomOccupant(new DrawableTreasure(maze));

        // add the explorer
        maze.setExplorer(new DrawableExplorer(squares[0][0], maze, name));
    }

    public void move(int key)
    {
       maze.getExplorer().move(key);
    }

    public void monsterMove()
    {
       maze.randMove();
    }

    /**
     * Draw method for GUI.
     */
    public void draw()
    {
        int status = maze.gameStatus();

        if (status == Maze.ACTIVE)
        {
           maze.draw();
        }
        else if (status == Maze.EXPLORER_WIN) {
            maze.draw();
            gameover = true;

            DrawableExplorer winner = new DrawableExplorer(maze.getSquare(6, 4), maze, maze.getExplorer().name());
            pushMatrix();
            translate(-900, -1300);
            scale(5);
            winner.draw();
            popMatrix();

            // tell them they won
            fill(255, 255, 0);
            textFont(f, 32);
            text(winner.name() + " wins!!!", 50, 150);
        }
        else if (status == Maze.MONSTER_WIN) {
            maze.draw();
            gameover = true;

            // draw large monster
            DrawableMonster dog = new DrawableMonster(maze, maze.getSquare(6, 4));
            maze.getSquare(6,4).setInView(true);
            pushMatrix();
            translate(-900, -1300);
            scale(5);
            dog.draw();
            popMatrix();

            // tell them they lost
            fill(255, 0, 0);
            textFont(f, 32);
            text("You lose!!! Ha ha ha!!!!", 50, 150);
        }
    }
}

//**************drawable**********
private interface Drawable{
  public void draw();
}

//************drawableexplorer**************
private class DrawableExplorer extends Explorer implements Drawable{
  public DrawableExplorer(Square location, Maze maze, String name){
    super(location, maze, name);
  }
  public void draw(){
    pushMatrix();
    noStroke();
    //happy face
    fill(255);
    ellipse(25,25,25,25);
    //eyes
    fill(0);
    ellipse(20,20,2,2);
    ellipse(30,20,2,2);
    //mouth
    fill(255,0,100);
    ellipse(25,32.5,5,5);
    popMatrix();
  }  
}

//***********drawablemaze****************
private class DrawableMaze extends Maze implements Drawable{
  public DrawableMaze(DrawableSquare[][] squares, int rows, int cols) {
    super(squares, rows, cols);
  }
  public void draw(){
    background(150,255,200);
    for (int i = 0; i < super.rows; i++) {
      for (int j = 0; i < super.cols; j++) {
        ((Drawable)getSquare(i,j)).draw();
    }
  }
  
  //for (int i = 0; i < getNumRandOccupants(); i++) {
  //  ((Drawable)getRandomOccupant(i)).draw();
  //}
  
  ((Drawable)getExplorer()).draw();
  
  }
}

// ******drawablemonster**********
private class DrawableMonster extends Monster implements Drawable {
  public DrawableMonster(Maze maze){
    super(maze);
  }
  public DrawableMonster(Maze maze, long seed){
    super(maze, seed);
  }
  public DrawableMonster(Maze maze, Square location){
    super(maze, location);
  }
  public void draw(){
    if(location().inView()) {
      pushMatrix();
      noStroke();
      //dark minion
      //head
      fill(120,100,206);
      ellipse(27.5,27.5,25,35);
      //eyes
      fill(0);
      ellipse(22.5,20,8,12);
      fill(0);
      ellipse(32.5,20,8,12);
      //pupils
      fill(255);
      ellipse(22.5,20,3,5);
      fill(255);
      ellipse(32.5,20,3,5);
        
      //mouth
      fill(0);
      ellipse(27.5,32.5,7.5,15);
        
      //teeth
      fill(255);
      triangle(24,30,27,24,26,30);
      triangle(30.5,30,28.5,24,28,30);    
      popMatrix();
    }
}

//**************drawablesquare****************
private class DrawableSquare extends Square implements Drawable{
  public DrawableSquare(boolean up, boolean right, boolean down, boolean left, int row, int col){
    super(up, right, down, left, row, col);
  }
  
  public void draw(){
  
  pushMatrix();
  noStroke();
  
  if (super.inView() == true) {
    //draw the area around it, and squares adjacent if inview is true
    //background square SEEN
    fill(255);
    rect(0,0,50,50);
    //walls
    if (wall(Square.UP)==true) {
      fill(100,100,100);
      rect(0,0,50,5);
    }
    if (wall(Square.RIGHT)==true) {
      fill(100,100,100);
      rect(50,0,5,50);
    }
    if (wall(Square.DOWN)==true) {
      fill(100,100,100);
      rect(0,50,50,5);
    }
    if (wall(Square.LEFT)==true) {
      fill(100,100,100);
      rect(0,0,5,50);
    } //end of if
  } // end of first if
  else {
    fill(0);
    rect(0,0,50,50);
  }
  popMatrix();
} //end of method
  
}//end of class

//*************drawabletreasure**************
private class DrawableTreasure extends Treasure implements Drawable{
  public DrawableTreasure(Maze maze){
    super(maze);
  }
  public DrawableTreasure(Maze maze, long seed){
    super(maze, seed);
  }
  public DrawableTreasure(Maze maze, Square location){
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
    }
    
  }
}


  
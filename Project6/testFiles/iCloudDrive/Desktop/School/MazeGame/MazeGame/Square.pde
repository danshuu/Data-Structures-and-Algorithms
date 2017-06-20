// Square.java: Class for operating the squares inside of the maze. 


public class Square {

  public static final int SQUARE_SIZE = 50;
  public static final int UP = 0;
  public static final int RIGHT = 1;
  public static final int DOWN = 2;
  public static final int LEFT = 3;
  
  private boolean[] walls = new boolean[4];
  private boolean seen = false;
  private boolean inView = false;
  private int row;
  private int column;
  private Treasure treasure = null;
  
  public Square(boolean up, boolean right, boolean down, boolean left, int row, int col)
  {
    walls[UP] = up;
    walls[RIGHT] = right;
    walls[DOWN] = down;
    walls[LEFT] = left;
    this.row = row;
    this.column = col;
  }

  public boolean wall(int direction)
  {
    return walls[direction];
  }
  public boolean seen()
  {
    return seen;
  }
  public boolean inView()
  {
    return inView;
  }
  public int row()
  {
    //System.out.println("Square's Row: " + row);
    return row;
  }
  public int col()
  {
    //System.out.println("Col: " + column);
    return column;
  }
  public Treasure treasure() 
  {
    return treasure;
  }
  
  public int x()
  {
    return (column)*SQUARE_SIZE;
  }
  public int y()
  {
    return (row)*SQUARE_SIZE;
  }
  public void setInView(boolean inView)
  {
    this.inView = inView;
    if(inView == true)
    {
      seen = true;
    }
  }
  public void setTreasure(Treasure t)
  {
    this.treasure = t;
  }
  public void enter()
  {
    if(treasure != null)
    {
      treasure.setFound();
    }
  }
  
}
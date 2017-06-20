// Occupant.java: Abstract class to encompass all occupants within the maze, which are the Explorer, monsters, and treasure.


public abstract class Occupant {
  
  private Square square;
  
  //constructors
  public Occupant()
  {
  }
  public Occupant(Square start)
  {
    this.square = start;
  }
  
  //methods
  public Square location()
  {
    return square;
  }
  public void moveTo(Square newLoc)
  {
    square = newLoc;
  }
  
}
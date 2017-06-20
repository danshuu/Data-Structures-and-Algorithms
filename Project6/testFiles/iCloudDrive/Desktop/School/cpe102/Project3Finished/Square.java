/**
 * A class containing specifications for a Square in the maze class
 *
 * @author Bradley Ting, Daniel Shu
 * @version 11/4/2016
 */
public class Square {
	//constants
	public static final int SQUARE_SIZE = 50;
	public static final int UP = 0;
	public static final int RIGHT = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;
	
	//instance variables
	private boolean[] walls;
	private boolean seen;
	private boolean inView;
	private int row;
	private int col;
	private Treasure treasure;
	
	//Square constructor
	public Square(boolean up, boolean right, boolean down, boolean left, int row, int col){
		walls = new boolean[] {false,false,false,false};
		this.walls[0] = up;
		this.walls[1] = right;
		this.walls[2] = down;
		this.walls[3] = left;
		this.row = row;
		this.col = col;
		this.seen = false;
		this.inView = false;
		this.treasure = null;
	}
	
	//Square methods
	//return wall at certain direction
	public boolean wall(int direction){
		return walls[direction];
	}
	//getters
	public boolean seen(){return this.seen;}
	public boolean inView(){return this.inView;}
	public int row(){return this.row;}
	public int col(){return this.col;}
	public Treasure treasure(){return this.treasure;}
	public int x(){return col*SQUARE_SIZE;}
	public int y(){return row*SQUARE_SIZE;}
	public void setInView(boolean inView){
		this.inView = inView;
		if(inView)
			this.seen = true;
	}
	public void setTreasure(Treasure t){
		this.treasure= t;
	}
	public void enter(){
		if(treasure != null)
			treasure.setFound();
	}
	
}

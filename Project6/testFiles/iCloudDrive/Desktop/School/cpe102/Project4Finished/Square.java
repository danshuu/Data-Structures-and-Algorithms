import java.util.Scanner;

/**
 * A class containing specifications for a Square in the maze class
 *
 * @author Bradley Ting, Daniel Shu
 * @version 11/17/2016
 */
public class Square implements DelimitedTextIO{
	//constants
	public final static int SQUARE_SIZE = 50;
	public final static int UP = 0;
	public final static int RIGHT = 1;
	public final static int DOWN = 2;
	public final static int LEFT = 3;
	
	//instance variables
	private boolean[] walls;
	private boolean seen;
	private boolean inView;
	private int row;
	private int col;
	private Treasure treasure;
	
	//Square constructor
	//rc constructor
	public Square(int row, int col){
		this.row = row;
		this.col = col;
	}
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
	
	//toText 
	public String toText(char delimiter){
		String out = "";
		out += this.getClass().getName() + delimiter;
		out += Integer.toString(row) + delimiter;
		out += Integer.toString(col) + delimiter;
		
		for(int i = 0; i < 4; i++){
			out += String.valueOf(this.walls[i]) + delimiter;
		}
		out += String.valueOf(seen) + delimiter + String.valueOf(inView);
		
		return out;
	}
	
	public void toObject(Scanner input){
		this.walls = new boolean[] {false,false,false,false};
		this.walls[0] = input.nextBoolean();
		this.walls[1] = input.nextBoolean();
		this.walls[2] = input.nextBoolean();
		this.walls[3] = input.nextBoolean();
		this.seen = input.nextBoolean();
		this.inView = input.nextBoolean();
	}
	
}

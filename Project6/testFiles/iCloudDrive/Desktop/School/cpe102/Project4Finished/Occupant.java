import java.util.Scanner;
/**
 * An abstract class for Occupants of the maze
 *
 * @author Bradley Ting, Daniel Shu
 * @version 11/17/2016
 */
public abstract class Occupant implements DelimitedTextIO {
	//instance variables
	private Square location;
	
	//constructors
	public Occupant(){}
	public Occupant(Square start){
		this.location = start;
	}
	
	//methods
	public Square location(){
		return this.location;
	}
	public void moveTo(Square newLoc){
		this.location = newLoc;
	}
	
	public String toText(char delimiter){
		String out = "";
		out += this.getClass().getName() + delimiter;
		out += Integer.toString(this.location().row()) + delimiter;
		out += Integer.toString(this.location().col());
		return out;
	}
	

}
	
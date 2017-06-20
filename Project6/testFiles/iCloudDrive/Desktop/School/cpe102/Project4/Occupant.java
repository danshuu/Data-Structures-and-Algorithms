import java.util.*;

public abstract class Occupant implements DelimitedTextIO {
	//Fields (instance variables)
	private Square square;

	//Constructors
	public Occupant() {
		//default constructor
	}

	public Occupant(Square start) {
		this.square = start;
	}

	//Methods
	public Square location() {
		return square;
	}

	public void moveTo(Square newLoc) {
		this.square = newLoc;
	}

	public String toText(char delimiter) {
		return getClass().getName() + delimiter + square.row() + delimiter + square.col();
	}

	
}
import java.util.*;
import java.io.*;

public class MazeReadException extends Exception {

	//instance variables
	private String line;
	private int lineNumber;

	//constructor
	public MazeReadException(String message, String line, int lineNumber) {
		super(message);
		this.line = line;
		this.lineNumber = lineNumber;
	}

	//query methods
	public String getLine() {
		return line;
	}

	public int getLineNum() {
		return lineNumber;
	}
}
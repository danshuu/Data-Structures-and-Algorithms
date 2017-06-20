/**
 * A class for MazeReadException for our maze class
 *
 * @author Bradley Ting, Daniel Shu
 * @version 11/17/2016
 */
public class MazeReadException extends IllegalArgumentException {
	private String line;
	private int lineNumber;
	public MazeReadException(String message, String line, int lineNumber){
		super(message);
		this.line = line;
		this.lineNumber = lineNumber;
	}
	
	public String getLine(){return this.line;}
	public int getLineNum(){return this.lineNumber;}
}

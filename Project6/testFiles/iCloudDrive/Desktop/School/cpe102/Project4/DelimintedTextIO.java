import java.util.Scanner;

public interface DelimitedTextIO {
	
	//methods
	public String toText(char delimiter); //returns a String containing all data of implementing class as text
										  //and with each element separated by the provided delimiter

	public void toObject(Scanner input); //uses the provided Scanner input to parse delimited text representing the data 
										 //for the implementing class and initializes the objects instance variables
}
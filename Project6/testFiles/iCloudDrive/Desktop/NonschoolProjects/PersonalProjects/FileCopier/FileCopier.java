import java.util.Scanner;
import java.io.*;

public class FileCopier {

	public static void main(String[] args) {

		try {

			//input file you want to copy
			System.out.println("Enter the file name to open with extension: ");
			Scanner sc = new Scanner(System.in);
			File file = new File(sc.nextLine());

			//open file with the inputted name
			sc = new Scanner(file); 

			//show the path the file takes to be opened
			System.out.println(file.getAbsolutePath());

			//create the new file 
			System.out.println("What is the file name you want to create? ");
			Scanner sc2 = new Scanner(System.in);
			File write = new File(sc2.nextLine());

			//create writer for the new file
			PrintWriter writer = new PrintWriter(write);
			System.out.println("Copying file contents over... ");

			//write all contents from the original file to the newly created file
			while (sc.hasNextLine()) {

				String line = sc.nextLine();
				writer.println(line);

			}

			//close the writer and the scanner	
			writer.close();
			sc.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} 
	
	}
}
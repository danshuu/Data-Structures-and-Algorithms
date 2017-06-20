import java.util.*;
import java.io.*;

public class Plagiarism {

	public static void main(String[] args) {

		if (checkPlag()) {

			System.out.println("The files are the same. ");

		} else {

			System.out.println("The files are not the same. ");

		}
		// System.out.println(checkPlag());
	}
	
	private static boolean checkPlag() {

		try {

			Scanner sc1 = new Scanner(System.in);
			Scanner sc2 = new Scanner(System.in);

			System.out.println("Enter the name of the first file you want to compare: ");
			File file1 = new File(sc1.next());
			System.out.println(file1.getAbsolutePath());
			//*** use /Users/danielshu/Desktop/etc if you want to set file path to file in different directory

			System.out.println("Enter the name of the second file you want to compare: ");
			File file2 = new File(sc2.next());
			System.out.println(file2.getAbsolutePath());	

			sc1 = new Scanner(file1);
			// System.err.println(file1.getAbsolutePath());

			sc2 = new Scanner(file2);
			// System.err.println(file2.getAbsolutePath());		

			//not plagiarizing if one or both files are empty.
			if (!sc1.hasNextLine() || !sc2.hasNextLine()) {
				return false;
			}	

			//check if all lines in the files are the same
			while (sc1.hasNextLine() || sc2.hasNextLine()) {

				try {

					String first = sc1.nextLine();
					String second = sc2.nextLine();

					if (!(first.equals(second))) { //if it doesn't equal, then return false for plagiarism
							//print the discrepancy so i know where the line is not equal.
							System.out.println("The following lines are not equal in: ");
							// System.out.println(FileUtils.readFileToString(file1));
							// Converting the file name into a string. 
							// To be finished later
							System.out.println(first);
							System.out.println(second);

						return false;

					}

				} catch (NoSuchElementException e) {

					System.out.println("One file has more lines than the other. This program cannot tell if one file is fully plagiarized. ");
					// check = false;
					return false;		

				}

			}

			return true; // for the first try block in the method

		} catch (FileNotFoundException e) {

			System.out.println("File is not found. Try again. ");

		} 

		return false;

	}

}

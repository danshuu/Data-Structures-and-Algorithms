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
			System.out.println("Enter the name of the second file you want to compare: ");
			File file2 = new File(sc2.next());
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

					if (!(sc1.nextLine().equals(sc2.nextLine()))) { //if it doesn't equal, then return false for plagiarism
						if (sc1.hasNextLine() && sc2.hasNextLine()){
							System.out.println(sc1.nextLine());
							System.out.println(sc2.nextLine());
						}
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

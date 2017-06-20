import java.util.Scanner;
import java.io.*;


public class FileOpener {
	public static void main(String[] args) {
		try {
			System.out.println("Enter the file name to open with extension: ");
			Scanner sc = new Scanner(System.in);
			File file = new File(sc.nextLine());
			sc = new Scanner(file); //opens inputted file name
//			System.err.println(file.getAbsolutePath());

			System.out.println("What is the file name you want to create? ");
			Scanner sc2 = new Scanner(System.in);
			File write = new File(sc2.nextLine());

			PrintWriter writer = new PrintWriter(write);
//			System.out.println("Copying file contents over... ");
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				writer.println(line);
			}
			writer.close();
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
		} finally {
			
			System.out.println("Program finished. ");
			
		}
		
		
	
	}
}

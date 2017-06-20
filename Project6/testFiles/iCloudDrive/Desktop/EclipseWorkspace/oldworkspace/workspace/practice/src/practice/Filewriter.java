package practice;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.*;

public class Filewriter {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the file you want to create: ");
			File newFile = new File(sc.nextLine());
			PrintWriter write = new PrintWriter(newFile);

			for(int i = 0; i < 5; i++) {
				System.out.println("Enter a line to be printed in the new file: ");
				write.println(sc.nextLine());
			}
			write.close();
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		}

	}

}

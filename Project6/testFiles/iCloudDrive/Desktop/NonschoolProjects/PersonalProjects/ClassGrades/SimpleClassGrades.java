/**
*
* @author Daniel Shu
* @version Personal Project
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.*;

public class SimpleClassGrades { 

		public static void main(String[] args) {
		//add trys and catches last to make this program robust, for now focus on getting it working
		//think about using other classes, etc to make this program more complex and clean later

		//name of the file you'd like to create
			// System.out.println("What is the name of the text file you'd like to export the grades to? ");
			// PrintWriter writer = new PrintWriter(sc.next());

			//arraylist to hold the grade categories
			ArrayList<Grades> gradeCategories = new ArrayList<Grades>();

			// ArrayList<Integer> numberOfAssignmentsForEachCategory = new ArrayList<Integer>();
			//unnecessary
			ArrayList<Double> weightedGrades = new ArrayList<Double>();

			// ArrayList<String> studentNames = new ArrayList<String>();

			// ArrayList<Students> students = new ArrayList<Students>();

			//scanner to add grade categories to a list
			Scanner sc = new Scanner(System.in);

			// Scanner sc2 = new Scanner(System.in);

			
			// System.out.println("Separate each one separated by a space and each line with the enter key. Type quit when complete. ");
			// System.out.println("Example: Homework .20");
			String holderString = "irrelevant";
			double holderDouble = 0.0;

			while (!holderString.equals("quit")) { //automatically terminate when weighted grades reach 1?
				//still yet to find out why !sc.hasNext("quit") prompts for input. 
				System.out.println("Please enter the grade categories for the class syllabus");
				try {
					holderString = sc.nextLine();
					Grades newGrade = new Grades(holderString);
					if (!holderString.equals("quit")) {
						gradeCategories.add(newGrade);
					} else {
						break;
					}//The if statement is needed because even while holderString is "quit" the while loop has to finish executting for the last time.
				} catch (InputMismatchException e) {
					System.out.println("Not a String");
				}//make it keep asking in a while loop in else
				// numberOfAssignmentsForEachCategory.add(sc.nextInt());
				while (weightedGrades.size() != gradeCategories.size()) {
					System.out.println("What is the weighted percentage of this category in correspondence to overall grade?");
					try {
						// System.out.println("inside try statement");
						holderDouble = sc.nextDouble();
						weightedGrades.add(holderDouble);
						// System.out.println("exiting try statement");
					} catch (InputMismatchException e) {
						System.out.println("Not a decimal, try again.");
					}
					sc.nextLine(); //flush
				}

			}
	
			System.out.println("Grade Categories: \n");
			for (int i=0;i<gradeCategories.size();i++) {
				System.out.println(gradeCategories.get(i).categoryName());
			}
			System.out.println("Weighted Grades: \n");
			for (int i=0;i<weightedGrades.size();i++) {
				System.out.println(weightedGrades.get(i));
			}
			//when done, all weighted grades have to add up to 1

			System.out.println("What is the student's name?");
			String studentName = sc.nextLine();

			System.out.println("Let's input grades for the student to find the overall grade. Type quit when done inputting. ");

			String holderString2 = "irrelevant again";
			double holderDouble2 = 0.0;

			for (int i = 0; i < gradeCategories.size(); i++) {

				System.out.println("Input the following grades for " + gradeCategories.get(i).categoryName() + "\n");

				while (!holderString2.equals("quit")) {
					System.out.println("Enter the assignment name: (i.e., hw1), type quit when complete.");
					try {
						holderString2 = sc.nextLine();
						if (!holderString2.equals("quit")) {
							gradeCategories.get(i).add(holderString2); //holds the string containing the assignment name
						} else {
							holderString2 = "notquit";
							break;
						}
					} catch (InputMismatchException e) {
						System.out.println("Not a String");
					}

					while (gradeCategories.get(i).size() != gradeCategories.get(i).sizeGrade()) { //while the assignmentNames and assignmentGrades lists aren't equal in length
						System.out.println("Enter the grade for this assignment in decimal: ");
						try {
							holderDouble2 = sc.nextDouble();
							gradeCategories.get(i).addGrade(holderDouble2);
						} catch (InputMismatchException e) {
							System.out.println("Not a decimal, try again.");
						}
						sc.nextLine(); //flush
					}

				} //end of while loop

			} //end of for loop

			//has to be inside a try catch
			boolean flag = true;

			double totalGrade = 0;

			System.out.println("What is the name of the file you'd like the grade data exported to?");

			while (flag) {
				try {
					Scanner sc2 = new Scanner(System.in);
					File file = new File(sc2.next()); //creates a new file
					PrintWriter writer = new PrintWriter(file); //sets up the file to be written in

					for (int i = 0; i < gradeCategories.size(); i++) {

						writer.println(gradeCategories.get(i).categoryName() + ": ");
						writer.println("");

						for (int j = 0; j < gradeCategories.get(i).size(); j++) {
							totalGrade += (gradeCategories.get(i).getGrade(j)/gradeCategories.get(i).sizeGrade() * weightedGrades.get(i)); //weighted grades * 
							writer.println(gradeCategories.get(i).get(j) + ": " + gradeCategories.get(i).getGrade(j)); //prints the assignmentName 
							// System.out.println(); //prints the assignmentGrade of the assignment
						}
						writer.println("\n"); //spacing purposes

					}

					totalGrade *= 100;

					writer.println("Overall Grade for student(" + studentName + "): " + totalGrade + "%");

					flag = false;
					//DON'T FORGET TO CLOSE THE WRITER
					writer.close();
					// break;
				} catch (FileNotFoundException e) {
					System.out.println("File not found. Try again.");
				}

			}



			//print it all in an excel worksheet or word doc??? how?

		} //end of main

	} //end of SimpleClassGrades

		//***Notable things throughout this project: ***
		//categoryGrades.size() == weightedGrades.size()
		//
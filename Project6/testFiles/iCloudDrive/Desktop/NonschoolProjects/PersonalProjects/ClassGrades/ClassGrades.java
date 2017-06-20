import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.*;
/**
* This program allows the user to input the grade categories for a class, how many assignments there are for each
* grade category, and the weighted grade of each category to the students overall grade. The program then
* prompts the user to enter each student name in and then enters all the grades for the categories as the
* program prompts them to, and concurrently adds these values to a list to calculate the final grade for the student
* in the class by taking the weighted category grade divided by the number of assignments for each category and multiplying
* it by the assignment grade the student got in the end. This number is then added to a total grade counter.
* in the end, return the summary of each student, and the overall grade at the bottom.
* maybe create a class for student that would hold these lists, so in the loop the student would be able
* to hold arraylists of gradeCategories, and add the already formulated lists into the new ArrayList
* @author Daniel Shu
* @version Personal Project
*/
public class ClassGrades {

	public static void main(String[] args) {
	//add trys and catches last to make this program robust, for now focus on getting it working
	//think about using other classes, etc to make this program more complex and clean later

		//arraylist to hold the grade categories
		ArrayList<Grades> gradeCategories = new ArrayList<Grades>(); //common grade ArrayList shared between all students currently
		//you have to create new grades that are equal to this list and insert it into the grades of each student

		ArrayList<Double> weightedGrades = new ArrayList<Double>();

		ArrayList<Student> students = new ArrayList<Student>();

		//scanner to add grade categories to a list
		Scanner sc = new Scanner(System.in);

		// Scanner sc2 = new Scanner(System.in);

		
		// System.out.println("Separate each one separated by a space and each line with the enter key. Type quit when complete. ");
		// System.out.println("Example: Homework .20");
		String holderString = "irrelevant";
		double holderDouble = 0.0;
		double weightOne = 0;


		while (weightOne < 1) { //automatically terminate when weighted grades reach 1
			//still yet to find out why !sc.hasNext("quit") prompts for input. 
			System.out.println("Please enter the grade categories for the class syllabus one by one. (ex: Homework)");
			try {
				holderString = sc.nextLine();
				Grades newGrade = new Grades(holderString);

				gradeCategories.add(newGrade);

				//The if statement is needed because even while holderString is "quit" the while loop has to finish executting for the last time.
			} catch (InputMismatchException e) {
				System.out.println("Not a String");
			}//make it keep asking in a while loop in else
			// numberOfAssignmentsForEachCategory.add(sc.nextInt());
			while (weightedGrades.size() != gradeCategories.size()) {

				System.out.println("What is the weighted percentage of this category in correspondence to overall grade? [decimal form] (Grades must add up to 1 in the end.)");
				try {
					// System.out.println("inside try statement");
					holderDouble = sc.nextDouble();
					weightedGrades.add(holderDouble);
					weightOne += holderDouble;
					// System.out.println("exiting try statement");
				} catch (InputMismatchException e) {
					System.out.println("Not a decimal, try again.");
				}
				sc.nextLine(); //flush
				if (weightOne == 1) {
					break;
				} else if (weightOne > 1) {
					throw new IndexOutOfBoundsException("Grade weights can't surpass 1.");
				}

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


		String studentName = "irrelevant 2";

		// implement a \n as the input instead of quit to quit. ****************
		while (!(studentName.equals("quit"))) {

			System.out.println("\nWhat is the student's name? (type 'quit' when no more students) ");
			studentName = sc.nextLine();
			if (studentName.equals("quit")) {
				break;
			}

			//create a student object and add it to the studentlist
			Student stud = new Student(studentName);
			students.add(stud);


			System.out.println("\nLet's input grades for " + stud.getName() + " to find the overall grade. Type quit when done inputting. ");

			String holderString2 = "irrelevant again";
			double holderDouble2 = 0.0;

			//loops through the grade categories
			for (int i = 0; i < gradeCategories.size(); i++) {

				//this creates the notion of obstructing a new object and inserting it into each student, better than each student sharing and referring to a common arrayList gradeCategories (which wouldn't even work becuase all students would have the same grades [attempted])
				String gradeName = gradeCategories.get(i).categoryName(); //SUCCESS
				Grades tempGrade = new Grades(gradeName);
				stud.add(tempGrade); //adds the gradeCategories into each student
				System.out.println("\nInput the following grades for " + gradeCategories.get(i).categoryName() + "\n");

				//quit is necessary here because when the student is written into, the assignment grades and names need to stop executing at some point while grade categories run
				while (!holderString2.equals("quit")) {
					//entering each specific assignment name and assignment grade for each grade category looped
					System.out.println("Enter the assignment name: (i.e.: " + gradeCategories.get(i).categoryName() + "#), type quit when grade inputting for the student is complete.");
					try {
						holderString2 = sc.nextLine();
						if (!holderString2.equals("quit")) {
							stud.getIndex(i).add(holderString2); //holds the string containing the assignment name
							//^ this adds the assignment name for the respective gradeCategory for each student
						} else {
							holderString2 = "notquit";
							break;
						}
					} catch (InputMismatchException e) {
						System.out.println("Not a String");
					}

					//this while loop makes sure to keep prompting the user for the assignment grade as long as the amount of grades doesn't equal to the amount of assignments
					while (stud.getIndex(i).size() != stud.getIndex(i).sizeGrade()) { //while the assignmentNames and assignmentGrades lists aren't equal in length
						System.out.println("Enter the grade for this assignment in decimal: ");
						try {
							holderDouble2 = sc.nextDouble();
							stud.getIndex(i).addGrade(holderDouble2);
						} catch (InputMismatchException e) {
							System.out.println("Not a decimal, try again.");
						}
						sc.nextLine(); //flush
					}

				} //end of while loop

			} //end of for loop

		} //end of while loop


		//****for every student, print the grade categories and their respective assignments and grades

		//has to be inside a try catch
		boolean flag = true;

		double totalGrade = 0;

		System.out.println("What is the name of the file you'd like the grade data exported to?");

		while (flag) {
			try {
				// Scanner sc2 = new Scanner(System.in);
				File file = new File(sc.nextLine()); //creates a new file
				PrintWriter writer = new PrintWriter(file); //sets up the file to be written in
				for (int a = 0; a < students.size(); a++) {

					writer.println(students.get(a).getName() + ": ");

					for (int i = 0; i < students.get(a).size(); i++) { //loops through the grades

						writer.println(students.get(a).getIndex(i).categoryName() + ": \n");
						//writer.println("");

						for (int j = 0; j < students.get(a).getIndex(i).size(); j++) { //both size() and sizeGrades() would work in this case because they are equal
							totalGrade += (students.get(a).getIndex(i).getGrade(j)/students.get(a).getIndex(i).sizeGrade() * weightedGrades.get(i)); //each grade has a weighted grade 
							//grade / number of assignments for each gradecategory * weighted grade
							writer.println(students.get(a).getIndex(i).get(j) + ": " + students.get(a).getIndex(i).getGrade(j)); //prints the assignmentName 
							// System.out.println(); //prints the assignmentGrade and assignmentName of the assignment
						}
						writer.println("\n"); //spacing purposes

					} //end of gradeCategory loop

					totalGrade *= 100; //gets the integer value of the total grade.

					writer.println("Overall Grade for student(" + students.get(a).getName() + "): " + totalGrade + "%");
					writer.println("\n");

					totalGrade = 0;
				} //end of student loop

				//DON'T FORGET TO CLOSE THE WRITER
				writer.close();
				flag = false;

				// break;
			} catch (FileNotFoundException e) {
				System.out.println("File not found. Try again.");
			}

		}
		sc.close(); //close the scanner so it won't be used again


		//print it all in an excel worksheet or word doc??? how? 
		//^ solution: Apache

	} //end of main


}

//Notes: you can make this cleaner by separating each arraylist (grad)
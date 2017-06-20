/**
* This class is created for the purpose of being a support class for SimpleClassGrades and ClassGrades
* @author Daniel Shu
*
*/

import java.util.ArrayList;

public class Grades {

	private String gradeCategory;
	private ArrayList<String> assignmentNames;
	private ArrayList<Double> assignmentGrades; //same number of assignments for each category

	public Grades(String gradeCategory) {

		this.gradeCategory = gradeCategory; //initiate the name of the grade category
		assignmentNames = new ArrayList<String>(); //initiate the assignmentnames arraylist so you can store
		assignmentGrades = new ArrayList<Double>(); //initiate the assignmentgrades arraylist so you can store
	} // constructor

	public void add(String assignment) {			
		assignmentNames.add(assignment);
	}

	public void addGrade(double grade) {
		assignmentGrades.add(grade);
	}

	//used for printing purposes only
	public String get(int index) {
		return assignmentNames.get(index);
	}

	public double getGrade(int index) {
		return assignmentGrades.get(index);
	}

	public String categoryName() {
		return gradeCategory;
	}

	public int size() {
		return assignmentNames.size();
	}

	public int sizeGrade() {
		return assignmentGrades.size();
	}

} //end of class Grades
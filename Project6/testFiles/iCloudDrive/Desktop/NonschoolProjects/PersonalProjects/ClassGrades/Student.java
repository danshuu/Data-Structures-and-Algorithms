import java.util.ArrayList;

public class Student {

	private String studentName;

	private ArrayList<Grades> grades;

	public Student(String studentName) {
		this.studentName = studentName;
		this.grades = new ArrayList<Grades>();
	}

	public void add(Grades theGrade) {
		grades.add(theGrade);
	}

	public int size() {
		return grades.size();
	}

	public String getName() {
		return studentName;
	}

	public Grades getIndex(int index) {
		return grades.get(index);
	}
	
}
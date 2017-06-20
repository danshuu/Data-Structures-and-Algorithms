public class Student extends Person {
	//instance variables
	private double gpa;

	//constructors
	//what do you mean double parameter? this has 3 parameters
	public Student(double gpa, String name, int legs) {
		super(name, legs);
		this.gpa = gpa;
	} // how does this work? 

	//methods
	//override equals method (inherited from Person that inherited from Animal)
	public boolean equals(Object st) {
		return super.equals(st) && gpa == ((Student)st).gpa;
	}

	public String toString(double gpa, String name, int legs) {
		return super.toString() + " and a Student object with a " + gpa + " gpa";
	}

	public static void main(String[] args) {
		Student x = new Student(3.0, "Daniel", 2);
		Student y = new Student(3.0, "Daniel", 2);
		System.out.println(x.equals(y));
	}

}
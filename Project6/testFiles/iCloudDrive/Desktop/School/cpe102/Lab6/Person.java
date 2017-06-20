public class Person extends Animal {
	//instance variables
	private String name;

	//constructor
	public Person(String name, int legs) {
		//how does super(legs) work?
		super(legs);
		this.name = name;
	}

	//methods
	//override equals method (inherited from Animal class)
	public boolean equals(Object pe) {
		return super.equals(pe) && name == ((Person)pe).name;
	}

	//override the toString method (inherited from Animal class)
	//also explicitly states how many legs and the name of the person
	public String toString(String name, int legs) {
		return super.toString() + " and a Person object whose name is " + name;
	}

	// public static void main(String[] args) {
	// 	Person x = new Person("Daniel", 2);
	// 	Person y = new Person("Daniel", 2);
	// 	System.out.println(x.equals(y));
	// }

}
public class TestDrive {
	public static void main(String[] args) {
		Animal x = new Animal(2);
		Animal y = new Animal(2);
		System.out.println(x.equals(y));

		Person z = new Person("Daniel", 2);
		Person a = new Person("Daniel", 2);
		System.out.println(z.equals(a));

		Student b = new Student(3.0, "Daniel", 2);
		Student c = new Student(3.0, "Daniel", 2);
		System.out.println(b.equals(c));		
	}
}
public class Animal {
	//instnace variables
	private int legs;

	//constructor
	public Animal(int legs) {
		this.legs = legs;
	}

	//methods
	/*overwrite the equals method so that it'll return false if
	the reference passed in is null, or is not the same time as this,
	or dooesnt have the same number of legs as this, otherwise true*/

	//**** ask if you want to check if the classes are same or the data type//
	//also difference between getclass and instance of?
	public boolean equals(Object an) {
		if (an == null) {
			return false;
		} else if (this.getClass() != an.getClass()) {
			return false;
		}
		else {
			return legs == ((Animal)an).legs;
			//can only do an.legs if it is within the same class, otherwise use
			//super. or you'd have to create another method that returns the var
		}
	}

	/*overwrite the toString method so that it returns the message
	with N legs*/
	public String toString(int legs) {
		return "I am an Animal object with " + legs + "legs";
	}

	// public static void main(String[] args) {
	// 	Animal x = new Animal(2);
	// 	Animal y = new Animal(2);
	// 	System.out.println(x.equals(y));
	// }
}
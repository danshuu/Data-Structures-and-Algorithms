package practice2;

public class Driver {

	public static void main(String[] args) {
		ObjectEqualizer obj = new ObjectEqualizer();
		ObjectEqualizer obj1 = new ObjectEqualizer();
		if (obj == obj1) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		
		System.out.println(obj1.equals(obj));
	}

}

	//this is a method created to determine if the 2 objects constructed are equal or not
//	public boolean checkIfEqual(obj1,obj2) {
//		if (obj1 == obj2) {
//			return true;
//		} else {
//			return false;
//		}
//	}


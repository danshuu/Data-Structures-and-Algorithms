package practice;

public class Snake implements TotemPole {
	//3 points
	//instance variable
	private TotemPole head;

	//constructor
	public Snake(TotemPole rest) {
		this.head = rest;
	}

	public int power() { //total power of the poles

//		if (head == null) {
//
//			return 3;
//
//		}
//
//		if (head instanceof Bear){
//
//			return 3 + ((Bear)head).power();
//
//		} else if (head instanceof Eagle) {
//
//			return 3 + ((Eagle)head).power();
//
//		} else {
//			
//			return 6;
//
//		}
		
		return 3 + head.power();
	}

	public int height() { //number of heads in the pole

//		if (head == null) {
//
//			return 1;
//			
//		}
//
//		if (head instanceof Bear){
//
//			return 1 + ((Bear)head).power();
//
//		} else if (head instanceof Eagle) {
//
//			return 1 + ((Eagle)head).power();
//
//		} else {
//
//			return 2;
//			
//		}
		
		return 1 + head.height();

	}

	public boolean chiefPole(int bearCount) {
	//is this pole worthy of a chief?
	//must have at least 3 bears in a row to be a chief
	//bearCount is how many bears in a row encountered so far

		if (bearCount == 3) {
			
			return true;

		} else {

			return false;

		}

	}

}
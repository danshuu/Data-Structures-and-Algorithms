package practice;

public class Bear implements TotemPole {
	//5 points

	//instance variable
	private TotemPole head;

	//constructor
	public Bear(TotemPole rest) {

		this.head = rest;
	
	}

	public int power() { //total power of the poles

//		if (head instanceof Snake){
//
//			return 5 + ((Snake)head).power();
//
//		} else if (head instanceof Eagle) {
//
//			return 5 + ((Eagle)head).power();
//
//		} else {
//			
//			return 10;
//
//		}
		
		return 5 + head.power();
	
	}

	public int height() { //number of heads in the pole

//		if (head instanceof Snake) {
//
//			return 1 + ((Snake)head).height();
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
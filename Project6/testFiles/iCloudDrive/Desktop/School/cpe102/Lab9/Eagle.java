public class Eagle implements TotemPole {
	//2 points
	//always at the top of the pole

	//constructor
	public Eagle() {

	}

	public int power() { //total power of the poles

		return 2;
	
	}

	public int height() { //number of heads in the pole

		return 1;
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
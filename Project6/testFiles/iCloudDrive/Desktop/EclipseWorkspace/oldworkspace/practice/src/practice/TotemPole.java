package practice;

public interface TotemPole {

	int power(); //total power of the poles

	int height(); //number of heads in the pole

	boolean chiefPole(int bearCount); //is this pole worthy of a chief?
	//bearCount is how many bears in a row encountered so far

}
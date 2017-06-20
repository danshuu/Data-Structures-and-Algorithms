import java.util.*;

public class Descending implements Comparator<Integer> {
	
	public int compare(Integer first, Integer second) {
		//why do the references have to Integers?
		
		if (first > second) {
		
			return -1;

		} else if (first < second) {

			return 1;
	
		} else {

			return 0;
	
		}
	
	}

}
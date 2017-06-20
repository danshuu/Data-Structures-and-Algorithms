import java.util.*;

public class OddEvenDescending implements Comparator<Integer> {
	
	public int compare(Integer first, Integer second) {

		int f = first%2;

		int s = second%2;

		if (f == 0 && s == 1) { //first is even, second is odd = not sorted

			return 1; //not sorted

		} else if (first > second) { // descending means not sorted

			return 1;

		} else if (f == 1 && s == 0) { //first is odd, second is even = sorted

			return -1; //sorted

		} else if (f == s) { //both are even or both are odd

			if (first > second) { //descending order

				return -1; //sorted 

			} else if (first < second) { //ascending order

				return 1; //not sorted

			} 

		}

		return 0;
		
	}

}
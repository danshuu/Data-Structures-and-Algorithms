import java.util.Random; 
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;
import java.lang.Integer; //required to use the comparedTo method?
import java.io.*;

//doesnt implement the comparable interface?
//how does it use compareTo?
public class IntegerList {
	//instance variable
	private ArrayList<Integer> list;

	//first constructor
	public IntegerList(int ints, int maxValue) {
		Random rdm = new Random();
		list = new ArrayList<Integer>(ints);
		for (int i = 0; i < list.size(); i++) {
			list.add(rdm.nextInt(maxValue));
		}
		//autoboxing (wrapping) -> converts the int so that it can be added to ArrayList of Integers
	}

	//second constructor
	public IntegerList(int ints, int maxValue, int seed) {
		Random rdm = new Random(seed);
		list = new ArrayList<Integer>(ints); //putting a number in here only initiates the capacity
		//NOT THE SIZE, so the size would still be empty if you increase capacity.
		//use add method inside a loop, looping up to maxValue to increase size.
		for (int i = 0; i < ints; i++) {
			list.add(rdm.nextInt(maxValue));
		}
	}

	public void sort() {
		Collections.sort(list);
	}

	public void sort(Comparator<Integer> intList) {
		Collections.sort(list, intList);
	}

	public boolean isSorted() {
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i).compareTo(list.get(i+1)) > 0) {
				return false;
			}	
		}
		return true;
	}

	public boolean isSorted(Comparator<Integer> intList) {
		//check if intList is null first
		if (intList == null) { 
			//then use compareTo to check if its 
			for (int i = 0; i < list.size() - 1; i++) {
				if (list.get(i).compareTo(list.get(i+1)) > 0) {
					return false;
				}	
			}
			return true;
		} else {
			for (int i = 0; i < list.size() - 1; i++) {
				if (intList.compare(list.get(i), list.get(i+1)) > 0) {
					//how would this work if intList was descending?
					//descending would use a different comparison methodology?
					return false;
				}
			}
			return true;
		}
	}

	//override the toString method from Object class
	public String toString() {
		//initialize an empty string
		String newString = "";
		for (int i = 0; i < list.size(); i++) {
			if (i != list.size() - 1) {
				newString += list.get(i) + "\n";
			} else {
				newString += list.get(i);
			}
		}
		return newString;
	}

	//override the get method
	public int get(int index) {
		return this.list.get(index);
	} //in the case that an IntegerList is created and the list needs to be returned

	public void mySLOsort() {
		//selection method
		int i, j, minIndex, temp;
		//do 2 loops 
		for (i=0;i<list.size()-1;i++) {
			minIndex = i; //equal to the first element of each loops list
			for (j=i+1;j<list.size();j++) {
				if (list.get(j) < list.get(minIndex)) {
					minIndex = j; //j,which is i+1 holds the new minimum
				}
			} //once minimum of the loop is found, swap:
			Collections.swap(list,i,minIndex);
			//can also do this instead of swap method
			//int storeFirst = list.get(i);
			//int storeMin = list.get(minIndex);
			//list.remove(i);
			//list.remove(minIndex);
			//list.add(i, storeMin);
			//list.add(minIndex, storeMin);
		}

	}

	public void mySLOsort(Comparator<Integer> clist) {
		int i, j, minIndex, temp;
		//do 2 loops 
		for (i=0;i<list.size()-1;i++) {
			minIndex = i; //equal to the first element of each loops list
			for (j=i+1;j<list.size();j++) {
				if (clist.compare(list.get(minIndex),list.get(j))>0) {
					minIndex = j; //j,which is i+1 holds the new minimum
				}
			} //once minimum of the loop is found, swap:
			Collections.swap(list,i,minIndex);
		}
	}

	public int binarySearch(int key) {
		int min,max,mid;
		min = 0;
		max = list.size();
		while (min <= max) {
			mid = (min + max)/2; //create middle, but what if its a double? //it rounds down
			if (list.get(mid) == key) {
				return mid;
			} else if (list.get(mid) < key) {
				min = mid + 1;
			} else if (list.get(mid) > key) {
				max = mid - 1;
			}

		}
		return -1;
	}
}

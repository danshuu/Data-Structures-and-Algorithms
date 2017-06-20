package practice;

import java.util.*;

public class IntegerList {
	
	private ArrayList<Integer> list;

	  public IntegerList(int size, int max) {
	    list = new ArrayList<Integer>();
	    Random r = new Random();
	    for (int i = 0; i < size; i++) {
	      int j = r.nextInt(max);
	      list.add(j);
	    }
	  }

	  public void sort() {
	    Collections.sort(list);
	  }

	  public void sort(Comparator<Integer> c) {
	    Collections.sort(list, c);
	  }

	  public boolean isSorted(Comparator<Integer> c) {
	    if (c == null) {

	      for (int i = 0; i < list.size() - 1; i++) {
	        // System.out.println("first number = " + list.get(i)
	        // + ", second number = " + list.get(i + 1));
	        if (list.get(i).compareTo(list.get(i + 1)) == 1) {
	          return false;
	        }
	      }
	      return true;

	    } else {
	      for (int i = 0; i < list.size() - 1; i++) {
	        if (c.compare(list.get(i), list.get(i + 1)) == 1) {
	          return false;
	        }
	      }
	      return true;
	    }

	  }

	  public String toString() {
	    String s = "";
	    for (int i = 0; i < list.size(); i++) {
	      s = s.concat(list.get(i).toString() + "\n");
	    }
	    return s;
	  }

	  public void mySLOsort() {
	    int i, j, theNum;
	    for (i = 1; i < list.size(); i++) {
	      theNum = list.get(i); // 3
	      // System.out.println("The Num = " + theNum);
	      j = i; // 1
	      // System.out.println("i = " + i + ", j = " + j);
	      while (j > 0 && list.get(j - 1) > theNum) {
	        list.remove(j);
	        list.add(j - 1, theNum);
	        j--;
	         System.out.println("new j: " + j);
	         System.out.println("updated list: " + list.toString());
	      }
	    }
	  }

	  public void mySLOsort(Comparator<Integer> c) {
	    int i, j, theNum;
	    for (i = 1; i < list.size(); i++) {
	      theNum = list.get(i); // 3
	      System.out.println("The Num = " + theNum);
	      j = i; // 1
	      System.out.println("i = " + i + ", j = " + j);
	      while (j > 0 && c.compare(list.get(j - 1), list.get(j)) == 1) {
	        list.remove(j);
	        list.add(j - 1, theNum);
	        j--;
	        System.out.println("new j: " + j);
	        System.out.println("updated list: " + list.toString());
	      }
	    }
	  }

	  public int binarySearch(int key) {
	    int mid;
	    int min = 0;
	    int max = list.size();

	    while (min <= max) {
	      mid = (min + max) / 2;
	      if (list.get(mid) == key) {
	        return mid;
	      } else if (list.get(mid) < key) {
	        min = mid + 1;
	      } else {
	        max = mid - 1;
	      }
	    }
	    return -1;
	  }

	  public int recBinarySearch(int key) {
	    return recBinarySearch(key, 0, list.size());
	  }

	  private int recBinarySearch(int key, int min, int max) {
	    int mid = (min + max) / 2;
	    if (min > max) {
	      return -1;
	    }
	    if (list.get(mid) == key) {
	      return mid;
	    } else if (list.get(mid) < key) {
	      return recBinarySearch(key, mid + 1, max);
	    }
	    return recBinarySearch(key, min, mid - 1);
	    

	  }


	public static void main(String[] args) {
//		ArrayList<Integer> newList = new ArrayList<Integer>();
//		//{38, 27, 43, 3, 9, 82, 10}
//		newList.add(38);
//		newList.add(27);
//		newList.add(43);
//		newList.add(3);
//		newList.add(9);
//		newList.add(82);
//		newList.add(10);
		IntegerList nums = new IntegerList(10, 100);
		nums.mySLOsort();
	}

}

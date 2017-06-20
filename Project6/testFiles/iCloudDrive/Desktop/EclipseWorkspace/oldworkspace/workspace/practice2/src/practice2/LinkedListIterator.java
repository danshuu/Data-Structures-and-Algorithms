package practice2;

import java.util.LinkedList;
import java.util.ListIterator;
import java.io.*;

public class LinkedListIterator {

	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		list.add(42);
		list.add(84);
		list.add(24);
		list.add(144);
		list.add(43);
		list.add(844);
		
		ListIterator<Integer> it = list.listIterator();
//		int lastOne = 0; 
		
		System.out.println(it.next());
		try {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(it.next());
	
			}
			System.out.println(it.previous());
			System.out.println(it.previous());
	//		System.out.println((68/80.0)*100);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Index out of bounds");
		}
	}

}
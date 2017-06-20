//Driver fror Class LinkedList_noIt
import java.util.*;

public class TestLinkedList {

	public static void main(String[] args) 	{
		System.out.println("Creating an integer List:");
		LinkedList_noIt <Integer> nums = new LinkedList_noIt<Integer>();
      Scanner in = new Scanner(System.in);
      System.out.println("Enter value and any letter for exit: ");
      Integer val;
      int idx=0;
      while (in.hasNextInt()){
         val=in.nextInt();
     	   nums.add(idx,val);
         idx++;
      }
		System.out.println("Number of Nodes in List:"+nums.getSize());
		System.out.println("address of list:"+nums);
		System.out.println("List is:");
      nums.printList(nums.getNode(0));
		System.out.println("Remove index 2");
      nums.remove(2);
      nums.printList(nums.getNode(0));
   }//main
}   
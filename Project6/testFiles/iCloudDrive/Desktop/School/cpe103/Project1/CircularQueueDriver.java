/**
* Test driver for circular queue
* 
* @Author Daniel Shu
* @version Project 1CPE103
*/

public class CircularQueueDriver {
	
	public static void main(String[] args) {

      CircularQueue<Integer> q = new CircularQueue<Integer>();

      q.enqueue(37);
      // q.enqueue(38);
      System.out.println(q.size());
      System.out.println(q.peek());

      System.out.println(q.dequeue());

      System.out.println(q.size());

      q.enqueue(37);
      System.out.println(q.size());

      System.out.println(q.peek());

      q.enqueue(-48);
      System.out.println(q.size());
      System.out.println(q.peek());
      System.out.println(q.dequeue());
      System.out.println(q.peek());
      System.out.println(q.size());
	}

}
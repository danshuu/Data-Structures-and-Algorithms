public class SimpleLinkedQueueDriver {
	
	public static void main(String[] args) {

		 SimpleLinkedQueue<Integer> queue = new SimpleLinkedQueue<Integer>();

		 queue.enqueue(5);
		 queue.enqueue(10);
		 queue.dequeue();

		 System.out.println(queue.peek());

	}

}
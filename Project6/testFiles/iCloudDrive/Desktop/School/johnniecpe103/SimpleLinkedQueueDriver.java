
public class SimpleLinkedQueueDriver {

   public static void main(String[] args) {
      SimpleLinkedQueue<Integer> list = new SimpleLinkedQueue<Integer>();
      list.enqueue(1);
      list.enqueue(21);
      list.enqueue(69);
      System.out.println(list.peek());
   }

}

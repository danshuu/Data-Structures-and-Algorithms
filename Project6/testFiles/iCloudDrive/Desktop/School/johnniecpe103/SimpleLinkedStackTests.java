//Johnnie Baba
//CPE 103-07
//Description: this program will test the SimpleLinkedStack program

import org.junit.*;


import static org.junit.Assert.*;

import java.util.NoSuchElementException;

public class SimpleLinkedStackTests {
   
   @Test(expected = NoSuchElementException.class)
   public void error01(){
      SimpleLinkedStack<Integer> s = new SimpleLinkedStack<Integer>();
      s.peek();
   }
   
   @Test(expected = NoSuchElementException.class)
   public void error02(){
      SimpleLinkedStack<Integer> s = new SimpleLinkedStack<Integer>();
      s.pop();
   }
   
   @Test(expected = NoSuchElementException.class)
   public void error03_sizeCheck(){
      SimpleLinkedStack<Integer> s = new SimpleLinkedStack<Integer>();
      s.push(1);
      s.push(2);
      assertEquals(s.size(),2);
      s.pop();
      s.pop();
      s.pop();
   }
   
   @Test
   public void peek01(){
      SimpleLinkedStack<Integer> s = new SimpleLinkedStack<Integer>();
      s.push(1);
      assertEquals((Integer)1, s.peek());
   }
   
   @Test
   public void peek02_sizeCheck(){
      SimpleLinkedStack<Integer> s = new SimpleLinkedStack<Integer>();
      s.push(1);
      s.push(2);
      assertEquals(s.size(), 2);
      assertEquals((Integer)2, s.peek());
   }
   
   @Test
   public void sizeCheck02(){
      SimpleLinkedStack<Integer> s = new SimpleLinkedStack<Integer>();
      s.push(1);
      s.push(2);
      s.push(3);
      s.push(4);
      s.push(5);
      assertEquals(s.size(),5);
   }
   
   @Test
   public void sizeCheck03(){
      SimpleLinkedStack<Integer> s = new SimpleLinkedStack<Integer>();
      s.push(1);
      s.push(2);
      s.push(3);
      s.pop();
      assertEquals(s.size(), 2);
   }
   
   @Test
   public void pop01(){
      SimpleLinkedStack<Integer> s = new SimpleLinkedStack<Integer>();
      s.push(1);
      s.push(2);
      s.push(3);
      s.push(4);
      assertEquals((Integer)4, s.pop());
   }
   
   @Test
   public void pop02(){
      SimpleLinkedStack<Integer> s = new SimpleLinkedStack<Integer>();
      s.push(1);
      s.push(2);
      s.push(3);
      s.push(4);
      s.pop();
      s.pop();
      assertEquals((Integer)2, s.pop());
   }
   
   @Test
   public void pop03_sizeCheck(){
      SimpleLinkedStack<Integer> s = new SimpleLinkedStack<Integer>();
      s.push(1);
      s.push(2);
      s.push(3);
      assertEquals(s.size(),3);
      s.pop();
      assertEquals(s.size(),2);
   }
   
   @Test
   public void pop04(){
      SimpleLinkedStack<Integer> s = new SimpleLinkedStack<Integer>();
      s.push(1);
      s.push(2);
      s.pop();
      s.push(3);
      s.push(4);
      s.pop();
      assertEquals((Integer) 3, s.pop());
   }

}


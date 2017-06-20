//Johnnie Baba
//CPE 103-07
//Description: this program will test the SimpleArrayStack program
import org.junit.*;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

public class SimpleArrayStackTests {
   
   @Test
   public void makeSimpleStack(){
      SimpleArrayStack<Integer> s = new SimpleArrayStack<Integer>();
      s.push(1);
      assertEquals(s.size(), 1);
   }
   
   @Test
   public void makeSimpleStackAgain(){
      SimpleArrayStack<Integer> s = new SimpleArrayStack<Integer>();
      s.push(1);
      s.push(2);
      s.push(3);
      assertEquals(s.size(), 3);
      s.push(5);
      assertEquals(s.size(), 4);
      assertEquals((Integer)5, s.pop());
   }
   @Test(expected = NoSuchElementException.class)
   public void testPopError(){
      SimpleArrayStack<Integer> s = new SimpleArrayStack<Integer>();
      s.pop();

   }
   
   @Test(expected = NoSuchElementException.class)
   public void testPeekError(){
      SimpleArrayStack<Integer> s = new SimpleArrayStack<Integer>();
      s.peek();

   }
   @Test
   public void testCapacity(){
      SimpleArrayStack<Integer> s = new SimpleArrayStack<Integer>();
      assertEquals(s.capacity(), 10);
   }
   
   @Test
   public void fix_for_program4(){
      SimpleArrayStack<Integer> s = new SimpleArrayStack<Integer>();
      s.push(1);
      s.push(2);
      s.push(3);
      assertEquals(s.capacity(), 10);
      assertEquals((Integer)3, s.peek());
      assertEquals(3, s.size());
      s.push(4);
      s.push(5);
      s.push(6);
      assertEquals(s.capacity(), 10);
      assertEquals((Integer)6, s.peek());
      assertEquals(6, s.size());
      s.push(7);
      s.push(8);
      s.push(9);
      assertEquals(s.capacity(), 10);
      assertEquals((Integer)9, s.peek());
      assertEquals(9, s.size());
      s.push(10);
      assertEquals(10,s.size());
      assertEquals((Integer)10, s.peek());
      assertEquals(10, s.capacity());
      


      

   }
   
   
   @Test
   public void fix_for_program4_02(){
      SimpleArrayStack<Integer> s = new SimpleArrayStack<Integer>();
      s.push(1);
      s.push(2);
      s.push(3);
      assertEquals(s.capacity(), 10);
      assertEquals((Integer)3, s.peek());
      assertEquals(3, s.size());
      s.push(4);
      s.push(5);
      s.push(6);
      assertEquals(s.capacity(), 10);
      assertEquals((Integer)6, s.peek());
      assertEquals(6, s.size());
      s.push(7);
      s.push(8);
      s.push(9);
      assertEquals(s.capacity(), 10);
      assertEquals((Integer)9, s.peek());
      assertEquals(9, s.size());
      s.push(10);
      assertEquals(10,s.size());
      assertEquals((Integer)10, s.peek());
      assertEquals(10, s.capacity());
      s.pop();
      s.pop();
      s.pop();
      s.pop();
      s.pop();
      s.pop();
      s.pop();
      s.pop();
      s.pop();
      assertEquals((Integer)1, s.pop());
      assertEquals(0, s.size());
      assertEquals(10, s.capacity());
      
   }

}

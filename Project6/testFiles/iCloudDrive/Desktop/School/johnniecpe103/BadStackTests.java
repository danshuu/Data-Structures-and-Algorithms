//Johnnie Baba
//CPE 103-07
//Description: This is used to tests the BadStack program
import org.junit.*;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

public class BadStackTests {
   
   @Test
   public void makeSimpleStack(){
      BadStack<Integer> s = new BadStack<Integer>();
      s.push(1);
      assertEquals(s.size(), 1);
   }
   
   @Test
   public void popOne(){
      BadStack<Integer> b = new BadStack<Integer>();
      b.push(1);
      assertEquals((Integer) 1, b.pop());
      assertEquals(b.size(), 0);
   }
   
   @Test
   public void makeSimpleStackAgain(){
      BadStack<Integer> s = new BadStack<Integer>();
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
      BadStack<Integer> s = new BadStack<Integer>();
      s.pop();

   }
   
   @Test(expected = NoSuchElementException.class)
   public void testPeekError(){
      BadStack<Integer> s = new BadStack<Integer>();
      s.peek();

   }

}

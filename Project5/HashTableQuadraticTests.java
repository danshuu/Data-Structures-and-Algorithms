/**
 * JUnit tests for HashTableQuadratic
 *
 * @author Daniel Shu
 * @version CPE 103 Program 5
 */
import static org.junit.Assert.*;
import org.junit.*;

public class HashTableQuadraticTests {

   @Test
   public void basicCollisionsMaxCollisionsDuplicatesTest() {
      HashTableQuadratic<Integer> table = new HashTableQuadratic<Integer>(200); // Next prime is 211
      Integer i1 = new Integer(522);

      assertTrue(table.isEmpty());
      assertEquals(211, table.tableSize());

      for (int i = 11; i < 101; i++) {
         assertEquals(null, table.add(i));
      }   
      assertEquals(null, table.add(311)); // Hashes to 100, goes to 101
      assertEquals(1, table.collisions());
      assertEquals(1, table.maxCollisions());
      assertEquals(null, table.add(i1)); // Hashes to 100 goes to 104
      assertEquals(3, table.collisions());
      assertEquals(2, table.maxCollisions());
      assertTrue(i1 == table.add(522)); // Hashes to 100 goes to 104
      assertEquals(5, table.collisions());
      assertEquals(2, table.maxCollisions());
      assertTrue(table.contains(522));
      assertTrue(table.remove(522));
      assertFalse(table.contains(522));
      assertEquals(91, table.size()); 
      assertEquals(91.0/211, table.loadFactor(), .000001);
   }

   @Test
   public void emptyTest() {
      HashTableQuadratic<Integer> ht = new HashTableQuadratic<Integer>(10); // Next prime is 11
      assertEquals(ht.size(), 0);
      assertEquals(ht.tableSize(), 11);
      assertEquals(ht.collisions(), 0);
      assertEquals(ht.maxCollisions(), 0);
      assertFalse(ht.contains(5));
   }

   @Test
   public void addRemoveTest() {
      HashTableQuadratic<Integer> ht = new HashTableQuadratic<Integer>(10); // Next prime 11
      assertEquals(ht.tableSize(), 11);
      ht.add(68);
      ht.add(73);
      ht.add(7);
      ht.add(84);
      ht.add(119);
      ht.add(195);
      ht.add(172);
      assertEquals(ht.size(), 7);
      assertEquals(ht.collisions(), 6);
      assertEquals(ht.maxCollisions(), 2);
      assertFalse(ht.contains(5));
      assertTrue(ht.remove(68));
      assertEquals(ht.size(), 6);
      assertTrue(ht.remove(172));
      assertEquals(ht.size(), 5);
      assertFalse(ht.contains(68));
      assertFalse(ht.contains(172));
      assertTrue(ht.contains(7));

   }
} 

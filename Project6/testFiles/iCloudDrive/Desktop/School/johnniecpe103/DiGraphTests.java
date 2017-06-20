//Johnnie Baba
//CPE 103-07
//Lab 13

import java.io.FileNotFoundException;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;


public class DiGraphTests {
   
   @Test
   public void setStart_v1() throws FileNotFoundException{
      
      DiGraph dg = new DiGraph( "inputText9.txt" );
      dg.setStart( "v1" );
      assertTrue( dg.getDistanceTo( "v4" ) == 1 );
      assertTrue( dg.getDistanceTo( "v2" ) == 2 );
      assertTrue( dg.getDistanceTo( "v3" ) == 3 );
      assertTrue( dg.getDistanceTo( "v5" ) == 3 );
      assertTrue( dg.getDistanceTo( "v6" ) == 6 );
      assertTrue( dg.getDistanceTo( "v7" ) == 5 );
   }
   
   @Test
   public void setStart_v1_prior() throws FileNotFoundException{
      DiGraph dg = new DiGraph( "inputText9.txt" );
      dg.setStart( "v1" );
      assertEquals( dg.getPathTo( "v7" ), "v1 v4 v7");
      assertEquals( dg.getPathTo( "v3" ) ,"v1 v4 v3" );
      
   }

}

//Johnnie Baba
//CPE 103-07
//Description: this program will test the RPN program

import org.junit.*;


import static org.junit.Assert.*;

import java.util.NoSuchElementException;


public class RPNTests {
   
   
   @Test
   public void rpnEval_01(){
      String exp = "5 1 2 + +";
      assertEquals((Double) 8.0, (Double)RPN.evaluateRPN(exp));   //call RPN's eval RPN method
      
   }
   
   @Test
   public void rpnEval_02(){
      String exp = "5 1 + 2 - 6 * 4 /";
      assertEquals((Double) 6.0, (Double)RPN.evaluateRPN(exp));
   }
   
   @Test
   public void rpnEval_03(){
      String exp = "5.0 5 1 2 + * * 7 * 5 /";
      assertEquals( 105.0, RPN.evaluateRPN(exp), .000001);
   }
   
   @Test
   public void rpnEval_04(){
      String exp = "21 3 + 7 / 3 - 21 1 + 8 * *";
      assertEquals(75.4285715, RPN.evaluateRPN(exp),.000001);
   }
   
   @Test
   public void infix_toRpn_01(){
      String nfx = "5 + ( 1 + 2 )";
      assertEquals("5 1 2 + +", RPN.toRPN(nfx));
   }
   
   @Test
   public void infix_toRpn_02(){
      String nfx = "5 * 2";
      assertEquals("5 2 *", RPN.toRPN(nfx));
      
   }
   @Test
   public void infix_toRpn_03(){
      String nfx = "1 * 2 * 3";
      assertEquals("1 2 * 3 *", RPN.toRPN(nfx));
   }
   @Test
   public void infix_toRpn_04(){
      String nfx = "1 * 2 / 3";
      assertEquals("1 2 * 3 /", RPN.toRPN(nfx));
   }
   
   @Test
   public void infix_toRpn_05(){
      String nfx = "( 1 + 2 ) * ( 3 + 4 ) - ( 5 + 6 ) + 7 / 8";
      assertEquals("1 2 + 3 4 + * 5 6 + - 7 8 / +",RPN.toRPN(nfx));
   }
   
   @Test
   public void infix_toRpn_06(){
      String nfx = "1 * 2 / 3 * 4 / 6";
      assertEquals("1 2 * 3 / 4 * 6 /",RPN.toRPN(nfx));
   }
   
   @Test
   public void infix_toRpn_07(){
      String nfx ="1 * ( 1 + 2 ) * 3";
      assertEquals("1 1 2 + * 3 *", RPN.toRPN(nfx));
   }
   
   @Test
   public void infix_toRpn_08(){
      String nfx = "( 1 + 2 + 3 + 4 + 5 )";
      assertEquals("1 2 + 3 + 4 + 5 +", RPN.toRPN(nfx));
   }
   
   @Test
   public void infix_toRpn_09(){
      String nfx = "( 1 + 2 )";
      assertEquals("1 2 +", RPN.toRPN(nfx));
   }
   
   @Test
   public void infix_toRpn_10(){
      String nfx = "( ( 1 + 2 ) )";
      assertEquals("1 2 +", RPN.toRPN(nfx));

   }
   @Test
   public void infix_toRpn_11(){
      String nfx = "( ( 1 + 2 ) + ( ( 3 + 4 ) ) )";
      assertEquals("1 2 + 3 4 + +",RPN.toRPN(nfx));
   }
   
   @Test
   public void infix_toRpn_12(){
      String nfx = "1 + ( 2 + ( 3 + 4 ) + 5 * ( 6 + 7 ) )";
      assertEquals("1 2 3 4 + + 5 6 7 + * + +", RPN.toRPN(nfx));
   }
   
   @Test
   public void infix_toRpn_13(){
      String nfx = "1 * 2 + 3 * ( 1 + 2 * 3 + ( 5 + 6 ) )";
      assertEquals("1 2 * 3 1 2 3 * + 5 6 + + * +", RPN.toRPN(nfx));
   }
   
   @Test
   public void infix_toRpn_eval_01(){
      String nfx = "1 * ( 1 + 2 ) * 3";
      assertEquals((Double) 9.0, (Double) RPN.evaluateInfix(nfx));
   }
   @Test
   public void infix_toRpn_eval_02(){
      String nfx ="1 + ( 2 * 3 ) * 5";
      assertEquals((Double) 31.0, (Double)RPN.evaluateInfix(nfx));
   } 
   @Test
   public void infix_toRpn_eval_03(){
      String nfx = "1 + ( 2 * ( 3 + 4 ) ) * 5";
      assertEquals((Double) 71.0, (Double) RPN.evaluateInfix(nfx));
   }

}

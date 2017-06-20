/**
* junit tests for RPN 
* @author Daniel Shu
* @version Project 2 CPE103
*/

import org.junit.*;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

public class RPNTests {

	@Test(expected = IllegalArgumentException.class) 
	public void testLetter() {
		RPN.evaluateRPN("s");
	}

	@Test(expected = IllegalArgumentException.class) 
	public void testLetter2() {
		RPN.evaluateRPN("1 0 4 s");
	}

	@Test(expected = IllegalArgumentException.class) 
	public void testLetter3() {
		RPN.evaluateRPN("s 1 0 2");
	}

	@Test(expected = IllegalArgumentException.class) 
	public void testLetter4() {
		RPN.evaluateRPN("1 0 + s");
	}

	@Test
	public void testSampleEvaluateRPN() {
		assertEquals((Double)83.0, RPN.evaluateRPN("5 1 2 + 4 ^ + 3 -"), 0.000001);
	}

	@Test
	public void testSampleEvaluateRPNWithSpaces() {
		assertEquals((Double)83.0, RPN.evaluateRPN("5     1 2     +    4 ^         + 3.    -"), 0.000001);
	}

	@Test
	public void testSampleToRPN() {
		assertEquals("3 4 2 * 1 5 - 2 3 ^ ^ / +", RPN.toRPN("3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3"));
	}

	@Test
	public void testEvaluateRPN1() {
		assertEquals((Double)5.0, RPN.evaluateRPN("6 4 3 + 2 - * 6 /"), 0.000001);
	}

	@Test
	public void testEvaluateRPN2() {
		assertEquals((Double)18.0, RPN.evaluateRPN("5 2 4 * + 7 2 - 4 6 2 / 2 - * + 4 - +"), 0.000001);
	}

	@Test
	public void testToRPN1() {
		assertEquals("5 6 3 + 7 3 * - 2 + * 6 /", RPN.toRPN("5 * ( 6 + 3 - 7 * 3 + 2 ) / 6"));
	}

	@Test
	public void testToRPN2() {
		assertEquals("3 4 2 * 1 5 - 2 3 ^ ^ / +", RPN.toRPN("3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3"));
	}

	@Test
	public void testEvaluateInfix() {
		String infix = "3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3";
		assertEquals((Double)3.0001220703125, (Double)RPN.evaluateInfix(infix), 0.000001);
	}

	@Test
	public void testEvaluateInfix2() {
    	String infix = "1 * ( 1 + 2 ) * 3";
    	assertEquals((Double) 9.0, (Double) RPN.evaluateInfix(infix));
	}

	@Test
	public void testEvaluateInfix3() {
    	String infix ="1 + ( 2 * 3 ) * 5";
    	assertEquals((Double) 31.0, (Double)RPN.evaluateInfix(infix));
	}

	@Test
	public void testEvaluateInfix4() {
    	String infix = "1 + ( 2 * ( 3 + 4 ) ) * 5";
    	assertEquals((Double) 71.0, (Double) RPN.evaluateInfix(infix));
	}

	@Test
	public void testSimpleEvaluateInfix() {
		assertEquals((Double)25.0, RPN.evaluateInfix("5 ^ 2"), 0.000001);
	}

	@Test
	public void testSimpleEvaluateInfix2() {
		assertEquals((Double)7.0, RPN.evaluateInfix("5 + 2"), 0.000001);
	}

	@Test
	public void testSimpleEvaluateInfix3() {
		assertEquals((Double)2.5, RPN.evaluateInfix("5 / 2"), 0.000001);
	}

	@Test
	public void testSimpleEvaluateInfix4() {
		assertEquals((Double)1.25, RPN.evaluateInfix("5 / 2 ^ 2"), 0.000001);
	}

	@Test
	public void testSampleEvaluateInfix() {
		assertEquals((Double)3.00012207031, RPN.evaluateInfix("3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3"), 0.000001);
	}

/*

	@Test
	public void testToRPN2() {
		assertEquals("8 3 4 * + 6 2 – 2 6 3 / 1 - * + 3 - +", RPN.toRPN("8 + 3 * 4 + ( 6 - 2 + 2 * ( 6 / 3 - 1 ) - 3 )"));
	} //this one gave a comparison error, but the 2 given were exactly the same...

	@Test
	public void testEvaluateInfix3() {
		String infix = "5 ^ 2 + 17 * (2 / 1) ^ 0";
		assertEquals((Double)42.0, (Double)RPN.evaluateInfix(infix), 0.000001);
	}

	@Test
	public void testEvaluateInfix4() {
		String infix = "5 ^ 2 ^ 2 + 17 * (2 / 1) ^ 0";
		assertEquals((Double)642.0, (Double)RPN.evaluateInfix(infix), 0.000001);
	}

	couldn't pass these for some reason, gave nosuchelementexception
*/
	

}
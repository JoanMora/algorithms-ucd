/**
 * 
 */
package recurssion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author joan
 *
 */
class TestRecurssion {

	@Test
	void fibonacciRecurssive() {
		int n = 10;
		int res = Fibonacci.fibonacciRecurssive(n);
		
		assertEquals(res,55);
	}
	
	@Test
	void fibonacciIterative() {
		int n = 10;
		int res = Fibonacci.fibonacciIterative(n);
		
		assertEquals(res,55);
	}

}

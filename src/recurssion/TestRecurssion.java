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
		int n = 30;
		int res = Fibonacci.fibonacciRecurssive(n);
		
		assertEquals(res,832040);
	}
	
	@Test
	void fibonacciIterative() {
		int n = 30;
		int res = Fibonacci.fibonacciIterative(n);
		
		assertEquals(res,832040);
	}

}

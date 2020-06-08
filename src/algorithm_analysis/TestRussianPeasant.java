/**
 * 
 */
package algorithm_analysis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author joan
 *
 */
class TestRussianPeasant {

	@Test
	void russianMultiplicationTest() {
		long multiplier = 238, multiplicand = 13;
		long hypothesis = RussianPeasant.russianMultiplication(multiplier, multiplicand);
		
		assertTrue(hypothesis == 3094);
	}

}

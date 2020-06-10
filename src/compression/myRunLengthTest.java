/**
 * 
 */
package compression;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author joan
 *
 */
class myRunLengthTest {

	@Test
	void testMyRunLengthCompression() {
		String expected = "a4b5";
		String input = "aaaabbbbb";
		String actual = MyRunLength.compress(input);
		
		assertEquals(expected, actual);
	}

}

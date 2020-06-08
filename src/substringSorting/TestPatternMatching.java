package substringSorting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPatternMatching {

	@Test
	void testBruteForce() {
		String text = "This is a random text to test the brute force implementation.";
		int times = PatternMatching.bruteForce(text, "tex", true);
		assertTrue(times == 1);
	}

}

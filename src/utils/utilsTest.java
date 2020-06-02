package utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class utilsTest {

	@Test
	void testSortedArray() {
		Integer[] sortedArray = {1,2,3,4,5,6};
		
		boolean b = Utils.isSorted(sortedArray);
		
		assertTrue( b == true);
	}
	
	@Test
	void testminimumPos() {
		Integer[] sortedArray = {1,2,3,4,5,6};
		
		assertTrue( 0 == Utils.minimumPos(sortedArray) );
	}
	
	@Test
	void testShiftElements() {
		Integer[] sortedArray = {1,2,3,4,5,6};
		Utils.shiftElements(sortedArray, 2, 4);
		
		Integer[] resultingArray = {1,2,5,3,4,6};
		assertArrayEquals( resultingArray, sortedArray);
	}

}

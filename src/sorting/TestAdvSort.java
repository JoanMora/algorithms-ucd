package sorting;
import utils.Utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestAdvSort {

	@Test
	void testMergeSort() {
		Integer[] array = {99,1,0,5,5,6,98,54,2,7,104};
		
		AdvancedSorting.mergeSort(array);
		
		assertTrue(Utils.isSorted(array));
	}
	
	@Test
	void testQuickSort() {
		Integer[] array = {99,1,0,5,5,6,98,54,2,7,104};
		
		AdvancedSorting.quickSort(array);
		
		assertTrue(Utils.isSorted(array));
	}

	@Test
	void testenhancedQuickSort() {
		Integer[] array = {99,1,0,5,5,6,98,54,2,7,104};
		
		AdvancedSorting.enhancedQuickSort(array);
		
		assertTrue(Utils.isSorted(array));
	}
}

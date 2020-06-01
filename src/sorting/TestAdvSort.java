package sorting;
import utils.Utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestAdvSort {

	@Test
	void testMergeSort() {
		Integer[] array = {99,1,0,5,5,6,98,54,2,7,104};
		
		AdvSort.mergeSort(array);
		
		assertTrue(Utils.isSorted(array));
	}

}

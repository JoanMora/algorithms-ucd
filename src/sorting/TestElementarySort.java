package sorting;
import utils.Utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestElementarySort {
	

	@Test
	public void testInsertionSort() {
		
		Integer[] array = {99,1,0,5,5,6,98,54,2,7,104};
		ElementarySorting.insertionSort(array);
		
		assertTrue( Utils.isSorted(array) );
		
		
	}

}

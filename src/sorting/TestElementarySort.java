package sorting;
import utils.Utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestElementarySort {
	
	public static Integer[] mockArray() {
		Integer[] array = {99,1,0,5,5,6,98,54,2,7,104};
		
		return array;
	}
	

	@Test
	public void testInsertionSort() {
		
		Integer[] array = mockArray();
 		ElementarySorting.insertionSort(array);
		
		assertTrue( Utils.isSorted(array) );
		
		
	}
	
	@Test
	public void testSelectionSort() {
		
		Integer[] array = mockArray();
		ElementarySorting.selectionSort(array);
		
		assertTrue( Utils.isSorted(array) );
		
		
	}

}

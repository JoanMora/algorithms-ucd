package sorting;

import java.util.Arrays;
import utils.Utils;

/**
 * @author joan
 *
 */
public class ElementarySorting {

	public static void insertionSort(Integer[] array) {

		insertionSort(array, 0, array.length-1);
	}
	
	protected static void insertionSort(Integer[] array, int start, int end) {
		for (int pivot = start; pivot <= end; pivot++) {
			for (int j = 0; j <= pivot; j++) {
				if (array[pivot] < array[j]) {
					// insert in position j and shift the rest of the array
					Utils.shiftElements(array, j, pivot);
				}
			}
		}
	}

	public static void selectionSort(Integer[] array) {

		for (int i = 0; i < array.length; i++) {
			// 1 and 2 Find the smallest card in the remaining unsorted part
			int index_smallest = i + Utils.minimumPos(Arrays.copyOfRange(array, i, array.length));
			Utils.swap(array, i, index_smallest);
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
 

}

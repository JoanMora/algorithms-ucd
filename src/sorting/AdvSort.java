package sorting;
import java.util.*;
import utils.Utils;

/**
 * @author joan
 *
 */
public class AdvSort {
	
	private static int CUTOFF = 10;
	
	public static void mergeSort(Integer[] array) {
		mergeSort(array,0,array.length-1);
	}
	
	public static void quickSort(Integer[] array) {
		quickSort(array,0,array.length-1);
	}
	
	public static void enhancedQuickSort(Integer[] array) {
		enhancedQuickSort(array,0,array.length-1);
	}
	
	private static void mergeSort(Integer[] array, int start, int end) {
		// base case
		if(start >= end) return;
		
		// inductive case
		else {
		
			int mid = (start+end) / 2;
			
		
			mergeSort(array, start, mid);
			mergeSort(array, mid+1, end);
			
			// Skip merge if array already ordered
			if(array[mid] > array[mid+1]) {
				merge(array, start, end);
			}
			
		}
	}
	
	private static void merge(Integer[] array, int start, int end) {
		
		// Avoid overhead when merging small arrays improvement 
		if(end <= start+CUTOFF) {
			ElementarySorting.insertionSort(array,start,end);
		}
		else {
			int mid = (start+end) / 2;
			Integer[] left = Arrays.copyOfRange(array,start,mid+1);
			Integer[] right = Arrays.copyOfRange(array,mid+1,end+1);

			
			int i=0, j=0, k=start;
			
			// j is the right counter
			// i is the left counter
			while( j<right.length && i<left.length) {
				if(left[i] <= right[j]) {
					array[k] = left[i];
					i++;
				}
				else {
					array[k] = right[j];
					j++;
				}
				k++;
			}
			
	
			// copy the left side
			while(i<left.length) {
				array[k] = left[i];
				k++; i++;
			}
			
			// copy the right side
			while(j<right.length) {
				array[k] = right[j];
				k++; j++;
			}
			
		}
	}
	
	private static void quickSort(Integer[] array, int start, int end) {
		if(start < end ) {
			int p = end; // our pivot is the last element
			partitionOperation(array, start, end, p);
			
			// pivot is in its right place
			quickSort(array, start, p-1);
			quickSort(array, p+1, end);
		}
	}
	
	private static void partitionOperation(Integer[] array, int start, int end, int p) {		

		int i = start - 1;
		int j = start; // goes from start to end-1
		
		while(j<end) {
			if(array[j] < array[p]) {
				i++;
				Utils.swap(array, i, j);
			}
			j++;
		}
		
		// pivot should be in i+1 position
		Utils.shiftElements(array, i+1, p);
	}
	
	private static void enhancedQuickSort(Integer[] array, int start, int end) {
		
		if(end <= start+CUTOFF) {
			ElementarySorting.insertionSort(array,start,end);
		}
		else {
			Utils.shuffle(array);
			int p = (start+end) / 2;
			medianOfThree(array,start,end);
			
			partitionOperation(array, start, end, p);
			
			// pivot is in its right place
			quickSort(array, start, p-1);
			quickSort(array, p+1, end);
			
		}
	}
	
	private static void medianOfThree(Integer[] array, int start, int end) {
		int m = (start+end) / 2;
		
		Integer[] elements = { array[start], array[m], array[end] };
		ElementarySorting.insertionSort(elements);
		
		array[start] = elements[0];
		array[m] = elements[1];
		array[end] = elements[2];
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] array = {99,1,0,5,5,6,98,54,2,7,104};
		AdvSort.enhancedQuickSort(array);
		Utils.printArray(array);
	}

}

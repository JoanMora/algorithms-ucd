package sorting;
import java.util.*;
import utils.Utils;

/**
 * @author joan
 *
 */
public class AdvSort {
	
	public static void mergeSort(Integer[] array) {
		mergeSort(array,0,array.length-1);
	}
	
	public static void quickSort(Integer[] array) {
		quickSort(array,0,array.length-1);
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
		
		int numberOfElements = end-start+1;
		
		// Avoid overhead when merging small arrays improvement 
		if((numberOfElements) <= 10) {
			mergeInsertion(array,start,end);
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
	
	/* Perform insertion for sub arrays*/
	private static void mergeInsertion(Integer[] array, int start, int end) {
		
		int numberOfElements = end-start+1;
		
		Integer[] arrayCopy = Arrays.copyOfRange(array,start,end+1);
		ElementarySorting.insertionSort(arrayCopy);
		
		
		for(int i=0; i<numberOfElements; i++) {
			array[start+i] = arrayCopy[i];
		}
		
	}
	
	/*
	
	
	private static void quickSort(Integer[] array, int start, int end) {
		if(start < end) {
			int pivot = partition(array,start,end);
			
			// Place pivot at position high - 1
            Utils.swap( array, start, end - 1 );
			
			// Begin partitioning
            int i, j;
            for( i = start, j = end - 1; ; ) {
                while( array[ ++i ] < array[pivot]);
                System.out.println(j);
                while( array[pivot] < array[j--]);
                if( i >= j )
                    break;
                Utils.swap(array, i, j );
            }
             
            // Restore pivot
            Utils.swap( array, i, end - 1 );
			
			quickSort(array,start,pivot - 1);
			quickSort(array,pivot + 1, end);
		}
	}
	
	private static int partition(Integer[] array, int start, int end) {
		Integer pivot = array[end];
		//int pivot = pivotMedian(array, start, end);
		
		int i = start - 1;
		for(int j=start; j<=end-1; j++) {
			if(array[j] < pivot) {
				i++;
				Utils.swap(array, i, j);
			}
		}
		
		Utils.swap(array, i+1, end);
		
		return i + 1;
	}
	
	*/
	
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] array = {99,1,0,5,5,6,98,54,2,7,104};
		AdvSort.quickSort(array);
		Utils.printArray(array);
	}

}

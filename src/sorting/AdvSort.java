package sorting;
import java.util.*; 

/**
 * @author joan
 *
 */
public class AdvSort {
	
	public static void mergeSort(Integer[] array) {
		mergeSort(array,0,array.length-1);
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

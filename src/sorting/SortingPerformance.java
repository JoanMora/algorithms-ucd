/**
 * 
 */
package sorting;
import java.util.ArrayList;
import java.util.Random;

import utils.StdOut;

// import utils.Utils;

/**
 * @author joan
 *
 */
public class SortingPerformance {
	
	private static ArrayList<Integer[]> samples = new ArrayList<Integer[]>();
	
	private static final int MAX_SIZE = 16384; // 2^15, 15 samples for the experiment
	
	public static void createSamples() {
		for(int n=4; n<=MAX_SIZE; n*=2 ) {
			samples.add(generateArray(n));
		}
	}
	
	private static Integer[] generateArray(int size) {
		Random rd = new Random(); // creating Random object
		Integer[] array = new Integer[size];
		for (int i = 0; i < array.length; i++) {
			array[i] = rd.nextInt(); // storing random integers in an array
			
		}
		return array;
	}
	
	private static long performanceEvaluation(Runnable r) {
		long startTime, elapsedTime;
		startTime = System.nanoTime();
		r.run();
		elapsedTime = System.nanoTime() - startTime;
		return elapsedTime;
	}
	
	public static void selectionSortPerformance() {
		System.out.println("\n----SELECTION SORT PERFORMANCE EVALUATION----");
		StdOut.printf("\n%10s\t%20s", "Size (n)", "Time (ns)\n");
		for(Integer[] sample: samples) {
			long t = performanceEvaluation(() -> ElementarySorting.selectionSort(sample));
			StdOut.printf("\n%10s\t%20s", sample.length, t);
		}
		System.out.println();
	}
	
	public static void insertionSortPerformance() {
		System.out.println("\n----INSERTION SORT PERFORMANCE EVALUATION----");
		StdOut.printf("\n%10s\t%20s\n", "Size (n)", "Time (ns)\n");
		for(Integer[] sample : samples) {
			long t = performanceEvaluation(() -> ElementarySorting.insertionSort(sample));
			StdOut.printf("\n%10s\t%20s", sample.length, t);
		}
		System.out.println();
	}
	
	private static void sillySortPerformance() {
		System.out.println("\n----Silly SORT PERFORMANCE EVALUATION----");
		StdOut.printf("\n%10s\t%20s\n", "Size (n)", "Time (ns)\n");
		for(Integer[] sample : samples) {
			long t = performanceEvaluation(() -> SillySorts.bogoSort(sample));
			StdOut.printf("\n%10s\t%20s", sample.length, t);
		}
		System.out.println();
	}
	
	@SuppressWarnings("unused")
	private static void elementarySortingPerformance() {
		createSamples();
		selectionSortPerformance();
		insertionSortPerformance();
		sillySortPerformance();
	}
	
	public static void mergeSortPerformance() {
		System.out.println("\n----MERGE SORT PERFORMANCE EVALUATION----");
		StdOut.printf("\n%10s\t%20s\n", "Size (n)", "Time (ns)\n");
		for(Integer[] sample : samples) {
			long t = performanceEvaluation(() -> AdvancedSorting.mergeSort(sample));
			StdOut.printf("\n%10s\t%20s", sample.length, t);
		}
		System.out.println();
	}
	
	public static void enhancedMergeSortPerformance() {
		System.out.println("\n----MERGE SORT ENHANCED PERFORMANCE EVALUATION----");
		StdOut.printf("\n%10s\t%20s\n", "Size (n)", "Time (ns)\n");
		for(Integer[] sample : samples) {
			long t = performanceEvaluation(() -> AdvancedSorting.enhancedMergeSort(sample));
			StdOut.printf("\n%10s\t%20s", sample.length, t);
		}
		System.out.println();
	}
	
	public static void enhancedQuickSortPerformance() {
		System.out.println("\n----QUICK SORT ENHANCED PERFORMANCE EVALUATION----");
		StdOut.printf("\n%10s\t%20s\n", "Size (n)", "Time (ns)\n");
		for(Integer[] sample : samples) {
			long t = performanceEvaluation(() -> AdvancedSorting.enhancedQuickSort(sample));
			StdOut.printf("\n%10s\t%20s", sample.length, t);
		}
		System.out.println();
	}
	
	
	public static void quickSortPerformance() {
		System.out.println("\n----QUICK SORT PERFORMANCE EVALUATION----");
		StdOut.printf("\n%10s\t%20s\n", "Size (n)", "Time (ns)\n");
		for(Integer[] sample : samples) {
			long t = performanceEvaluation(() -> AdvancedSorting.quickSort(sample));
			StdOut.printf("\n%10s\t%20s", sample.length, t);
		}
		System.out.println();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		createSamples();
		elementarySortingPerformance();
		insertionSortPerformance();
		mergeSortPerformance();
		enhancedMergeSortPerformance();
		quickSortPerformance();
		enhancedQuickSortPerformance();
	}

}

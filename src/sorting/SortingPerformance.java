/**
 * 
 */
package sorting;
import java.util.Random;

/**
 * @author joan
 *
 */
public class SortingPerformance {
	
	private static Integer[] generateArray(int size) {
		Random rd = new Random(); // creating Random object
		Integer[] array = new Integer[size];
		for (int i = 0; i < array.length; i++) {
			array[i] = rd.nextInt(); // storing random integers in an array
			
		}
		return array;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}

}

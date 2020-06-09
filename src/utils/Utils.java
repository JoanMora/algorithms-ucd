package utils;

public class Utils {
	
	@SuppressWarnings("rawtypes")
	public static void printArray(Comparable[] array) {
		for(Comparable e: array) {
			System.out.print(e);
			System.out.print(" ");
		}
		System.out.println("-------");
	}
	
	@SuppressWarnings("rawtypes")
	public static void swap(Comparable[] array, int i, int j) {
		Comparable temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	@SuppressWarnings("rawtypes")
	public static void shuffle(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            // choose index uniformly in [0, i]
            int r = (int) (Math.random() * (i + 1));
            Comparable swap = a[r];
            a[r] = a[i];
            a[i] = swap;
        }
    }
	
	/*
	 * start < end
	 */
	@SuppressWarnings("rawtypes")
	public static void shiftElements(Comparable[] array, int index_to_insert, int index_value_to_insert) {
		Comparable value_to_insert = array[index_value_to_insert];
		Comparable to_shift = array[index_to_insert];
		for (int i = index_to_insert; i < index_value_to_insert; i++) {
			Comparable temp = array[i + 1];
			array[i + 1] = to_shift;
			to_shift = temp;
		}
		array[index_to_insert] = value_to_insert;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static int minimumPos(Comparable[] array) {
		Comparable min = array[0];
		int min_pos = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i].compareTo(min) < 0) {
				min = array[i];
				min_pos = i;
			}
		}
		return min_pos;
	}
	
	// **helper function to check if your array is sorted or not
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public static boolean isSorted(Comparable[] nums) {
			for (int i = 0; i < nums.length - 1; i++) {
				if ( nums[i].compareTo(nums[i + 1]) > 0) {
					return false;
				}
			}
			return true;
		}

}

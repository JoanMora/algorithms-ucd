package utils;

public class Utils {
	
	public static void printArray(Comparable[] array) {
		for(Comparable e: array) {
			System.out.print(e);
			System.out.print(" ");
		}
		System.out.println("-------");
	}
	
	public static void swap(Comparable[] array, int i, int j) {
		Comparable temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}

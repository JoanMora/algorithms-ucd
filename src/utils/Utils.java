package utils;

public class Utils implements {
	
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
	
	public static void main(String[] args) {
		Integer[] a = {1,2,3,4,5};
		shuffle(a);
		
		printArray(a);
	}

}

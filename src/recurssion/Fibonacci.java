package recurssion;

public class Fibonacci {
	/*
	 * @param n element n of the Fibonacci succession.
	 * @return value of the n element of the succession.
	 */
	public static int fibonacciIterative(int n) {
		if(n<1) return 0;
		
		int an = 1;
		int an_prev = 0;
		
		for(int i = 1; i < n; i++) {
			int temp = an;
			an += an_prev;
			an_prev = temp;
		}
		return an;
	}
	
	/*
	 * Precondition n > 1
	 */
	public static int fibonacciRecurssive(int n) {
		// Base Case
		if(n == 1) {
			return 1;
		}
		else if(n == 0){
			return 0;
		}
		// Inductive Case
		else {
			return fibonacciRecurssive(n-1) + fibonacciRecurssive(n-2);
		}
	}
}

package recurssion;

import utils.StdOut;

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
	
	private static void evaluatePerformance(int size) {
		long startTime, ans, elapsedTimeIterative, elapsedTimeRecursive;
		StdOut.printf("\n%10s\t%10s\t%20s\t%20s", "Size (n)", "Result", "Time Iterative (ns)", "Time Iterative(ns)\n");
		System.out.println();
		for(int n=1; n<=size; n++) {
			startTime = System.nanoTime();
            ans = fibonacciIterative(n);
            elapsedTimeIterative = System.nanoTime() - startTime;
            
            startTime = System.nanoTime();
            ans = fibonacciRecurssive(n);
            elapsedTimeRecursive = System.nanoTime() - startTime;
            
            StdOut.printf("%8d\t%8d\t%8d\t%8d\n", n, ans, elapsedTimeIterative, elapsedTimeRecursive);
		}
	}
	
	public static void main(String[] args) {
		evaluatePerformance(30);
	}
}

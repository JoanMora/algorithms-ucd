/**
 * @author Joan Mora Grau
 *
 */
package algorithm_analysis;

import utils.StdIn;
import utils.StdOut;

public class RussianPeasant {
	
	public static long russianMultiplication (long multiplier, long multiplicand) {
		long result = 0;
		while( multiplicand > 0) {
			if( multiplicand % 2 == 1) result += multiplier;
			multiplicand /= 2;
			multiplier *= 2;
		}
		return result;
	}


		private static void evaluatePerformance() {
	        StdOut.printf("\n%8s\t%8s\t%15s\t\t%8s", "Multiplier", "Multiplicand", "Product", "Time (ns)\n");
	        int i = 2;
	        while (i < (int) (Math.pow(2, 20))) {
	            long startTime = System.nanoTime();
	            long ans = russianMultiplication(i, (i+3));
	            long elapsedTime = System.nanoTime() - startTime;
	            StdOut.printf("%8d\t%8d\t%15d\t%8d\n", i, i+3, ans, elapsedTime);
	            i *= 3;
	        }
	    }
		
		
	public static void main(String[] args) {
		evaluatePerformance();

	}

}

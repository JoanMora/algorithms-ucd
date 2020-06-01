/**
 * @author Joan Mora Grau
 *
 */
package algorithmAnalysis;

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

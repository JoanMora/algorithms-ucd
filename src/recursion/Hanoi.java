/**
 * 
 */
package recursion;

/**
 * @author joan
 *
 */
public class Hanoi {
	public static void towersOfHanoi(int n, String source, String destination, String auxiliary) {
		if (n == 1) {
			//base case
			System.out.println("Move disk 1 from " + source + " to " + destination);
			return;
		}
		towersOfHanoi(n-1, source, auxiliary, destination);
	              System.out.println("Move disk " + n + " " + source + " to " + destination); 
		towersOfHanoi(n-1, auxiliary, destination, source);
		
	}
}

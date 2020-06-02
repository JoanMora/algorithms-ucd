package substringSorting;

public class StringSort {
	
	/*
	 * Assume text.length > pattern.length
	 */
	public static void bruteForce(String text, String pattern, boolean allOcurrences) {
		int stop = text.length() - pattern.length();
		
		for(int i=0; i<= stop; i++) {
			boolean match = true;
			for(int j=0; j< pattern.length() && match; j++) {
				match = text.charAt(i+j) == pattern.charAt(j);
			}
			// We found a match
			if(match) {
				if(allOcurrences) System.out.println(pattern);
				else break;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

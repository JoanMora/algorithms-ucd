/**
 * 
 */
package compression;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author joan
 *
 */
public class MyRunLength {
	
	public static String compress(String input) {
		String res = "";
		int j = 0;
		
		char c = input.charAt(0);
		
		input += " ";
		
		for(int i=0; i<input.length(); i++) {
			char next_c = input.charAt(i);
			if(next_c == c) {
				j++;
			}
			else {
				res += (j==1) ? "" + c : c + "" + j;
				j  = 1;
				c = next_c;
			}
		}
		return res;
	}
	
	public static void compressFromStdIn() {
		List<String> tokens = new ArrayList<>();
		BufferedReader br = null;

		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());

			while (st != null && st.hasMoreElements()) {
				tokens.add(st.nextToken());
			}

			String compressed = compress(tokens.toArray(new String[0])[0]);
			System.out.println(compressed);
		}
		catch (IOException e) {
			System.out.println(e);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		compressFromStdIn();
		

	}

}
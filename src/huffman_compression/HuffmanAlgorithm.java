/**
 * 
 */
package huffman_compression;


import utils.BinaryIn;
import utils.BinaryOut;
import utils.MinPQ;
import utils.StdOut;


/**
 * @author joan
 *
 */
public class HuffmanAlgorithm {
	
	private static final int ALPHABET_SIZE = 256; // extended ASCII
    private static BinaryIn binaryIn;
    private static BinaryOut binaryOut;
    
    // HuffmanCompression trie node
    private static class Node implements Comparable<Node> {
        private final Character ch;
        private final Integer freq;
        private final Node left, right;

        Node(char ch, int freq, Node left, Node right) {
            this.ch    = ch;
            this.freq  = freq;
            this.left  = left;
            this.right = right;
        }

        // is the node a leaf node?
        private boolean isLeaf() {
            assert ((left == null) && (right == null)) || ((left != null) && (right != null));
            return (left == null) && (right == null);
        }

        // compare, based on frequency
        public int compareTo(Node that) {
            return this.freq - that.freq;
        }
    }
    
    
    public static void compress() {
        // Read the input (1)
        char[] textInput = binaryIn.readString().toCharArray();

        // Tabulate frequency counts, build Huffman trie and code table
        // Count character frequency (2)
        int[] f = new int[ALPHABET_SIZE];
        for (char ch : textInput) {
            f[ch]++;
        }
        // Build the Huffman encoding tree (3)
        Node root = buildTrie(f);
        String[] table = new String[ALPHABET_SIZE];
        
        // Build the corresponding codeword table (4)
        buildCodeWordTable(table, root, "");
        
        
        // Write the trie (5)
        writeTrie(root);
        binaryOut.write(textInput.length); // Bytes in original message

        // Apply Huffman coding (6)
        for (char ch : textInput) {
            for (char e : table[ch].toCharArray()) {
                binaryOut.write(e == '1');
            }
        }
        binaryOut.close();
    }
    
    public static void decompress() {
    	
    	// Read the input (1,2)
        Node root = readTrie();
        // Use this trie to decode the bitstream (3)
        int nBytes = binaryIn.readInt(); // Bytes in original message
        int i = 0;
        while (i++ < nBytes) {
            Node node = root;
            while (!node.isLeaf()) {
                node = binaryIn.readBoolean() ? node.right : node.left;
            }
            // Output the decompressed characters (4,5)
            binaryOut.write(node.ch, 8);
        }
        binaryOut.close();
    }
    
    
    // Build the Huffman trie, given the frequencies of every character in text
    private static Node buildTrie(int[] freq) {

        // Initialise priority queue with singleton trees
        MinPQ<Node> pq = new MinPQ<>();
        for (char i = 0; i < ALPHABET_SIZE; i++) {
            if (freq[i] > 0) {
                pq.insert(new Node(i, freq[i], null, null));
            }
        }
    
        // Special case: only one character with a non-zero frequency exists
        if (pq.size() == 1) {
            char ch = freq['\0'] == 0 ? '\0' : '\1';
            pq.insert(new Node(ch, 0, null, null));
        }

        // Merge two smallest subtrees
        while (pq.size() > 1) {
            Node l = pq.delMin();
            Node r = pq.delMin();
            pq.insert(new Node('\0', l.getFreq() + r.getFreq(), l, r));
        }
        return pq.delMin();
    }
    
    
    // Make a lookup table from symbols and their encodings
    private static void buildCodeWordTable(String[] table, Node node, String s) {
        if (!node.isLeaf()) {
            buildCodeWordTable(table, node.left, s + '0');
            buildCodeWordTable(table, node.right, s + '1');
        } else {
            table[node.ch] = s;
        }
    }
    
    private static void writeTrie(Node node) {
        binaryOut.write(node.isLeaf());
        
        if (!node.isLeaf()) {
            writeTrie(node.left);
            writeTrie(node.right);
        } else {
            binaryOut.write(node.ch, 8);
        }
    }
    
    // Read Huffman trie from standard input
    private static Node readTrie() {
        boolean isLeaf = binaryIn.readBoolean();
        if (isLeaf) {
            return new Node(binaryIn.readChar(), -1, null, null);
        } else {
            return new Node('\0', -1, readTrie(), readTrie());
        }
    }
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		 if (args.length != 3 && !args[0].equals("compress") && !args[0].equals("decompress")) {
			 throw new IllegalArgumentException("Please follow the following syntax: java HuffmanCompression compress filename output filename");
		 }
		 else {
			 binaryIn = new BinaryIn(args[1]); // Input file
	         binaryOut = new BinaryOut(args[2]); // Output file
	         
	         // Timing
	         long t1 = System.currentTimeMillis();
			if (args[0].equals("compress")) {
				compress();
				StdOut.printf("\nTime taken for compression:\t%d milliseconds", (System.currentTimeMillis() - t1));
				StdOut.printf("\nInput file (original):\t\t%s", args[1]);
				StdOut.printf("\nOutput file (compressed):\t%s", args[2]);
				printStats(args[1], args[2]);
			} else {
				decompress();
				StdOut.printf("\nTime taken for decompression:\t%d milliseconds", (System.currentTimeMillis() - t1));
				StdOut.printf("\nInput file (compressed):\t%s", args[1]);
				StdOut.printf("\nOutput file (decompressed):\t%s", args[2]);
				StdOut.printf("\nFinal bits (decompressed):\t%d\n", countBits(args[2]));
			}
		 }
		 

	}

}

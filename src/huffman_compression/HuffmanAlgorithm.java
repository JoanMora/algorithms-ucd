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
    
    
    
    
 

	
	
	
	
	
	
	
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

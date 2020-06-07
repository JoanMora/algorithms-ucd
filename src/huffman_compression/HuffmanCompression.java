/**
 * 
 */
package huffman_compression;

import java.io.FileNotFoundException;
import java.io.PrintStream;
/******************************************************************************
 *  Compilation:  javac HuffmanCompression.java
 *
 *  Compress or expand a binary input stream using the HuffmanCompression algorithm.
 *
 * Add instructions and documentation related to your HuffmanCompression algorithm here...
 *
 ******************************************************************************/
import java.util.*;

import utils.Utils; 


/**
 *  Add in your information about each method etc. here
 *
 *
 *  @author Joan
 */
public class HuffmanCompression {

    // alphabet size of extended ASCII
    private static final int R = 256;

    // Frequency Table
    private static Hashtable<Character,Integer> frequencyTable = new Hashtable<Character, Integer>();
    
    // Input Storage
    private static ArrayList<Character> inputList = new ArrayList<Character>();
    
    // CodeWord Table <character,encoding>
    private static Hashtable<Character,String> codeWordTable = new Hashtable<Character, String>();
    
    // Do not instantiate.
    private HuffmanCompression() { }

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

    /**
     * Reads a sequence of 8-bit bytes from standard input; compresses them
     * using HuffmanCompression codes with an 8-bit alphabet; and writes the results
     * to standard output.
     * @throws FileNotFoundException 
     */
    public static void compress(String fileIn, String fileOut) throws FileNotFoundException {
    	
    	// Redirect standart output to a file
    	// PrintStream originalOut = System.out;
		// PrintStream compressedOut = new PrintStream(fileOut);
		// PrintStream trieOut = new PrintStream(fileOut + "Trie");
		
    	
    	
        // read the input
    	readInput(fileIn);
    	
    	//Utils.printArray(inputList.toArray(new Character[inputList.size()]));

        // tabulate frequency counts
    	tabulateFrequenctTable();

        // build HuffmanCompression trie

    	Node rootHuffmanTrie = buildTrie();

        // build code table
    	buildCodeWordTable(rootHuffmanTrie);
    	
    	
        // print trie for decoder
    	// System.setOut(trieOut);
    	writeTrie(rootHuffmanTrie);
    	BinaryStdOut.flush();
    	// System.setOut(originalOut);
    	
        // print number of bytes in original uncompressed message


        // use HuffmanCompression code to encode input
    	String encode = encode();
    	System.out.println();
    	System.out.println(encode);
    	BinaryOut out = new BinaryOut("try");
    	out.write(encode);
    	out.flush();

    }
    
    private static String encode() {
    	String code = "";
    	for(Character c : inputList) {
    		code += codeWordTable.get(c);
    	}
    	return code;
    }
    
    private static void pNode(Node x) {
    	if(!x.isLeaf()) {
    		// System.out.println(x.freq.toString());
    		pNode(x.left);
    		pNode(x.right);
    	}
    	else {
    		System.out.println(x.ch.toString());
    	}
    }
    
    public static void readInput(String file_url) {
    	BinaryIn in = new BinaryIn(file_url);

    	while(!in.isEmpty()) {
    		Character c = in.readChar();
    		inputList.add(c);
    	}
    }
    
    public static void tabulateFrequenctTable() {
    	for(Character c: inputList) {
    		Integer f = 1;
    		if(frequencyTable.containsKey(c)) {
    			f = frequencyTable.get(c) + 1;
    			
    		}
    		frequencyTable.put(c, f);
    	}
    }


    /**
     * Reads a sequence of bits that represents a HuffmanCompression-compressed message from
     * standard input; expands them; and writes the results to standard output.
     */
    public static void decompress(String fileIn, String fileOut) {

        // read in HuffmanCompression trie from input stream
    	Node rootHuffmanTrie = readTrie();
        // number of bytes to write
    	
    	
    	BinaryIn in = new BinaryIn("tryTrie");
    	String compressed = in.readString();
    	System.out.println(compressed);
        // decode using the HuffmanCompression trie
    	compressed = "111001010011001001001000100110010111110000101101101111101111110100110110001111100100101011001110101";
    	String decompressed = decompressInput(compressed, rootHuffmanTrie);
    	
    	System.out.println(decompressed);
    	System.out.println("End");
    }

    // build the HuffmanCompression trie given frequencies
    private static Node buildTrie() {

        // initialze priority queue with singleton trees
        MinPQ<Node> pq = new MinPQ<Node>();
        List<Character> keys = Collections.list(frequencyTable.keys());
        
        for (Character c : keys) {
               pq.insert(new Node(c, frequencyTable.get(c), null, null));
        }

        // special case in case there is only one character with a nonzero frequency
        /*
        if (pq.size() == 1) {
            if (freq['\0'] == 0) pq.insert(new Node('\0', 0, null, null));
            else                 pq.insert(new Node('\1', 0, null, null));
        }
        */

        // merge two smallest trees
        while (pq.size() > 1) {
            Node left  = pq.delMin();
            Node right = pq.delMin();
            Node parent = new Node('\0', left.freq + right.freq, left, right);
            pq.insert(parent);
        }
        return pq.delMin();
    }


    // write bitstring-encoded trie to standard output
    private static void writeTrie(Node x) {
        if (x.isLeaf()) {
            BinaryStdOut.write(true);
            BinaryStdOut.write(x.ch, 8);
            return;
        }
        BinaryStdOut.write(false);
        writeTrie(x.left);
        writeTrie(x.right);
    }
    

    // make a lookup table from symbols and their encodings
    /*
     * 
     */
    private static void buildCodeWordTable(Node x) {
    	for(Character c : inputList) {
    		buildCodeWordTable(c,x,"");
    	}
    }
    
    private static String decompressInput(String in, Node x) {
    	int i = 0;
    	String result = "";
    	
    	while(!in.isEmpty()) {
    		while(!x.isLeaf()) {
    			x = in.charAt(i) == '0' ? x.left : x.right;
    			i++;
    		}
    		// We are on a leaf
    		result += x.ch.toString(); 
    		in = in.substring(i+1);
    	}
    	
    	return result;
  
    }
    
    
    
    private static void buildCodeWordTable(Character c, Node x, String code) {
        if (!x.isLeaf()) {
        	buildCodeWordTable(c, x.left,  code + "0");
        	buildCodeWordTable(c, x.right, code + "1");
        }
        else if(x.ch.equals(c)) {
            codeWordTable.put(c,code);
        }
    }



    private static Node readTrie() {
        boolean isLeaf = BinaryStdIn.readBoolean();
        if (isLeaf) {
            return new Node(BinaryStdIn.readChar(), -1, null, null);
        }
        else {
            return new Node('\0', -1, readTrie(), readTrie());
        }
    }
    

    /**
     * Sample client that calls {@code compress()} if the command-line
     * argument is "compress" an {@code decompress()} if it is "decompress".
     *
     * @param args the command-line arguments
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException {
    	
    	String mode = "decompress"; //args[0];
    	String inputFile = "mockInHuffman"; //args[1];
    	String outputFile = "try"; // args[3];
    	
    	
    	
    	if(mode == "compress") {
    		System.out.println("Compressing...");
    		compress(inputFile, outputFile);
    	}
    	else if(mode == "decompress") {
    		// decompress(inputFile, outputFile);
    		System.out.println("Decompressing...");
    		decompress(inputFile, outputFile);
    		System.out.println("End");
    		
    		/*
    		Node rootHuffmanTrie = readTrie();
    		writeTrie(rootHuffmanTrie);
        	BinaryStdOut.flush();
        	*/
    	}

    }

}


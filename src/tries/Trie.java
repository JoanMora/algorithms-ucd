package tries;

/**
 * @author joan
 *
 */
public class Trie {
	
	// Alphabet size (# of symbols) we pick 26 for English alphabet
    static final int ALPHABET_SIZE = 26;

    // class for Trie node
    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        // isEndOfWord is true if the node represents end of a word i.e. leaf node
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;

            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    }

    static TrieNode root;

    // If not key present, inserts into trie
    // If the key is prefix of Trie node, 
    // marks leaf node
    public static void insert(String key) {
    	int length = key.length();
    	int index;
    	
    	TrieNode crawler = root; // start the crawler at the root
    	
    	for(int level=0; level < length; level++) {
    		// we use indexes for letters and values to reference other TrieNodes
    		index = key.charAt(level) - 'a';
    		if(crawler.children[index] == null) {
    			crawler.children[index] = new TrieNode();
    		}
    		// Advance to next subtree
    		crawler = crawler.children[index];
    	}
    	
    	// At this point we are finished but we need to mark the last node as a leaf
    	crawler.isEndOfWord = true;
    	
    }

    // Returns true if key presents in trie, else false
    public static boolean search(String key) {
    	int length = key.length();
    	
    	TrieNode crawler = root;
    	
    	for(int level=0; level<length; level++) {
    		int index = key.charAt(level) - 'a';
    		
    		if(crawler.children[index] == null) {
    			return false;
    		}
    		else {
    			crawler = crawler.children[index];
    		}
    		
    	}
    	
    	// We went through all the word to search
    	// check if we are at the end of some word
    	return crawler != null && crawler.isEndOfWord;
    }

    // Driver
    public static void main(String args[]) {

        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = { "bank", "book", "bar", "bring", "film", "filter", "simple", "silt", "silver" };

        String output[] = { "Not present in trie", "Present in trie" };

        root = new TrieNode();

        // Construct trie
        int i;
        for (i = 0; i < keys.length; i++) {
            insert(keys[i]);
        }

        // Search for different keys

    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

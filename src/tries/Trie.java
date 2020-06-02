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

    TrieNode root = new TrieNode();
    

    // If not key present, inserts into trie
    // If the key is prefix of Trie node, 
    // marks leaf node
    public void insert(String key) {
    	int length = key.length();
    	int index;
    	
    	TrieNode crawler = this.root; // start the crawler at the root
    	
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
    
    // Insert a set of keys in a Trie
    public void insert(String[] keys) {
    	for(String key : keys) {
    		insert(key);
    	}
    }

    // Returns true if key presents in trie, else false
    public boolean search(String key) {
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

}

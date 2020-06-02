/**
 * 
 */
package tries;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author joan
 *
 */
class TestTries {
	
	// Input keys (use only 'a' through 'z' and lower case)
    String keys[] = { "the", "a", "there", "answer", "any", "by", "bye", "their" };
    
    String output[] = { "Not present in trie", "Present in trie" };
    
    
    
	
	
	@Test
	void insertSearchKeyTrue() {
		Trie myTrie = new Trie();
	    myTrie.insert(keys);
		
		
		assertTrue(myTrie.search("answer"));
	}
	
	@Test
	void insertSearchKeyFalse() {
		Trie myTrie = new Trie();
	    myTrie.insert(keys);
		
		
		assertFalse(myTrie.search("joan"));
	}

}

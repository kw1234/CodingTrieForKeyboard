import java.util.*;

public class Trie {

    TrieNode root = null;

    public Trie() {
	root = new TrieNode(' ',null);
    }

    public void insert(String word, String filePath) {
	TrieNode copy = root;
	for (int i = 0; i < word.length(); i++) {
	    char ch = word.charAt(i);
	    //System.out.println(ch);
	    //System.out.println(root.getVal()+" "+copy.getVal());
	    TrieNode curr = copy.getChar(ch);
	    if (curr == null) {
		curr = copy.addChar(ch);
	    }
	    copy = curr;
	}
	
	copy.setIsLeaf(true, filePath); 
    }

    public TrieNode search(String word) {
	TrieNode copy = root;
	for (int i = 0; i < word.length(); i++) {
	    char ch = word.charAt(i);
	    TrieNode curr = copy.getChar(ch);
	    if (curr == null) return null;
	    copy = curr;
	}
	return copy != null && copy.getIsLeaf() ? copy:null;
    }

    public void printTrie() {
	TrieNode copy = root;
	System.out.println(copy.val);
	while(copy != null) {
	    System.out.println(copy.val);
	    if (copy.children.size() > 0) {
		copy = copy.children.get(0);
	    } else {
		copy = null;
	    }
	}
    }

    public static void main(String[] args) {
	Trie trie = new Trie();
 
	trie.insert("REally", "poo");
	trie.insert("Do", "poo");
	trie.insert("you", "poo");
	trie.insert("know", "poo");
	trie.insert("my", "poo");
	trie.insert("address?", "poo");
	
	trie.printTrie();
    }
}

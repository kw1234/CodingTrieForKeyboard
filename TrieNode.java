import java.util.*;


public class TrieNode {

    TrieNode parent;
    List<TrieNode> children;
    char val;
    boolean isLeaf;
    List<String> filePathLst;

    public TrieNode(char val, TrieNode parent) {
        this.parent = parent;
        this.val = val;
        children = new ArrayList<TrieNode>();
        isLeaf = false;
        filePathLst = new ArrayList<String>();
    }

    public TrieNode getChar(char ch) {
        for (TrieNode child: children) {
            if (child.val == ch) return child;
        }
        return null;
    }

    public char getVal() {
	return val;
    }

    public TrieNode addChar(char ch) {
	TrieNode newNode = new TrieNode(ch, this);
        children.add(newNode);
	return newNode;
    }

    public boolean getIsLeaf() {
        return isLeaf;
    }

    // sets the leaf node to a value, sets the filePath if the node is a leaf                                                                                                                                             
    public void setIsLeaf(boolean value, String path) {
        isLeaf = value;
        if (value == true && !filePathLst.contains(path)) {
            filePathLst.add(path);
        }
    }

    public List<String> getFilePaths() {
        return filePathLst;
    }

}
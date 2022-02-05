package alldatastructure.tree.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	Map<Character, TrieNode> childrens;
	boolean endOfString;

	public TrieNode() {
		childrens = new HashMap<>();
		endOfString = false;
	}

}

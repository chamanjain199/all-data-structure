package alldatastructure.tree.trie;

public class Trie {

	TrieNode root;

	public Trie() {

		root = new TrieNode();
	}

	public void insert(String value) {
		char chars[] = value.toCharArray();

		TrieNode current = root;
		for (int i = 0; i < chars.length; i++) {

			current = current.childrens.putIfAbsent(Character.valueOf(chars[i]), new TrieNode());

		}

		current.endOfString = true;

	}

	public void search(String value) {

		TrieNode current = root;
		char chars[] = value.toCharArray();

		for (int i = 0; i < chars.length; i++) {

			current = current.childrens.get(Character.valueOf(chars[i]));
			if (current == null) {
				System.out.println("Not found");
				break;
			}
		}
		if (current.endOfString) {
			System.out.println("Found");
		} else {
			System.out.println("Not found");
		}

	}

	public boolean delete(TrieNode parentNode, String word, int index) {

		return false;

	}
}

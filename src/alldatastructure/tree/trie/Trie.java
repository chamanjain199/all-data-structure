package alldatastructure.tree.trie;

import java.util.HashMap;

public class Trie {

    TrieNode root;

    public Trie() {

        root = new TrieNode();
    }

    public void insert(String value) {
        char chars[] = value.toCharArray();
        TrieNode current = root;
        for (int i = 0; i < chars.length; i++) {

            current.childrens.putIfAbsent(chars[i], new TrieNode());
            current = current.childrens.get(chars[i]);
        }
        current.endOfString = true;
    }

    public boolean search(String value) {

        TrieNode current = root;
        char chars[] = value.toCharArray();

        for (int i = 0; i < chars.length; i++) {

            current = current.childrens.get(Character.valueOf(chars[i]));
            if (current == null) {
                System.out.println("Not found");
                return false;
            }
        }
        if (current.endOfString) {
            System.out.println("Found");
            return true;
        } else {
            System.out.println("It is a prefix of another string");
            return false;
        }

    }

    private boolean delete(TrieNode parentNode, String word, int index) {

        char ch = word.charAt(index);
        TrieNode currentNode = parentNode.childrens.get(ch);

        if (currentNode.childrens.size() > 1) {
            delete(currentNode, word, index + 1);
            return false;
        }
        if (index == word.length() - 1) {
            if (currentNode.childrens.size() >= 1) {
                currentNode.endOfString = false;
                return false;
            } else {
                parentNode.childrens.remove(ch);
                return true;
            }
        }
        if (currentNode.endOfString == true) {
            delete(currentNode, word, index + 1);
            return false;
        }
        if (delete(currentNode, word, index++)) {
            parentNode.childrens.remove(ch); //this condition is reache donly when parent has only one child and that also been deleted
            return false;
        } else {
            return true;
        }
    }

    public void delete(String word) {
        if (search(word)) {
            delete(root, word, 0);
        }
    }


}

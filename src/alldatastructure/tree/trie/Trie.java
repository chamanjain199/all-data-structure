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

    public void delete(TrieNode parentNode, String word, int index) {

        TrieNode currentNode = root;

        char[] allChars = word.toCharArray();

        for (int i = 0; i < allChars.length; i++) {
            currentNode = currentNode.childrens.get(allChars[i]);
            if (currentNode == null) {
                return;
            }
        }

        if (currentNode.endOfString) {

            if (currentNode.childrens.size() == 1) {
                currentNode = null;
            } else if (currentNode.childrens.size() > 1) {
                currentNode.endOfString = false;
            }
        }
    }

    public TrieNode deleteRecursively(TrieNode parentNode, String word, int index,) {

                 if(parentNode.childrens.containsKey(word.charAt(index))){

                 }


    }
}

package alldatastructure.tree.trie;

public class TrieMain {
    public static void main(String[] args) {
        Trie trie=new Trie();
        trie.insert("ABC");
        trie.insert("ACB");
        trie.insert("ABD");
        trie.delete("ABC");
    }
}

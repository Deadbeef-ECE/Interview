// O(n) space, O(height) time
class TrieNode {
    // Initialize your data structure here.
    boolean end;
    TrieNode[] children;
    public TrieNode() {
        this.end = false;
        this.children = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(node.children[index] == null)
                node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.end = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(node.children[index] == null)
                return false;
            node = node.children[index];
        }
        return node.end;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if(node.children[index] == null)
                return false;
            node = node.children[index];
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
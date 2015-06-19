class TrieNode{
    boolean end;
    TrieNode[] children;
    public TrieNode(){
        this.end = false;
        this.children = new TrieNode[26];
    }
}

public class WordDictionary {
    private TrieNode root;
    public WordDictionary(){
        root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(node.children[index] == null)
                node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.end = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return doDFS(root, word, 0, word.length());
    }
    
    private boolean doDFS(TrieNode node, String word, int start, int end){
        if(start == end)
            return node.end;
        if(word.charAt(start) != '.'){
            int index = word.charAt(start) - 'a';
            if(node.children[index] == null)
                return false;
            if(doDFS(node.children[index], word, start+1, end))
                return true;
        }else{
            for(int i = 0; i < 26; i++){
                if(node.children[i] != null && 
                doDFS(node.children[i], word, start+1, end))
                        return true;
            }
        }
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
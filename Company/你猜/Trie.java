class TrieNode{
	boolean end;
	TrieNode[] child;
	public TrieNode(){
		this.end = false;
		this.child = new TrieNode[26];
	}
}

public class Trie {
	private TrieNode root;
	public Trie(){
		root = new TrieNode();
	}
	
	public void insert(String str){
		TrieNode node = root;
		for(int i = 0; i < str.length(); i++){
			int index = str.charAt(i) - 'a';
			if(node.child[index] == null)
				node.child[index] = new TrieNode();
			node = node.child[index];
		}
		node.end = true;
	}
	
	public TrieNode root(){
		return root;
	}
	
	// Check if there is any word in the trie
    // that starts with the given prefix.
    public boolean startWith(String prefix){
        TrieNode cur = root;
        for(int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if(cur.child[index] == null)
                return false;
            cur = cur.child[index];
        }
        return true;
    }
    
    // Check if the word is in the trie.
    public boolean search(String word){
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(cur.child[index] == null)
                return false;
            cur = cur.child[index];
        }
        return cur.end;
    }
}

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
}

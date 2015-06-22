public class Solution {
    
    public List<String> findWords(char[][] board, String[] words) {
        HashSet<String> set = new HashSet<String>();
        if(board == null || words == null)
            return new LinkedList<String>();
            
        Trie trie = new Trie(); 
        for(String word : words){
            trie.insert(word);
        }
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        String path = "";
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                doDFS(board, trie, visited, i, j, path, set);
            }
        }
        return new LinkedList<String>(set);
    }
    
    private void doDFS(char[][] board, Trie trie, boolean[][] visited, 
                    int x, int y, String path, HashSet<String> set){
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y] == true)
            return;
        path += board[x][y];
        if(!trie.startsWith(path))  
            return;
        if(trie.search(path))
            set.add(path);
        
        visited[x][y] = true;
        doDFS(board, trie, visited, x+1, y, path, set);
        doDFS(board, trie, visited, x-1, y, path, set);
        doDFS(board, trie, visited, x, y+1, path, set);
        doDFS(board, trie, visited, x, y-1, path, set);
        visited[x][y] = false;
    }
}
class TrieNode {
    // Initialize your data structure here.
    boolean end;
    TrieNode[] children;
    public TrieNode() {
        this.end = false;
        this.children = new TrieNode[26];
    }
}

class Trie {
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
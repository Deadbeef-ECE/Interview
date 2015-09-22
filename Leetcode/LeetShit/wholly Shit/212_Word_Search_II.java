public class Solution {
    // TODO: 
    // O() time
    // O() space
    public List<String> findWords(char[][] board, String[] words) {
        if(board == null || words == null)
            return new LinkedList<String>();
            
        int row = board.length;
        int col = board[0].length;
        // create trie
        Trie trie = new Trie();
        for(String word : words)
            trie.insert(word);
            
        boolean[][] visited = new boolean[row][col];
        HashSet<String> set = new HashSet<String>();
        String path = "";
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                doDFS(i, j, board, path, trie, visited, set);
            }
        }
        return new LinkedList<String>(set);
    }
    
    private void doDFS(int i, int j, char[][] board, String path, Trie trie, 
                    boolean[][] visited, HashSet<String> set){
        int row = board.length;
        int col = board[0].length;
        if(i < 0 || j < 0 || i >= row || j >= col || visited[i][j] == true )
            return;
        path += board[i][j];
        if(!trie.startWith(path))
            return;
        if(trie.search(path))
            set.add(path);
        
        visited[i][j] = true;
        doDFS(i + 1, j, board, path, trie, visited, set);
        doDFS(i, j + 1, board, path, trie, visited, set);
        doDFS(i - 1, j, board, path, trie, visited, set);
        doDFS(i, j - 1, board, path, trie, visited, set);
        visited[i][j] = false;
    }
}

class TrieNode{
    boolean end;
    TrieNode[] children;
    public TrieNode(){
        this.end = false;
        this.children = new TrieNode[26];
    }
}

class Trie{
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
        
    // Insert a word into the trie.
    public void insert(String word){
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(cur.children[index] == null)
                cur.children[index] = new TrieNode();
            cur = cur.children[index];
        }
        cur.end = true;
    }
    
    // Check if there is any word in the trie
    // that starts with the given prefix.
    public boolean startWith(String prefix){
        TrieNode cur = root;
        for(int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if(cur.children[index] == null)
                return false;
            cur = cur.children[index];
        }
        return true;
    }
    
    // Check if the word is in the trie.
    public boolean search(String word){
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(cur.children[index] == null)
                return false;
            cur = cur.children[index];
        }
        return cur.end;
    }
}
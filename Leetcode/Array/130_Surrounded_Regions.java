public class Solution {
    // DFS(TLE) 
    public void solve(char[][] board) {
        if(board == null || board.length == 0)  return;
        int row = board.length;
        int col = board[0].length;
        if (row == 1 || col == 1)   return;
        
        for(int j = 0; j < col; j++){
            doDFS(board, 0, j);
            doDFS(board, row-1, j);
        }
        
        for(int i = 1; i < row-1; i++){
            doDFS(board, i, 0);
            doDFS(board, i, col-1);
        }
        for(int i = 0;i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j]=='#') 
                    board[i][j]='O';
                else if(board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
        return;
    }
    
    private void doDFS(char[][] board, int x, int y){
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != 'O'
        || board[x][y] == '#')
            return;
        board[x][y] = '#';
        doDFS(board, x-1, y);
        doDFS(board, x+1, y);
        doDFS(board, x, y-1);
        doDFS(board, x, y+1);
    }

    // BFS
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0)  return;
        int row = board.length;
        int col = board[0].length;
        if (row == 1 || col == 1)   return;
        
        for(int j = 0; j < col; j++){
            doBFS(board, 0, j);
            doBFS(board, row-1, j);
        }
        
        for(int i = 1; i < row-1; i++){
            doBFS(board, i, 0);
            doBFS(board, i, col-1);
        }
        for(int i = 0;i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j]=='#') 
                    board[i][j]='O';
                else if(board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
        return;
    }
    private void doBFS(char[][] board, int x, int y){
        Queue<Integer> queue = new LinkedList<Integer>();
        int row = board.length;
        int col = board[0].length;
        queue.add(x * board[0].length + y);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            if (cur < 0 || cur >= row * col)
                continue;
            int i = cur / col;
            int j = cur % col;
            if (board[i][j] != 'O')
                continue;

            board[i][j] = '#';
            queue.add(cur+1);
            queue.add(cur-1);
            queue.add(cur+col);
            queue.add(cur-col);
        }
    }
}

// 4 Union-Find solutions
class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length < 2)
            return;
        int m = board.length, n = board[0].length;
        // QuickFind, TLE
        // UF uf = new QuickFind(m * n + 1);
        // QuickUnion, 10ms, beats 20%
        // UF uf = new QuickUnion(m * n + 1);
        // WeightedQuickUnion, 10ms, beats 20%
        // UF uf = new WeightedQuickUnion(m * n + 1);
        // WeightedQuickUnionWithPathCompression, 10ms, beats 20%
        UF uf = new WeightedQuickUnionWithPathCompression(m * n + 1);

        // dummyO is the 'O' that cannot be changed to 'X'
        int dummyO = m * n;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O'){
                    int idx = i * n + j;
                    if(i == 0 || j == 0 || i == m - 1 || j == n - 1){
                        uf.union(idx, dummyO);
                    }else{
                        for(int k = 0; k < 4; k++){
                            int x = i + dx[k], y = j + dy[k];
                            if(x >= 0 && y >= 0 && x < m && y < n && board[x][y] == 'O')
                                uf.union(x * n + y, idx);
                        }
                    }
                }
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O' && !uf.isConnected(i * n + j, dummyO))
                    board[i][j] = 'X';
            }
        }
        return;
    }
}

interface UF{
    boolean isConnected(int p, int q);
    int root(int p);
    void union(int p, int q);
}

class QuickFind implements UF{
    int[] parent;
    public QuickFind(int n){
        parent = new int[n];
        for(int i = 0; i < n; i++)
            parent[i] = i;
    }
    
    public boolean isConnected(int p, int q){
        return root(p) == root(q);
    }
    
    public int root(int p){
        return parent[p];
    }
    
    public void union(int p, int q){
        int pid = parent[p];
        int qid = parent[q];
        for(int i = 0; i < parent.length; i++){
            if(parent[i] == pid)
                parent[i] = qid;
        }
    }
}

class QuickUnion implements UF{
    int[] parent;
    public QuickUnion(int n){
        parent = new int[n];
        for(int i = 0; i < n; i++)
            parent[i] = i;
    }
    
    public boolean isConnected(int p, int q){
        return root(p) == root(q);
    }
    
    public int root(int p){
        while(p != parent[p])
            p = parent[p];
        return p;
    }
    
    public void union(int p, int q){
        int i = root(p);
        int j = root(q);
        parent[i] = j;
    }
}

class WeightedQuickUnion implements UF{
    int[] parent;
    int[] size;
    public WeightedQuickUnion(int n){
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    public boolean isConnected(int p, int q){
        return root(p) == root(q);
    }
    
    public int root(int p){
        while(p != parent[p])
            p = parent[p];
        return p;
    }
    
    public void union(int p, int q){
        int i = root(p);
        int j = root(q);
        if(i == j)  return;
        if(size[i] < size[j]){
            parent[i] = parent[j];
            size[j] += size[i];
        }else{
            parent[j] = parent[i];
            size[i] += size[j];
        }
    }
}

class WeightedQuickUnionWithPathCompression implements UF{
    int[] parent;
    int[] size;
    public WeightedQuickUnionWithPathCompression(int n){
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    public boolean isConnected(int p, int q){
        return root(p) == root(q);
    }
    
    public int root(int p){
        int root = p;
        while(root != parent[root])
            root = parent[root];
        while(p != root){
            int newP = parent[p];
            parent[p] = root;
            p = newP;
        }
        return p;
    }
    
    public void union(int p, int q){
        int i = root(p);
        int j = root(q);
        if(i == j)  return;
        if(size[i] < size[j]){
            parent[i] = parent[j];
            size[j] += size[i];
        }else{
            parent[j] = parent[i];
            size[i] += size[j];
        }
    }
}



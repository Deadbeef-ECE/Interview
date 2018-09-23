public class Solution {
    // DFS
    // O(1) space without recursion stack
    // O(n) space with recursion stack, n is the maximum height of recursion tree
    // O(n^2 * avgLen) time: 
    // traversal every nodes, for each node, traversal numbers of average nodes of the 
    // path from it
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int ret = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    ret++;
                    doDFS(grid, i, j);
                }
            }
        }
        return ret;
    }
    
    private void doDFS(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        doDFS(grid, i+1, j);
        doDFS(grid, i-1, j);
        doDFS(grid, i, j+1);
        doDFS(grid, i, j-1);
    }

    // BFS:
    // O(n) space, O(n^2) time;
    private int row, col;
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    private Queue<Integer> queue;
    private int cnt;
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        cnt = 0;
        row = grid.length;
        col = grid[0].length;
        queue = new LinkedList<Integer>();
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    cnt++;
                    grid[i][j] = '0';
                    bfs(grid, i, j);
                }
            }
        }
        return cnt;
    }
    
    private void bfs(char[][] grid, int i, int j){
        int num = i * col + j;
        queue.add(num);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            int r = cur / col, c = cur % col;
            for(int k = 0; k < 4; k++){
                int x = r + dx[k];
                int y = c + dy[k];
                if(x < 0 || y < 0 || x >= row || y >= col)
                    continue;
                if(grid[x][y] == '1'){
                    queue.add(x*col + y);
                    grid[x][y] = '0';
                }
            }
        }
    }
}

// Union-Find
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {-1, 1, 0, 0};
        
        int dummy = m * n;
        UF uf = new UF(m * n + 1);
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int idx = i * n + j;
                if(grid[i][j] == '1'){
                    for(int k = 0; k < 4; k++){
                        int x = i + dx[k], y = j + dy[k];
                        if(x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == '1'){
                            uf.union(x * n + y, idx);
                        }
                    }
                }else{
                    uf.union(idx, dummy);
                }
            }
        }
        return uf.getCount();
    }
}

class UF{
    int[] parent;
    int[] size;
    int cnt;
    public UF(int n){
        parent = new int[n];
        size = new int[n];
        cnt = n - 1;
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    public int getCount(){
        return cnt;
    }
    public boolean isConnected(int p, int q){
        return root(p) == root(q);
    }
    
    public int root(int p){
        int root = p;
        while(root != parent[root])
            root = parent[root];
        while(p != root){
            int newp = parent[p];
            parent[p] = root;
            p = newp;
        }
        return p;
    }
    
    public void union(int p, int q){
        int i = root(p);
        int j = root(q);
        if(i == j)  return;
        if(size[i] < size[j]){
            size[j] += size[i];
            parent[i] = j;
        }else{
            size[i] += size[j];
            parent[j] = i;
        }
        cnt--;
    }
}
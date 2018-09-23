class Solution {
    int m, n;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public int[] hitBricks(int[][] grid, int[][] hits) {
        if(grid.length == 0 || grid[0].length == 0)
            return new int[]{};
        m = grid.length;
        n = grid[0].length;
        UF uf = new UF(m * n + 1);
        
        for (int[] hit : hits) {
            if (grid[hit[0]][hit[1]] == 1) {
                grid[hit[0]][hit[1]] = 2;
            }
        }
        for (int i = 0 ; i < m; i++)  {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    unionAround(i, j, grid, uf);
                }
            }
        }
        
        int count = uf.count(m * n);
        int[] ret = new int[hits.length];
        for (int i = hits.length -1; i >= 0; i--) {
            int[] hit = hits[i];
            if (grid[hit[0]][hit[1]] == 2) {
                unionAround(hit[0], hit[1], grid, uf);
                grid[hit[0]][hit[1]] = 1;
            }
            int newCount = uf.count(m * n);
            // -1 for the the brick got hit
            ret[i] = (newCount - count > 0) ? newCount - count - 1 : 0;
            count = newCount;
        }        
        return ret;
    }
    
    private void unionAround(int i, int j, int[][] grid, UF uf){
        int id1 = i * n + j;
        for(int k = 0; k < 4; k++){
            int x = i + dx[k], y = j + dy[k];
            if(x < 0 || y < 0 || x >= m || y >= n || grid[x][y] != 1)
                continue;
            int id2 = x * n + y;
            uf.union(id1, id2);
        }
        if(i == 0)
            uf.union(id1, m * n);
    }
}

class UF{
    int[] parent;
    int[] size;
    public UF(int n){
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    public int root(int p){
        while(p != parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    
    public int count(int p){
        return size[root(p)];
    }

    public void union(int p, int q){
        int i = root(p), j = root(q);
        if(i == j)  return;
        if(size[i] > size[j]){
            size[i] += size[j];
            parent[j] = i;
        }else{
            size[j] += size[i];
            parent[i] = j;
        }
    }
}
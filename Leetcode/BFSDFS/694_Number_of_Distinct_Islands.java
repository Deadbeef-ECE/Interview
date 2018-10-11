class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    char[] dir = {'r', 'l', 'd', 'u'};
    int m;
    int n;
    public int numDistinctIslands(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        Set<String> set = new HashSet<>();
        m = grid.length;
        n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    StringBuilder sb = new StringBuilder();
                    dfs(i, j, sb, grid);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }
    
    private void dfs(int i, int j, StringBuilder sb, int[][] grid){
        grid[i][j] = 0;
        for(int k = 0; k < 4; k++){
            int x = dx[k] + i, y = dy[k] + j;
            if(x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 0)
                continue;
            sb.append(dir[k]);
            dfs(x, y, sb, grid);
        }
        sb.append('b');
        return;
    }
}
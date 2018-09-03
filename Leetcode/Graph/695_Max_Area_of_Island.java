class Solution {
    int row;
    int col;
    int count = 0;
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        row = grid.length;
        col = grid[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    int[] area = {0};
                    dfs(grid, area, i, j);
                }
            }
        }
        return count;
    }
    
    private void dfs(int[][] grid, int[] area, int i, int j){
        if(i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != 1)
            return;
        area[0]++;
        count = Math.max(count, area[0]);
        grid[i][j] = 0;
        dfs(grid, area, i + 1, j);
        dfs(grid, area, i - 1, j);
        dfs(grid, area, i, j + 1);
        dfs(grid, area, i, j - 1);
    }
}
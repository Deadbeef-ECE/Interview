// DP, 
// grid[i][j] + h = Math.min(Max_col[i], Max_row[j])
class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;
        int[] rowMax = new int[n];
        int[] colMax = new int[m];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                rowMax[j] = Math.max(rowMax[j], grid[i][j]);
                colMax[i] = Math.max(colMax[i], grid[i][j]);
            }
        }
        int cnt = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int h = Math.min(rowMax[j], colMax[i]);
                cnt += h - grid[i][j];
            }
        }
        return cnt;
    }
}
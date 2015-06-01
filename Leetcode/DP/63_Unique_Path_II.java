public class Solution {
    // 二维DP, O(m*n) space, O(m*n) time
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int col = obstacleGrid[0].length;
        int row = obstacleGrid.length;
        int[][] dp = new int[row][col];
        if(obstacleGrid[0][0] == 1) return 0;
        dp[0][0] = 1;
        // update first row, 如果i处为1，则其后都应该走不到，dp数值为0
        for(int i = 1; i < col; i++){
            if(obstacleGrid[0][i] == 0)
                dp[0][i] = dp[0][i-1];
        }
        // update first col, 如果i处为1，则其后都应该走不到，dp数值为0
        for(int j = 1; j < row; j++){
            if(obstacleGrid[j][0] == 0)
                dp[j][0] = dp[j-1][0];
        }
        // update other ceils
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[row-1][col-1];
    }
}
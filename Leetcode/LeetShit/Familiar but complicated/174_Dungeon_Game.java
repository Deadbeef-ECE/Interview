public class Solution {
    // 二维DP:
    // O(n^2) time, O(n^2) space
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        // dp[i][j] is the minimum health point at dungeon[i][j] before fighting
        int[][] dp = new int[row][col];
        if(dungeon[row-1][col-1] < 0)
            dp[row-1][col-1] = 1 - dungeon[row-1][col-1];
        else
            dp[row-1][col-1] = 1;
        
        // init the last row of dp
        for(int j = col - 2; j >= 0; j--)
            dp[row-1][j] = Math.max(1, dp[row-1][j+1] - dungeon[row-1][j]);
        
        // init the last col of dp
        for(int i = row - 2; i >= 0; i--)
            dp[i][col-1] = Math.max(1, dp[i+1][col-1] - dungeon[i][col-1]);
            
        for(int i = row - 2; i >= 0; i--){
            for(int j = col - 2; j >= 0; j--){
                dp[i][j] = Math.max(1, Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}
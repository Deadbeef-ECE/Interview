public class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0)
            return 0;
        int n = costs.length;
        int[][] dp = new int[n][3];
        for(int i = 0; i < 3; i++)
            dp[0][i] = costs[0][i];
            
        for(int i = 1; i < n; i++){
            for(int j = 0; j < 3; j++){
                dp[i][j] = costs[i][j] + getMinExcept(dp, i-1, j);
            }
        }
        int min = dp[n-1][0];
        for(int i = 1; i < 3; i++)
            min = Math.min(min, dp[n-1][i]);
        
        return min;
    }
    
    private int getMinExcept(int[][] dp, int i, int j){
        int Min = Integer.MAX_VALUE;
        for(int k = 0; k < 3; k++){
            if(k == j)  continue;
            Min = Math.min(Min, dp[i][k]);
        }
        return Min;
    }
}
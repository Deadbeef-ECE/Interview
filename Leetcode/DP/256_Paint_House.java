/* 题意:
 * 一排房子(n个), 每个房子可涂三种颜色(红蓝绿), 各颜色的cost不同, int[n][i]表示第n个房子涂上
 * 第i (0 <= i < 3) 个颜色的cost, 求涂完所有颜色的最小cost(相邻房子颜色不能相同) 
 *
 * Solution:
 * 二维DP:  开一个int[n][3]的二维数组, dp[i][j]表示涂到第i个房子时, 若涂上第j个颜色所需最小值 
 * 状态转移方程: dp[i][j] = costs[i][j] + getMinExcept(dp, i-1, j)
 * getMinExcept(dp, i, j): 找到前一个房子不涂j颜色的最小值(相邻房子颜色不能相同)
 */

public class Solution {
    // O(1) space, O(n) time
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0)
            return 0;
        int n = costs.length;
        
        for(int i = 1; i < n; i++){
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }
        return Math.min(Math.min(costs[n - 1][0], costs[n - 1][1]), costs[n - 1][2]);
    }
    
    // O(n) space, O(n) time
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0)
            return 0;
        int n = costs.length;
        int[][] dp = new int[n][3];

        // init the first column meaning cost of painting the first house
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
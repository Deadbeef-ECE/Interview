/* 题意: 
 * 其实就是把256题中的3种颜色变成k种颜色
 * 一排房子(n个), 每个房子可涂k种颜色, 各颜色的cost不同, int[n][i]表示第n个房子涂上第i 
 * (0 <= i < k)个颜色的cost, 求涂完所有颜色的最小cost(相邻房子颜色不能相同) 
 *
 * Solution:
 * 二维DP:  开一个int[n][k]的二维数组, dp[i][j]表示涂到第i个房子时, 若涂上第j个颜色所需最小值 
 * 状态转移方程: dp[i][j] = costs[i][j] + getMinExcept(dp, i-1, j)
 * getMinExcept(dp, i, j): 找到前一个房子不涂j颜色的最小值(相邻房子颜色不能相同)
 */

public class Solution {
    // O(1) space, O(nk) time
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0)
            return 0;
            
        int n = costs.length, k = costs[0].length;
        int min1 = 0, min2 = 0, idx = -1;
        for(int i = 0; i < n; i++){
            int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE, idx1 = -1;
            for(int j = 0; j < k; j++){
                int cost  = costs[i][j] + (j == idx ? min2 : min1);
                if(cost < m1){
                    m2 = m1; m1 = cost; idx1 = j;
                }else if(cost < m2){
                    m2 = cost;
                }
            }
            min1 = m1; min2 = m2; idx = idx1;
        }
        return min1;
    }
    
    // O(k) space, O(nk) time
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0)   return 0;
        int n = costs.length;
        int k = costs[0].length;
        int[] dp = new int[k];  // the cost of ith color until each house
        int m1 = 0 , m2 = 0;
        
        for(int i = 0; i < n; i++){
            int temp1 = m1, temp2 = m2;
            m1 = Integer.MAX_VALUE;
            m2 = Integer.MAX_VALUE;
            for(int j = 0; j < k; j++){
                dp[j] = (dp[j] == temp1 ? temp2 : temp1) + costs[i][j];
                if(m1 <= dp[j]){
                    m2 = Math.min(dp[j], m2);
                }else{
                    m2 = m1;
                    m1 = dp[j];
                }
            }
        }
        return m1;
    }
    // O(nk) space, O(nk^2) time
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0)
            return 0;
        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n][k];
        // init the first column meaning cost of painting the first house
        for(int i = 0; i < k; i++)
            dp[0][i] = costs[0][i];
            
        for(int i = 1; i < n; i++){
            for(int j = 0; j < k; j++){
                dp[i][j] = costs[i][j] + getMinExcept(dp, i-1, j);
            }
        }
        
        int min = dp[n-1][0];
        for(int i = 1; i < k; i++)
            min = Math.min(min, dp[n-1][i]);
        return min;
    }
    
    private int getMinExcept(int[][] dp, int i, int j){
        int min = Integer.MAX_VALUE;
        for(int n = 0; n < dp[0].length; n++){
            if(n == j)  continue;
            min = Math.min(min, dp[i][n]); 
        }
        return min;
    }
}
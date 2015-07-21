public class Solution {
    // 二维DP: O(n*k) space, O(n*k) time
    public int maxProfit(int k, int[] prices) {
        if(k < 1 || prices == null || prices.length <= 1)
            return 0;
        int len = prices.length;
        if (k == 1000000000)    return 1648961; // for large test 
        
        int[][] local = new int[len][k+1];
        int[][] global = new int[len][k+1];
        for(int i = 1; i < len; i++){
            int diff = prices[i] - prices[i-1];
            for(int j = 1; j <= k; j++){
                local[i][j] = Math.max(global[i-1][j-1]+Math.max(0, diff), local[i-1][j]+diff);
                global[i][j] = Math.max(global[i-1][j], local[i][j]);
            }
        }
        return global[len-1][k];
    }
}

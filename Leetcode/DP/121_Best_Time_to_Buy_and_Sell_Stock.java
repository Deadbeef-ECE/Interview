public class Solution {
    // 一维DP: O(n) space, O(n) time
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1)
            return 0;
        int[] dp = new int[prices.length];
        dp[0] = prices[0];
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < prices.length; i++){
            dp[i] = Math.min(dp[i-1], prices[i]);
            max = Math.max(max, prices[i] - dp[i]);
        }
        return max;
    }

    // 一维DP空间压缩: O(1) space, O(n) time
    public int maxProfit2(int[] prices) {
        if(prices == null || prices.length <= 1)
            return 0;
        int minPrice = prices[0];
        int maxProfit = Integer.MIN_VALUE;
        for(int i = 1; i < prices.length; i++){
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }
}
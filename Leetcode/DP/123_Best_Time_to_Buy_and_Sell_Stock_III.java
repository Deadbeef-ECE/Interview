public class Solution {
    // 一维DP, O(n) space, O(1) time
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1)
            return 0;
        int[] maxProfitUntilI = new int[prices.length]; // 0 => i
        int[] maxProfitFromI = new int[prices.length];  // i => N
        // MaxProfit from day 0 => i
        int MinPrice = prices[0];
        int MaxProfit = Integer.MIN_VALUE;
        for(int i = 1; i < prices.length; i++){
            MinPrice = Math.min(MinPrice, prices[i]);
            MaxProfit = Math.max(MaxProfit, prices[i] - MinPrice);
            maxProfitUntilI[i] = MaxProfit;
        }
        // MaxProfit from day i => N
        int MaxPrice = prices[prices.length-1];
        MaxProfit = Integer.MIN_VALUE;
        for(int i = prices.length - 2; i >= 0; i--){
            MaxPrice = Math.max(MaxPrice, prices[i]);
            MaxProfit = Math.max(MaxProfit, MaxPrice - prices[i]);
            maxProfitFromI[i] = MaxProfit;
        }
        // All possible break down
        int max = maxProfitFromI[0] + maxProfitUntilI[0];
        for(int i = 1; i < prices.length; i++)
            max = Math.max(max, maxProfitFromI[i] + maxProfitUntilI[i]);
        return max;
    }
}
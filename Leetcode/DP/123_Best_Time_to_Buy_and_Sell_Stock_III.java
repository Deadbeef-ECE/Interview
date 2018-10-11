// K维DP， 此题k = 2, 可适用于any trascation number
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)  return 0;
        int[][] dp = new int[3][prices.length];
        for(int k = 1; k <= 2; k++){
            for(int i = 1; i < prices.length; i++){
                int min = prices[0];
                for(int j = 1; j <= i; j++){
                    min = Math.min(min, prices[j] - dp[k-1][j-1]);
                }
                dp[k][i] = Math.max(dp[k][i-1], prices[i] - min);
            }
        }
        return dp[2][prices.length - 1];
    }
}
// 一维DP
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[] dp = new int[prices.length];
        for (int k = 1; k <= 2; k++) {
            int min = prices[0], last = 0;
            for (int i = 1; i < prices.length; i++) {
                min = Math.min(min, prices[i] - last);
                last = dp[i];
                dp[i] = Math.max(dp[i-1],  prices[i] - min);
            }
        }
        return dp[prices.length - 1];
    }
}

// dp[k, i] = max(dp[k, i-1], prices[i] - prices[j] + dp[k-1, j-1]), j=[0..i-1]
// For k transactions, on i-th day,
// if we don't trade then the profit is same as previous day dp[k, i-1];
// and if we bought the share on j-th day where j=[0..i-1], then sell the 
// share on i-th day then the profit is prices[i] - prices[j] + dp[k-1, j-1] .
// Actually j can be i as well. When j is i, the one more extra item 
// prices[i] - prices[j] + dp[k-1, j] = dp[k-1, i] looks like we just lose 
// one chance of transaction.

// I see someone else use the formula 
// dp[k, i] = max(dp[k, i-1], prices[i] - prices[j] + dp[k-1, j]), where the 
// last one is dp[k-1, j] instead of dp[k-1, j-1]. It's not the direct sense, 
// as if the share was bought on j-th day, then the total profit of previous 
// transactions should be done on (j-1)th day. However, the result based on 
// that formula is also correct, because if the share was sold on j-th day and 
// then bought again, it is the same if we didn't trade on that day.
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/discuss/135704/Detail-explanation-of-DP-solution
// 动态转移方程适用于309
// dp[i] = max(dp[i-1], prices[i] - prices[j] + dp[j-2]), j=[0..i-1]
// If we sell the shares on i-th day bought on j-th day, we couldn't trade on (j-1)-th 
// day because of cooldown. So the last one is dp[j-2].
// The straight implementation is:
//     public int MaxProfit(int[] prices) {
//         if (prices.Length < 2) return 0;
//         var dp = new int[prices.Length + 1]; // use 1 more to guard
//         int min = prices[0];
//         for (int i = 1; i < prices.Length; i++) {
//             min = Math.Min(min, prices[i] - dp[i-1]);
//             dp[i+1] = Math.Max(dp[i], prices[i] - min);
//         }
//         return dp[dp.Length-1];
//     }
// Same idea to compact space. Here dp[i] only depends on dp[i-1] and dp[i-2], so dp can be compacted to two variables. The compacted space is O(1). e.g.

//     // dp[i] = max(dp[i-1], prices[i] - prices[j] + dp[j-2]), j=[0..i-1]
//     public int MaxProfit(int[] prices) {
//         if (prices.Length < 2) return 0;
//         int prev = 0, res = 0;
//         int min = prices[0];
//         for (int i = 1; i < prices.Length; i++) {
//             min = Math.Min(min, prices[i] - prev);
//             prev = res;
//             res = Math.Max(res, prices[i] - min);
//         }
//         return res;
//     }


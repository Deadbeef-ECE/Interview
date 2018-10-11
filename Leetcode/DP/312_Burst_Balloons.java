class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int[] num = new int[n + 2];
        num[0] = num[n + 1] = 1;
        for(int i = 0; i < n; i++)
            num[i + 1] = nums[i];
        int[][] dp = new int[n + 2][n + 2];
        for(int len = 1; len <= n; len++){
            for(int i = 1; i <= n - len + 1; i++){
                int j = i + len - 1;
                for(int x = i; x <= j; x++){
                    dp[i][j] = Math.max(dp[i][j], 
                    num[x] * num[i - 1] * num[j + 1] + dp[i][x - 1] + dp[x + 1][j]);
                }
            }
        }
        return dp[1][n];
    }
}

// 最后的剩下一个气球为i的时候，可以获得的分数为：nums[-1]*nums[i]*nums[n].
// 那么介于i,j之间的x，有： dp[i][j] = max(dp[i][j], dp[i][x – 1] + nums[i – 1] * nums[x] * nums[j + 1] + dp[x + 1][j]);
// 这里，为了方便代码书写，我在首尾插入了两个1，所以答案是 dp[1][n] (n为原来的长度)
// https://www.hrwhisper.me/leetcode-burst-balloons/

public class Solution {
    public int DP(int i, int j, int[] nums, int[][] dp) {
        if (dp[i][j] > 0) return dp[i][j];
        for (int x = i; x <= j; x++) {
            dp[i][j] = Math.max(dp[i][j], DP(i, x - 1, nums, dp) + nums[i - 1] * nums[x] * nums[j + 1] + DP(x + 1, j, nums, dp));
        }
        return dp[i][j];
    }
 
    public int maxCoins(int[] iNums) {
        int n = iNums.length;
        int[] nums = new int[n + 2];
        for (int i = 0; i < n; i++) nums[i + 1] = iNums[i];
        nums[0] = nums[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        return DP(1, n, nums, dp);
    }
}
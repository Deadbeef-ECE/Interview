public class Solution {
    // 一维DP, O(n) space, O(n) time
    public int rob(int[] nums) {
        if(nums.length <= 1)
            return nums.length == 1 ? nums[0]:0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        return dp[nums.length-1];
    }
    
    // 一维DP空间压缩， O(1) space, O(n) time
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int prev = 0;
        int curMax = nums[0];
        for(int i = 1; i < nums.length; i++){
            int temp = prev + nums[i];
            prev = curMax;
            curMax = Math.max(temp, prev);
        }
        return curMax;
    }
}
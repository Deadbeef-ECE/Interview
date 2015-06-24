public class Solution {
    // 一维DP空间压缩
    // O(1) space, O(n) time
    public boolean canJump(int[] nums) {
        if(nums.length <= 1)
            return true;
        int maxDistance = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(maxDistance < i) return false;
            maxDistance = Math.max(maxDistance, i+nums[i]);
            if(maxDistance >= nums.length - 1)
                return true;
        }
        return false;
    }

    // 一维DP
    // O(n) space, O(n) time
    public boolean canJump2(int[] nums) {
        if(nums.length <= 1)
            return true;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(dp[i-1] < i) return false;
            dp[i] = Math.max(nums[i]+i, dp[i-1]);
            if(dp[i] >= nums.length-1)
                return true;
        }
        return false;
    }
}
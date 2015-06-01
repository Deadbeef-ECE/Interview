public class Solution {
    // 一维DP, O(n) space, O(1) time
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
    
    // 一维DP空间压缩， O(1) space, O(1) time
    public int rob2(int[] nums) {
        int a = 0, b = 0;
        for(int i = 0; i < nums.length; i++){
            if(i % 2 == 0){
                a += nums[i];
                a = Math.max(a, b);
            }else{
                b += nums[i];
                b = Math.max(a, b);
            }
        }
        return Math.max(a, b);
    }
}
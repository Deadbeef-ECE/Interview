public class Solution {
    // naive dp:
    // O(n) space, O(n^2) time
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int max = 1;
        int[] dp = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }
}
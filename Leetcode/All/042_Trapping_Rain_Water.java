public class Solution {
    // DP:
    // O(n) time, O(n) space
    public int trap(int[] height) {
        if(height == null || height.length < 2)
            return 0;
        int[] dp = new int[height.length];
        dp[0] = height[0];
        for(int i = 1; i < height.length; i++)
            dp[i] = Math.max(dp[i-1], height[i]);
        int area = 0;
        // RightMax keep the heighest column from right to left
        int RightMax = height[height.length - 1];
        for(int i = height.length - 1; i >= 0; i--){
            RightMax = Math.max(RightMax, height[i]);
            int h = Math.min(RightMax, dp[i]);
            area += h - height[i];
        }
        return area;
    }
}
public class NumArray {
    int[] dp;
    public NumArray(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
        dp = new int[nums.length + 1];
        dp[0] = 0;
        for(int i = 1; i <= nums.length; i++)
            dp[i] = dp[i-1] + nums[i-1];
    }

    public int sumRange(int i, int j) {
        if(dp == null || dp.length == 0)
            return 0;
        return dp[j+1] - dp[i];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
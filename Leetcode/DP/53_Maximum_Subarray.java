public class Solution {
    // (1) 一维DP, O(n) space, O(1) time
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    // (2) 一维DP空间压缩, O(1) space, O(n) time
    public int maxSubArray2(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int dp = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp = Math.max(dp + nums[i], nums[i]);
            max = Math.max(max, dp);
        }
        return max;
    }

    // (3) Dide & Conqure, O(1) space, O(nlogn) time
    public int maxSubArray3(int[] A) {
        int maxSum = Integer.MIN_VALUE;
        return findMaxSub(A, 0, A.length - 1, maxSum);
    }
     
    // recursive to find max sum 
    // may appear on the left or right part, or across mid(from left to right)
    private int findMaxSub(int[] A, int left, int right, int maxSum) {
        if(left > right)    return Integer.MIN_VALUE;
         
        // get max sub sum from both left and right cases
        int mid = (left + right) / 2;
        int leftMax = findMaxSub(A, left, mid - 1, maxSum);
        int rightMax = findMaxSub(A, mid + 1, right, maxSum);
        maxSum = Math.max(maxSum, Math.max(leftMax, rightMax));
        
        // another case: across mid
        // need to expend to both left and right using mid as center
        // mid-1 -> left
        int sum = 0, midLeftMax = 0;
        for(int i = mid - 1; i >= left; i--) {
            sum += A[i];
            if(sum > midLeftMax)   
                midLeftMax = sum;
        }
        // mid+1 -> right
        sum = 0; int midRightMax = 0;
        for(int i = mid + 1; i <= right; i++) {
            sum += A[i];
            if(sum > midRightMax)    
                midRightMax = sum;
        }
         
        // get the max value from the left, right and across mid
        maxSum = Math.max(maxSum, midLeftMax + midRightMax + A[mid]);

        return maxSum;
    }
    // (4) kadane algorithm: O(n) space, O(1) time
    // 注：input的所有元素都是负数的话，此算法无比蛋疼！！！！
    public int maxSubArray4(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int max_so_far = 0;
        int max_ending_here = 0;
        for(int i = 0; i < nums.length; i++){
            max_ending_here += nums[i];
            if(max_ending_here < 0)
                max_ending_here = 0;
            if(max_so_far < max_ending_here)
                max_so_far = max_ending_here;
        }
        return max_so_far;
    }
}
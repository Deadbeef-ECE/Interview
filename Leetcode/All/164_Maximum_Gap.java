public class Solution {
    // O(n) space, O(n) time
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        int min = nums[0];
        int max = nums[0];
        for(int n : nums){
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        int gap = (max - min) / (nums.length-1) == 0 ? 
        (max - min) / (nums.length-1) : (max - min) / (nums.length-1) + 1;
        int[] BuckMin = new int[nums.length-1];
        int[] BuckMax = new int[nums.length-1];
        Arrays.fill(BuckMin, Integer.MAX_VALUE);
        Arrays.fill(BuckMax, Integer.MIN_VALUE);
        for(int n : nums){
            if(n == min || n == max)  continue;
            int index = (n - min)/gap;
            BuckMin[index] = Math.min(n, BuckMin[index]);
            BuckMax[index] = Math.max(n, BuckMax[index]);
        }

        int MaxGap = Integer.MIN_VALUE;
        int pre = min;
        for(int i = 0; i < nums.length-1; i++){
            if(BuckMin[i] == Integer.MAX_VALUE && BuckMax[i] == Integer.MIN_VALUE)  continue;
            MaxGap = Math.max(MaxGap, BuckMin[i] - pre);
            pre = BuckMax[i];
        }
        MaxGap = Math.max(MaxGap, max - pre);
        return MaxGap;
    }
}
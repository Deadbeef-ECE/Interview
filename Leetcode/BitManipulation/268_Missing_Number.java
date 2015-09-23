public class Solution {
    // 数学解法，0要特殊对待
    public int missingNumber(int[] nums) {
        boolean hasZero = false;
        int len = nums.length;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(nums[i] == 0)    
                hasZero = true;
        }
        int idea = (0 + len) * (len + 1) / 2;
        return hasZero ? idea - sum : 0;
    }

    // 位操作
    public int missingNumber(int[] nums) {
        int ret = 0, i = 0;
        for(; i < nums.length; i++){
            ret = ret ^ i ^ nums[i];
        }
        return ret ^ i;
    }
}
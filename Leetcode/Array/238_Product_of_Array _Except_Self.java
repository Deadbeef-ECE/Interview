public class Solution {
    // O(1) space, O(n) time
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0)
            return nums;
        int[] ret = new int[nums.length];
        int temp = 1;
        for(int i = 0; i < nums.length; i++){
            ret[i] = temp;
            temp *= nums[i];
        }
        
        temp = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            ret[i] *= temp;
            temp *=  nums[i];
        }
        return ret;
    }
}
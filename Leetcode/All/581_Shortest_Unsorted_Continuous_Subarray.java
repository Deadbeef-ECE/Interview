public class Solution {
    // O(n) time, O(1) space
    public int findUnsortedSubarray(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int s = -1, e = -1;
        int max = nums[0], min = nums[nums.length - 1];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > max)   max = nums[i];
            else if(nums[i] < max)  e = i;
        }
        if(e == -1)    return 0;
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] < min)   min = nums[i];
            else if(nums[i] > min)  s = i;
        }
        return e - s + 1;
    }
}
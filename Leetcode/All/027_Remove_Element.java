public class Solution {
    // O(n) time, O(1) space
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0)
            return 0;
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val)
                nums[j++] = nums[i];
        }
        return j;
    }
}
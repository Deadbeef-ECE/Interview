public class Solution {
    // O(n) time, O(1) space
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int j = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
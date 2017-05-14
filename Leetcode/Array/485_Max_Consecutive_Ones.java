public class Solution {
    //O(n) time, O(1) space
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int max = 0, cnt = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1)
                max = Math.max(max, ++cnt);
            else   
                cnt = 0;
        }
        return max;
    }
}
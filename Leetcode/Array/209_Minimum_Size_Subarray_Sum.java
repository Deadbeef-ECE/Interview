public class Solution {
    // O(1) space, O(n) time
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int start = 0, end = 0, sum = 0, len = Integer.MAX_VALUE;
        while(end != nums.length){
            while(sum + nums[end] < s){
                if(end == nums.length-1)  return 0;
                sum += nums[end++]; 
            }
            sum += nums[end++];
            while(sum - nums[start] >= s){
                sum -= nums[start++];
                if(start == end - 1)    return 1;
            }
            len = Math.min(len, end - start);
        }
        return len;
    }
}
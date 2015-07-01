public class Solution {
    // 如何决定最后是return lo 还是 hi:
    // 可以用edge case来试: nums = {1}, target = 0 或 2
    // nums = {1}, target = 2和
    // nums = {1,2,5,8,10,14,17,20}, target = 7是一样的效果
    //
    // O(1) space, O(logn) time
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return 0;
        int lo = 0;
        int hi = nums.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] > target){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return lo;
    }
}
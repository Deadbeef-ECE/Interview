public class Solution {
    // O(1) space, O(logn) time
    public int findPeakElement(int[] nums) {
        if(nums == null)    return -1;
        if(nums.length == 1)    return 0;
        int lo = 0, hi = nums.length-1;
        while(lo <= hi){
            if(lo == hi)    return lo;
            int mid = lo + (hi - lo)/2;
            if(nums[mid] < nums[mid+1]){
                lo = mid+1;
            }else{
                hi = mid;
            }
        }
        return -1;
    }
}
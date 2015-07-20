public class Solution {
    // O(1) space, O(logn) time
    public int[] searchRange(int[] nums, int target) {
        int[] ret = {-1, -1};
        if(nums == null || nums.length == 0)
            return ret;
        
        //find the smallest index
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(target <= nums[mid]){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        // find the biggest index
        int lo2 = 0, hi2 = nums.length - 1;
        while(lo2 <= hi2){
            int mid = lo2 + (hi2 - lo2)/2;
            if(target >= nums[mid]){
                lo2 = mid + 1;
            }else{
                hi2 = mid - 1;   
            }
        }
        // biggest index must be bigger than smallest index
        if(hi2 >= lo){
            ret[0] = lo; ret[1] = hi2;
        }
        return ret;
    }
}
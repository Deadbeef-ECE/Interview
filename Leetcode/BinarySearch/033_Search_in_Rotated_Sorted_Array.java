public class Solution {
    // O(1) space, O(logn) time
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == -1)
            return -1;
        int lo = 0;
        int hi = nums.length-1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(target == nums[mid])
                return mid;
            // right part is sorted
            if(nums[mid] < nums[hi]){
                if(target > nums[mid] && target <= nums[hi])
                    lo = mid + 1;
                else
                    hi = mid - 1; 
            }else{// left part is sorted
                if(target < nums[mid] && target >= nums[lo])
                    hi = mid - 1;
                else
                    lo = mid + 1;
            }
        }
        return -1;
    }
}
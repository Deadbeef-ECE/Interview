public class Solution {
    // O(1) space, O(logn) avg time, O(n) worest case
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return false;
        int lo = 0;
        int hi = nums.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(nums[mid] == target)
                return true;
            // right part is sorted
            if(nums[mid] < nums[hi]){
                if(target > nums[mid] && target <= nums[hi])
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }else{
                // maybe not determined
                if(nums[mid] == nums[hi]){
                    hi--;   continue;
                }
                if(target < nums[mid] && target >= nums[lo])
                    hi = mid - 1;
                else 
                    lo = mid + 1;
            }
        }
        return false;
    }
}
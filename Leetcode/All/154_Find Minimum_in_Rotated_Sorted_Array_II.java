public class Solution {
    // O(1) space, O(logn) avg time, O(n) worest case
    public int findMin(int[] arr) {
        if(arr == null || arr.length == 0)
            return 0;
        int lo = 0;
        int hi = arr.length - 1;
        while(lo < hi){
            int mid = lo + (hi - lo)/2;
            // right part is sorted
            if(arr[mid] < arr[hi])
                hi = mid;
            // left part is sorted or cannot determine
            else{
                if(arr[mid] == arr[hi]){
                    hi--;   continue;
                }
                lo = mid + 1;
            }
        }
        return arr[lo];
    }
    
    // 偷懒解法， 不推荐，如果让你返回min的index，此解法废了
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int lo = 0, hi = nums.length - 1;
        int ret = nums[0];
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(nums[mid] <= nums[hi]){
                if(nums[mid] == nums[hi]){
                    ret = Math.min(ret, nums[hi]);
                    hi--;
                    continue;
                }
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
            ret = Math.min(ret, nums[mid]);
        }
        return ret;
    }
}
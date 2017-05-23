public class Solution {
    // Binary Search:
    // nums1.length = n, nums2.length = m;
    // O(nlogm + mlogm) time, O(m) space
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0)  return nums1;
        if(nums2 == null || nums2.length == 0)  return nums2;
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums1.length; i++){
            if(search(nums2, nums1[i]))
                set.add(nums1[i]);
        }
        int[] ret = new int[set.size()];
        int i = 0;
        for(Integer n : set){
            ret[i++] = n;
        }
        return ret;
    }
    
    public boolean search(int[] nums, int target){
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(nums[mid] == target)
                return true;
            if(nums[mid] > target)
                r = mid - 1;
            else 
                l = mid + 1;
        }
        return false;
    }
}
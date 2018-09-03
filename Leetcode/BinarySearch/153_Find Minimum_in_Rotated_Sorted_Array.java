public class Solution {
	/* 给一个sorted but rotated int[n], 无dups, 找minimum, 找不到返回-1 
	 * 每次分一半，必有一半是sorted，一半是unsorted, 那么min要么是在sorted那一半的第一个(第三种情况),
	 * 要么是在unsorted的部分，因此为了应对第三种情况，hi在改变的时候，hi = mid而不是mid-1. 
	 * 0, 1, 2,  4,  5, 6, 7           4, 5, 6,  7,  0, 1, 2           5, 6, 7,  0,  1, 2, 4        
	 * lo       mid       hi          lo        mid       hi           lo       mid        hi  */

	// O(1) space, O(logn) time
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] < nums[r])
                r = mid;
            else
                l = mid + 1;
        }
        return nums[r];
    }

    // 偷懒解法， 不推荐，如果让你返回min的index，此解法废了
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int lo = 0, hi = nums.length - 1;
        int ret = nums[0];
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(nums[mid] <= nums[hi])
                hi = mid - 1;
            else
                lo = mid + 1;
            ret = Math.min(ret, nums[mid]);
        }
        return ret;
    }

    // 如果nums有Integer.MAX_VALUE, 此解法也不行
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int min = nums[0];

        while(l <= r){
            int mid = (r + l) >> 1;
            int left = mid == 0 ? Integer.MAX_VALUE : nums[mid-1];
            int right = mid == nums.length - 1 ? Integer.MAX_VALUE : nums[mid+1];
            if(nums[mid] < left && nums[mid] < right)   return nums[mid];
            if(nums[mid] < nums[r])
                r = mid - 1;
            else
                l = mid + 1;
            
        }
        return 0;
    }
}
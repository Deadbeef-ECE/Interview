class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)    return -1;
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int mid = (r + l) >> 1;
            if(target == nums[mid]) return mid;
            if(target > nums[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }
}
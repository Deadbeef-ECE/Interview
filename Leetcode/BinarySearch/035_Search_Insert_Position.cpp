class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        if(nums.size() == 0)    return 0;
        int lo = 0, hi = nums.size() - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return lo;
    }
};
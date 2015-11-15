class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        // find the lowest position
        vector<int> ret(2, -1);
        int lo = 0, hi = nums.size() - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] >= target)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        int leftMost = lo;
        
        lo = 0, hi = nums.size() - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] <= target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        int rightMost = hi;
        
        if(leftMost <= rightMost){
            ret[0] = leftMost;
            ret[1] = rightMost;
        }
        return ret;
    }
};
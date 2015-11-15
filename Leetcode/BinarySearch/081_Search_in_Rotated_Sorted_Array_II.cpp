class Solution {
public:
    bool search(vector<int>& nums, int target) {
        if(nums.size() == 0)
            return false;
        int lo = 0, hi = nums.size() - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] == target) 
                return true;
            if(nums[mid] >= nums[lo]){
                if(nums[mid] == nums[lo]){
                    lo++;
                    continue;
                }
                if(target < nums[mid] && target >= nums[lo])
                    hi = mid - 1;                           
                else
                    lo = mid + 1;
            }else{
                if(target > nums[mid] && target <= nums[hi]) 
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }
        }
        return false;
    }
};
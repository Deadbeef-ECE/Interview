class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        if(nums.size() <= 1)    return 0; 
        int lo = 0, hi = nums.size() - 1;
        
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(mid != 0 && mid != nums.size() - 1 && nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;
            if(mid == 0 && nums[mid] > nums[mid + 1])
                return mid;
            if(mid == nums.size() - 1 && nums[mid] > nums[mid - 1])
                return mid;
            
            if(nums[mid] < nums[mid+1])
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return 0;
    }
};
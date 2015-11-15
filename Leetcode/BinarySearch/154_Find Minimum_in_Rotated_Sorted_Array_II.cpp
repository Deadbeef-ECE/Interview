class Solution {
public:
    int findMin(vector<int>& nums) {
        if(nums.size() == 0)
            return 0;
        int ret = nums[0];
        int lo = 0, hi = nums.size() - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] >= nums[hi]){
                if(nums[mid] == nums[hi]){
                    ret = min(ret, nums[hi]);
                    hi--;
                    continue;
                }
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
            ret = min(ret, nums[mid]);
        }
        return ret;
    }
};
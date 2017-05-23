class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        int ret = nums[0] + nums[1] + nums[2];
        int diff = abs(target - ret);
        for(int i = 0; i < nums.size() - 2; i++){
            int l = i + 1, r = nums.size() - 1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == target)   
                    return target;
                int new_diff = abs(sum - target);
                if(new_diff < diff){
                    diff = new_diff;
                    ret = sum;
                }
                if(sum > target){
                    r--;
                }else if(sum < target){
                    l++;
                }
            }
        }
        return ret;
    }
};
class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        vector<int> ret(nums.size());
        
        int temp = 1;
        for(int i = 0; i < nums.size(); i++){
            ret[i] = temp;
            temp *= nums[i];
        }
        
        temp = 1;
        for(int i = nums.size() - 1; i >= 0; i--){
            ret[i] *= temp;
            temp *= nums[i];
        }
        return ret;
    }
};
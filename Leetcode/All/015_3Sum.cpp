class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> ret;
        if(nums.size() < 3) 
            return ret;
        sort(nums.begin(), nums.end());
        
        for(int i = 0; i < nums.size() - 2; i++){
            if(i != 0 && nums[i] == nums[i-1])  continue;
            int l = i + 1, r = nums.size() - 1;
            while(l < r){
                int sum = nums[i] + nums[r] + nums[l];
                if(sum == 0){
                    vector<int> sol;
                    sol.push_back(nums[i]);
                    sol.push_back(nums[l]);
                    sol.push_back(nums[r]);
                    ret.push_back(sol);
                    l++; r--;
                    while(l < r && nums[l] == nums[l-1])
                        l++;
                    while(l < r && nums[r] == nums[r+1])
                        r--;
                }else if(sum < 0){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return ret;
    }
};
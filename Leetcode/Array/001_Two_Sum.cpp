class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> ret;
        unordered_map<int, int> map;
        for(int i = 0; i < nums.size(); i++){
            if(map.find(target - nums[i]) != map.end()){
                ret.push_back(map[target - nums[i]] + 1);
                ret.push_back(i+1);
                break;
            }
            map[nums[i]] = i;
        }
        return ret;
    }
};
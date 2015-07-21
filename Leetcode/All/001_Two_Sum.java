public class Solution {
    // O(n) time, O(n) space
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        if(nums == null || nums.length == 0)
            return ret;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                ret[0] = map.get(target - nums[i]) + 1;
                ret[1] = i + 1;
            }
            map.put(nums[i], i);
        }
        return ret;
    }
}
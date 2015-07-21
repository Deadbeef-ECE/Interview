public class Solution {
    // O(n^2) time, O(1) space
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return 0;
        
        Arrays.sort(nums);
        int ret = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length - 2; i++){
            int l = i + 1, r = nums.length - 1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                int curDiff = Math.abs(target - sum);
                if(curDiff < diff){
                    diff = curDiff;
                    ret = sum;
                }
                if(sum > target)
                    r--;
                else
                    l++;
            }
            
        }
        return ret;
    }
}
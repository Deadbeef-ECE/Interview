public class Solution {
    // O(1) space, O(n^2) time
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length <= 2)
            return 0;
        Arrays.sort(nums);
        int cnt = 0;
        // 不要手贱去去重
        for(int i = 0; i < nums.length - 2; i++){
            int l = i + 1, r = nums.length - 1; 
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum < target){
                    cnt += r - l;
                    l++;
                }else
                    r--;
            }
        }
        return cnt;
    }
}
public class Solution {
    // Brute-force:
    // O(n^2) time, O(1) space
    public int reversePairs(int[] nums) {
        int cnt = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] > (2 * (long)nums[j]))
                    cnt++;
            }
        }
        return cnt;
    }
}
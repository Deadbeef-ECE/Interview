public class Solution {
    // 状压DP, O(1) space, O(n) time
    public int rob(int[] nums) {
        if(nums.length == 1)    return nums[0];
        int a = 0, b = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(i % 2 == 0){
                a += nums[i];
                a = Math.max(a, b);
            }else{
                b += nums[i];
                b = Math.max(a, b);
            }
        }
        int sol1 = Math.max(a, b);
        a = 0; b = 0;
        for(int i = 1; i < nums.length; i++){
            if(i % 2 == 0){
                a += nums[i];
                a = Math.max(a, b);
            }else{
                b += nums[i];
                b = Math.max(a, b);
            }
        }
        int sol2 = Math.max(a, b);
        return Math.max(sol1, sol2);
    }
    // 一维DP， O(n) space, O(n) time
    public int rob(int[] nums) {
        if(nums.length < 2)
            return nums.length == 1 ? nums[0]:0;
   
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        dp1[0] = nums[0];
        dp1[1] = nums[0];
        for(int i = 2; i < nums.length-1; i++){
            dp1[i] = Math.max(dp1[i-1], dp1[i-2]+nums[i]);
        }
        
        dp2[0] = 0;
        dp2[1] = nums[1];
        for(int i = 2; i < nums.length; i++){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2]+nums[i]);
        }
        
        return Math.max(dp1[nums.length-2], dp2[nums.length-1]);
    }
}
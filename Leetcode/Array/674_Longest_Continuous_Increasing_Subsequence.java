class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int len = 1, temp = 1;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] < nums[i + 1]){
                temp++;
                len = Math.max(len, temp);
            }else{
                temp = 1;
            }
        }
        return len;
    }
}
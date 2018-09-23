class Solution {
    // Two pointer
    public void moveZeroes(int[] nums) {
        int j = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                if(j != i){
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
        return;
    }
}
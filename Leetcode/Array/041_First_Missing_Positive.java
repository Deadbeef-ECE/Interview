public class Solution {
    // O(n) time, O(1) space
    public int firstMissingPositive(int[] nums) {
        int i = 0, n = nums.length;
        while(i < n){
            // nums[i] 放i+1 && nums[i] 不越界 && nums[i]应该放在index为nums[i]-1的地方, 若重复, 不交换
            if(nums[i] != i+1 && nums[i] > 0 && nums[i] < n && nums[i] != nums[nums[i]-1]){
                swap(nums, i, nums[i] - 1);
            }else{
                i++;
            }
        }
        for(i = 0; i < nums.length; i++){
            if(nums[i] != i+1)
                return i+1;
        }
        return n+1;
    }
    
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
public class Solution {
    // O(n) time, O(1) space
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
        
        int red = 0, blue = nums.length - 1;
        int i = 0;
        
        while(i <= blue){
            if(nums[i] == 2){
                swap(nums, i, blue--);
                continue;
            }
            if(nums[i] == 0){
                swap(nums, i++, red++);
                continue;
            }
            i++;
        }
        return;
    }
    
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
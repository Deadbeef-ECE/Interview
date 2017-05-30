public class Solution {
    // 同 31. Next Permutation
    public int nextGreaterElement(int n) {
        char[] nums = ("" + n).toCharArray();

        int start = -1;
        for(int i = nums.length - 1; i >= 1; i--){
            if(nums[i - 1] <  nums[i]){
                start = i - 1;
                break;
            }
        }
        if(start == -1) return -1;
        int end = 0;
        for(int i = nums.length - 1; i > start; i--){
            if(nums[i] > nums[start]){
                end = i;
                break;
            }
        }
        swap(nums, start, end);
        reverse(nums, start + 1, nums.length - 1);
        long ret = Long.parseLong(new String(nums));
        if(ret > Integer.MAX_VALUE) return -1;
        return (int)ret;
    }
    
    public void swap(char[] nums, int a, int b){
        char temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    public void reverse(char[] nums, int i, int j){
        while(i < j){
            swap(nums, i++, j--);
        }
    }
}
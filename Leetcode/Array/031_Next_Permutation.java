public class Solution {
    // O(1) space, O(n) time
    //traversal the array to find the first decrease order
    // 1 2 3 4 5 4 3 2
    //       i
    public void nextPermutation(int[] num) {
        if(num == null || num.length <= 1)
            return;
        // 从后往前找到一个降序的较小值
        int start = nums.length - 2;
        while(start >= 0){
            if(nums[start] < nums[start + 1])
                break;
            start--;
        }
        // 找到在start后面比num[start]大的最小值
        // 从start往后找的话要加入diff变量取最小的
        // 因为从 start+1＝> n-1 是降序, 因此从后往前找不需要引入diff变量
        if(start >= 0){
            for(int end = nums.length - 1; end > start; end--){
                if(nums[end] > nums[start]){
                    swap(nums, start, end);
                    break;
                }
            }
        }
        reverse(nums, start + 1, nums.length - 1);
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int l, int r){
        while(l < r){
            swap(nums, l++, r--);
        }
    }
}
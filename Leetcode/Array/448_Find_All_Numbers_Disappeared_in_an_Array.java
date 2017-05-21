public class Solution {
    // O(n) time, O(1) space
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new LinkedList<Integer>();
        int i = 0, n = nums.length;
        while(i < n){
            if(nums[i] != i + 1 && nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }
        
        for(i = 0; i < n; i++){
            if(nums[i] != i + 1)
                ret.add(i + 1);
        }
        return ret; 
    }
    
    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
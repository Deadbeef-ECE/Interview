public class Solution {
    // O(n) time, O(1) space
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int slow = n;
        int fast = n;
        while(true){
            slow = nums[slow-1];
            fast = nums[nums[fast-1] - 1];
            if(slow == fast)    break;
        }

        slow = n;
        while(slow != fast){
            slow = nums[slow - 1];
            fast = nums[fast - 1];
        }
        return slow;
    }
}
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return new int[0];
        int n = nums.length;
        int[] ret = new int[n-k+1];
        Deque<Integer> dq = new LinkedList<Integer>();
        for(int i = 0; i < nums.length; i++){
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) 
                dq.pollLast();
            while (!dq.isEmpty() && dq.peekFirst() <= i - k)
 				dq.pollFirst();
            dq.addLast(i);
            if(i >= k-1)
                ret[i-k+1] = nums[dq.peekFirst()];
            
        }
        return ret;
    }
}
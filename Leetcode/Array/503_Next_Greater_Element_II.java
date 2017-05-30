public class Solution {
    // Stack:
    // ref: http://www.cnblogs.com/grandyang/p/6442861.html
    // https://www.youtube.com/watch?v=NBcqBddFbZw&list=PLamzFoFxwoNjPfxzaWqs7cZGsPYy0x_gI
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = 0; i < 2 * n; i++){
            int idx = i % n;
            while(!stack.isEmpty() && nums[stack.peek()] < nums[idx]){
                ret[stack.peek()] = nums[idx];
                stack.pop();
            }
            if(i < n)
                stack.push(i);
        }
        return ret;
    }
}
public class Solution {
    // O(n) space, O(n) time
    public boolean verifyPreorder(int[] preorder) {
        int p = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<Integer>();
        for(int cur : preorder){
            if(cur < p)   return false;
            while(!stack.isEmpty() && stack.peek() < cur)
                p = stack.pop();
            stack.push(cur);
        }
        return true;
    }
    // TODO: O(1) space, O(n) time solution
}
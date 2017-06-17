public class Solution {
    // Stack:
    // O(n) time, O(h) space: h is max level which is n
    public int lengthLongestPath(String input) {
        String[] strs = input.split("\n");
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        int maxLen = 0;
        for(int i = 0; i < strs.length; i++){
            int level = strs[i].lastIndexOf("\t") + 1;
            while(stack.size() > level + 1)
                stack.pop();
            int len = stack.peek() + strs[i].length() - level + 1;
            stack.push(len);
            if(strs[i].contains("."))   maxLen = Math.max(maxLen, len - 1);
        }
        return maxLen;
    }
}
public class Solution {
    // 一维DP:
    
    // stack 解法:
    public int longestValidParentheses(String s) {
        if(s.length() <= 0) return 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        int start = -1;
        int maxLen = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                if(!stack.isEmpty()){
                    stack.pop();
                    if(stack.isEmpty()){
                        maxLen = Math.max(maxLen, i - start);
                    }else{
                        maxLen = Math.max(maxLen, i - (int)stack.peek());
                    }
                }else{
                    start  = i;
                }
            }
        }
        return maxLen;
    }
}
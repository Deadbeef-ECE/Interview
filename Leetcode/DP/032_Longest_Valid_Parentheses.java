// DP reference: 
// https://leetcode.com/problems/longest-valid-parentheses/discuss/14278/Two-Java-solutions-with-explanation.-Stack-and-DP.-Short-and-easy-to-understand.
public class Solution {
    // 一维DP:
    // O(n) space, O(n) time;

    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int n = s.length();
        int[] dp = new int[n];
        int left = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '('){
                left++;
            }else{
                if(left > 0){
                    left--;
                    dp[i] = dp[i - 1] + 2;
                    if(i >= dp[i])  dp[i] += dp[i - dp[i]];
                }
                if(dp[i] > max)
                    max = dp[i];
            }
        }
        return max;
    }

    // stack 解法:
    // O(n) space, O(n) time
    public int longestValidParentheses(String s) {
        if(s.length() <= 0) return 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        int start = 0;
        int maxLen = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                if(!stack.isEmpty()){
                    stack.pop();
                    if(stack.isEmpty()){
                        maxLen = Math.max(maxLen, i - start + 1);
                    }else{
                        maxLen = Math.max(maxLen, i - stack.peek()); // (()()
                    }
                }else{
                    start = i + 1;
                }
            }
        }
        return maxLen;
    }
}
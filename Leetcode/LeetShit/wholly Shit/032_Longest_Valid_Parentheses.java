// DP reference: 
// https://leetcodenotes.wordpress.com/2013/10/19/leetcode-longest-valid-parentheses-%E8%BF%99%E7%A7%8D%E6%8B%AC%E5%8F%B7%E7%BB%84%E5%90%88%EF%BC%8C%E6%9C%80%E9%95%BF%E7%9A%84valid%E6%8B%AC%E5%8F%B7%E7%BB%84%E5%90%88%E6%9C%89%E5%A4%9A/
public class Solution {
    // 一维DP:
    // O(n) space, O(n) time;

    public int longestValidParentheses(String s) {
        if(s == null || s.length() < 2) return 0;
        int len = s.length();
        int[] dp = new int[len];
        dp[len - 1] = 0;
        int max = 0;
        
        for(int i = len - 2; i >= 0; i--){
            if(s.charAt(i) == ')'){
                dp[i] = 0;
            }else{                          // i    j
                int j = i + 1 + dp[i + 1];  // (()())
                if(j < len && s.charAt(j) == ')'){
                    dp[i] = dp[i+1] + 2;
                    if(j + 1 < len && s.charAt(j) == ')') // ()()
                        dp[i] += dp[j+1];
                }
            }
            max = Math.max(max, dp[i]);
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
public class Solution {
    // Recursion 解法:
    // O(1) space, polynomial time
    public boolean isMatch(String s, String p) {
        if(p.length() == 0)
            return s.length() == 0;
        // special case
        if(p.length() == 1){
            // if len of s is 0, return false
            if(s.length() < 1)
                return false;
            // if the first char of s and p is not same, and
            // the first char of p is not '.', return false
            else if((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.'))
                return false;
            // otherwise, compare the rest of the string of s and p
            else
                return isMatch(s.substring(1), p.substring(1));
        }
        // when the 2nd char of p is not "*"
        if(p.charAt(1) != '*'){
            if(s.length() < 1)
                return false;
            if((p.charAt(0)!= s.charAt(0)) && (p.charAt(0) != '.'))
                return false;
            else
                return isMatch(s.substring(1), p.substring(1));
        }
        // when the 2nd char of p is '*'
        else{
            // when "*" stands for 0 preceding element
            if(isMatch(s, p.substring(2)))
                return true;
            // when "*" stands for 1 or more preceding element, try
            // every possible number
            int i = 0;
            while(i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')){
                if(isMatch(s.substring(i+1), p.substring(2)))
                    return true;
                i++;
            }
            return false;
        }
    }

    // DP: DP乱用天地灭, 暴力破解保平安
    // O(n^2) space, O(n^2) time
    public boolean isMatchDP(String s, String p) {
            
        int sLen = s.length();
        int pLen = p.length();
        boolean dp[][] = new boolean[sLen+1][pLen+1];
        dp[0][0] = true;
        
        for(int i = 1; i < pLen && p.charAt(i) == '*'; i+=2){
            dp[0][i+1] = true;
        }
        
        for(int i = 1; i <= sLen; i++){
            for(int j = 1; j <= pLen; j++){
                // 一对一匹配原则
                if(p.charAt(j-1) == '.' || s.charAt(i-1) == p.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                // p的偶数位置出现了‘*’(偶数位的index是奇数)
                else if(j > 1 && p.charAt(j-1) == '*')
                    // 情况一:p的*匹配0个前符号, s和p去掉后俩字符(dp[i][j-2])
                    dp[i][j] = dp[i][j-2]|| 
                    // 情况二:p的*匹配一个前符号, s去掉最后一个, dp[i-1](s.charAt(i-2))
                    (dp[i-1][j] && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.'));
            }
        }
        return dp[sLen][pLen];
    }
}
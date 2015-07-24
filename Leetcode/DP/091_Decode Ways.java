public class Solution {
    // 一维DP:
    //  O(n) space, O(n) time
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0')
            return 0;
        // dp[i+1] -> s.charAt(i);
        int[] dp = new int[s.length() + 1];
        dp[0] = dp[1] = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) != '0')
                 dp[i+1] = dp[i];
                 
            if(s.charAt(i-1) != '0'){
                int num = (s.charAt(i-1) - '0')*10 + (s.charAt(i) - '0');
                if(num > 0 && num < 27)
                    dp[i+1] += dp[i-1];
            }
        }
        return dp[s.length()];
    }
}
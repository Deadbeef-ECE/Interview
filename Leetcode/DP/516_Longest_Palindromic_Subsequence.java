public class Solution {
    // O(n^2) space, O(n^2) time
    public int longestPalindromeSubseq(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int len = s.length();
        int[][] dp = new int[len][len];
        // dp[i][j] -> longest palindromic sequence between[i, j]
        for(int i = len - 1; i >= 0; i--){
            dp[i][i] = 1;
            for(int j = i + 1; j < len; j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][len-1];
    }
}
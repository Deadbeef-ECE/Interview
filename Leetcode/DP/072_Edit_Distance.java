public class Solution {
    // O(m*n) space, O(m*n) time
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if(m == 0)  return n;
        if(n == 0)  return m;
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++)  dp[i][0] = i;
        for(int j = 0; j <= n; j++)  dp[0][j] = j;
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                int cost = word1.charAt(i-1) == word2.charAt(j-1) ? 0 : 1;
                // delete insert replace
                dp[i][j] = Math.min(Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1), dp[i-1][j-1] + cost);
            }
        }
        return dp[m][n];
    }
}
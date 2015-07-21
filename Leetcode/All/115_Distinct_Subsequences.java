public class Solution {
    // O(m*n) space, O(m*n) time
//     t\s j        0   1   2   3   4   5   6   7   8   9   10
//      i         null  h   e   l   l   o   w   o   r   l   d
//      0   null    1   1   1   1   1   1   1   1   1   1   1
//      1   h       0   1   1   1   1   1   1   1   1   1   1
//      2   e       0   0   1   1   1   1   1   1   1   1   1
//      3   o       0   0   0   0   0   1   1   2   2   2   2
//      4   w       0   0   0   0   0   0   1   1   1   1   1
//      5   r       0   0   0   0   0   0   0   0   1   1   1
//      6   d       0   0   0   0   0   0   0   0   0   0   1
    public int numDistinct(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int[][] dp = new int[tLen+1][sLen+1];
        dp[0][0] = 1;
        // s is null
        for(int i = 1; i <= tLen; i++)
            dp[i][0] = 0;
        // t is null
        for(int j = 1; j <= sLen; j++)
            dp[0][j] = 1;
            
        for(int i = 1; i <= tLen; i++){
            for(int j = 1; j <= sLen; j++){
                dp[i][j] = dp[i][j-1];
                if(s.charAt(j-1) == t.charAt(i-1))
                    dp[i][j] += dp[i-1][j-1];
            }
        }
        return dp[tLen][sLen];
    }
}
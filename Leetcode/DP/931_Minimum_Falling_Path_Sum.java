// O(n^2) space, O(n^2) time, n is A.length
class Solution {
    public int minFallingPathSum(int[][] A) {
        if(A == null || A.length == 0)  return 0;
        if(A.length == 1)  return A[0][0];
        int n = A.length;
        int[][] dp = new int[n][n];
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++)
            dp[0][j] = A[0][j];
        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = dp[i - 1][j];
                if(j > 0)
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                if(j < n - 1)
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j + 1]);
                dp[i][j] += A[i][j];
                if(i == n - 1)  min = Math.min(min, dp[i][j]);
            }
        }
        return min;
    }
}
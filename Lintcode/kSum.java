// http://codeanytime.blogspot.com/2014/12/lintcode-k-sum.html
public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public int kSum(int A[], int k, int target) {
        if(A == null || A.length == 0)
            return 0;
            
        int[][][] dp = new int[A.length + 1][k + 1][target + 1];
        dp[0][0][0] = 1;
        
        // only the slots with k == 0 && t == 0 will be initialized as 1. 
        // All other need to be 0
        // when A[i] == t so we could derive f[i][k][t] from f[i - 1][k - 1][0]
        for (int i = 0; i <= A.length; i++)
            dp[i][0][0] = 1; 

        for(int i = 1; i <= A.length; i++){
            for(int n = 1; n <= k && n <= i; n++){
                for(int t = 1; t <= target; t++){
                    dp[i][n][t] = 0;
                    //case 1: the # of solutions with A[i - 1]
                    if (A[i - 1] <= t){
                    // pick n - 1 items from first i - 1 elements with the 
                    // sum = t - A[i - 1] plus this item A[i-1]
                        dp[i][n][t] = dp[i - 1][n - 1][t - A[i - 1]];
                    }
                    //case 2: the # of solution w/o A[i - 1]
                    dp[i][n][t] += dp[i - 1][n][t]; //directly inherit from i - 1
                    
                }
            }
        }
        return dp[A.length][k][target];
    }
}


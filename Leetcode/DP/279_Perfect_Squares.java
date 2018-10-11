class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        
        for(int i = 1; i <= n; i++){
            int min = Integer.MAX_VALUE;
            int j = 1;
            while(i >= j * j){
                min = Math.min(min, dp[i - j * j] + 1);
                j++;
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
// dp[n] indicates that the perfect squares count of the given n, and we have:

// dp[0] = 0 
// dp[1] = dp[0]+1 = 1
// dp[2] = dp[1]+1 = 2
// dp[3] = dp[2]+1 = 3
// dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 } 
//       = Min{ dp[3]+1, dp[0]+1 } 
//       = 1               
// dp[5] = Min{ dp[5-1*1]+1, dp[5-2*2]+1 } 
//       = Min{ dp[4]+1, dp[1]+1 } 
//       = 2
//                         .
//                         .
//                         .
// dp[13] = Min{ dp[13-1*1]+1, dp[13-2*2]+1, dp[13-3*3]+1 } 
//        = Min{ dp[12]+1, dp[9]+1, dp[4]+1 } 
//        = 2
//                         .
//                         .
//                         .
// dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1
// https://leetcode.com/problems/perfect-squares/discuss/71495/An-easy-understanding-DP-solution-in-Java
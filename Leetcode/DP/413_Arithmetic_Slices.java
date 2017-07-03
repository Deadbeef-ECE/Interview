public class Solution {
    // 常规解法, O(n) time, O(n) space
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length < 3)    return 0;
        int len = 2;
        int num = 0;
        for(int i = 2; i < A.length; i++){
            if(A[i] - A[i-1] == A[i-1] - A[i-2])
                len++;
            else{
                if(len > 2)
                    num += (len - 1)*(len - 2)/2;
                len = 2;
            }
        }
        if(len > 2)
            num += (len - 1)*(len - 2)/2;
        return num;
    }

    // DP, O(n) space, O(n) time
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length < 3)    return 0;
        int[] dp = new int[A.length];
        int ret = 0;
        for(int i = 2; i < A.length; i++){
            if(A[i] - A[i-1] == A[i-1] - A[i-2])
                dp[i] = dp[i-1] + 1;
            ret += dp[i];
        }
        return ret;
    }
    // DP状压. O(1) space, O(n) time
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length < 3)    return 0;
        int dp = 0;
        int ret = 0;
        for(int i = 2; i < A.length; i++){
            if(A[i] - A[i-1] == A[i-1] - A[i-2]){
                dp++;
                ret += dp;
            }else{
                dp = 0;
            }
        }
        return ret;
    }
}
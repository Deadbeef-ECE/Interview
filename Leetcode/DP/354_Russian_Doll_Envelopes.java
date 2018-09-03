// 解法和300一样
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0)
            return 0;
        Arrays.sort(envelopes, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        
        int[] dp = new int[envelopes.length];
        int len = 0;
        for(int[] e : envelopes){
            int i = Arrays.binarySearch(dp, 0, len, e[1]);
            if(i < 0)   i = - (i + 1);
            dp[i] = e[1];
            if(i == len)    len++;
        }
        return len;
    }
}
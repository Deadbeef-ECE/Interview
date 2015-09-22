public class Solution {
    // O(n^2) space, O(n^2) time
    public int minCut(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int[] cuts = new int[len+1];
        for(int i = 0; i <= len; i++)
            cuts[i] = len - i;
        for(int i = len - 1; i >= 0; i--){
            for(int j = i; j < len; j++){
                if(s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    cuts[i] = Math.min(cuts[i], cuts[j+1] + 1);
                }
            }
            
        }
        return cuts[0] - 1;
    }
}
public class Solution {
    // 中心拓展法:
    // O(1) space, O(n^2) time
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0)
            return null;
        String longest = "";
        for(int i = 0; i < s.length(); i++){
            String str = helper(s, i, i);
            if(str.length() > longest.length())
                longest = str;
            str = helper(s, i, i+1);
            if(str.length() > longest.length())
                longest = str;
        }
        return longest;
    }
    private String helper(String s, int start, int end){
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        return s.substring(start+1, end);
    }

    // DP: DP乱用天地灭, 暴力破解保平安
    // O(n^2) space, O(n^2) time
    public String longestPalindromeDP(String s) {
        if(s == null || s.length() <= 1)
            return s;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        String longest = "";
        // dp[i][j] => s[i:j]
        int max = 0;
        for(int i = len - 1; i >= 0; i--){
            for(int j = i; j < len; j++){
                //   s[i] == s[j]的前提下           自己或左右相邻  或  内层也是回文  
                if(s.charAt(i) == s.charAt(j) && (i + 1 > j - 1 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    if(max < j - i + 1){
                        max = j - i + 1;
                        longest = s.substring(i, j+1);
                    }
                }
            }
        }
        return longest;
    }
}
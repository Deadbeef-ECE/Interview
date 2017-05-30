public class Solution {
    // Brute-force:
    // O(n^2) time, O(n^2) space.
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        
        for(int i = n / 2; i >= 1; i--){
            if(n % i == 0){
                StringBuilder sb = new StringBuilder();
                String seg = s.substring(0, i);
                int cnt = n / i;
                for(int j = 0; j < cnt; j++){
                    sb.append(seg);
                }
                if(sb.toString().equals(s))   return true;
            }
        }
        return false;
    }

    // KMP
    // O(n) time, O(n) space
    public boolean repeatedSubstringPattern(String s) {
        if(s == null || s.length() == 0)     return false;
        int[] lps = KMP(s);
        int n = s.length();
        // n - dp[n]是一个子字符串的长度，那么重复字符串的长度和肯定是一个子字符串的整数倍
        // ref: http://www.cnblogs.com/grandyang/p/6087347.html
        return lps[n - 1] != 0 && (lps[n - 1] % (n - lps[n - 1]) == 0);
    }
    public int[] KMP(String str){
        int[] lps = new int[str.length()];
        lps[0] = 0;
        int i = 0, j = 1;
        while(j < str.length()){
            if(str.charAt(j) != str.charAt(i)){
                if(i != 0)
                    i = lps[i - 1];
                else
                    lps[j++] = 0;
            }
            else{
                lps[j] = i + 1;
                i++;j++;
            }
        }
        return lps;
    }
}
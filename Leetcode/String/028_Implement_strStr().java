public class Solution {
    // Brute-force:
    // O(1) space, O(n^2) time
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null)
            return -1;
        int i, j;
        for(i = 0; i <= haystack.length()-needle.length(); i++){
            for(j = 0; j < needle.length(); j++){
                if(needle.charAt(j) != haystack.charAt(i+j))
                    break;
            }
            if(j == needle.length())
                return i;
        }
        return -1;
    }

    // O(n+m) time, O(m) space.
    public int strStr(String haystack, String needle) {
        if(needle == null || haystack == null)
            return -1;
        if(needle.length() == 0)    return 0;
        int[] lps = KMP(needle);

        int M = haystack.length(), N = needle.length();
        int i = 0, j = 0;
        while(i < M){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++; j++;
            }
            if(j == N){
                return i - needle.length();
            }
            if(i < M  && haystack.charAt(i) != needle.charAt(j)){
                if(j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }

        return -1;
    }
    //aabaaaab
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
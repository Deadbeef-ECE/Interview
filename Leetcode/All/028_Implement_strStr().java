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

    //TODO: KMP Solution
}
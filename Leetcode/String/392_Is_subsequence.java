public class Solution {
    // Two pointer:
    // O(n) time, O(1) space
    public boolean isSubsequence(String s, String t) {
        if(s == null || s.length() == 0)   return true;
        if(t == null || t.length() == 0)   return false;
        int i = 0, j = 0;
        while(j < t.length()){
            if(t.charAt(j) == s.charAt(i)){
                i++;
                if(i == s.length()) return true;
            }
            j++;
        }
        return false;
    }
}
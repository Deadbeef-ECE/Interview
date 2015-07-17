public class Solution {
    // O(1) space, O(n) time
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0)
            return 0;
        
        int len = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) != ' ')  len++;
            if(s.charAt(i) == ' ' && len != 0)
                return len;
        }
        return len;
    }
}
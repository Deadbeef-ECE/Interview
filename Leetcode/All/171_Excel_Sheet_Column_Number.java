public class Solution {
	// O(1) space, O(n) time
    public int titleToNumber(String s) {
        int ret = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            ret = ret*26 + (ch - 'A' + 1);
        }
        return ret;
    }
}
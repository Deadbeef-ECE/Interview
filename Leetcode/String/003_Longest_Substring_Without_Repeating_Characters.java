public class Solution {
    // O(1) space, O(n) time
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() < 1)
            return 0;
        int start = 0;
        int cur = 0;
        int max = 0;
        int[] table = new int[256];
        Arrays.fill(table, -1);
        while(cur < s.length()){
            int ch = s.charAt(cur);
            if(table[ch] >= start)
                start = table[ch]+1;
            max = Math.max(max, cur-start+1);
            table[ch] = cur;
            cur++;
        }
        return max;
    }
}
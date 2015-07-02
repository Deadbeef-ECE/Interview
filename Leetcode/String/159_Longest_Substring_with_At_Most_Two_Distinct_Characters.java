public class Solution {
    // Two pointer 解法
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int i = 0, j = -1, maxLen = 0;
        for (int k = 1; k < s.length(); k++) {
            if (s.charAt(k) == s.charAt(k - 1)) continue;
            if (j >= 0 && s.charAt(j) != s.charAt(k)) {
                maxLen = Math.max(k - i, maxLen);
                i = j + 1; 
            }
            j = k - 1;  
        }
        return Math.max(s.length() - i, maxLen);
    }

    // hashTable解法，可以扩展到k
    // O(1) space, O(n) time
    public int lengthOfLongestSubstringTwoDistinct2(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int[] table = new int[256];
        int start = 0;
        int end = 0;
        int max = 1;
        for(int i = 0; i < s.length(); i++){
            int ch = s.charAt(i);
            table[ch]++;
            end++;
            while(!isValid(table, 2)){
                table[s.charAt(start)]--;
                start++;
            }
            max = Math.max(end - start, max);
        }
        return max;
    }
    
    private boolean isValid(int[] table, int k){
        int v = 0;
        for(int i = 0; i < table.length; i++){
            if(table[i] > 0)
                v++;
        }
        return k >= v;
    }
}
public class Solution {
    // O(1) space, O(n) time
    public int lengthOfLongestSubstringTwoDistinct2(String s， int k) {
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
            while(!isValid(table, k)){
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
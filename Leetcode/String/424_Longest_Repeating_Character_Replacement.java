// sliding window
class Solution {
    public int characterReplacement(String s, int k) {
        int[] table = new int[26];
        int end = 0, start = 0;
        int len = 0;
        int maxCount = 0;
        while(end < s.length()){
            char c = s.charAt(end);
            maxCount = Math.max(maxCount, ++table[c - 'A']);
            end++;
            while(end - start - maxCount > k){
                char a = s.charAt(start);
                table[a - 'A']--;
                start++;
            }
            len = Math.max(len, end - start);
        }
        return len;
    }
}
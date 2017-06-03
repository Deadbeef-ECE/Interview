public class Solution {
    //O(n) time, O(1) space
    public char findTheDifference(String s, String t) {
        int[] table = new int[26];
        for(int i = 0; i < t.length(); i++)
            table[t.charAt(i) - 'a']++;

        for(int i = 0; i < s.length(); i++)
            table[s.charAt(i) -'a']--;
        
        for(int i = 0; i < 26; i++){
            if(table[i] == 1)
                return (char) (i + 'a');
        }
        return 'a';
    }
}
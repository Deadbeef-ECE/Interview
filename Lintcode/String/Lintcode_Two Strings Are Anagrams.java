public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    // O(1) space, O(n) time
    public boolean anagram(String s, String t) {
        // write your code here
        if(s == null || s.length() == 0)
            return (t == null || t.length() == 0);
        if(s.length() != t.length())
            return false;
        
        int[] table = new int[256];
        for(int i = 0; i < s.length(); i++){
            int index = s.charAt(i);
            table[index]++;
        }
        for(int i = 0; i < t.length(); i++){
            int index = t.charAt(i);
            if(--table[index] < 0)
                return false;
        }
        return true;
    }
};

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] dict = new int[26];
        for(int i = 0; i < ransomNote.length(); i++)
            dict[ransomNote.charAt(i) - 'a']++;
        
        for(int i = 0; i < magazine.length(); i++){
            dict[magazine.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i++){
            if(dict[i] > 0)
                return false;
        }
        return true;
    }
}
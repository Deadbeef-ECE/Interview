class Solution {
    public String customSortString(String S, String T) {
        int[] table = new int[26];
        for(int i = 0; i < T.length(); i++)
            table[T.charAt(i) - 'a']++;
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            while(table[c - 'a'] > 0){
                sb.append(c);
                table[c - 'a']--;
            }
        }
        
        for(int i = 0; i < 26; i++){
            char c = (char)('a' + i);
            while(table[i] > 0){
                sb.append(c);
                table[i]--;
            }
        }
        return sb.toString();
    }
}
public class Solution {
    // 一维DP: O(n) space, O(n^2) time
    public boolean wordBreak(String s, Set<String> dict) {
        int len = s.length();
        boolean[] possible = new boolean[len+1];
        possible[0] = true;
        for(int i = 1; i <= len; i++){
            for(int j = 0; j < i; j++){
                if(possible[j] && dict.contains(s.substring(j, i))) {
                    possible[i] = true;
                    break;
                }
            }
        }
        return possible[len];
    }
}
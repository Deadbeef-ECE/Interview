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

// DFS
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0)
            return false;
        boolean[] visited = new boolean[s.length() + 1];
        return dfs(visited, 0, s, wordDict);
    }
    
    private boolean dfs(boolean[] visited, int idx, String s, List<String> wordDict){
        if(idx == s.length())
            return true;
        visited[idx] = true;
        for(String str : wordDict){
            int end = idx + str.length();
            if(end <= s.length() && s.startsWith(str, idx) && !visited[end]){
                if(dfs(visited, end, s, wordDict))
                    return true;
            }
        }
        return false;
    }
}
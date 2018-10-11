public class Solution {
    // DP+Backtracking
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> ret = new LinkedList<String>();
        if(s == null || s.length() == 0)
            return ret;
        List<String>[] dp = new LinkedList[s.length()+1];
        dp[0] = new LinkedList<String>();
        for(int i = 0; i < s.length(); i++){
            if(dp[i] == null)   continue;
            for(String word : wordDict){
                int len = word.length();
                int end = i + len;
                if(end > s.length())    continue;
                if(s.substring(i, end).equals(word)){
                    if(dp[end] == null)
                        dp[end] = new LinkedList<String>();
                    dp[end].add(word);
                }
            }
        }
        if(dp[s.length()] == null) return ret;
        List<String> path = new LinkedList<String>();
        doDFS(dp, s.length(), path, ret);
        return ret;
    }
    private void doDFS(List<String>[] dp, int end, List<String> path, List<String> ret){
        if(end <= 0){
            String s = "";
            int size = path.size();
            for(int i = 0; i < size; i++){
                String tmp = path.get(i);
                if(i != 0)
                    tmp += " ";
                s = tmp + s;
            }
            ret.add(s);
            return;
        }
        for(String str : dp[end]){
            path.add(str);
            doDFS(dp, end-str.length(), path, ret);
            path.remove(path.size()-1);
        }
    }

    // 普通Backtracking 解法，大数据超时
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new LinkedList<>();
        if(s == null || s.length() == 0 || wordDict.size() == 0)
            return res;
        Set<String> set = new HashSet<>(wordDict);
        
        StringBuilder sb = new StringBuilder();
        dfs(0, sb, s, set, res);
        return res;
    }
    
    private void dfs(int pos, StringBuilder path, String s, Set<String> set, List<String> res){
        if(pos == s.length()){
            String sol = path.toString().trim();
            res.add(sol);
            return;
        }
        for(String str : set){
            int end = pos + str.length();
            if(end <= s.length() && s.startsWith(str, pos)){
                int n = path.length();
                path.append(str + " ");
                dfs(end, path, s, set, res);
                path.delete(n, path.length());
            }
        }
    }
}
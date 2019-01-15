// Euler path
class Solution {
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int total = (int)Math.pow(k, n);
        for(int i = 0; i < n; i++)
            sb.append('0');
        Set<String> visited = new HashSet<>();
        visited.add(sb.toString());
        dfs(sb, total, visited, n, k);
        return sb.toString();
    }
    
    private boolean dfs(StringBuilder sb, int total, Set<String> visited,
                    int n, int k){
        if(visited.size() == total)
            return true;
        
        String prefix = sb.substring(sb.length() - n + 1, sb.length());
        for(int i = 0; i < k; i++){
            String next = prefix + i;
            if(!visited.contains(next)){
                visited.add(next);
                sb.append(i);
                if(dfs(sb, total, visited, n, k))
                    return true;
                visited.remove(next);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return false;
    }
}
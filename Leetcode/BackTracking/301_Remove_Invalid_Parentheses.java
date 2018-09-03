class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ret = new LinkedList<>();
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.add(s);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String cur = q.poll();
                if(isValid(cur)){
                    ret.add(cur);
                    continue;
                }
                
                for(int j = 0; j < cur.length(); j++){
                    if(cur.charAt(j) == '(' || cur.charAt(j) == ')'){
                        String next = cur.substring(0, j) + cur.substring(j + 1);
                        if(!visited.contains(next)){
                            q.add(next);
                            visited.add(next);
                        }
                    }
                }
            }
            if(!ret.isEmpty())    return ret;
        }
        return ret;
    }
    
    private boolean isValid(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                count++;
            }else if(s.charAt(i) == ')'){
                count--;
                if(count < 0)   return false;
            }
        }
        return count == 0;
    }

    //DFS
    int len = 0;
    public List<String> removeInvalidParentheses(String s) {
        List<String> ret = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        dfs(0, "", visited, s, ret);
        return ret;
    }
    
    private void dfs(int start, String path, Set<String> visited, String s, List<String> ret){
        if(path.length() > 0 && path.charAt(0) == ')')  return;
        if(isValid(path)){
            if(path.length() == len && !ret.contains(path)){
                ret.add(path);
            }else if(path.length() > len){
                ret.clear();
                ret.add(path);
                len = path.length();
            }
        }
        if(start >= s.length()) return;
        dfs(start + 1, path + s.charAt(start), visited, s, ret);
        if(s.charAt(start) == '(' || s.charAt(start) == ')')
            dfs(start + 1, path, visited, s, ret);
    }
    
    private boolean isValid(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                count++;
            }else if(c == ')'){
                count--;
                if(count < 0)   return false;
            }
        }
        return count == 0;
    }
}
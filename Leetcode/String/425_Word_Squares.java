class Solution {
    // HashMap解法
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ret = new LinkedList<>();
        if(words == null || words.length == 0)
            return ret;

        Map<String, Set<String>> map = new HashMap<>();
        for(String str : words){
            for(int i = 0; i <= str.length(); i++){
                String prefix = str.substring(0, i);
                if(!map.containsKey(prefix))
                    map.put(prefix, new HashSet<>());
                map.get(prefix).add(str);
            }
        }
        List<String> path = new ArrayList<>();
        dfs(0, map, words, path, ret);
        return ret;
    }
    
    private void dfs(int cur, Map<String, Set<String>> map,
                     String[] words, List<String> path, List<List<String>> ret){
        if(cur == words[0].length()){
            ret.add(new ArrayList<String>(path));
            return;
        }
        StringBuilder prefix = new StringBuilder();
        for(int i = 0; i < cur; i++){
            prefix.append(path.get(i).charAt(cur));
        }
        // bachtracking
        Set<String> cand = map.get(prefix.toString());
        if(cand == null) return;
        for(String str : cand){
            path.add(str);
            dfs(cur + 1, map, words, path, ret);
            path.remove(path.size()-1);
        }
    }
}
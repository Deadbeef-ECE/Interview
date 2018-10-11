class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new LinkedList<>();
        Map<String, List<String>> graph = new HashMap<>();
        Set<String> dict = new HashSet<>(wordList);
        buildGraph(graph, dict, beginWord, endWord);
        List<String> path = new LinkedList<>();
        path.add(beginWord);
        dfs(beginWord, endWord, path, graph, res);
        return res;
    }
    
    private void dfs(String cur, String end, List<String> path, 
                     Map<String, List<String>> graph, List<List<String>> res){
        if(cur.equals(end)){
            List<String> sol = new LinkedList<>(path);
            res.add(sol);
            return;
        }
        
        if(!graph.containsKey(cur)) return;
        List<String> child = graph.get(cur);
        for(String s : child){
            path.add(s);
            dfs(s, end, path, graph, res);
            path.remove(path.size() - 1);
        }
    }
    
    private void buildGraph(Map<String, List<String>> graph, Set<String> dict,
                            String beginWord, String endWord){
        Set<String> visited = new HashSet<>();
        Set<String> levelVisited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.add(beginWord);
        boolean reachEnd = false;
        while(!queue.isEmpty()){
            int cnt = queue.size();
            levelVisited.clear();
            while(cnt-- > 0){
                String str = queue.poll();
                List<String> replace = replace(str, dict);
                for(String s : replace){
                    if(s.equals(endWord))   reachEnd = true;
                    if(visited.contains(s)) continue;
                    if(!graph.containsKey(str))
                        graph.put(str, new ArrayList<>());
                    graph.get(str).add(s);
                    if(!visited.contains(s) && !levelVisited.contains(s))
                        queue.add(s);
                    levelVisited.add(s);
                }
            }
            visited.addAll(levelVisited);
            if(reachEnd)
                break;
        }
    }
    
    private List<String> replace(String str, Set<String> dict){
        List<String> res = new LinkedList<>();
        char[] arr = str.toCharArray();
        for(int i = 0; i < str.length(); i++){
            for(char c = 'a'; c <= 'z'; c++){
                if(arr[i] != c){
                    char t = arr[i];
                    arr[i] = c;
                    String newStr = new String(arr);
                    if(dict.contains(newStr))
                        res.add(new String(arr));
                    arr[i] = t;
                }
            }
        }
        return res;
    }
}
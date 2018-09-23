class Solution {
    // 和course schedule类似，有向图拓补排序/后序遍历
    Stack<String> reversePostOrder = new Stack<>();
    public List<String> findItinerary(String[][] tickets) {
        List<String> ret = new LinkedList<>();
        Map<String, List<String>> map = buildGraph(tickets);
        dfs("JFK", map, ret);
        return ret;
    }
    
    private void dfs(String city, Map<String, List<String>> map, List<String> ret){
        if(!map.containsKey(city) || map.get(city).size() == 0){
            ret.add(0, city);
            return;
        }
        List<String> list = map.get(city);
        while(list.size() > 0){
            String s = list.remove(0);
            dfs(s, map, ret);
        }
        ret.add(0, city);
    }
    
    private Map<String, List<String>> buildGraph(String[][] tickets){
        Map<String, List<String>> map = new HashMap<>();
        for(String[] t : tickets){
            String from = t[0], to = t[1];
            if(!map.containsKey(from))
                map.put(from, new LinkedList<>());
            map.get(from).add(to);
        }
        for(String key : map.keySet()){
            Collections.sort(map.get(key));
        }
        return map;
    }
}